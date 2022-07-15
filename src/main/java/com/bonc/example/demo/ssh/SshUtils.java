package com.bonc.example.demo.ssh;


import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

/**
 * 远程执行SSH命令工具类
 * 
 * @author  wangdonghao
 * @date 2018年12月5日 下午5:58:43
 * @version v1.0
 */
public class SshUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(com.bonc.example.demo.ssh.SshUtils.class);

	private HostInfo hostInfo;

	public SshUtils(String ip, int port, String user, String password, String charset) {

		hostInfo = new HostInfo(ip, port, user, password, charset);
	}

	/**
	 * 远程 shell 命令
	 * 
	 * @param command
	 * @return
	 * @throws BddsException
	 * @throws JSchException
	 * @throws IOException
	 */
	public void shell(Session session, String command) throws BddsException {
		LOGGER.info("------execute shell : {} ------", command);
		InputStream infoIs = null;
		InputStream errIs = null;
		ChannelExec exec = null;
		Channel channel = null;
		try {
			channel = session.openChannel("exec");
			exec = (ChannelExec) channel;
			exec.setCommand(command);
			exec.connect();
			infoIs = exec.getInputStream();
			errIs = exec.getErrStream();
			BufferedInputStream infoBis = new BufferedInputStream(infoIs);
			BufferedInputStream errBis = new BufferedInputStream(errIs);
			String info = null;
			String error = null;
			// shell 执行结果
			int infoBr = 0;
			byte[] infoArr = new byte[1024];
			while ((infoBr = infoBis.read(infoArr)) != -1) {
				//将读取的字节转为字符串对象
				info = new String(infoArr, 0, infoBr);
				LOGGER.info(info);
			}
			// shell 执行异常
			byte[] errArr = new byte[1024];
			int errBr = 0;
			while ((errBr = errBis.read(errArr)) != -1) {
				//将读取的字节转为字符串对象
				error = new String(errArr, 0, errBr);
				LOGGER.info(error);
			}
		} catch (Exception e) {
			throw new BddsException("execute shell failed !", e);
		} finally {
			try {
				if (infoIs != null) {
					infoIs.close();
				}
				if (errIs != null) {
					errIs.close();
				}
				if (channel != null) {
					channel.disconnect();
				}
				if (exec != null) {
					exec.disconnect();
				}
			} catch (IOException e) {
				LOGGER.error("close InputStream failed ! ", e);
			}
		}
	}

	/**
	 * 获取shell 执行结果
	 * @param session
	 * @param command
	 * @return
	 * @throws BddsException
	 */
	public Map<String, String> getShellResult(Session session, String command) throws BddsException {
		LOGGER.info("------execute shell : {} ------", command);
		InputStream infoIs = null;
		InputStream errIs = null;
		ChannelExec exec = null;
		Channel channel = null;
		Map<String,String> result = new HashMap<>();
		try {
			channel = session.openChannel("exec");
			exec = (ChannelExec) channel;
			exec.setCommand(command);
			exec.connect();
			infoIs = exec.getInputStream();
			errIs = exec.getErrStream();
			BufferedInputStream infoBis = new BufferedInputStream(infoIs);
			BufferedInputStream errBis = new BufferedInputStream(errIs);
			String info = null;
			String error = null;
			// shell 执行结果
			int infoBr = 0;
			byte[] infoArr = new byte[1024];
			while ((infoBr = infoBis.read(infoArr)) != -1) {
				//将读取的字节转为字符串对象
				info = new String(infoArr, 0, infoBr);
				LOGGER.info(info);
			}
			result.put("info",info);
			// shell 执行异常
			byte[] errArr = new byte[1024];
			int errBr = 0;
			while ((errBr = errBis.read(errArr)) != -1) {
				//将读取的字节转为字符串对象
				error = new String(errArr, 0, errBr);
				LOGGER.info(error);
			}
			result.put("error",error);
			LOGGER.info("result",result);
			return result;
		} catch (Exception e) {
			throw new BddsException("execute shell failed !", e);
		} finally {
			try {
				if (infoIs != null) {
					infoIs.close();
				}
				if (errIs != null) {
					errIs.close();
				}
				if (channel != null) {
					channel.disconnect();
				}
				if (exec != null) {
					exec.disconnect();
				}
			} catch (IOException e) {
				LOGGER.error("close InputStream failed ! ", e);
			}
		}
	}

	/**
	 * 推送本地目录下所有文件到远端主机
	 * 
	 * @param srcDir
	 * @param destDir
	 * @throws BddsException
	 */
	public String pushFiles(String srcDir, String destDir)
			throws JSchException, SftpException, IOException, BddsException {
		Session session = connect();
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftp = (ChannelSftp) channel;
		LOGGER.info("Pushing idl in dir [{}] to [{}@{}:{}] ......", srcDir, hostInfo.user, hostInfo.ip, destDir);
		File dir = new File(srcDir);
		if (!dir.exists() || dir.isFile()) {
			LOGGER.error("Dir [{}] not exist !", srcDir);
			return null;
		}
		// 如果目标目录不存在，创建目录
		try {
			Vector content = sftp.ls(destDir);
			if (null == content) {
				sftp.mkdir(destDir);
			}
		} catch (SftpException e) {
			sftp.mkdir(destDir);
		}
		// 进入目标路径
		sftp.cd(destDir);
		File[] files = dir.listFiles();
		for (File def : files) {
			if (def.isDirectory()) {
				continue;
			}
			LOGGER.info("Pushing file [{}] ......", def.getName());
			InputStream ins = new FileInputStream(def);
			sftp.put(ins, new String(def.getName().getBytes(), hostInfo.charset));
			try {
				ins.close();
			} catch (IOException e) {
				LOGGER.error("pushFiles failed", e);
			}
		}
		channel.disconnect();
		session.disconnect();
		return destDir;
	}

	/**
	 * 获取session
	 * 
	 * @author wangdonghao
	 * @date 2018年12月6日 上午9:38:14
	 * @param
	 * @return
	 */
	public Session getSession() {
		Session session = null;
		try {
			session = connect();
		} catch (Exception e) {
			LOGGER.error("getSession failed !", e);
		}
		return session;
	}

	/**
	 * 获取channel
	 * 
	 * @author wangdonghao
	 * @date 2018年12月6日 上午9:38:23
	 * @param
	 * @return
	 */
	public Channel getSFTPChannel(Session session) {
		Channel channel = null;
		try {
			channel = session.openChannel("sftp");
		} catch (Exception e) {
			LOGGER.error("getChannel failed !", e);
		}
		return channel;
	}

	/**
	 * 获取ChannelSftp
	 * 
	 * @author wangdonghao
	 * @date 2018年12月6日 上午9:38:34
	 * @param
	 * @return
	 */
	public ChannelSftp getSftp(Channel channel) {
		ChannelSftp sftp = null;
		try {
			channel.connect();
			sftp = (ChannelSftp) channel;
		} catch (Exception e) {
			LOGGER.error("getSftp failed !", e);
		}
		return sftp;
	}

	/**
	 * 关闭连接
	 * 
	 * @author wangdonghao
	 * @date 2018年12月6日 上午9:38:44
	 * @param sftp
	 *            channel session
	 * @return void
	 */
	public void close(ChannelSftp sftp, Channel channel, Session session) {
		try {
			if (sftp != null) {
				sftp.disconnect();
			}
			if (channel != null) {
				channel.disconnect();
			}
			if (sftp != null) {
				session.disconnect();
			}
		} catch (Exception e) {
			LOGGER.error("closeSfpt failed !", e);
		}
	}

	/**
	 * 关闭连接
	 * @author zzw
	 * @date 2019/10/18 16:51
	 * @param session
	 * @return void
	 */
	public void close(Session session){
		try{
			if(null != session){
				session.disconnect();
			}
		}catch(Exception e){
			LOGGER.error("closeSession failed!");
		}
	}
	/**
	 * 推送文件到远端主机
	 * 
	 * @author wangdonghao
	 * @param srcFile
	 *            本地文件路径
	 * @param destDir
	 *            远端主机目录
	 * @throws SftpException
	 */
	public void pushFile(ChannelSftp sftp, String srcFile, String destDir) throws SftpException {
		LOGGER.info("Pushing file [{}] to [{}@{}:{}] ......", srcFile, hostInfo.user, hostInfo.ip, destDir);
		File file = new File(srcFile);
		if (!file.exists() || file.isDirectory()) {
			LOGGER.error("File [{}] not exist !", srcFile);
		}
		// 进入目标路径
		sftp.cd(destDir);
		try (InputStream ins = new FileInputStream(file)) {// jdk1.7特性，自动关闭资源，SonarLink建议
			sftp.put(ins, new String(file.getName().getBytes(), hostInfo.charset));
		} catch (Exception e) {
			LOGGER.error("pushFile failed !", e);
		}
	}

	/**
	 * 从远端主机拉取文件
	 * 
	 * @param srcFile
	 * @param destDir
	 * @return
	 * @throws JSchException
	 * @throws SftpException
	 * @throws BddsException
	 */
	public String pullFile(String srcFile, String destDir) throws JSchException, SftpException, BddsException {
		Session session = connect();
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftp = (ChannelSftp) channel;
		LOGGER.info("Pulling file from [{}@{}:{}] to [{}] ......", hostInfo.user, hostInfo.ip, srcFile, destDir);
		Vector conts = sftp.ls(srcFile);
		if (conts.size() > 1 || conts.size() < 1) {
			LOGGER.error("Remote file [{}] not exist !", srcFile);
			return null;
		}
		String fileName = ((ChannelSftp.LsEntry) conts.get(0)).getFilename();
		File directory = new File(destDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		// 拉取文件
		sftp.get(srcFile, destDir);
		// 本地文件路径
		String destFile = directory.getAbsolutePath() + File.separator + fileName;
		channel.disconnect();
		session.disconnect();
		return destFile;
	}

	/**
	 * 连接远程主机
	 * 
	 * @return
	 * @throws BddsException
	 * @throws JSchException
	 */
	private Session connect() throws BddsException {
		LOGGER.info("Initing ssh session with [{}] ......", hostInfo.ip);
		Session session = null;
		try {
			session = new JSch().getSession(hostInfo.user, hostInfo.ip, hostInfo.port);
			session.setPassword(hostInfo.pwd);
			// 设置第一次登陆的时候提示，可选值:(ask | yes | no)
			Properties props = new Properties();
			props.setProperty("StrictHostKeyChecking", "no");
			session.setConfig(props);
			// 10秒连接超时
			session.connect(10000);
		} catch (JSchException e) {
			throw new BddsException("please check your config(ip,port,user,password)", e);
		}
		return session;
	}

	/**
	 * 在远程Linux服务器上执行脚本，并返回结果
	 * @param session
	 * @param command
	 * @param encoding
	 * @return
	 * @throws JSchException
	 * @throws IOException
	 */
	public String execCommand(Session session, String command, String encoding) {
		String result = null;
		try {
			ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
			InputStream in = channelExec.getInputStream();
			channelExec.setCommand(command);
			channelExec.connect();
			result = IOUtils.toString(in,encoding);
			channelExec.disconnect();
		} catch (JSchException|IOException e) {
			LOGGER.error("method: execCommand: execute shell failed !",e);
		}
		return result;
	}

	/**
	 *  远程节点信息
	 * @Author yuezp
	 * @Date 2019/8/12 9:51
	 */
	public class HostInfo {
		public String ip;
		public int port;
		private String user;
		private String pwd;
		private String charset;

		private HostInfo(String ip, int port, String user, String pwd, String charset) {
			this.ip = ip;
			this.port = port;
			this.user = user;
			this.pwd = pwd;
			this.charset = (null == charset) ? "UTF-8" : charset;
		}
	}
}

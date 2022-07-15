
package com.bonc.example.demo.kerberos;

import java.net.URI;
import java.security.PrivilegedExceptionAction;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.ha.HAServiceProtocol;
import org.apache.hadoop.ha.HAServiceStatus;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.HdfsConfiguration;
import org.apache.hadoop.hdfs.tools.DFSHAAdmin;
import org.apache.hadoop.hdfs.tools.NNHAServiceTarget;
import org.apache.hadoop.security.UserGroupInformation;

import javax.security.auth.Subject;
//import org.apache.hadoop.yarn.client.cli.RMAdminCLI;

/**
 * @author yuanwei
 * @date 2020年7月28日
 * @see Test
 * @since
 */

public class Test {
      static  Configuration config = new Configuration();
      
    public static void main(String[] args) throws Exception {
        config.addResource(new Path("H:\\core-site.xml"));
        config.addResource(new Path("H:\\hbase-site.xml"));
        config.addResource(new Path("H:\\hdfs-site.xml"));
//        config.set("hbase.zookeeper.quorum","172.16.13.144:2181,172.16.13.145:2181,172.16.13.146:2181");
//        config.set("hbase.zookeeper.property.clientPort","2181");
        System.setProperty("java.security.krb5.conf", "H:\\krb5.conf");
        // 2、初始化HDFS dfs属性
        UserGroupInformation.setConfiguration(config);
        UserGroupInformation.loginUserFromKeytab("hadoop@BONC.COM", "H:\\hadoop.keytab");
//        boolean loginKeytabBased = ugi.isLoginKeytabBased();
        HBaseAdmin.available(config);//String type = args[0];


        //String host = args[1];
//        System.err.println("-----fs uri:" +  config.get("fs.defaultFS"));
//        DistributedFileSystem dfs = ugi.doAs(new PrivilegedExceptionAction<DistributedFileSystem>() {
//            @Override
//            public DistributedFileSystem run()
//                throws Exception {
//                String uri = config.get("fs.defaultFS");
//                System.err.println(uri);
//                DistributedFileSystem dfs = new DistributedFileSystem();
//                dfs.initialize(new URI(uri), config);
//                return dfs;
//            }
//        });

//        FileStatus[] fileStatuses = dfs.listStatus(new Path("/"));
//        System.out.println(fileStatuses);
//        dfs.copyFromLocalFile(new Path("H:\\hadoop.keytab"),new Path("/tmp"));


//        DFSHAAdmin haAdmin = ugi.doAs(new PrivilegedExceptionAction<DFSHAAdmin>() {
//            @Override
//            public DFSHAAdmin run()
//                throws Exception {
//                DFSHAAdmin haAdmin  = new DFSHAAdmin();
//                String uri = config.get("fs.defaultFS");
//                haAdmin.setConf(config);
//                return haAdmin;
//            }
//        });
        
//        RMAdminCLI rmAdminCLI = ugi.doAs(new PrivilegedExceptionAction<RMAdminCLI>() {
//            @Override
//            public RMAdminCLI run()
//                throws Exception {
//                RMAdminCLI rmAdminCLI  = new RMAdminCLI();
//                String uri = config.get("fs.defaultFS");
//                rmAdminCLI.setConf(config);
//                return rmAdminCLI;
//            }
//        });
        
//        System.out.println("------rm-------------------");
//        YarnConfiguration yarnConf = (YarnConfiguration)rmAdminCLI.getConf();
//        yarnConf.set(YarnConfiguration.RM_HA_ID, "rm1");
//        RMHAServiceTarget rmhaServiceTarget = new RMHAServiceTarget(yarnConf);
//        HAServiceProtocol proxy = rmhaServiceTarget.getProxy(yarnConf, -1);
//        HAServiceStatus serviceStatus = proxy.getServiceStatus();
//        System.out.println(serviceStatus.getState().name().toLowerCase());
        
        
//        System.out.println("------namenode-------------------");
//        HdfsConfiguration conf = (HdfsConfiguration)haAdmin.getConf();
//        NNHAServiceTarget nnhaServiceTarget = new NNHAServiceTarget(conf, null, "nn2");
//        HAServiceProtocol proto = nnhaServiceTarget.getProxy(conf, -1);
//        HAServiceStatus state = proto.getServiceStatus();
//        System.out.println(state.getState().name().toLowerCase());
//        System.out.println("------namenode-------------------");
//
//
//        System.out.println("------datanode-------------------");
   //     DFSHAAdminUtils dfshaAdminUtils = new DFSHAAdminUtils(dfs.getConf(), "nn2");
   //     dfshaAdminUtils.getActiveNameNode();
//        DatanodeInfo[] dataNodeStats = dfs.getDataNodeStats(DatanodeReportType.ALL);
//        for (DatanodeInfo datanodeInfo : dataNodeStats) {
//            System.out.println(datanodeInfo.toString());
//        }
    }

}

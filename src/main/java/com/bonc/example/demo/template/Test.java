package com.bonc.example.demo.template;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoaojin
 * @CreateTime 2020-06-11
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        boolean build = build("aa");
        System.out.println("build " + build);


    }

    private static boolean build(String clusterId) {
        //            lock.lock();
        try {
            System.out.printf("------开始构建kafka_client_jaas.conf文件------");
            //keytab文件存放目录为 ../beh-director/tmp/kerberos/{clusterId}/hadoop.keytab
            String address = "C:\\Users\\Administrator\\Desktop";
            StringBuffer sb2 = new StringBuffer();
            String resultConfPath = sb2.append(address)
                    .append("\\tmp\\kerberos\\")
                    .append(clusterId)
                    .append("/kafka_client_jaas.conf").toString();
            File kafkaServerJaasConfFile = new File(resultConfPath);
            //假如这个文件已存在，则不用生成
            if (kafkaServerJaasConfFile.exists()) {
                System.out.printf("------kafka_client_jaas.conf文件已存在，无需生成------");
//                    return true;
            }
            Map<String , Object> configMap = new HashMap<>();
            StringBuffer sb = new StringBuffer();
            String keytabPath = sb.append(address)
                    .append("/tmp/kerberos/")
                    .append(clusterId)
                    .append("/")
                    .append("hadoop.keytab").toString();
            //../beh-director/tmp/kerberos/{clusterId}/hadoop.keytab
            configMap.put("keytabPath",keytabPath);

//                System.out.printf("------构建的keytabPath :{}------",sb.toString());
            //获取集群中的任意一台主机名
//                List<String> hosts = agentNodeRepository.getAllHostsByClusterId(clusterId);
//                String domain = bddClusterRepository.getDomainByClusterId(clusterId);
            configMap.put("currentHost","beh-1.bonc.com");
//                System.out.printf("------构建的currentHost :{}------",hosts.get(0));
            configMap.put("domain","LUO.COM");
//                System.out.printf("------构建的domain :{}------",domain);
            //将参数放入模板
            try {
                Configuration configuration = new Configuration(Configuration.getVersion());
                //configuration.setClassForTemplateLoading(getClass(), "host-template");
                configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\Administrator\\Desktop"));
                configuration.setDefaultEncoding("utf-8");
                configuration.clearTemplateCache();

                Template host = configuration.getTemplate("kafka_client_jaas.conf");
                System.out.printf("------获取模版kafka_client_jaas.conf----\n"+host.toString());

                PrintWriter printWriter = new PrintWriter(new FileWriter(resultConfPath));
                //生成文件
                host.process(configMap, printWriter);
                System.out.printf("------生成kafka_client_jaas.conf完毕------");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.printf("------生成kafka_client_jaas.conf失败 {}------",e.getMessage());
                return false;
            }
            return true;
        }catch (Exception e){
            System.out.printf("------生成kafka_client_jaas.conf失败 {}------",e.getMessage());
            return false;
        }
//            finally {
////                lock.unlock();
//            }
    }
}

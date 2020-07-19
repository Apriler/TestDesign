package com.bonc.example.demo.kafka;


import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.KafkaFuture;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author luoaojin
 * @CreateTime 2020-06-08
 * @Description
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Properties p = new Properties();
//        p.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "beh-3.bonc.com:9092,beh-2.bonc.com:9092,beh-1.bonc.com:9092");
        Properties props =  new Properties();
        props.put("bootstrap.servers", "beh-3.bonc.com:9092,beh-2.bonc.com:9092,beh-1.bonc.com:9092");

        System.setProperty("java.security.krb5.conf",
                Thread.currentThread().getContextClassLoader().getResource("krb5.conf").getPath());
        //加载本地jass.conf文件
        System.setProperty("java.security.auth.login.config",
                Thread.currentThread().getContextClassLoader().getResource("jaas.conf").getPath());
        //加载临时jass.conf
       /* File jaasConf = KerberosUtils.configureJAAS(Thread.currentThread().getContextClassLoader()
                .getResource("wms_dev.keytab").getPath(), "wms_dev@WONHIGH.COM");
        System.setProperty("java.security.auth.login.config", jaasConf.getAbsolutePath());*/
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");

        AdminClient adminClient = AdminClient.create(props);
        ListTopicsResult result = adminClient.listTopics();
        KafkaFuture<Set<String>> names = result.names();
        try {
            names.get().forEach((k)->{
                System.out.println(k);
            });
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        adminClient.close();
//        Collection<TopicListing> topicListings = listTopicsResult.listings().get();
//        for (TopicListing topicListing : topicListings) {
//            topicListing
//        }
    }
//    public static void main(String[] args) throws Exception, MalformedURLException, IllegalAccessException, InvocationTargetException, InstantiationException {
//
//        Test.loadJar("C:\\Users\\Administrator\\Desktop\\bse_client.jar");
//        Class toolClass = Class.forName("com.bonc.bse.client.kakfa_0_11.KafkaTools");
//        Object instance = toolClass.newInstance();
//        // 反射方法
//        Method method = toolClass.getDeclaredMethod("topicSet", String.class, String.class, String.class, String.class);
//        // 调用 cluster 方法
//        Set<String> topicSet = (Set<String>) method.invoke(instance, "beh-3.bonc.com:9092,beh-2.bonc.com:9092,beh-1.bonc.com:9092", "", "", "kafka");
//    }
//    public static void loadJar(String jarPath)
//            throws NoSuchMethodException, MalformedURLException, InvocationTargetException, IllegalAccessException {
//
//        File jarFile = new File(jarPath);
//        URLClassLoader system = (URLClassLoader) ClassLoader.getSystemClassLoader();
//        Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
//        add.setAccessible(true);
//        add.invoke(system, new Object[] { jarFile.toURI().toURL() });
//    }
}

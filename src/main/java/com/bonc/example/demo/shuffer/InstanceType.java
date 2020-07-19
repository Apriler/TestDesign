package com.bonc.example.demo.shuffer;

import lombok.Getter;

@Getter
public enum InstanceType {

    //zookeeper进程
    QUORUMPEERMAIN("QuorumPeerMain","ZOOKEEPER"),
    //hdfs进程
    NAMENODE("NameNode", "HDFS"),
    //hdfs进程
    DATANODE("DataNode", "HDFS"),
    //hdfs高可用进程
    JOURNALNODE("JournalNode", "HDFS"),
    //hdfs高可用进程
    DFSZKFAILOVERCONTROLLER("DFSZKFailoverController", "HDFS"),
    //hdfs客户端
    HDFSCLIENT("HDFSClient","HDFS"),
    //yarn进程
    JOBHISTORYSERVER("JobHistoryServer", "YARN"),
    //yarn进程
    RESOURCEMANAGER("ResourceManager", "YARN"),
    //yarn进程
    NODEMANAGER("NodeManager", "YARN"),
    //yarn进程
    TIMELINESERVER("TimelineServer", "YARN"),
    //flume进程
    APPLICATION("Application", "FLUME"),
    //mariadb进程
    MYSQL("Mysql", "MARIADB"),
    //hive进程
    METASTORE("MetaStore", "HIVE"),
    //hive进程
    HIVESERVER2("HiveServer2", "HIVE"),
    //hbase进程
    HMASTER("HMaster", "HBASE"),
    //hbase进程
    HREGIONSERVER("HRegionServer", "HBASE"),
    //spark进程
    SPARKCLIENT("Spark_Client", "SPARK"),
//    MASTER("Master", "SPARK"),
//    //spark进程
//    WORKER("worker", "SPARK"),
    //kafka进程
    KAFKA("Kafka", "KAFKA"),
    //flink进程
    FLINKCLIENT("Flink_Client", "FLINK"),
    //TASKMANAGERRUNNER("TaskManagerRunner", "FLINK"),
    //flink进程
    //STANDALONESESSIONCLUSTERENTRYPOINT("StandaloneSessionClusterEntryPoint", "FLINK");
    
    //ranger-admin的进程
    RANGERADMIN("ranger-admin", "RANGER");

    private String name;

    private String serviceTypeName;

    public String getName() {
        return name;
    }


    InstanceType(String name, String serviceTypeName){
        this.name = name;
        this.serviceTypeName = serviceTypeName;
    }

}

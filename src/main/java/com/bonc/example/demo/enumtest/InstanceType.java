package com.bonc.example.demo.enumtest;

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
    //yarn客户端
    YARNCLIENT("YARNClient","YARN"),
    //flume进程
    APPLICATION("Application", "FLUME"),
    //mariadb进程
    MYSQL("Mysql", "MARIADB"),
    //hive进程
    METASTORE("MetaStore", "HIVE"),
    //hive进程
    HIVESERVER2("HiveServer2", "HIVE"),
    //hive客户端
    HIVECLIENT("HiveClient","HIVE"),
    //hive/sparkengine下的spark进程
    HIVE_SPARK_HISTORYSERVER("HiveSparkHistoryServer","HIVE"),
    HIVE_TEZ_UI("tez-ui","HIVE"),
    //hbase进程
    HMASTER("HMaster", "HBASE"),
    //hbase进程
    HREGIONSERVER("HRegionServer", "HBASE"),
    //hbase客户端
    HBASECLIENT("HbaseClient", "HBASE"),
    //spark进程
    SPARKTHRIFTSERVER("SparkThriftServer", "SPARK"),
    //spark进程
    SPARKCLIENT("SparkClient", "SPARK"),
    //spark进程
    SPARK_HISTORYSERVER("Spark_HistoryServer", "SPARK"),

//    MASTER("Master", "SPARK"),
//    //spark进程
//    WORKER("worker", "SPARK"),
    //kafka进程
    KAFKA("Kafka", "KAFKA"),
    //flink进程
    FLINKCLIENT("FlinkClient", "FLINK"),
    //TASKMANAGERRUNNER("TaskManagerRunner", "FLINK"),
    //flink进程
    //STANDALONESESSIONCLUSTERENTRYPOINT("StandaloneSessionClusterEntryPoint", "FLINK");
    
    //ranger-admin的进程
    RANGERADMIN("ranger-admin", "RANGER"),
    
    //ranger-kms的进程
    RANGERKMS("ranger-kms", "RANGER_KMS"),

    //oozie进程
    EMBEDDEDOOZIESERVER("EmbeddedOozieServer", "OOZIE"),

    //prometheus进程
    PROMETHEUS("prometheus","METRICS"),

    //grafana 进程
    GRAFANA("grafana","METRICS"),

    //minio 进程
    MINIO("minio","MINIO"),
    
    //solr 进程
    SOLR("solr","SOLR"),
    
    //presto 进程
    COORDINATOR("Coordinator","PRESTO"),
    //presto 进程
    PRESTOWORKER("PrestoWorker","PRESTO"),
    
    //ozone 进程
    STORAGECONTAINERMANAGERSTARTER("StorageContainerManagerStarter","OZONE"),
    //ozone 进程
    OZONEMANAGERSTARTER("OzoneManagerStarter","OZONE"),
    //ozone 进程
    HDDSDATANODESERVICE("HddsDatanodeService","OZONE"),
    //ozone 进程
    RECONSERVER("ReconServer","OZONE"),
    //ozone 进程 Gateway
    S3G("s3g","OZONE"),
    //redis Standalone 模式
    REDIS_STANDALONE("Redis-Standalone","REDIS_STANDALONE"),

    //PHOENIX 客户端
    PHOENIX("Phoenix","PHOENIX"),
    //HFTP 进程
    HFTP("hftp","HFTP"),
    
    //openlookeng 进程
    LK_COORDINATOR("LK_Coordinator","OPENLOOKENG"),
    //openlookeng 进程
    LK_WORKER("LK_Worker","OPENLOOKENG");



    

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

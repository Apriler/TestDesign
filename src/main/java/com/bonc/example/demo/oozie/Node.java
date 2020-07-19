package com.bonc.example.demo.oozie;

import java.util.List;

/**
 * @author luoaojin
 * @CreateTime 2019-03-20
 * @Description
 */

public class Node {
    private String  id;
    private String parent;
    private String child;

    String s ="{\n" +
            "  \"id\":1,\n" +
            "  \"nodes\":[\n" +
            "    {\n" +
            "      \"nodeId\":\"2c90dc0169b388310169b38848280000\",\n" +
            "      \"nodeName\":\"node1\",\n" +
            "      \"parent\":null,\n" +
            "      \"child\":\"2c90dc0169b388310169b38848280002\",\n" +
            "      \"nodeType\":0,\n" +
            "      \"nodeStatus\":2,\n" +
            "      \"nodeTypeId\":\"1\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nodeId\":\"2c90dc0169b388310169b38848280001\",\n" +
            "      \"nodeName\":\"node2\",\n" +
            "      \"parent\":null,\n" +
            "      \"child\":\"2c90dc0169b388310169b38848280002\",\n" +
            "      \"nodeType\":0,\n" +
            "      \"nodeStatus\":2,\n" +
            "      \"nodeTypeId\":\"2\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nodeId\":\"2c90dc0169b388310169b38848280002\",\n" +
            "      \"nodeName\":\"node3\",\n" +
            "      \"parent\":\"2c90dc0169b388310169b38848280001,2c90dc0169b388310169b38848280000\",\n" +
            "      \"child\":\"2c90dc0169b388310169b38848280003\",\n" +
            "      \"nodeType\":1,\n" +
            "      \"nodeStatus\":1,\n" +
            "      \"nodeTypeId\":\"3\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nodeId\":\"2c90dc0169b388310169b38848280003\",\n" +
            "      \"nodeName\":\"node4\",\n" +
            "      \"parent\":\"2c90dc0169b388310169b38848280002\",\n" +
            "      \"child\":null,\n" +
            "      \"nodeType\":0,\n" +
            "      \"nodeStatus\":0,\n" +
            "      \"nodeTypeId\":\"4\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

}

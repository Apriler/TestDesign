package com.bonc.example.demo.pattern;

import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @Author luoaojin
 * @Date 2020/8/11 9:47
 * @Description
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) throws NodeParser.NodeParserException {

        NodeParser nodeParser = new NodeParser();
//       nodeParser.parse("/rack,/rasss");
        nodeParser.parse("/rack/rads/fasf,rasss");
        nodeParser.getResults().forEach(System.out::println);
    }
}

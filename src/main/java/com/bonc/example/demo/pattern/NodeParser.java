package com.bonc.example.demo.pattern;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeParser {
//    private static final Pattern BAD_CHAR = Pattern.compile("[^\\S-\\[\\]\\.]");
    private static final Pattern BAD_CHAR = Pattern.compile("[^\\[a-zA-Z_0-9/]-\\[]\\.]");
    private static final Pattern OPEN_BRACKET = Pattern.compile("\\[");
    private static final Pattern CLOSE_BRACKET = Pattern.compile("\\]");
    private static final Pattern RANGE = Pattern.compile("^\\[(\\d+)-(\\d+)\\]$");
    private static final Pattern LEADING_ZEROES = Pattern.compile("^0+\\d");
    static final int DEFAULT_RESULT_LIMIT = 10000;
    private int resultLimit;
    private Set<String> results;

    public NodeParser() {
        this(10000);
    }

    public NodeParser(int resultLimit) {
        this.results = Sets.newHashSet();
        this.resultLimit = resultLimit;
    }

    public Set<String> getResults() {
        return this.results;
    }

    private void addResult(String result) throws NodeParserException {
        this.results.add(result);
        if (this.results.size() > this.resultLimit) {
            throw new NodeParserException("Exceeded parser limit of " + this.resultLimit + " results");
        }
    }

    private List<String> parseRange(String entry, Matcher open) throws NodeParserException {
        List<String> candidates = Lists.newLinkedList();
        int rangeBegin = open.start();
        Matcher close = CLOSE_BRACKET.matcher(entry.substring(rangeBegin));
        if (!close.find()) {
            throw new NodeParserException("Input " + entry + " contains open bracket without corresponding close bracket");
        } else {
            int rangeEnd = rangeBegin + close.start() + 1;
            String range = entry.substring(rangeBegin, rangeEnd);
            Matcher rm = RANGE.matcher(range);
            if (!rm.find()) {
                throw new NodeParserException("Input " + entry + " contains pair of brackets without valid range expression");
            } else {
                String prefix = entry.substring(0, rangeBegin);
                String start = rm.group(1);
                String end = rm.group(2);
                String suffix = entry.substring(rangeEnd);
                if (start.length() > end.length()) {
                    throw new NodeParserException("Input " + entry + " contains range expression with more digits in start than in end");
                } else {
                    int startNum = Integer.parseInt(start);
                    int endNum = Integer.parseInt(end);
                    if (startNum > endNum) {
                        throw new NodeParserException("Input " + entry + " contains range expression with a greater start than end");
                    } else {
                        boolean zeroPadding = LEADING_ZEROES.matcher(start).find();

                        for(int i = startNum; i <= endNum; ++i) {
                            StringBuilder format = new StringBuilder("%s%");
                            if (zeroPadding) {
                                format.append("0" + start.length());
                            }

                            format.append("d%s");
                            candidates.add(String.format(format.toString(), prefix, i, suffix));
                        }

                        return candidates;
                    }
                }
            }
        }
    }

    public void parse(String input) throws NodeParserException {
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("[,;\\s]+");

        while(scanner.hasNext()) {
            String token = scanner.next();
            Matcher matcher = BAD_CHAR.matcher(token);
            if (matcher.find()) {
                throw new NodeParserException("Input " + token + " contains illegal characters");
            }

            List<String> candidates = Lists.newLinkedList();
            candidates.add(token);

            while(!candidates.isEmpty()) {
                String candidate = (String)candidates.remove(0);
                Matcher open = OPEN_BRACKET.matcher(candidate);
                if (open.find()) {
                    candidates.addAll(this.parseRange(candidate, open));
                } else {
                    Matcher close = CLOSE_BRACKET.matcher(candidate);
                    if (close.find()) {
                        throw new NodeParserException("Input " + candidate + " contains close bracket without corresponding open bracket");
                    }

                    this.addResult(candidate);
                }
            }
        }

    }

    public static class NodeParserException extends Exception {
        public NodeParserException(String message) {
            super(message);
        }
    }
}


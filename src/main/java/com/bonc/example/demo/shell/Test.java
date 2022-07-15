package com.bonc.example.demo.shell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author luoaojin
 * @Date 2022/1/4 16:57
 * @Description
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        
    }
    private static boolean processExec(String command) {
        boolean result = true;
        String shell = "";
        System.out.printf("execute shell :--- {}" , shell);
//        infoSb.append(shell);
//        infoSb.append("\n");
        try {
            Process process;
            process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", shell}, null, null);

            //获取进程的标准输入流
            final InputStream info = process.getInputStream();
            //获取进程的错误流
            final InputStream error = process.getErrorStream();
            new Thread() {
                @Override
                public void run() {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(info));
                    try {
                        String infoLine = null;
                        while ((infoLine = br1.readLine()) != null) {
                            if (infoLine != null){
                                System.out.printf(infoLine);
//                                infoSb.append(infoLine);
//                                infoSb.append("\n");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            info.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(error));
                    try {
                        String errorLine = null;
                        while ((errorLine = br2.readLine()) != null) {
                            if (errorLine != null){
                                System.out.printf(errorLine);
//                                infoSb.append(errorLine);
//                                infoSb.append("\n");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            error.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            process.waitFor();
            int exit = process.exitValue();
            System.out.printf("操作命令执行退出码---" + exit);
            if (exit != 0) {
                result = false;
            }
//            if (process.isAlive()) {
//                process.destroyForcibly();
//            }
        } catch (Exception e) {
            e.printStackTrace();
//            LOGGER.error("执行操作异常", e);
            result = false;
        }
        return result;
    }
}

package com.bonc.example.demo.kerberos;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;

import static org.apache.hadoop.security.UserGroupInformation.AuthenticationMethod.KERBEROS;

/**
 * @Author luoaojin
 * @Date 2021/5/17 16:56
 * @Description
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        runKerberosLogin();
//        Configuration conf = new
//                org.apache.hadoop.conf.Configuration();
//        conf.set("hadoop.security.authentication", KERBEROS.toString());
//        UserGroupInformation.setConfiguration(conf);
//        try {
//            // Check TGT before calling login
//            // Ref: https://github.com/apache/hadoop/blob/release-3.0.1-RC1/hadoop-common-project/
//            // hadoop-common/src/main/java/org/apache/hadoop/security/UserGroupInformation.java#L1232
//            if (!UserGroupInformation.isSecurityEnabled()
//                    || UserGroupInformation.getCurrentUser().getAuthenticationMethod() != KERBEROS
//                    || !UserGroupInformation.isLoginKeytabBased()) {
//                String keytab = "";
//                String principal = "";
//                UserGroupInformation.loginUserFromKeytab(principal, keytab);
////                LOGGER.info("Login successfully via keytab: {} and principal: {}", keytab, principal);
//            } else {
////                LOGGER.info("The user has already logged in using Keytab and principal, " +
////                        "no action required");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
////            LOGGER.error("Failed to get either keytab location or principal name in the " +
////                    "interpreter", e);
//        }
    }

    protected static boolean runKerberosLogin() {
        try {
            if (UserGroupInformation.isLoginKeytabBased()) {
                UserGroupInformation.getLoginUser().reloginFromKeytab();
                return true;
            } else if (UserGroupInformation.isLoginTicketBased()) {
                UserGroupInformation.getLoginUser().reloginFromTicketCache();
                return true;
            }
        } catch (Exception e) {
//            LOGGER.error("Unable to run kinit for zeppelin", e);
        }
        return false;
    }
}

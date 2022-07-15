package com.bonc.example.demo.pulsar;

import com.google.common.collect.Maps;
import org.apache.pulsar.client.api.Authentication;
import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;


import java.util.Map;

/**
 * @Author luoaojin
 * @Date 2021/8/12 10:48
 * @Description
 * @Version 1.0
 */
public class TestKerberos {
    public static void main(String[] args) throws PulsarClientException {
        System.setProperty("java.security.auth.login.config", "D:\\pulsar_jaas.conf");
        System.setProperty("java.security.krb5.conf", "D:\\krb5.conf");

        Map<String, String> authParams = Maps.newHashMap();
        authParams.put("saslJaasClientSectionName", "PulsarClient");
        authParams.put("serverType", "broker");

        Authentication saslAuth = AuthenticationFactory
                .create(org.apache.pulsar.client.impl.auth.AuthenticationSasl.class.getName(), authParams);

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://beh-2.bonc.com:6650")
                .authentication(saslAuth)
                .build();

    }
}

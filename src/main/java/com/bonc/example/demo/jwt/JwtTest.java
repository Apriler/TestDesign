package com.bonc.example.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.net.util.Base64;
import org.apache.kerby.kerberos.kerb.type.pa.pkinit.AlgorithmIdentifiers;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.security.AlgorithmConstraints;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static javax.crypto.Cipher.PUBLIC_KEY;

public class JwtTest {
    //生成jwt的秘钥
    private static String  PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuGbXWiK3dQTyCbX5xdE4\n" +
            "yCuYp0AF2d15Qq1JSXT/lx8CEcXb9RbDddl8jGDv+spi5qPa8qEHiK7FwV2KpRE9\n" +
            "83wGPnYsAm9BxLFb4YrLYcDFOIGULuk2FtrPS512Qea1bXASuvYXEpQNpGbnTGVs\n" +
            "WXI9C+yjHztqyL2h8P6mlThPY9E9ue2fCqdgixfTFIF9Dm4SLHbphUS2iw7w1JgT\n" +
            "69s7of9+I9l5lsJ9cozf1rxrXX4V1u/SotUuNB3Fp8oB4C1fLBEhSlMcUJirz1E8\n" +
            "AziMCxS+VrRPDM+zfvpIJg3JljAh3PJHDiLu902v9w+Iplu1WyoB2aPfitxEhRN0\n" +
            "YwIDAQAB";

    public static void main(String[] args) throws Exception {

//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIiLCJpc05vcm1hbCI6InRydWUiLCJtb2JsaWUiOiIxODYxMjM0MTIzNCIsImlzU3lzVGVuYW50IjoidHJ1ZSIsImxvZ2luSWQiOiJhZG1pbiIsIm9yZ3NfanNvbiI6Ilt7XCJpZFwiOlwiMTIzNFwiLFwib3JnTmFtZVwiOlwi6buY6K6k57uE57uH5py65p6EXCIsXCJvcmdUeXBlTmFtZVwiOlwi6KGM5pS_5py65p6EXCIsXCJwYXJlbnRJZFwiOlwiXCIsXCJwYXRoXCI6XCIvMTIzNFwiLFwidHlwZUlkXCI6XCIxMTFcIn1dIiwiaXNzIjoiYm9uYyIsImlzQWRtaW4iOiJ0cnVlIiwidXNlck5hbWUiOiLnrqHnkIblkZgiLCJ1c2VySWQiOiIxIiwiYXVkIjoiIiwidGVuYW50TmFtZSI6Iuezu-e7n-enn-aItyIsInJvbGVzX2pzb24iOiJbe1wiaWRcIjozLFwicm9sZUNvZGVcIjpcIsK3MjEzMTFcIixcInJvbGVOYW1lXCI6XCIyMTMyMTNcIn0se1wiaWRcIjoxLFwicm9sZUNvZGVcIjpcInJvb3RcIixcInJvbGVOYW1lXCI6XCLns7vnu5_nrqHnkIblkZhcIn0se1wiaWRcIjotMSxcInJvbGVDb2RlXCI6XCJ0ZW5hbnRfbWFuYWdlclwiLFwicm9sZU5hbWVcIjpcIuenn-aIt-euoeeQhuWRmFwifV0iLCJ0ZW5hbnRJZCI6InRlbmFudF9zeXN0ZW0iLCJpc01hbmFnZXIiOiJ0cnVlIiwiZXhwIjoxNjQyNjA2NjE1LCJlbWFpbCI6IjFAMTYzLmNvbSJ9.MkVvTMlLjjQeSNMVGlrvpuH8zfr7hq_aMyjz5TQwh1e_Pd9TjQgsCFhQdtEdlR_7i-_S2twt8znB2kPCq4X7_OdoO0zWTxFvQ3xvhgK-MgJgT_YnKTlqIuqBaKI34i-75uUK_oknfhdEtiP_YDnCaDnERDj5dI_QeFN0i0RX0QSzNbsEeOvdMvQ3Kl3YwggAsXTVQwM9zQ_w4YwfOt_hSOvD39ydJG4qsTTRMUUOXjksob12ggM3wQqELuesZRmOWrAQNaOQi_WES5sdMO3BP9OiI_yNlp3cyYH2rnKcDJoqPWNVHNTUSFiBTUnMhxocVVFR7pH2L5pG7PdR6jbpOg";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIiLCJpc05vcm1hbCI6InRydWUiLCJtb2JsaWUiOiIxODYxMjM0MTIzNCIsImlzU3lzVGVuYW50IjoidHJ1ZSIsImxvZ2luSWQiOiJhZG1pbiIsIm9yZ3NfanNvbiI6Ilt7XCJpZFwiOlwiMTIzNFwiLFwib3JnTmFtZVwiOlwi6buY6K6k57uE57uH5py65p6EXCIsXCJvcmdUeXBlTmFtZVwiOlwi6KGM5pS_5py65p6EXCIsXCJwYXJlbnRJZFwiOlwiXCIsXCJwYXRoXCI6XCIvMTIzNFwiLFwidHlwZUlkXCI6XCIxMTFcIn1dIiwiaXNzIjoiYm9uYyIsImlzQWRtaW4iOiJ0cnVlIiwidXNlck5hbWUiOiLnrqHnkIblkZgiLCJ1c2VySWQiOiIxIiwiYXVkIjoiIiwidGVuYW50TmFtZSI6Iuezu-e7n-enn-aItyIsInJvbGVzX2pzb24iOiJbe1wiaWRcIjozLFwicm9sZUNvZGVcIjpcIsK3MjEzMTFcIixcInJvbGVOYW1lXCI6XCIyMTMyMTNcIn0se1wiaWRcIjoxLFwicm9sZUNvZGVcIjpcInJvb3RcIixcInJvbGVOYW1lXCI6XCLns7vnu5_nrqHnkIblkZhcIn0se1wiaWRcIjotMSxcInJvbGVDb2RlXCI6XCJ0ZW5hbnRfbWFuYWdlclwiLFwicm9sZU5hbWVcIjpcIuenn-aIt-euoeeQhuWRmFwifV0iLCJ0ZW5hbnRJZCI6InRlbmFudF9zeXN0ZW0iLCJpc01hbmFnZXIiOiJ0cnVlIiwiZXhwIjoxNjQyNjA2NjE1LCJlbWFpbCI6IjFAMTYzLmNvbSJ9.MkVvTMlLjjQeSNMVGlrvpuH8zfr7hq_aMyjz5TQwh1e_Pd9TjQgsCFhQdtEdlR_7i-_S2twt8znB2kPCq4X7_OdoO0zWTxFvQ3xvhgK-MgJgT_YnKTlqIuqBaKI34i-75uUK_oknfhdEtiP_YDnCaDnERDj5dI_QeFN0i0RX0QSzNbsEeOvdMvQ3Kl3YwggAsXTVQwM9zQ_w4YwfOt_hSOvD39ydJG4qsTTRMUUOXjksob12ggM3wQqELuesZRmOWrAQNaOQi_WES5sdMO3BP9OiI_yNlp3cyYH2rnKcDJoqPWNVHNTUSFiBTUnMhxocVVFR7pH2L5pG7PdR6jbpOg";
//        String token ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRJZCI6ImNjYjIiLCJleHAiOjE1NTI0ODUxMzAsImlzcyI6ImNsb3VkaWlwLWJhc2ljLXBsYXRmb3JtIiwianRpIjoiYWJmNGE0OGItZjVhZi00MTEyLTg3OGMtMzYzNGI4N2MxNTdiIiwidXNlciI6IntcImFzc2lnblJlYXNvblwiOlwiXCIsXCJidXNpbmVzc1JlZ2lzdHJhdGlvbk51bWJlclwiOlwiXCIsXCJjb21wYW55TmFtZVwiOlwiXCIsXCJjb21wYW55U2NhbGVcIjpcIlwiLFwiY3JlYXRVc2VyXCI6XCJcIixcImNyZWF0ZURhdGVcIjp7XCJkYXRlXCI6MjYsXCJkYXlcIjoyLFwiaG91cnNcIjoxOCxcIm1pbnV0ZXNcIjo1MCxcIm1vbnRoXCI6MSxcInNlY29uZHNcIjoyOSxcInRpbWVcIjoxNTUxMTc4MjI5MDAwLFwidGltZXpvbmVPZmZzZXRcIjotNDgwLFwieWVhclwiOjExOX0sXCJkZXBhcnRtZW50XCI6XCJcIixcImRldmVsb3BlckF1ZGl0VGltZVwiOm51bGwsXCJkZXZlbG9wZXJBdXRoVGltZVwiOm51bGwsXCJkZXZlbG9wZXJSZWplY3RSZWFzb25cIjpcIlwiLFwiZGV2ZWxvcG1lbnREaXJlY3Rpb25cIjpcIlwiLFwiZGV2ZWxvcG1lbnRMYW5ndWFnZVwiOlwiXCIsXCJkdXR5XCI6XCJcIixcImVtYWlsXCI6XCJcIixcImV4dFwiOm51bGwsXCJpZFwiOjEwMTAwOCxcImlkTnVtYmVyXCI6XCJcIixcImltYWdlc1wiOltdLFwiaW5kdXN0cnlcIjpcIlwiLFwiaXNBZG1pblwiOmZhbHNlLFwiaXNBcHBseVwiOlwiXCIsXCJpc0RldmVsb3BlckF1dGhcIjpcIlwiLFwiaXNOb3JtYWxcIjpmYWxzZSxcImxvZ2luSWRcIjpcImNjYjJcIixcIm1lbW9cIjpcIlwiLFwibW9iaWxlXCI6XCIxODYxMjM0MTIzNCwgXCIsXCJvcmdUeXBlXCI6XCJcIixcIm9yZ3NcIjpbXSxcInBhc3N3b3JkXCI6XCJib25jXCIsXCJwb3NpdGlvblwiOlwiXCIsXCJwb3NpdGlvbkxldmVsXCI6XCJcIixcInByb3ZpZGVSZXNvdXJjZXNcIjpcIlwiLFwicHdkRXhwaXJlRGF0ZVwiOm51bGwsXCJxcU9wZW5JZFwiOlwiXCIsXCJyZWFsTmFtZUF1ZGl0VGltZVwiOm51bGwsXCJyZWFsTmFtZUF1dGhUaW1lXCI6bnVsbCxcInJlYWxOYW1lUmVqZWN0UmVhc29uXCI6XCJcIixcInJlc2VydmUxXCI6XCJcIixcInJlc2VydmUyXCI6XCJcIixcInJlc2VydmUzXCI6XCJcIixcInJlc2VydmU0XCI6XCJcIixcInJlc2VydmU1XCI6XCJcIixcInJvbGVzXCI6W3tcImNyZWF0VXNlclwiOlwiXCIsXCJjcmVhdGVUaW1lXCI6bnVsbCxcImlkXCI6LTEsXCJwYXJlbnRJZFwiOjAsXCJwYXJlbnRSb2xlXCI6bnVsbCxcInJvbGVDb2RlXCI6XCJ0ZW5hbnRfbWFuYWdlclwiLFwicm9sZU5hbWVcIjpcIuenn-aIt-euoeeQhuWRmFwiLFwicm9sZWluZm9zXCI6W10sXCJ1c2VyaW5mb3NcIjpbXX1dLFwic2V4XCI6bnVsbCxcInNleElkXCI6MCxcInRlbGVwaG9uZVwiOlwiXCIsXCJ1cGRhdGVEYXRlXCI6e1wiZGF0ZVwiOjI2LFwiZGF5XCI6MixcImhvdXJzXCI6MTgsXCJtaW51dGVzXCI6NTAsXCJtb250aFwiOjEsXCJzZWNvbmRzXCI6MjksXCJ0aW1lXCI6MTU1MTE3ODIyOTAwMCxcInRpbWV6b25lT2Zmc2V0XCI6LTQ4MCxcInllYXJcIjoxMTl9LFwidXNlckV4dFByb3BlcnR5VmFsdWVzXCI6W10sXCJ1c2VyTmFtZVwiOlwiY2NiMlwiLFwidXNlck9yZ3NcIjpcIlwiLFwidXNlclJvbGVzXCI6XCItMVwiLFwid3hPcGVuSWRcIjpcIlwifSJ9.fiz01d2P7KVTGQ57PJVIM05MBXiRCdjM3ifooPT5toEndYvUtfrpepJE2V3Seta0j-kN2zinvp1rIQDhisKb1EBlPDSgldd8EjwAuqr0n_uf5HmZgZ5e9W-Cq7uVS2BwUJ9ulZ3i5HwDs9qcmrrAjI39iXOv5m_0ANcR1kCvOeDEv0UoXLcIFkYpw-eD3O3HmKX_jxH2VziW_m-tai15CyWXwSSL08eNcNAo5wzbT-qhPIk02izq15ZUAsCGxaC1vLHUw-tNRup2RC9tAv_5fOyL8S6pn_MD4kbSOJDzH3A0JAuws6FyI-BIX5HLbpRFVVMxZNEllYQYGtw8IpuZXQ";

//        PublicKey publicKey = getPublicKey(JwtTest.pubkey);
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
//        System.out.println(claimsJws);
//        String str ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRJZCI6ImNjYjIiLCJleHAiOjE1NTI0ODUxMzAsImlzcyI6ImNsb3VkaWlwLWJhc2ljLXBsYXRmb3JtIiwianRpIjoiYWJmNGE0OGItZjVhZi00MTEyLTg3OGMtMzYzNGI4N2MxNTdiIiwidXNlciI6IntcImFzc2lnblJlYXNvblwiOlwiXCIsXCJidXNpbmVzc1JlZ2lzdHJhdGlvbk51bWJlclwiOlwiXCIsXCJjb21wYW55TmFtZVwiOlwiXCIsXCJjb21wYW55U2NhbGVcIjpcIlwiLFwiY3JlYXRVc2VyXCI6XCJcIixcImNyZWF0ZURhdGVcIjp7XCJkYXRlXCI6MjYsXCJkYXlcIjoyLFwiaG91cnNcIjoxOCxcIm1pbnV0ZXNcIjo1MCxcIm1vbnRoXCI6MSxcInNlY29uZHNcIjoyOSxcInRpbWVcIjoxNTUxMTc4MjI5MDAwLFwidGltZXpvbmVPZmZzZXRcIjotNDgwLFwieWVhclwiOjExOX0sXCJkZXBhcnRtZW50XCI6XCJcIixcImRldmVsb3BlckF1ZGl0VGltZVwiOm51bGwsXCJkZXZlbG9wZXJBdXRoVGltZVwiOm51bGwsXCJkZXZlbG9wZXJSZWplY3RSZWFzb25cIjpcIlwiLFwiZGV2ZWxvcG1lbnREaXJlY3Rpb25cIjpcIlwiLFwiZGV2ZWxvcG1lbnRMYW5ndWFnZVwiOlwiXCIsXCJkdXR5XCI6XCJcIixcImVtYWlsXCI6XCJcIixcImV4dFwiOm51bGwsXCJpZFwiOjEwMTAwOCxcImlkTnVtYmVyXCI6XCJcIixcImltYWdlc1wiOltdLFwiaW5kdXN0cnlcIjpcIlwiLFwiaXNBZG1pblwiOmZhbHNlLFwiaXNBcHBseVwiOlwiXCIsXCJpc0RldmVsb3BlckF1dGhcIjpcIlwiLFwiaXNOb3JtYWxcIjpmYWxzZSxcImxvZ2luSWRcIjpcImNjYjJcIixcIm1lbW9cIjpcIlwiLFwibW9iaWxlXCI6XCIxODYxMjM0MTIzNCwgXCIsXCJvcmdUeXBlXCI6XCJcIixcIm9yZ3NcIjpbXSxcInBhc3N3b3JkXCI6XCJib25jXCIsXCJwb3NpdGlvblwiOlwiXCIsXCJwb3NpdGlvbkxldmVsXCI6XCJcIixcInByb3ZpZGVSZXNvdXJjZXNcIjpcIlwiLFwicHdkRXhwaXJlRGF0ZVwiOm51bGwsXCJxcU9wZW5JZFwiOlwiXCIsXCJyZWFsTmFtZUF1ZGl0VGltZVwiOm51bGwsXCJyZWFsTmFtZUF1dGhUaW1lXCI6bnVsbCxcInJlYWxOYW1lUmVqZWN0UmVhc29uXCI6XCJcIixcInJlc2VydmUxXCI6XCJcIixcInJlc2VydmUyXCI6XCJcIixcInJlc2VydmUzXCI6XCJcIixcInJlc2VydmU0XCI6XCJcIixcInJlc2VydmU1XCI6XCJcIixcInJvbGVzXCI6W3tcImNyZWF0VXNlclwiOlwiXCIsXCJjcmVhdGVUaW1lXCI6bnVsbCxcImlkXCI6LTEsXCJwYXJlbnRJZFwiOjAsXCJwYXJlbnRSb2xlXCI6bnVsbCxcInJvbGVDb2RlXCI6XCJ0ZW5hbnRfbWFuYWdlclwiLFwicm9sZU5hbWVcIjpcIuenn-aIt-euoeeQhuWRmFwiLFwicm9sZWluZm9zXCI6W10sXCJ1c2VyaW5mb3NcIjpbXX1dLFwic2V4XCI6bnVsbCxcInNleElkXCI6MCxcInRlbGVwaG9uZVwiOlwiXCIsXCJ1cGRhdGVEYXRlXCI6e1wiZGF0ZVwiOjI2LFwiZGF5XCI6MixcImhvdXJzXCI6MTgsXCJtaW51dGVzXCI6NTAsXCJtb250aFwiOjEsXCJzZWNvbmRzXCI6MjksXCJ0aW1lXCI6MTU1MTE3ODIyOTAwMCxcInRpbWV6b25lT2Zmc2V0XCI6LTQ4MCxcInllYXJcIjoxMTl9LFwidXNlckV4dFByb3BlcnR5VmFsdWVzXCI6W10sXCJ1c2VyTmFtZVwiOlwiY2NiMlwiLFwidXNlck9yZ3NcIjpcIlwiLFwidXNlclJvbGVzXCI6XCItMVwiLFwid3hPcGVuSWRcIjpcIlwifSJ9.fiz01d2P7KVTGQ57PJVIM05MBXiRCdjM3ifooPT5toEndYvUtfrpepJE2V3Seta0j-kN2zinvp1rIQDhisKb1EBlPDSgldd8EjwAuqr0n_uf5HmZgZ5e9W-Cq7uVS2BwUJ9ulZ3i5HwDs9qcmrrAjI39iXOv5m_0ANcR1kCvOeDEv0UoXLcIFkYpw-eD3O3HmKX_jxH2VziW_m-tai15CyWXwSSL08eNcNAo5wzbT-qhPIk02izq15ZUAsCGxaC1vLHUw-tNRup2RC9tAv_5fOyL8S6pn_MD4kbSOJDzH3A0JAuws6FyI-BIX5HLbpRFVVMxZNEllYQYGtw8IpuZXQ";
        System.out.println(isVerify(token));
        parseJWT(token);

    }

    /**
     * Token的解密
     * @param token 加密后的token
     * @param user  用户的对象
     * @return
     * @throws Exception
     * @throws IllegalArgumentException
     */
//    public static Map<String,String> parseJWT(String token) throws IllegalArgumentException, Exception {
//        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey)RSAUtil.string2PublicKey(PUBLIC_KEY),null);
//        JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(System.currentTimeMillis()).build();
//        DecodedJWT jwt = verifier.verify(token);
//        String userJson = jwt.getClaim("user").asString();
//        String tenantId = jwt.getClaim("tenantId").asString();
//        Map<String,String> info = new HashMap<String,String>();
//        info.put("user", userJson);
//        System.out.println(userJson);
//        info.put("tenant",tenantId);
//        System.out.println(tenantId);
//        return info;
//    }


    /**
     * 校验token
     * 主要校验解密及token超时时长
     * @param token
     * @param user
     * @return
     */
    public static Boolean isVerify(String token) {
        try{
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey)RSAUtil.string2PublicKey(PUBLIC_KEY),null);
            JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(System.currentTimeMillis()).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Token的解密
     * @param token 加密后的token
     * @param user  用户的对象
     * @return
     * @throws Exception
     * @throws IllegalArgumentException
     */
    public static Map<String,String> parseJWT(String token) throws IllegalArgumentException, Exception {
        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey)RSAUtil.string2PublicKey(PUBLIC_KEY),null);
        JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(System.currentTimeMillis()).build();
        DecodedJWT jwt = verifier.verify(token);
        String userJson = jwt.getClaim("user").asString();
        String tenantId = jwt.getClaim("tenantId").asString();
        Map<String,String> info = new HashMap<String,String>();
        info.put("user", userJson);
        System.out.println(userJson);
        info.put("tenant",tenantId);
        System.out.println(tenantId);
        return info;
    }

    private static PublicKey getPublicKey(String publicKeyBase64) throws Exception {
        String pem = publicKeyBase64
                .replaceAll("-*BEGIN.*KEY-*", "")
                .replaceAll("-*END.*KEY-*", "")
                .replaceAll("\\s+","");
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(pem));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PublicKey publicKey = keyFactory.generatePublic(pubKeySpec);
        return publicKey;
    }


}

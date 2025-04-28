package com.example.demo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HisenseApiClient {
    public static void main(String[] args) {
        try {
            // API 地址
            String url = "https://open-apisix-test.hisense.com/hcrm/api/SL/CreateWorkOrder";
            String secretKey = "h9r8kvkz";

            // 请求体数据（传统拼接方式）
            String requestBody = "{"
                    + "\"area\":\"南山区\","
                    + "\"areaCode\":\"440305\","
                    + "\"bookingRange\":\"上午\","
                    + "\"boxId\":33517,"
                    + "\"city\":\"深圳市\","
                    + "\"cityCode\":\"440300\","
                    + "\"customerAddress\":\"深圳市南山区科技园\","
                    + "\"customerNumber\":\"C02697666\","
                    + "\"description\":\"冰柜制冷问题\","
                    + "\"linkMan\":\"黄生\","
                    + "\"linkMobile\":\"15986704258\","
                    + "\"modelName\":\"SC-518WYSL/HP\","
                    + "\"province\":\"广东省\","
                    + "\"provinceCode\":\"440000\","
                    + "\"requireServiceDate\":\"2025-01-13\""
                    + "}";

            // 时间戳生成（RFC 1123 格式）
            SimpleDateFormat rfc1123Format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
            rfc1123Format.setTimeZone(TimeZone.getTimeZone("GMT"));
            String timestamp = rfc1123Format.format(new Date());

            // 签名字符串
            String signatureString = "POST\n/hcrm/api/SL/CreateWorkOrder\n" + secretKey + "\n" + timestamp + "\n" + requestBody;

            // 签名生成
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] rawSignature = mac.doFinal(signatureString.getBytes(StandardCharsets.UTF_8));

            // 将签名转换为十六进制字符串
            StringBuilder signature = new StringBuilder();
            for (byte b : rawSignature) {
                signature.append(String.format("%02x", b));
            }

            // 调试输出
            System.out.println("Signature String: " + signatureString);
            System.out.println("Generated Signature: " + signature);
            System.out.println("Timestamp: " + timestamp);

            // 构建请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("hisense-hc-date", timestamp);
            headers.set("hisense-hc-sign", signature.toString());

            // 使用 RestTemplate 发送请求
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            // 打印响应
            System.out.println("Response: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
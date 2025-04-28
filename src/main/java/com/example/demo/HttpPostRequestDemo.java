package com.example.demo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostRequestDemo {

    public static void main(String[] args) {
        // 循环次数，根据需要更改
//        int loopCount = 10;
//
//        for (int i = 0; i < loopCount; i++) {
//            try {
//                sendPOSTRequest();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        String relateCode = "Bac_sdf_1dsdsd";
        String[] strArray = relateCode.split("_");
        System.out.println(strArray[2]);
    }

    private static void sendPOSTRequest() throws Exception {
        URL url = new URL("http://oa.szeastroc.com:8008/servlet/ZdWorkflow");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        // 这里是你的JSON请求体
        String jsonInputString = "{\"json\": {\"bbMoney\":\"4780.46\", ... }}";  // 请完善此JSON字符串

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        String responseMessage = con.getResponseMessage();
        System.out.println("POST Response Code :: " + responseCode);

        con.disconnect();
    }
}


package com.example.demo;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@SpringBootTest
class DemoApplicationTests {
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    @Test
    void contextLoads() {

    }
    @Test
    void httpTest() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Map headParam = new HashMap();
        Map restParam = new HashMap();
        headParam.put("userCode","ex_lirh6");
        headParam.put("userName","李日红");
        headParam.put("userKey","TOKEN_67A988ECFFFFFF820A8F135DECFE516A");
        headParam.put("transactionId","b362c62eedfaf5f213a41e9a00c3523f");

        restParam.put("sourceBusinessType","2C");
        restParam.put("sellerTenantCode","T20201223044744");
        restParam.put("searchState","7");


        RequestBody formBody = new FormBody.Builder()
                .add("headParams", headParam.toString())
                .add("restParam", restParam.toString())
                .build();

        Request request = new Request.Builder().get()
                .url("https://mcsp.midea.com/api/mcsp_ofc/mcsp-order-fulfilment-center/order-fulfilment/fulfilmentOrderQuery/retrieveSaleOrderToCList")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Content-Type","application/json")
                .post(formBody).build();
        
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }

}

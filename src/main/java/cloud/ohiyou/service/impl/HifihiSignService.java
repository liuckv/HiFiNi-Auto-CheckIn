package cloud.ohiyou.service.impl;

import okhttp3.*;
import java.io.IOException;
import java.util.Collections;

public class HifihiSignService {

    private final OkHttpClient client;

    public HifihiSignService() {

        client = new OkHttpClient.Builder()
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .retryOnConnectionFailure(true)
                .build();
    }

    public String sign(String cookie) {

        String url = "https://www.hifini.com/plugin.php?id=dsu_paulsign:sign";

        Request request = new Request.Builder()
                .url(url)
                .header("Cookie", cookie)
                .header("User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/120 Safari/537.36")
                .get()
                .build();

        try {

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                return "签到成功";
            }

            return "签到失败 HTTP:" + response.code();

        } catch (IOException e) {

            return "签到异常: " + e.getMessage();
        }
    }
}

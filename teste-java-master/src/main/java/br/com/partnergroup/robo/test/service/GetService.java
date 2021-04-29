package br.com.partnergroup.robo.test.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetService{

    public String criaConexao(String url, CloseableHttpClient httpclient) throws IOException{

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);

            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            Document document = Jsoup.parse(EntityUtils.toString(response.getEntity()));
            String imgCaptcha = document.getElementById("imgCaptcha").toString();
            String img64 = imgCaptcha.substring(69, imgCaptcha.length() - 3);
            EntityUtils.consume(entity);
            return img64;

    }
}

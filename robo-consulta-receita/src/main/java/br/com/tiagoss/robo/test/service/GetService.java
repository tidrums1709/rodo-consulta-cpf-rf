package br.com.tiagoss.robo.test.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class GetService{

    public String criaConexao(String url, CloseableHttpClient httpclient) throws IOException{

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);

        System.out.println(response.getStatusLine());
        HttpEntity entity = response.getEntity();
        Document document = Jsoup.parse(EntityUtils.toString(response.getEntity()));

        Element img = document.getElementById("imgCaptcha");
        String imgCaptcha = img.attr("src");

        String img64 = imgCaptcha.replace("data:image/png;base64,", "");

        EntityUtils.consume(entity);
            return img64;

    }
}

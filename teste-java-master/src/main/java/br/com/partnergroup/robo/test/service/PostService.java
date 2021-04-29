package br.com.partnergroup.robo.test.service;

import br.com.partnergroup.robo.test.model.Consulta;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostService {

    public String criaconexao(String url, Consulta parametros, CloseableHttpClient httpclient) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> parametrosPair = new ArrayList<>();
        parametrosPair.add(new BasicNameValuePair("idCheckedReCaptcha", "false"));
        parametrosPair.add(new BasicNameValuePair("txtCPF", parametros.getCpf()));
        parametrosPair.add(new BasicNameValuePair("txtDataNascimento", parametros.getDataNascimento()));
        parametrosPair.add(new BasicNameValuePair("txtTexto_captcha_serpro_gov_br", parametros.getCaptha()));
        parametrosPair.add(new BasicNameValuePair("Enviar", "Consultar"));
        httpPost.setEntity(new UrlEncodedFormEntity(parametrosPair));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            Document document = Jsoup.parse(EntityUtils.toString(response.getEntity()));
            Elements p = document.getElementsByTag("p");
            String text = p.text();
            if(text.length() == 0){
                throw new RuntimeException("Não foi possível obter os dados. Verifique os dados e tente novamente");
            }
            EntityUtils.consume(entity);
            return text;
        }
        finally {
            response.close();
        }
    }
}

package io.renren;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class deleteTest {

    public static void main(String[] args) {
        String url="http://localhost:8080/api/deleteMessage";
        String json="[{\"newsUrl\":\"http://cordial99.blog.163.com\"}," +
                "{\"newsUrl\":\"http://cordial99.blog.163.com/xxxxx\"}]";
        try {
            httpPostWithJSON(url,json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void httpPostWithJSON(String url, String json) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        StringEntity myEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        post.setEntity(myEntity);
        String responseContent = null; // 响应内容
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
                System.out.println(responseContent);
            }
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (response != null)
                    response.close();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    if(client != null)
                        client.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

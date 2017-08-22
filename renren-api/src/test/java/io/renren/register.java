package io.renren;

import net.sf.json.JSONObject;
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

/**
 * Created by 李博 on 2017-06-19.
 */
public class register {

    public static void main(String[] args) {
        String url="http://127.0.0.1:8080/api/register";
        String json="{\"mobile\":\"13720737094\",\"password\":\"13720737094\"}";
        try {
            httpPostWithJSON(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void httpPostWithJSON(String url) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mobile","13720737094");
        jsonObject.put("password","123456");
        StringEntity myEntity = new StringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON);
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

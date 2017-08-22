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

/**
 * Created by 李博 on 2017-06-16.
 */
public class insertTest {

    public static void main(String[] args) {
        String url="http://10.63.24.11/release/api/insertMessage";
        String json="[{\"releaseTime\":\"2017-09-14 15:03:52\",\"modifiedTime\":\"2017-09-14 15:10:52\",\"newsTitle\":\"韩宏琪深入渭滨办调研指导基层党建工作\",\"newsUrl\":\"http://cordial99.blog.163.com\",\"editor\":\"李媛\",\"source\":\"区信息中心\",\"website\":\"秦都区人民政府x\"}," +
                "{\"website\":\"三原县人民政府\",\"releaseTime\":\"2017-09-13 18:23:31\",\"modifiedTime\":\"2017-09-13 18:23:31\",\"newsTitle\":\"我县收看全国推进简政放权放管结合优化服务改革电视电话会议\",\"newsUrl\":\"http://cordial99.blog.163.com/xxxxx\",\"editor\":\"杨小龙\",\"source\":\"信息办\"}]";
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

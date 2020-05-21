package com.course.httpclient.demo;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-05-20 19:42
 */
public class MyHttpClient {
    @Test
    public void test()throws IOException {
        //存放结果
        String result;
        HttpGet get = new HttpGet("https://www.baidu.com");
        //这个是用来执行get方法的
        //HttpClient httpClient = new DefaultHttpClient();
        //HttpResponse response = client.execute(get)
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        
    }
}

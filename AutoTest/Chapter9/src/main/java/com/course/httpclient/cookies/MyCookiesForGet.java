package com.course.httpclient.cookies;

import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author shkstart
 * @create 2020-05-20 21:48
 */
public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    BasicCookieStore basicCookieStore = null;
    String result;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }
    @Test
    public void testGetCookies()throws IOException {


        //从配置文件中拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        //测试逻辑代码书写
        HttpGet get = new HttpGet(url+uri);
        basicCookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
        CloseableHttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies
        List<Cookie> cookies = basicCookieStore.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies: key= "+ name + "  value= " + value);
        }
    }
    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies()throws IOException{
        String uri = bundle.getString("get.with.cookie");
        String testurl = url+uri;
        HttpGet get =new HttpGet(testurl);
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
        CloseableHttpResponse response = client.execute(get);
        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode == 200){
            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }else {
            System.out.println("测试失败");
        }
    }
}

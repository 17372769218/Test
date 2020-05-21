package com.course.httpclient.cookies;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author shkstart
 * @create 2020-05-21 20:49
 */
public class MyCookiesForPost {
    BasicCookieStore basicCookieStore = null;
    private String uri;
    private String url;
    private String testurl = uri+url;
    private ResourceBundle bundle;
    private String result;
    @BeforeTest
    public void test(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url =bundle.getString("test.url");
    }
    @Test
    public void test1()throws IOException {
        uri =bundle.getString("getCookies.post");
        testurl =url+uri;
        HttpPost post = new HttpPost(testurl);
        basicCookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
        CloseableHttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        List<Cookie> cookies = basicCookieStore.getCookies();
        for (Cookie c : cookies){
            String name = c.getName();
            String value = c.getValue();
            System.out.println(name+"+"+value);
        }
    }
    @Test(dependsOnMethods = "test1")
    public void test2()throws Exception{
        uri = bundle.getString("post.with.cookie");
        testurl = url+uri;
        //声明一个client对象，用来进行方法的执行
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(basicCookieStore).build();
        //声明一个方法，就是post方法
        HttpPost post = new HttpPost(testurl);
        //填写参数
        JSONObject param = new JSONObject();
        param.put("name","wjt");
        param.put("age","18");
        //设置请求头信息 设置header信息
        post.setHeader("content-typy","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        //设置cookie信息
        //执行post方法
        CloseableHttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应结果字符串转化为json对象
        JSONObject resultjson = new JSONObject(result);
        //获取到结果值
        String success = (String) resultjson.get("wjt");
        String status = (String) resultjson.get("status");
        //具体的判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }
}

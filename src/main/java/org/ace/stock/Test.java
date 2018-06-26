package org.ace.stock;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.ace.stock.pojo.Stock;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
	//	get();
		File file = new File("~/");
        System.out.println(file.getAbsoluteFile());
        System.out.println(System.getProperty("user.home"));
	}
	
	public static void get() {  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {  
            // 创建httpget.    
            HttpGet httpget = new HttpGet("http://qt.gtimg.cn/q=sh601216");  
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.    
            CloseableHttpResponse response = httpclient.execute(httpget);  
            try {  
                // 获取响应实体    
                HttpEntity entity = response.getEntity();  
                System.out.println("--------------------------------------");
                // 打印响应状态    
                System.out.println(response.getStatusLine());
                if (entity != null) {  
                    // 打印响应内容长度    
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容    
                    String msg = EntityUtils.toString(entity);
                    System.out.println("Response content: " + msg);
                    Stock stock = new Stock(msg);
                    System.out.println(stock);
                    stock.setMyPrice(5.11f);
                    stock.setCount(200);
//                    System.out.println("盈亏:" +stock.getEarning() );
                }  
                System.out.println("------------------------------------");
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {
                e.printStackTrace();  
            }  
        }  
    }  
}

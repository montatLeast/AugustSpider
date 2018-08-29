package Worm;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class AbstractSpider {
	public static String getResult(String url) throws Exception {
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				CloseableHttpResponse response = httpClient.execute(new HttpGet(url))){
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something Wrong!");
			return "";
		}
	}
}

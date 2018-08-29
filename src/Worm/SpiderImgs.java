package Worm;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderImgs {
	
	public  SpiderImgs(String url) throws Exception{
		// TODO 
		String result = AbstractSpider.getResult(url);
		Document document = Jsoup.parse(result);
		document.setBaseUri(url);
		
		Elements elements = document.select("img");
		for(Element e : elements) {
			String src = e.absUrl("src"); //绝对url路径
			URL urlSource = new URL(src);
			URLConnection urlConnection = urlSource.openConnection();
			String imageName = src.substring(src.lastIndexOf("/") + 1, src.length());
			System.out.println(src);
			InputStream inputStream = urlConnection.getInputStream();
			OutputStream outputStream = new FileOutputStream(new File("E:\\imgs\\", imageName));
			byte[] buf = new byte[1024];
			int l = 0;
			while((l = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, l);
			}
		}
	}
}

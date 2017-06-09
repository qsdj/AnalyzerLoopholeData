package david.apache.crawlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ApacheCrawlet {

	private OutputStream outputStream;
	private CloseableHttpClient closeableHttpClient;

	public ApacheCrawlet() {
		try {
			closeableHttpClient = HttpClients.custom().build();
		} catch (Exception e) {
		}
	}

	public void crawlet(String url, String path) {
		try {
			outputStream = new FileOutputStream(path);
			HttpUriRequest request = new org.apache.http.client.methods.HttpGet(url);
			CloseableHttpResponse response = closeableHttpClient.execute(request);
			HttpEntity entity = response.getEntity();
			entity.writeTo(outputStream);
		} catch (Exception e) {
			System.err.println("抓取失败！" + path);
		}
	}

	public void start() throws Exception {
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ip.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String dir = "D:\\国家漏洞详细数据\\";
		File dirFile = new File(dir);
		if (!dirFile.exists())
			dirFile.mkdirs();
		List<String> list = new ArrayList<>();
		while (reader.ready()) {
			String string = reader.readLine();
			if (!string.equals("")) {
				string = string.split("\t")[0];
				if (string.length() > 4) {
					string = string.substring(3);
					list.add(string);
				}
			}
		}
		System.out.println(list.size());
		reader.close();
		for (int i = 0; i < list.size(); i++)
			crawlet(list.get(i), dir + (i+1) + ".txt");
	}

}

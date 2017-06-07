package david.data.crawlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrwaletFile {
	private OutputStream outputStream;
	private CloseableHttpClient closeableHttpClient;
	private String path="D:\\国家漏洞详细数据\\";
	private String pathFile="D:\\国家漏洞库ip地址.txt";
	public CrwaletFile() {
		try {
			closeableHttpClient = HttpClients.custom().build();
		} catch (Exception e) {
		}
	}

	public void analyzerDir() {
		String path = "D:\\国家漏洞详细数据\\";
		File file[] = new File(path).listFiles();
		if (file != null && file.length > 0) {
			for (File file2 : file) {
				try {
					loop(file2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				file2.delete();
			}
		}
	}

	private void loop(File file) throws Exception {
		Document document = Jsoup.parse(file, "UTF-8");
		Elements element = document.select("tbody");
		LoopBean bean = null;
		List<LoopBean> list = new ArrayList<>();
		String id = null;
		String date = null;
		String name = null;
		String url = null;
		for (Element element2 : element) {
			if (element2.toString().contains("middle") && !element2.toString().contains("最后一页")) {
				Elements elements = element2.select("tr");
				for (Element element3 : elements) {
					if (element3.toString().contains("middle")) {
						Elements elements4 = element3.select("td");
						for (Element element4 : elements4) {
							if (element4.toString().contains("15%")) {
								String context = element4.text();
								if (context.length() != 10) {
									id = element4.select("a").attr("title");
									url = "http://www.cnnvd.org.cn" + element4.select("a").attr("href");
									if (url.length() == 70) {
										id = id + "\t";
										url = url + "\t";
									}
								} else if (context.length() == 10)
									date = context;
							}
							if (element4.toString().contains("45%")) {
								name = element4.select("a").attr("title");
							}
							if (date != null) {
								bean = new LoopBean(id, name, date, url);
								list.add(bean);
								date = null;
							}
						}
					}
				}
			}
		}
		Writer writer = new FileWriter("D:\\国家漏洞库ip地址.txt", true);
		for (LoopBean loopBean : list) {
			writer.write(loopBean.toString());
		}
		writer.flush();
		writer.close();
	}

	private void crawlet(String url) {
		try {
			Random random=new Random();
			outputStream = new FileOutputStream(path+random.nextInt());
			HttpUriRequest request = new org.apache.http.client.methods.HttpGet(url);
			CloseableHttpResponse response = closeableHttpClient.execute(request);
			HttpEntity entity = response.getEntity();
			entity.writeTo(outputStream);
		} catch (Exception e) {
		}
	}

	public void start() throws Exception {
		File file=new File(pathFile);
		if(!file.exists())
			return;
		InputStream stream = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
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
		for (String string : list) {
			crawlet(string);
		}
		file.delete();
	}
}

class LoopBean {
	private String id;
	private String name;
	private String date;
	private String url;

	public LoopBean(String id, String name, String date, String url) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.url = url;
	}

	@Override
	public String toString() {
		return "地址:" + url + "\t\t漏洞ID:" + id + "\t\t公布时间:" + date + "\t\t漏洞名字:" + name + "\r\n";
	}
}

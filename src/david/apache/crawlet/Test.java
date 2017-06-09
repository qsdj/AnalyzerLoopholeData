package david.apache.crawlet;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		for (int i = 1; i <= 4763; i++) {
			loop("G:\\国家漏洞库\\国家漏洞信息第" + i + "页\\" + i + ".txt");
			System.out.println("分析完" + i);
		}
	}

	public static void loop(String ip) throws Exception {
		File file = new File(ip);
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

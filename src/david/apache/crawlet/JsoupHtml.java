package david.apache.crawlet;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupHtml {
	private List<String> list = new ArrayList<>(1000);
	private List<String> ergodic = new ArrayList<>(1000);
	private final String AddApth = "D:\\1.txt";
	private int depth;
	private int dp;

	public JsoupHtml() {
	}

	public JsoupHtml(int depth) {
		this.depth = depth;
	}

	private void start(String url) throws Exception {
		Connection connection = Jsoup.connect(url);
		Response response = connection.execute();
		Element doc = response.parse();
		Elements elements = doc.select("a");
		for (Element element : elements) {
			String string = element.attr("abs:href");
			if (string.length() > 0 && string.startsWith("http"))
				list.add(string);
		}
		ergodic.add(url);
		refresh(list);
		noGrgodic(list);
	}

	private void refresh(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			int s = list.lastIndexOf(list.get(i));
			if (i != s)
				list.remove(i--);
		}
	}

	private void scan() throws Exception {
		list.addAll(ergodic);
		Collections.sort(list);
		Writer writer = new FileWriter(AddApth);
		for (String string : list)
			writer.write(string + "\r\n");
		writer.write("\r\n");
		writer.write("##########下面是分析成功的url地址！###########");
		writer.write("\r\n");
		for (String string : ergodic)
			writer.write(string + "\r\n");
		writer.flush();
		writer.close();
	}

	private void noGrgodic(List<String> list) {
		for (String string : ergodic) {
			int s = 0;
			while ((s = list.lastIndexOf(string)) >= 0) {
				list.remove(s);
			}
		}
	}

	public void loop(List<String> l) {
		List<String> url = new ArrayList<>();
		url = l;
		while (depth >= 0) {
			if (list.size() > 0) {
				url.clear();
				for (String string : list)
					url.add(string);
			}
			for (String string : url) {
				try {
					start(string);
					System.out.println("抓取" + string + "成功！");
				} catch (Exception e) {
					System.err.println("抓取" + string + "失败！");
				}
			}
			System.out.println("第" + (dp++) + "层网站抓取成功！一共" + list.size());
			this.depth--;
		}
		try {
			scan();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		try {
			JsoupHtml html = new JsoupHtml(1);
			List<String> list = new ArrayList<>();
			list.add("http://www.cnnvd.org.cn/vulnerability/index/p/1/");
			html.loop(list);
		} catch (Exception e) {
		}
	}
}

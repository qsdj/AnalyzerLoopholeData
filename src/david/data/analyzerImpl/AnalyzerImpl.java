package david.data.analyzerImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import david.data.Ianalyzer.IAnalyzer;
import david.data.bean.DataBean;
import david.data.mysql.ConnDataSoure;

public class AnalyzerImpl implements IAnalyzer {
	private String url = "http://www.cnnvd.org.cn/vulnerability/show/cv_cnnvdid/";

	private StringBuilder builder = new StringBuilder();

	public void analyzer(File file) throws Exception {
		Element element = Jsoup.parse(file, "UTF-8");
		Elements elements = element.select(".cont_details,.rht_cont");
		String relevantLoophole = "";
		String effectEntity = "";
		String patch = "";
		for (Element element2 : elements) {
			Elements vc = element2.select("td");
			for (Element element3 : vc) {
				String vce = element3.text();
				if (vce.contains("CVE-"))
					builder.append(vce + "\r\n");
			}

			Elements e = element2.select(".displayitem");
			if (e.size() > 0) {
				for (Element element3 : e)
					if (!element3.text().equals(""))
						builder.append(element3.text() + "\r\n");
			} else {
				Elements elements2 = element2.select("a[title]");
				for (Element element3 : elements2)
					relevantLoophole += element3.attr("title") + ",";
			}
			Elements e1 = element2.select("span");
			if (e1.size() > 0) {
				for (Element element3 : e1) {
					if (element3.toString().contains("patch"))
						patch += element3.attr("title") + ",";
					else
						effectEntity += element3.attr("title") + ",";
				}
			}
		}
		if (relevantLoophole == "")
			return;

		if (patch == "")
			builder.append("暂无数据\r\n");
		else
			builder.append(patch.substring(0, patch.length() - 1) + "\r\n");
		if (effectEntity == "")
			builder.append("暂无数据\r\n");
		else
			builder.append(effectEntity.substring(0, effectEntity.length() - 1) + "\r\n");

		builder.append(relevantLoophole.substring(0, relevantLoophole.length() - 1) + "\r\n");
		relevantLoophole = "";
		effectEntity = "";
		patch = "";
		builder.append("##############################\r\n");
		file.delete();
	}

	public void dataWrite() throws Exception {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\数据分析结果.txt"));
		bufferedWriter.write(builder.toString());
		bufferedWriter.flush();
		bufferedWriter.close();
		readerData();
	}

	private void readerData() throws Exception {
		List<DataBean> list = new ArrayList<>();
		DataBean bean = null;
		String line = "#";
		File file=new File("D:\\数据分析结果.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while (reader.ready()) {
			String string = line;
			if (string.startsWith("#")) {
				String cve = reader.readLine();
				if (cve.contains("CVE-")) {
					String key = reader.readLine();
					if (key.contains("漏洞")) {
						String ccn = reader.readLine();
						bean = new DataBean(ccn, key, reader.readLine(), reader.readLine(), reader.readLine(),
								reader.readLine(), reader.readLine(), cve, reader.readLine() + reader.readLine(),
								reader.readLine(), reader.readLine(), reader.readLine(), "", url + ccn);
						line = reader.readLine();
						if (line != null && !line.startsWith("#")) {
							bean.setRelevantLoophole(line);
							list.add(bean);
						}
					} else if (key.contains("CNNVD")) {
						bean = new DataBean(key, "该漏洞没有名称", reader.readLine(), reader.readLine(), reader.readLine(),
								reader.readLine(), "存在危险", cve, reader.readLine(), reader.readLine(), reader.readLine(),
								"暂无数据", reader.readLine(), url + key);
						list.add(bean);
					}
				}
			} else {
				string = reader.readLine();
				line = string;
			}
		}
		reader.close();
		repeats(list);
		file.delete();
		mysql(list);
	}

	private void repeats(List<DataBean> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++)
			if (list.get(i).getCNNVD_ID().equals(list.get(i + 1).getCNNVD_ID())) {
				list.remove(list.get(i + 1));
				i--;
			}
	}

	private void mysql(List<DataBean> list) {
		String sql = "insert into loopholedata values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnDataSoure conn = new ConnDataSoure();
		conn.setSql(sql);
		for (DataBean bean : list) {
			conn.DataSouce(bean.getCNNVD_ID(), bean.getLoopholeName(), bean.getPublishTime(), bean.getUpdateTime(),
					bean.getDangerGrade(), bean.getLoopholeType(), bean.getDangerType(), bean.getCVE_ID(),
					bean.getLoopholeIntroduce(), bean.getLoopholeAnnounce(), bean.getLoopholePatch(),
					bean.getEffectEntity(), bean.getRelevantLoophole(), bean.getLoopholeURL());
		}
	}

}

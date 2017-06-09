package david.data.crawletList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import david.data.mysql.ConnDataSoure;

public class CrwaletDir {

	private boolean flag = true;
	private OutputStream outputStream;
	private CloseableHttpClient closeableHttpClient;
	private String path = "D:\\国家漏洞详细数据\\";
	private String httpUrl;
	private List<String> list = new ArrayList<>();

	public CrwaletDir() {
		try {
			closeableHttpClient = HttpClients.custom().build();
			File file = new File(path);
			if (!file.exists())
				file.mkdirs();
			else {
				File f[] = file.listFiles();
				if (f != null && f.length > 0) {
					for (File file2 : f)
						file2.delete();
				} else
					file.delete();
				file.mkdirs();
			}
		} catch (Exception e) {
		}
	}

	public void crwaletDirLoop() {
		int i = 1;
		String url = "http://www.cnnvd.org.cn/vulnerability/index/p/";
		String key = null;
		try {
			key = MySqlKey();
			System.out.println("最新ID："+key);
			if (key == null)
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (flag) {
			crawlet(url + i + "/", key);
			i++;
		}
		for (String string : list) {
			System.out.println(string);
			crawlet(string);
		}
	}

	private void crawlet(String url, String key) {
		try {
			HttpUriRequest request = new org.apache.http.client.methods.HttpGet(url);
			CloseableHttpResponse response = closeableHttpClient.execute(request);
			HttpEntity entity = response.getEntity();
			Random random = new Random();
			httpUrl = path + random.nextInt();
			outputStream = new FileOutputStream(httpUrl);
			entity.writeTo(outputStream);
			outputStream.close();
			System.out.println("抓取成功！"+url);
			reader(key);
		} catch (Exception e) {
			System.err.println("抓取失败！" + path);
		}
	}

	private void reader(String key) {
		File file = new File(httpUrl);
		Document document = null;
		try {
			document = Jsoup.parse(file, "UTF-8");
		} catch (IOException e) {
		}
		Elements element = document.select("[href*=/vulnerability/show/cv_cnnvdid/]");
		String id = "";
		for (Element element2 : element) {
			id = element2.attr("title");
			if (!id.equalsIgnoreCase(key)) {
				list.add("http://www.cnnvd.org.cn" + element2.attr("href"));
			} else {
				flag = false;
				break;
			}
		}
		file.delete();
	}

	private String MySqlKey() throws Exception {
		ConnDataSoure conn = ConnDataSoure.SingleConn();
		Connection connection = conn.getConnection();
		String sql = "select cnnvd_id from loopholedata order by cnnvd_id desc limit 1";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String key = resultSet.getString(1);
			return key;
		}
		return null;
	}

	private void crawlet(String url) {
		try {
			Random random = new Random();
			outputStream = new FileOutputStream(path + random.nextInt() + ".txt");
			HttpUriRequest request = new org.apache.http.client.methods.HttpGet(url);
			CloseableHttpResponse response = closeableHttpClient.execute(request);
			HttpEntity entity = response.getEntity();
			entity.writeTo(outputStream);
			outputStream.flush();
			outputStream.close();
			System.out.println("抓取成功！"+url);
		} catch (Exception e) {
		}
	}
}

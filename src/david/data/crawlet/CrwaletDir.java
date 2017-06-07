package david.data.crawlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import david.data.mysql.ConnDataSoure;

public class CrwaletDir {

	private boolean flag = true;
	private BufferedWriter outputStream;
	private CloseableHttpClient closeableHttpClient;
	private String path = "D:\\国家漏洞详细数据\\";

	public CrwaletDir() {
		try {
			closeableHttpClient = HttpClients.custom().build();
			File file = new File(path);
			if (!file.exists())
				file.mkdirs();
		} catch (Exception e) {
		}
	}

	private void crawlet(String url, String key) {
		try {

			HttpUriRequest request = new org.apache.http.client.methods.HttpGet(url);
			CloseableHttpResponse response = closeableHttpClient.execute(request);
			HttpEntity entity = response.getEntity();
			reader(entity.getContent(), key);
		} catch (Exception e) {
			System.err.println("抓取失败！" + path);
		}
	}

	public void crwaletDirLoop() {
		 int i = 1;
		 String url = "http://www.cnnvd.org.cn/vulnerability/index/p/";
		 String key=null;
		try {
			key = MySqlKey();
			if(key==null)
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 while (flag) {
		 crawlet(url + i + "/", key);
		 i++;
		 }
	}

	private  String MySqlKey() throws Exception {
		ConnDataSoure conn = new ConnDataSoure();
		Connection connection = conn.getConnection();
		String sql="select cnnvd_id from loopholedata order by cnnvd_id desc limit 1";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet=statement.executeQuery();
		if(resultSet.next()){
			String key=resultSet.getString(1);
			return key;
		}
		return null;
	}

	private void reader(InputStream content, String key) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(content, "UTF-8"));
			String string = "";
			StringBuilder builder = new StringBuilder();
			while ((string = reader.readLine()) != null) {
				if (string.contains(key)) {
					flag = false;
					return;
				} else {
					builder.append(string + "\r\n");
				}
			}
			Random random = new Random();
			outputStream = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(path + random.nextInt()), "UTF-8"));
			outputStream.write(builder.toString());
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			return;
		}

	}
}

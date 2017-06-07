package david.data.mysql;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import david.data.bean.DataBean;

public class ConnDataSoure {
	private PreparedStatement statement;
	private Connection connection;
	private String sql;
	
	public Connection getConnection() {
		return connection;
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ConnDataSoure() {
		try {
			connection = new Conn().conn().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<DataBean> readerSouce(String loopholeName) {
		try {
			List<DataBean> list = new ArrayList<>();
			DataBean bean = null;
			statement.setString(1, loopholeName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				bean = new DataBean(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
						resultSet.getString(11), resultSet.getString(12), resultSet.getString(13),
						resultSet.getString(14));
				list.add(bean);
			}

			return list;
		} catch (SQLException e) {
		}
		return null;
	}

	public int DataSouce(String... paramas) {
		try {
			for (int i = 0; i < paramas.length; i++) {
				statement.setString(i + 1, paramas[i]);
			}
			return statement.executeUpdate();
		} catch (SQLException e) {
		}
		return 0;
	}
}

class Conn {

	private Properties properties;

	public Conn() {
		this.conn();
	}

	public DataSource conn() {
		try {
			//InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			String path="D:\\db.properties";
			InputStream inStream=new FileInputStream(path);
			properties = new Properties();
			properties.load(inStream);
			return DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Properties getProperties() {
		return properties;
	}
}
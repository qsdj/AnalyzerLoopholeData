package david.data.gui;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;
import david.data.bean.DataBean;
import david.data.mysql.ConnDataSoure;

public class LogicGUI {

	static ConnDataSoure connDataSoure = ConnDataSoure.SingleConn();

	public static List<DataBean> vagueFind(String string) {
		connDataSoure.setSql("select * from loopholedata where loopholename like ?");
		List<DataBean> list = connDataSoure.readerSouce("%" + string + "%");
		return list;
	}

	public static List<DataBean> accuarteFind(String string) {
		connDataSoure.setSql("select * from loopholedata where loopholename=(?)");
		List<DataBean> list = connDataSoure.readerSouce(string);
		return list;
	}

	public static List<DataBean> AnalyzerFind(String text) {
		List<DataBean> list = new ArrayList<>();
		Analyzer analyzer = new IKAnalyzer();
		TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(text));
		tokenStream.addAttribute(TermAttribute.class);
		try {
			while (tokenStream.incrementToken()) {
				TermAttribute termAttribute = tokenStream.getAttribute(TermAttribute.class);
				String work = termAttribute.term();
				if (work.length() >= 2) {
					List<DataBean> beans = vagueFind(work);
					list.addAll(beans);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		analyzer.close();
		repeats(list);
		return list;
	}

	private static void repeats(List<DataBean> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++)
			if (list.get(i).getCNNVD_ID().equals(list.get(i + 1).getCNNVD_ID())) {
				list.remove(list.get(i + 1));
				i--;
			}
	}
}

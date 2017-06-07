package david.data.gui;

import java.io.File;
import java.util.List;
import david.data.analyzerImpl.AnalyzerImpl;
import david.data.bean.DataBean;
import david.data.crawletList.CrwaletDir;

public class LoopholeGUI extends javax.swing.JFrame {

	private javax.swing.JTextField CNNVD_ID;
	private javax.swing.JTextField CVE_ID;
	private javax.swing.JRadioButton accurateFind;
	private javax.swing.JLabel currentMessage;
	private javax.swing.JTextField dangerGrade;
	private javax.swing.JTextField dangerType;
	private javax.swing.JButton down;
	private javax.swing.JTextField effectEntity;
	private javax.swing.JButton find;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField loopholeAnnonuce;
	private javax.swing.JTextField loopholeIntroduce;
	private javax.swing.JTextField loopholeName;
	private javax.swing.JTextField loopholePatch;
	private javax.swing.JTextField loopholeType;
	private javax.swing.JTextField loopholeURL;
	private javax.swing.JLabel messageSize;
	private javax.swing.JRadioButton partFind;
	private javax.swing.JTextField publishTime;
	private javax.swing.JTextField relevantLoophole;
	private javax.swing.JTextField searchText;
	private javax.swing.JButton up;
	private javax.swing.JTextField updateTime;
	private javax.swing.JRadioButton vagueFind;
	private static final long serialVersionUID = 1L;
	private List<DataBean> list;
	private int page = 0;
	private javax.swing.JButton crwaletData;

	public LoopholeGUI() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		searchText = new javax.swing.JTextField();
		find = new javax.swing.JButton();
		accurateFind = new javax.swing.JRadioButton();
		vagueFind = new javax.swing.JRadioButton();
		partFind = new javax.swing.JRadioButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		CNNVD_ID = new javax.swing.JTextField();
		loopholeName = new javax.swing.JTextField();
		publishTime = new javax.swing.JTextField();
		loopholeAnnonuce = new javax.swing.JTextField();
		loopholePatch = new javax.swing.JTextField();
		relevantLoophole = new javax.swing.JTextField();
		updateTime = new javax.swing.JTextField();
		loopholeIntroduce = new javax.swing.JTextField();
		dangerGrade = new javax.swing.JTextField();
		loopholeType = new javax.swing.JTextField();
		dangerType = new javax.swing.JTextField();
		CVE_ID = new javax.swing.JTextField();
		loopholeURL = new javax.swing.JTextField();
		up = new javax.swing.JButton();
		down = new javax.swing.JButton();
		currentMessage = new javax.swing.JLabel();
		messageSize = new javax.swing.JLabel();
		effectEntity = new javax.swing.JTextField();
		crwaletData = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Antenna");

		jLabel1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
		jLabel1.setText("漏洞名称:");

		jLabel2.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
		jLabel2.setText("全国信息漏洞库查询");

		searchText.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchTextActionPerformed(evt);
			}
		});

		find.setText("查询");
		find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findActionPerformed(evt);
			}
		});

		accurateFind.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		accurateFind.setText("精准查询");
		accurateFind.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				accurateFindActionPerformed(evt);
			}
		});

		vagueFind.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		vagueFind.setText("模糊查询");
		vagueFind.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				vagueFindActionPerformed(evt);
			}
		});

		partFind.setFont(new java.awt.Font("宋体", 1, 14));
		partFind.setText("分词查询");
		partFind.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				partFindActionPerformed(evt);
			}
		});

		jLabel3.setText("CNNVD");

		jLabel4.setText("漏洞名称");

		jLabel5.setText("发布时间");

		jLabel6.setText("更新时间");

		jLabel7.setText("危害等级");

		jLabel8.setText("漏洞类型");

		jLabel9.setText("威胁类型");

		jLabel10.setText("CVE编号");

		jLabel11.setText("漏洞介绍");

		jLabel12.setText("漏洞公告");

		jLabel13.setText("补丁");

		jLabel14.setText("影响实体");

		jLabel15.setText("相关漏洞");

		jLabel16.setText("漏洞网址");

		CNNVD_ID.setForeground(new java.awt.Color(51, 0, 51));

		loopholeName.setForeground(new java.awt.Color(204, 0, 0));

		up.setText("上一页");
		up.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				upActionPerformed(evt);
			}
		});

		down.setText("下一页");
		down.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				downActionPerformed(evt);
			}
		});

		currentMessage.setText("当前是第一个漏洞信息");

		messageSize.setText("共0个信息");

		crwaletData.setText("爬取数据");
		crwaletData.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				crwaletDataActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout
				.createSequentialGroup().add(325, 325, 325)
				.add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.add(crwaletData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
				.add(21, 21, 21)).add(
						layout.createSequentialGroup().add(44, 44, 44)
								.add(layout
										.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout
												.createSequentialGroup().add(layout
														.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(layout.createSequentialGroup().add(jLabel8)
																.addPreferredGap(
																		org.jdesktop.layout.LayoutStyle.UNRELATED)
																.add(loopholeType))
														.add(layout.createSequentialGroup().add(jLabel5)
																.addPreferredGap(
																		org.jdesktop.layout.LayoutStyle.UNRELATED)
																.add(publishTime))
														.add(layout.createSequentialGroup().add(jLabel4)
																.addPreferredGap(
																		org.jdesktop.layout.LayoutStyle.UNRELATED)
																.add(loopholeName))
														.add(layout.createSequentialGroup()
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(jLabel6).add(jLabel7))
																.addPreferredGap(
																		org.jdesktop.layout.LayoutStyle.UNRELATED)
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(dangerGrade).add(updateTime)))
														.add(layout.createSequentialGroup()
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(jLabel9).add(jLabel10).add(jLabel11))
																.addPreferredGap(
																		org.jdesktop.layout.LayoutStyle.UNRELATED)
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(loopholeIntroduce).add(CVE_ID)
																		.add(dangerType)))
														.add(layout.createSequentialGroup().add(jLabel3,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				false)
																		.add(layout.createSequentialGroup()
																				.add(10, 10, 10).add(CNNVD_ID,
																						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																						681,
																						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																		.add(layout.createSequentialGroup()
																				.addPreferredGap(
																						org.jdesktop.layout.LayoutStyle.RELATED)
																				.add(currentMessage,
																						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																						128,
																						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						org.jdesktop.layout.LayoutStyle.RELATED,
																						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.add(messageSize).add(18, 18, 18)
																				.add(up)
																				.addPreferredGap(
																						org.jdesktop.layout.LayoutStyle.RELATED)
																				.add(down))))
														.add(layout.createSequentialGroup()
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(jLabel15).add(jLabel16))
																.add(10, 10, 10)
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(loopholeURL).add(relevantLoophole)))
														.add(layout.createSequentialGroup()
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(layout.createSequentialGroup().add(2, 2, 2)
																				.add(layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(jLabel13).add(jLabel12)))
																		.add(org.jdesktop.layout.GroupLayout.TRAILING,
																				jLabel14,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				50,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
																.add(8, 8, 8)
																.add(layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.LEADING)
																		.add(loopholePatch).add(effectEntity)
																		.add(loopholeAnnonuce))))
												.add(0, 75, Short.MAX_VALUE))
										.add(layout.createSequentialGroup().add(jLabel1).add(18, 18, 18).add(layout
												.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
												.add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 492,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(org.jdesktop.layout.GroupLayout.TRAILING, layout
														.createSequentialGroup().add(accurateFind)
														.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.add(vagueFind).add(106, 106, 106).add(partFind)))
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(find)
												.addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout.createSequentialGroup().addContainerGap()
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
								.add(crwaletData, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
								.add(searchText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(find, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(vagueFind)
								.add(partFind).add(accurateFind))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(currentMessage)
								.add(up).add(messageSize).add(down))
						.add(6, 6, 6)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel3).add(
								CNNVD_ID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel4).add(
								loopholeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(jLabel5).add(
								publishTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(jLabel6).add(
								updateTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel7).add(
								dangerGrade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel8).add(
								loopholeType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel9).add(
								dangerType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel10).add(
								CVE_ID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel11).add(
								loopholeIntroduce, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel12).add(
								loopholeAnnonuce, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel13).add(
								loopholePatch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout
								.createSequentialGroup().add(jLabel14).add(18, 18, 18)
								.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel15)
										.add(relevantLoophole, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
								.add(18, 18, 18)
								.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel16)
										.add(loopholeURL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
								.add(effectEntity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.add(11, 11, 11)));

		pack();
		loopholeName.setEditable(false);
		CNNVD_ID.setEditable(false);
		publishTime.setEditable(false);
		updateTime.setEditable(false);
		dangerGrade.setEditable(false);
		dangerType.setEditable(false);
		loopholeType.setEditable(false);
		CVE_ID.setEditable(false);
		loopholeAnnonuce.setEditable(false);
		loopholeIntroduce.setEditable(false);
		loopholePatch.setEditable(false);
		effectEntity.setEditable(false);
		relevantLoophole.setEditable(false);
		loopholeURL.setEditable(false);
		find.setEnabled(false);
	}

	private void findActionPerformed(java.awt.event.ActionEvent evt) {
		up.setEnabled(true);
		down.setEnabled(true);
		String loopName = searchText.getText().trim();
		if (!loopName.equals("")) {
			find.setText("正在查询中...");
			find.setEnabled(false);
			clearText();

			if (accurateFind.isSelected()) {
				list = LogicGUI.accuarteFind(loopName);
			} else if (partFind.isSelected()) {
				list = LogicGUI.AnalyzerFind(loopName);
			} else {
				list = LogicGUI.vagueFind(loopName);
			}
			find.setText("查询");
			find.setEnabled(true);
			if (list.size() == 0)
				return;
			messageSize.setText("共" + list.size() + "个信息");
			scan();
		}
	}

	private void partFindActionPerformed(java.awt.event.ActionEvent evt) {
		if (partFind.isSelected()) {
			find.setEnabled(true);
			vagueFind.setEnabled(false);
			accurateFind.setEnabled(false);
		} else {
			find.setEnabled(false);
			vagueFind.setEnabled(true);
			accurateFind.setEnabled(true);
		}
	}

	private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void upActionPerformed(java.awt.event.ActionEvent evt) {
		if (list == null)
			return;
		page--;
		if (page >= 0) {
			down.setEnabled(true);
			scan();
		} else {
			page = 0;
			up.setEnabled(false);
		}
	}

	private void downActionPerformed(java.awt.event.ActionEvent evt) {
		if (list == null)
			return;
		page++;
		if (page == list.size()) {
			page = list.size() - 1;
			down.setEnabled(false);
		} else {
			up.setEnabled(true);
			scan();
		}
	}

	private void accurateFindActionPerformed(java.awt.event.ActionEvent evt) {
		if (accurateFind.isSelected()) {
			find.setEnabled(true);
			vagueFind.setEnabled(false);
			partFind.setEnabled(false);
		} else {
			find.setEnabled(false);
			vagueFind.setEnabled(true);
			partFind.setEnabled(true);
		}
	}

	private void vagueFindActionPerformed(java.awt.event.ActionEvent evt) {
		if (vagueFind.isSelected()) {
			find.setEnabled(true);
			accurateFind.setEnabled(false);
			partFind.setEnabled(false);
		} else {
			find.setEnabled(false);
			accurateFind.setEnabled(true);
			partFind.setEnabled(true);
		}
	}

	private void scan() {
		DataBean bean = null;
		currentMessage.setText("当前是第" + (page + 1) + "个漏洞信息");
		bean = list.get(page);
		CNNVD_ID.setText(bean.getCNNVD_ID());
		loopholeName.setText(bean.getLoopholeName());
		publishTime.setText(bean.getPublishTime());
		updateTime.setText(bean.getUpdateTime());
		String fString = bean.getDangerGrade();
		if (fString.startsWith("?"))
			fString = "暂未发现";
		else if (fString.endsWith("?"))
			fString = fString.substring(0, fString.length() - 1);
		dangerGrade.setText(fString);
		loopholeType.setText(bean.getLoopholeType());
		dangerType.setText(bean.getDangerType());
		CVE_ID.setText(bean.getCVE_ID());
		loopholeIntroduce.setText(bean.getLoopholeIntroduce());
		loopholeAnnonuce.setText(bean.getLoopholeAnnounce());
		loopholePatch.setText(bean.getLoopholePatch());
		effectEntity.setText(bean.getEffectEntity());
		relevantLoophole.setText(bean.getRelevantLoophole());
		loopholeURL.setText(bean.getLoopholeURL());
	}

	private void crwaletDataActionPerformed(java.awt.event.ActionEvent evt) {
		crwaletData.setText("正在爬取...");
		crwaletData.setEnabled(false);
		new CrwaletDir().crwaletDirLoop();
		AnalyzerImpl analyzer = new AnalyzerImpl();
		String dir = "D:\\国家漏洞详细数据\\";
		File file = new File(dir);
		File f[] = file.listFiles();
		if (f != null && f.length > 0)
			for (File file2 : f) {
				try {
					analyzer.analyzer(file2);
					analyzer.dataWrite();
				} catch (Exception e) {
					file2.delete();
				}
			}
		crwaletData.setText("爬取数据");
		crwaletData.setEnabled(true);
		file.delete();
	}

	private void clearText() {
		if (list != null)
			list.clear();
		page = 0;
		messageSize.setText("共0个信息");
		currentMessage.setText("当前是第0个漏洞信息");
		CNNVD_ID.setText("");
		loopholeName.setText("");
		publishTime.setText("");
		updateTime.setText("");
		dangerGrade.setText("");
		loopholeType.setText("");
		dangerType.setText("");
		CVE_ID.setText("");
		loopholeIntroduce.setText("");
		loopholeAnnonuce.setText("");
		loopholePatch.setText("");
		effectEntity.setText("");
		relevantLoophole.setText("");
		loopholeURL.setText("");
	}

	public static void main(String args[]) {
		try {
			javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager
					.getInstalledLookAndFeels();
			for (int idx = 0; idx < installedLookAndFeels.length; idx++)
				if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
					javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
					break;
				}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoopholeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoopholeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoopholeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoopholeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoopholeGUI().setVisible(true);
			}
		});
	}
}

package david.data.bean;

public class DataBean implements Comparable<DataBean>{
	private String CNNVD_ID;
	private String loopholeName;
	private String publishTime;
	private String updateTime;
	private String dangerGrade;
	private String loopholeType;
	private String dangerType;
	private String CVE_ID;
	private String loopholeIntroduce;
	private String loopholeAnnounce;
	private String loopholePatch;
	private String effectEntity;
	private String relevantLoophole;
	private String loopholeURL;

	public String getCVE_ID() {
		return CVE_ID;
	}
	
	public DataBean() {
	}

	public DataBean(String cNNVD_ID,String loopholeName,  String publishTime, String updateTime, String dangerGrade,
			String loopholeType, String dangerType, String cVE_ID, String loopholeIntroduce, String loopholeAnnounce,
			String loopholePatch, String effectEntity, String relevantLoophole, String loopholeURL) {
		CNNVD_ID = cNNVD_ID;
		this.loopholeName = loopholeName;
		this.publishTime = publishTime;
		this.updateTime = updateTime;
		this.dangerGrade = dangerGrade;
		this.loopholeType = loopholeType;
		this.dangerType = dangerType;
		CVE_ID = cVE_ID;
		this.loopholeIntroduce = loopholeIntroduce;
		this.loopholeAnnounce = loopholeAnnounce;
		this.loopholePatch = loopholePatch;
		this.effectEntity = effectEntity;
		this.relevantLoophole = relevantLoophole;
		this.loopholeURL = loopholeURL;
	}



	public String getLoopholeName() {
		return loopholeName;
	}

	public void setLoopholeName(String loopholeName) {
		this.loopholeName = loopholeName;
	}

	public String getCNNVD_ID() {
		return CNNVD_ID;
	}

	public void setCNNVD_ID(String cNNVD_ID) {
		CNNVD_ID = cNNVD_ID;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDangerGrade() {
		return dangerGrade;
	}

	public void setDangerGrade(String dangerGrade) {
		this.dangerGrade = dangerGrade;
	}

	public String getLoopholeType() {
		return loopholeType;
	}

	public void setLoopholeType(String loopholeType) {
		this.loopholeType = loopholeType;
	}

	public String getDangerType() {
		return dangerType;
	}

	public void setDangerType(String dangerType) {
		this.dangerType = dangerType;
	}


	public String getLoopholeIntroduce() {
		return loopholeIntroduce;
	}

	public void setLoopholeIntroduce(String loopholeIntroduce) {
		this.loopholeIntroduce = loopholeIntroduce;
	}

	public String getLoopholeAnnounce() {
		return loopholeAnnounce;
	}

	public void setLoopholeAnnounce(String loopholeAnnounce) {
		this.loopholeAnnounce = loopholeAnnounce;
	}

	public String getLoopholePatch() {
		return loopholePatch;
	}

	public void setLoopholePatch(String loopholePatch) {
		this.loopholePatch = loopholePatch;
	}

	public String getEffectEntity() {
		return effectEntity;
	}

	public void setEffectEntity(String effectEntity) {
		this.effectEntity = effectEntity;
	}

	public String getRelevantLoophole() {
		return relevantLoophole;
	}

	public void setRelevantLoophole(String relevantLoophole) {
		this.relevantLoophole = relevantLoophole;
	}

	public String getLoopholeURL() {
		return loopholeURL;
	}

	public void setLoopholeURL(String loopholeURL) {
		this.loopholeURL = loopholeURL;
	}

	@Override
	public int compareTo(DataBean o) {
		return this.CNNVD_ID.compareTo(o.CNNVD_ID);
	}
}

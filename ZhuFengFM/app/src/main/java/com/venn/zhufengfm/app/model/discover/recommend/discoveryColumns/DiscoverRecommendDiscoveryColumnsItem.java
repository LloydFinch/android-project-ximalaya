package com.venn.zhufengfm.app.model.discover.recommend.discoveryColumns;

import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendDiscoveryColumnsItem implements ParseJsonTool {

	private int id;
	private int orderNum;
	private String title;
	private String subtitle;
	private String coverPath;
	private String contentType;
	private String url;
	private String sharePic;
	private boolean enableShare;
	private long contentUpdatedAt;

	public DiscoverRecommendDiscoveryColumnsItem() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		id = json.getInt("id");
		orderNum = json.getInt("orderNum");
		title = json.getString("title");
		subtitle = json.getString("subtitle");
		coverPath = json.getString("coverPath");
		contentType = json.getString("contentType");
		sharePic = json.getString("sharePic");
		enableShare = json.getBoolean("enableShare");
		contentUpdatedAt = json.getLong("contentUpdatedAt");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSharePic() {
		return sharePic;
	}

	public void setSharePic(String sharePic) {
		this.sharePic = sharePic;
	}

	public boolean isEnableShare() {
		return enableShare;
	}

	public void setEnableShare(boolean enableShare) {
		this.enableShare = enableShare;
	}

	public long getContentUpdatedAt() {
		return contentUpdatedAt;
	}

	public void setContentUpdatedAt(long contentUpdatedAt) {
		this.contentUpdatedAt = contentUpdatedAt;
	}
}

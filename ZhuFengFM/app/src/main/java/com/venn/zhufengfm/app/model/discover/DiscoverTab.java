package com.venn.zhufengfm.app.model.discover;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/29.
 */
public class DiscoverTab {

	private String title;
	private String contentType;

	public DiscoverTab() {

	}

	public void parseJSON(JSONObject json) throws JSONException {
		if (json != null) {
			title = json.getString("title");
			contentType = json.getString("contentType");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}

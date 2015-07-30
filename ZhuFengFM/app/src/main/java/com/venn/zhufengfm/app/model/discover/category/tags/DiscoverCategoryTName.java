package com.venn.zhufengfm.app.model.discover.category.tags;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryTName {
	private String tName;
	private int category_id;

	public DiscoverCategoryTName() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		tName = json.getString("tname");
		category_id = json.getInt("category_id");
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
}

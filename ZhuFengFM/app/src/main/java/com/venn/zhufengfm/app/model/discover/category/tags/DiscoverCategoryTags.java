package com.venn.zhufengfm.app.model.discover.category.tags;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryTags {

	private int maxPageId;
	private String title;
	private int count;
	private List<DiscoverCategoryTName> tNameList;

	public DiscoverCategoryTags() {
		tNameList = new ArrayList<DiscoverCategoryTName>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		maxPageId = json.getInt("maxPageId");
		title = json.getString("title");
		count = json.getInt("count");
		JSONArray array = json.getJSONArray("list");
		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			DiscoverCategoryTName tName = new DiscoverCategoryTName();
			tName.parseJSON(object);
			tNameList.add(tName);
		}
	}

	public int getMaxPageId() {
		return maxPageId;
	}

	public void setMaxPageId(int maxPageId) {
		this.maxPageId = maxPageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<DiscoverCategoryTName> gettNameList() {
		return tNameList;
	}

	public void settNameList(List<DiscoverCategoryTName> tNameList) {
		this.tNameList = tNameList;
	}
}

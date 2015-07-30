package com.venn.zhufengfm.app.model.discover.category.contents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryContentItems {

	private String calcDimension;
	private String tagName;
	private String contentType;
	private String title;
	private boolean hasMore;
	private List<DiscoverCategoryContentListItem> itemList;

	public DiscoverCategoryContentItems() {
		itemList = new ArrayList<DiscoverCategoryContentListItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		calcDimension = json.getString("calcDimension");
		tagName = json.getString("tagName");
		contentType = json.getString("contentType");
		title = json.getString("title");
		hasMore = json.getBoolean("hasMore");
		JSONArray array = json.getJSONArray("list");
		for (int i = 0; i < array.length(); i++) {
			DiscoverCategoryContentListItem item = new DiscoverCategoryContentListItem();
			JSONObject object = array.getJSONObject(i);
			item.parseJSON(object);
			itemList.add(item);
		}
	}

	public String getCalcDimension() {
		return calcDimension;
	}

	public void setCalcDimension(String calcDimension) {
		this.calcDimension = calcDimension;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<DiscoverCategoryContentListItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoverCategoryContentListItem> itemList) {
		this.itemList = itemList;
	}
}

package com.venn.zhufengfm.app.model.discover.category.contents;

import com.venn.zhufengfm.app.model.discover.category.contents.DiscoverCategoryContentItems;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryContents {
	private int ret;
	private String title;
	private List<DiscoverCategoryContentItems> itemsList;

	public DiscoverCategoryContents() {
		itemsList = new ArrayList<DiscoverCategoryContentItems>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		title = json.getString("title");
		JSONArray array = json.getJSONArray("list");
		for (int i = 0; i < array.length(); i++) {
			DiscoverCategoryContentItems items = new DiscoverCategoryContentItems();
			JSONObject object = array.getJSONObject(i);
			items.parseJSON(object);
			itemsList.add(items);
		}
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<DiscoverCategoryContentItems> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<DiscoverCategoryContentItems> itemsList) {
		this.itemsList = itemsList;
	}
}

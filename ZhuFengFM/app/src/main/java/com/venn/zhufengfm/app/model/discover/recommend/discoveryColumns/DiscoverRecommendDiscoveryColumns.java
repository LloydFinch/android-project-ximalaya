package com.venn.zhufengfm.app.model.discover.recommend.discoveryColumns;

import com.venn.zhufengfm.app.model.jsontool.JsonArrayTool;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendDiscoveryColumns implements ParseJsonTool{

	private int ret;
	private String title;
	private List<DiscoverRecommendDiscoveryColumnsItem> itemList;
	private int locationInHotRecommend;

	public DiscoverRecommendDiscoveryColumns() {
		itemList = new ArrayList<DiscoverRecommendDiscoveryColumnsItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {

		ret = json.getInt("ret");
		title = json.getString("title");
		locationInHotRecommend = json.getInt("locationInHotRecommend");
		DiscoverRecommendDiscoveryColumnsItem item = new DiscoverRecommendDiscoveryColumnsItem();
		JsonArrayTool.getJsonArray(itemList, item, json);
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

	public List<DiscoverRecommendDiscoveryColumnsItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoverRecommendDiscoveryColumnsItem> itemList) {
		this.itemList = itemList;
	}

	public int getLocationInHotRecommend() {
		return locationInHotRecommend;
	}

	public void setLocationInHotRecommend(int locationInHotRecommend) {
		this.locationInHotRecommend = locationInHotRecommend;
	}
}

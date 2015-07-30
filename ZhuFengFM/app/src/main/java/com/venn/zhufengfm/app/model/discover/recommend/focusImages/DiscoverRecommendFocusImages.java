package com.venn.zhufengfm.app.model.discover.recommend.focusImages;

import com.venn.zhufengfm.app.model.jsontool.JsonArrayTool;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendFocusImages implements ParseJsonTool{
	private int ret;
	private String title;
	private List<DiscoverRecommendFocusImagesItem> itemList;

	public DiscoverRecommendFocusImages() {
		itemList = new ArrayList<DiscoverRecommendFocusImagesItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		title = json.getString("title");
		DiscoverRecommendFocusImagesItem item = new DiscoverRecommendFocusImagesItem();
		JsonArrayTool.getJsonArray(itemList,item,json);
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

	public List<DiscoverRecommendFocusImagesItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoverRecommendFocusImagesItem> itemList) {
		this.itemList = itemList;
	}
}

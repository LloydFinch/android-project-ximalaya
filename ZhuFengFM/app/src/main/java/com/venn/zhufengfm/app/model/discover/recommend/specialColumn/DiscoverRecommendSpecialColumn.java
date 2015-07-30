package com.venn.zhufengfm.app.model.discover.recommend.specialColumn;

import com.venn.zhufengfm.app.model.jsontool.JsonArrayTool;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendSpecialColumn implements ParseJsonTool{

	private int ret;
	private String title;
	private boolean hasMore;
	private List<DiscoverRecommendSpecialColumnItem> itemList;

	public DiscoverRecommendSpecialColumn() {
		itemList = new ArrayList<DiscoverRecommendSpecialColumnItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		title = json.getString("title");
		hasMore = json.getBoolean("hasMore");
		DiscoverRecommendSpecialColumnItem item = new DiscoverRecommendSpecialColumnItem();
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

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<DiscoverRecommendSpecialColumnItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoverRecommendSpecialColumnItem> itemList) {
		this.itemList = itemList;
	}
}

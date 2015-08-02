package com.venn.zhufengfm.app.model.discover.recommend.hotRecommends;

import com.venn.zhufengfm.app.model.jsontool.JsonArrayTool;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendHotRecommendsItems implements ParseJsonTool{

	private String title;
	private String contentType;
	private boolean isFinished;
	private int categoryId;
	private int count;
	private boolean hasMore;
	private List<DiscoverRecommendHotRecommendsItem> itemList;

	public DiscoverRecommendHotRecommendsItems() {
		itemList = new ArrayList<DiscoverRecommendHotRecommendsItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		title = json.getString("title");
		contentType = json.getString("contentType");
		isFinished = json.getBoolean("isFinished");
		categoryId = json.getInt("categoryId");
		count = json.getInt("count");
		hasMore = json.getBoolean("hasMore");
		JsonArrayTool.getJsonArray(itemList,DiscoverRecommendHotRecommendsItem.class,json);
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

	public boolean isFinished() {
		return isFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<DiscoverRecommendHotRecommendsItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoverRecommendHotRecommendsItem> itemList) {
		this.itemList = itemList;
	}
}

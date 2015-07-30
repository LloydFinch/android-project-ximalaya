package com.venn.zhufengfm.app.model.discover.recommend.editorRecommends;

import com.venn.zhufengfm.app.model.jsontool.JsonArrayTool;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendEditorRecommendAlbums implements ParseJsonTool {
	private int ret;
	private String title;
	private boolean hasMore;
	private List<DiscoverRecommendEditorRecommendAlbumsItem> itemList;

	public DiscoverRecommendEditorRecommendAlbums() {
		itemList = new ArrayList<DiscoverRecommendEditorRecommendAlbumsItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		title = json.getString("title");
		hasMore = json.getBoolean("hasMore");
		DiscoverRecommendEditorRecommendAlbumsItem item = new DiscoverRecommendEditorRecommendAlbumsItem();
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

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<DiscoverRecommendEditorRecommendAlbumsItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DiscoverRecommendEditorRecommendAlbumsItem> itemList) {
		this.itemList = itemList;
	}
}

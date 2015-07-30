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
public class DiscoverRecommendHotRecommends implements ParseJsonTool {
	private int ret;
	private String title;
	private List<DiscoverRecommendHotRecommendsItems> itemsList;

	public DiscoverRecommendHotRecommends() {
		itemsList = new ArrayList<DiscoverRecommendHotRecommendsItems>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		title = json.getString("title");
		DiscoverRecommendHotRecommendsItems item = new DiscoverRecommendHotRecommendsItems();
		JsonArrayTool.getJsonArray(itemsList, item, json);
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

	public List<DiscoverRecommendHotRecommendsItems> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<DiscoverRecommendHotRecommendsItems> itemsList) {
		this.itemsList = itemsList;
	}
}

package com.venn.zhufengfm.app.model.player;

import com.venn.zhufengfm.app.model.jsontool.JsonArrayTool;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/8/5.
 */
public class Tracks implements ParseJsonTool {

	private List<TrackItem> trackItemList;
	private int pageId;
	private int pageSize;
	private int maxPageId;
	private int totalCount;

	public Tracks() {
		trackItemList = new ArrayList<TrackItem>();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		pageId = json.getInt("pageId");
		pageSize = json.getInt("pageSize");
		maxPageId = json.getInt("maxPageId");
		totalCount = json.getInt("totalCount");

		JsonArrayTool.getJsonArray(trackItemList, TrackItem.class, json);
	}

	public List<TrackItem> getTrackItemList() {
		return trackItemList;
	}

	public void setTrackItemList(List<TrackItem> trackItemList) {
		this.trackItemList = trackItemList;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getMaxPageId() {
		return maxPageId;
	}

	public void setMaxPageId(int maxPageId) {
		this.maxPageId = maxPageId;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}

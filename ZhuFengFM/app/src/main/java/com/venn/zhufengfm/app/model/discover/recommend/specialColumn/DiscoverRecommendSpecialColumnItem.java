package com.venn.zhufengfm.app.model.discover.recommend.specialColumn;

import android.widget.MultiAutoCompleteTextView;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendSpecialColumnItem implements ParseJsonTool{

	private int columnType;
	private int specialId;
	private String title;
	private String subtitle;
	private String footnote;
	private String coverPath;
	private String contentType;

	public DiscoverRecommendSpecialColumnItem() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		columnType = json.getInt("columnType");
		specialId = json.getInt("specialId");
		title = json.getString("title");
		subtitle = json.getString("subtitle");
		footnote = json.getString("footnote");
		coverPath = json.getString("coverPath");
		contentType = json.getString("contentType");
	}

	public int getColumnType() {
		return columnType;
	}

	public void setColumnType(int columnType) {
		this.columnType = columnType;
	}

	public int getSpecialId() {
		return specialId;
	}

	public void setSpecialId(int specialId) {
		this.specialId = specialId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getFootnote() {
		return footnote;
	}

	public void setFootnote(String footnote) {
		this.footnote = footnote;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}

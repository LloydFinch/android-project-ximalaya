package com.venn.zhufengfm.app.model.discover;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by VennUser on 2015/7/29.
 */
public class DiscoverCategory implements Comparable<DiscoverCategory> {

	private int id;
	private String name;
	private String title;
	private boolean isChecked;
	private int orderNum;
	private String coverPath;
	private boolean selectedSwitch;
	private boolean isFinished;
	private String contentType;
	private List<String> tagNames;

	public DiscoverCategory() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		if (json != null) {
			id = json.getInt("id");
			name = json.getString("name");
			title = json.getString("title");
			isChecked = json.getBoolean("isChecked");
			orderNum = json.getInt("orderNum");
			coverPath = json.getString("coverPath");
			selectedSwitch = json.getBoolean("selectedSwitch");
			isFinished = json.getBoolean("isFinished");
			contentType = json.getString("contentType");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public boolean isSelectedSwitch() {
		return selectedSwitch;
	}

	public void setSelectedSwitch(boolean selectedSwitch) {
		this.selectedSwitch = selectedSwitch;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<String> getTagNames() {
		return tagNames;
	}

	public void setTagNames(List<String> tagNames) {
		this.tagNames = tagNames;
	}

	public int compareTo(DiscoverCategory another) {
		return orderNum - another.orderNum;
	}
}

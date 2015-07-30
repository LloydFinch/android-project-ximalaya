package com.venn.zhufengfm.app.model.discover;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VennUser on 2015/7/28.
 */
public class CategoryTagMenu {

	private int id;
	private String name;
	private String title;
	private String intro;
	private boolean is_display;
	private String cover_path;
	private List<String> tag_list;

	public CategoryTagMenu() {
		tag_list = new ArrayList<String>();
	}

	public void parseJSON(JSONObject jsonObject) throws JSONException {

		if (jsonObject != null) {
			id = jsonObject.getInt("id");
			name = jsonObject.getString("name");
			title = jsonObject.getString("title");
			intro = jsonObject.getString("intro");
			is_display = jsonObject.getBoolean("is_display");
			cover_path = jsonObject.getString("cover_path");
			JSONArray array = jsonObject.getJSONArray("tag_list");
			for (int i = 0; i < array.length(); i++) {
				tag_list.add(array.getString(i));
			}
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public boolean is_display() {
		return is_display;
	}

	public void setIs_display(boolean is_display) {
		this.is_display = is_display;
	}

	public String getCover_path() {
		return cover_path;
	}

	public void setCover_path(String cover_path) {
		this.cover_path = cover_path;
	}

	public List<String> getTag_list() {
		return tag_list;
	}

	public void setTag_list(List<String> tag_list) {
		this.tag_list = tag_list;
	}

	public String toString() {
		return "CategoryTagMenu{" +
				"id=" + id +
				", name='" + name + '\'' +
				", title='" + title + '\'' +
				", intro='" + intro + '\'' +
				", is_display=" + is_display +
				", cover_path='" + cover_path + '\'' +
				", tag_list=" + tag_list +
				'}';
	}
}

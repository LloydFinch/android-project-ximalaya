package com.venn.zhufengfm.app.model.discover.category.images;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryFocusImages {
	private int ret;
	private List<DiscoverCategoryFocusImages> imagesList;
	private String title;

	public DiscoverCategoryFocusImages() {
	}

	public void parseJSON(JSONObject json){

	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public List<DiscoverCategoryFocusImages> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<DiscoverCategoryFocusImages> imagesList) {
		this.imagesList = imagesList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

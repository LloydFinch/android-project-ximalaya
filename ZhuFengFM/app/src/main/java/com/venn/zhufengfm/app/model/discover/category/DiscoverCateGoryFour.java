package com.venn.zhufengfm.app.model.discover.category;

import com.venn.zhufengfm.app.model.discover.category.contents.DiscoverCategoryContents;
import com.venn.zhufengfm.app.model.discover.category.images.DiscoverCategoryFocusImages;
import com.venn.zhufengfm.app.model.discover.category.tags.DiscoverCategoryTags;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCateGoryFour {
	private DiscoverCategoryTags tags;
	private int ret;
	private List<DiscoverCategoryContents> contentsList;
	private boolean hasRecommendedZones;
	private List<DiscoverCategoryFocusImages> imagesList;
	private String msg;

	public DiscoverCateGoryFour() {
	}

	public void parseJSON(JSONObject json){

	}

	public DiscoverCategoryTags getTags() {
		return tags;
	}

	public void setTags(DiscoverCategoryTags tags) {
		this.tags = tags;
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public List<DiscoverCategoryContents> getContentsList() {
		return contentsList;
	}

	public void setContentsList(List<DiscoverCategoryContents> contentsList) {
		this.contentsList = contentsList;
	}

	public boolean isHasRecommendedZones() {
		return hasRecommendedZones;
	}

	public void setHasRecommendedZones(boolean hasRecommendedZones) {
		this.hasRecommendedZones = hasRecommendedZones;
	}

	public List<DiscoverCategoryFocusImages> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<DiscoverCategoryFocusImages> imagesList) {
		this.imagesList = imagesList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

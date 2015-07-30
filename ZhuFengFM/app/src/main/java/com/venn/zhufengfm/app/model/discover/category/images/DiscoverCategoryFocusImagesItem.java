package com.venn.zhufengfm.app.model.discover.category.images;

import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryFocusImagesItem {

	private int id;
	private String  shortTitle;
	private String  longTitle;
	private String pic;
	private int type;
	private String url;
	private  int uid;
	private  int albumId;
	private boolean isShare;
	private boolean is_External_url;

	public DiscoverCategoryFocusImagesItem() {
	}

	public  void parseJSON(JSONObject json){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getLongTitle() {
		return longTitle;
	}

	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public boolean isShare() {
		return isShare;
	}

	public void setIsShare(boolean isShare) {
		this.isShare = isShare;
	}

	public boolean is_External_url() {
		return is_External_url;
	}

	public void setIs_External_url(boolean is_External_url) {
		this.is_External_url = is_External_url;
	}
}

package com.venn.zhufengfm.app.model.discover.recommend.focusImages;

import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendFocusImagesItem implements ParseJsonTool {

	private int id;
	private String shortTitle;
	private String longTitle;
	private String pic;
	private int type;
	private boolean isShare;
	private boolean is_External_url;

	private int uid;
	private int albumId;
	private int specialId;
	private int subType;
	private int trackId;


	public DiscoverRecommendFocusImagesItem() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		id = json.getInt("id");
		shortTitle = json.getString("shortTitle");
		longTitle = json.getString("longTitle");
		pic = json.getString("pic");
		type = json.getInt("type");
		isShare = json.getBoolean("isShare");
		is_External_url = json.getBoolean("is_External_url");
		try {
			uid = json.getInt("uid");
		}
		catch (Exception e) {

		}
		try {
			albumId = json.getInt("albumId");
		}
		catch (Exception e) {

		}
		try {
			specialId = json.getInt("specialId");
		}
		catch (Exception e) {

		}
		try {
			subType = json.getInt("subType");
		}
		catch (Exception e) {

		}
		try {
			trackId = json.getInt("trackId");
		}
		catch (Exception e) {

		}
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

	public int getSpecialId() {
		return specialId;
	}

	public void setSpecialId(int specialId) {
		this.specialId = specialId;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}
}

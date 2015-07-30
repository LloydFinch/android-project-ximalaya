package com.venn.zhufengfm.app.model.discover.category.contents;

import android.content.Intent;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverCategoryContentListItem {

	private int id;
	private int albumId;
	private int uid;
	private String intro;
	private String nickname;
	private String albumCoverUrl290;
	private String coverMiddle;
	private String title;
	private String tags;
	private int tracks;
	private int trackCounts;
	private int playCounts;
	private int lastUptrackId;
	private String lastUpTrackTitle;
	private long lastUpTrackAt;
	private int isFinished;
	private int serialState;

	public DiscoverCategoryContentListItem() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
//				"nickname": "有声的紫襟",
//				"albumCoverUrl290": "http://fdfs.xmcdn
// .com/group6/M02/0D/43/wKgDg1UmlZjg4lIoAANVXahWnYE722_mobile_meduim.jpg",
//				"coverMiddle": "http://fdfs.xmcdn.com/group6/M02/0D/43/wKgDg1UmlZjg4lIoAANVXahWnYE722_mobile_meduim
// .jpg",
//				"title": "藏地密码（紫襟演播）",
//				"tags": "有声小说",
//				"tracks": 420,
//				"tracksCounts": 420,
//				"playsCounts": 10392685,
//				"lastUptrackId": 7994931,
//				"lastUptrackTitle": "藏地密码10 第27集（微信公众平台：zijinvoice）",
//				"lastUptrackAt": 1438008935000,
//				"isFinished": 1,
//				"serialState": 1
		id = json.getInt("id");
		albumId = json.getInt("albumId");
		uid = json.getInt("uid");
		intro = json.getString(intro);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAlbumCoverUrl290() {
		return albumCoverUrl290;
	}

	public void setAlbumCoverUrl290(String albumCoverUrl290) {
		this.albumCoverUrl290 = albumCoverUrl290;
	}

	public String getCoverMiddle() {
		return coverMiddle;
	}

	public void setCoverMiddle(String coverMiddle) {
		this.coverMiddle = coverMiddle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getTracks() {
		return tracks;
	}

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}

	public int getTrackCounts() {
		return trackCounts;
	}

	public void setTrackCounts(int trackCounts) {
		this.trackCounts = trackCounts;
	}

	public int getPlayCounts() {
		return playCounts;
	}

	public void setPlayCounts(int playCounts) {
		this.playCounts = playCounts;
	}

	public int getLastUptrackId() {
		return lastUptrackId;
	}

	public void setLastUptrackId(int lastUptrackId) {
		this.lastUptrackId = lastUptrackId;
	}

	public String getLastUpTrackTitle() {
		return lastUpTrackTitle;
	}

	public void setLastUpTrackTitle(String lastUpTrackTitle) {
		this.lastUpTrackTitle = lastUpTrackTitle;
	}

	public long getLastUpTrackAt() {
		return lastUpTrackAt;
	}

	public void setLastUpTrackAt(long lastUpTrackAt) {
		this.lastUpTrackAt = lastUpTrackAt;
	}

	public int getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}

	public int getSerialState() {
		return serialState;
	}

	public void setSerialState(int serialState) {
		this.serialState = serialState;
	}
}

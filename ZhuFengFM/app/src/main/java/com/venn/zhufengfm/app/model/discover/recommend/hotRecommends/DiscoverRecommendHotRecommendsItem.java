package com.venn.zhufengfm.app.model.discover.recommend.hotRecommends;

import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommendHotRecommendsItem implements ParseJsonTool{

	private int albumId;
	private String coverLarge;
	private String title;
	private String tags;
	private int tracks;
	private int playsCounts;
	private int isFinished;
	private int trackId;
	private String trackTitle;

	public DiscoverRecommendHotRecommendsItem() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		albumId = json.getInt("albumId");
		coverLarge = json.getString("coverLarge");
		title = json.getString("title");
		tags = json.getString("tags");
		tracks = json.getInt("tracks");
		playsCounts = json.getInt("playsCounts");
		isFinished = json.getInt("isFinished");
		trackId = json.getInt("trackId");
		trackTitle = json.getString("trackTitle");
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getCoverLarge() {
		return coverLarge;
	}

	public void setCoverLarge(String coverLarge) {
		this.coverLarge = coverLarge;
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

	public int getPlaysCounts() {
		return playsCounts;
	}

	public void setPlaysCounts(int playsCounts) {
		this.playsCounts = playsCounts;
	}

	public int getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
}

package com.venn.zhufengfm.app.model.player;

import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/8/5.
 */
public class Album implements ParseJsonTool {

	private int albumId;
	private int categoryId;
	private String categoryName;
	private String title;
	private String coverOrigin;
	private String coverSmall;
	private String coverLarge;
	private String coverWebLarge;
	private long createdAt;
	private long updatedAt;
	private int uid;
	private String nickname;
	private boolean isVerified;
	private String avatarPath;
	private String intro;
	private String introRich;
	private String tags;
	private int tracks;
	private int shares;
	private boolean hasNew;
	private boolean isFavorite;
	private int playTimes;
	private int status;
	private int serializeStatus;

	public Album() {
	}

	public void parseJSON(JSONObject json) throws JSONException {
		albumId = json.getInt("albumId");
		categoryId = json.getInt("categoryId");
		categoryName = json.getString("categoryName");
		title = json.getString("title");
		coverOrigin = json.getString("coverOrigin");
		coverSmall = json.getString("coverSmall");
		coverLarge = json.getString("coverLarge");
		coverWebLarge = json.getString("coverWebLarge");
		createdAt = json.getLong("createdAt");
		updatedAt = json.getLong("updatedAt");
		uid = json.getInt("uid");
		nickname = json.getString("nickname");
		isVerified = json.getBoolean("isVerified");
		avatarPath = json.getString("avatarPath");
		intro = json.getString("intro");
		introRich = json.getString("introRich");
		tags = json.getString("tags");
		tracks = json.getInt("tracks");
		shares = json.getInt("shares");
		hasNew = json.getBoolean("hasNew");
		isFavorite = json.getBoolean("isFavorite");
		playTimes = json.getInt("playTimes");
		status = json.getInt("status");
		serializeStatus = json.getInt("serializeStatus");
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverOrigin() {
		return coverOrigin;
	}

	public void setCoverOrigin(String coverOrigin) {
		this.coverOrigin = coverOrigin;
	}

	public String getCoverSmall() {
		return coverSmall;
	}

	public void setCoverSmall(String coverSmall) {
		this.coverSmall = coverSmall;
	}

	public String getCoverLarge() {
		return coverLarge;
	}

	public void setCoverLarge(String coverLarge) {
		this.coverLarge = coverLarge;
	}

	public String getCoverWebLarge() {
		return coverWebLarge;
	}

	public void setCoverWebLarge(String coverWebLarge) {
		this.coverWebLarge = coverWebLarge;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getIntroRich() {
		return introRich;
	}

	public void setIntroRich(String introRich) {
		this.introRich = introRich;
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

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public boolean isHasNew() {
		return hasNew;
	}

	public void setHasNew(boolean hasNew) {
		this.hasNew = hasNew;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public int getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(int playTimes) {
		this.playTimes = playTimes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSerializeStatus() {
		return serializeStatus;
	}

	public void setSerializeStatus(int serializeStatus) {
		this.serializeStatus = serializeStatus;
	}
}

package com.venn.zhufengfm.app.model.player;

import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/8/5.
 */
public class TrackItem implements ParseJsonTool {

	private int trackId;
	private int uid;
	private String playUrl64;
	private String playUrl32;
	private String downloadUrl;
	private String playPathAacv164;
	private String playPathAacv224;
	private String downloadAacUrl;
	private String title;
	private double duration;
	private int processState;
	private long createdAt;
	private String coverSmall;
	private String coverLarge;
	private String nickname;
	private String smallLogo;
	private int userSource;
	private int albumId;
	private String albumTitle;
	private String albumImage;
	private int orderNum;
	private int opType;
	private boolean isPublic;
	private int likes;
	private int playTimes;
	private int comments;
	private int shares;
	private int status;
	private int downloadSize;
	private int downloadAacSize;


	public TrackItem() {

	}

	public void parseJSON(JSONObject json) throws JSONException {
		trackId = json.getInt("trackId");
		uid = json.getInt("uid");
		playUrl64 = json.getString("playUrl64");
		playUrl32 = json.getString("playUrl32");
		downloadUrl = json.getString("downloadUrl");
		playPathAacv164 = json.getString("playPathAacv164");
		playPathAacv224 = json.getString("playPathAacv224");
		downloadAacUrl = json.getString("downloadAacUrl");
		title = json.getString("title");
		duration = json.getDouble("duration");
		processState = json.getInt("processState");
		createdAt = json.getLong("createdAt");
		coverSmall = json.getString("coverSmall");
		coverLarge = json.getString("coverLarge");
		nickname = json.getString("nickname");
		smallLogo = json.getString("smallLogo");
		userSource = json.getInt("userSource");
		albumId = json.getInt("albumId");
		albumTitle = json.getString("albumTitle");
		albumImage = json.getString("albumImage");
		orderNum = json.getInt("orderNum");
		opType = json.getInt("opType");
		isPublic = json.getBoolean("isPublic");
		likes = json.getInt("likes");
		playTimes = json.getInt("playtimes");
		comments = json.getInt("comments");
		shares = json.getInt("shares");
		status = json.getInt("status");
		downloadSize = json.getInt("downloadSize");
		downloadAacSize = json.getInt("downloadAacSize");
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPlayUrl64() {
		return playUrl64;
	}

	public void setPlayUrl64(String playUrl64) {
		this.playUrl64 = playUrl64;
	}

	public String getPlayUrl32() {
		return playUrl32;
	}

	public void setPlayUrl32(String playUrl32) {
		this.playUrl32 = playUrl32;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getPlayPathAacv164() {
		return playPathAacv164;
	}

	public void setPlayPathAacv164(String playPathAacv164) {
		this.playPathAacv164 = playPathAacv164;
	}

	public String getPlayPathAacv224() {
		return playPathAacv224;
	}

	public void setPlayPathAacv224(String playPathAacv224) {
		this.playPathAacv224 = playPathAacv224;
	}

	public String getDownloadAacUrl() {
		return downloadAacUrl;
	}

	public void setDownloadAacUrl(String downloadAacUrl) {
		this.downloadAacUrl = downloadAacUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getProcessState() {
		return processState;
	}

	public void setProcessState(int processState) {
		this.processState = processState;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSmallLogo() {
		return smallLogo;
	}

	public void setSmallLogo(String smallLogo) {
		this.smallLogo = smallLogo;
	}

	public int getUserSource() {
		return userSource;
	}

	public void setUserSource(int userSource) {
		this.userSource = userSource;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAlbumImage() {
		return albumImage;
	}

	public void setAlbumImage(String albumImage) {
		this.albumImage = albumImage;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(int playTimes) {
		this.playTimes = playTimes;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDownloadSize() {
		return downloadSize;
	}

	public void setDownloadSize(int downloadSize) {
		this.downloadSize = downloadSize;
	}

	public int getDownloadAacSize() {
		return downloadAacSize;
	}

	public void setDownloadAacSize(int downloadAacSize) {
		this.downloadAacSize = downloadAacSize;
	}
}

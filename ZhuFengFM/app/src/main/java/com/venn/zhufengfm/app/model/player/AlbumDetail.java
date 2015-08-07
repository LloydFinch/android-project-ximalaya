package com.venn.zhufengfm.app.model.player;

import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/8/5.
 */
public class AlbumDetail implements ParseJsonTool {

	private int ret;
	private Album album;
	private Tracks tracks;
	private String msg;

	public AlbumDetail() {
		album = new Album();
		tracks = new Tracks();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		album.parseJSON(json.getJSONObject("album"));
		tracks.parseJSON(json.getJSONObject("tracks"));
		msg = json.getString("msg");
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Tracks getTracks() {
		return tracks;
	}

	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

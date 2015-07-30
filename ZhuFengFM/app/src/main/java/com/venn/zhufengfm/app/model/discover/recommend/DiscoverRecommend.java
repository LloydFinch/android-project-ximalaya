package com.venn.zhufengfm.app.model.discover.recommend;

import com.venn.zhufengfm.app.model.discover.recommend.discoveryColumns.DiscoverRecommendDiscoveryColumns;
import com.venn.zhufengfm.app.model.discover.recommend.editorRecommends.DiscoverRecommendEditorRecommendAlbums;
import com.venn.zhufengfm.app.model.discover.recommend.focusImages.DiscoverRecommendFocusImages;
import com.venn.zhufengfm.app.model.discover.recommend.hotRecommends.DiscoverRecommendHotRecommends;
import com.venn.zhufengfm.app.model.discover.recommend.specialColumn.DiscoverRecommendSpecialColumn;
import com.venn.zhufengfm.app.model.jsontool.ParseJsonTool;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by VennUser on 2015/7/30.
 */
public class DiscoverRecommend implements ParseJsonTool {
	private int ret;
	private DiscoverRecommendDiscoveryColumns discoveryColumns;
	private DiscoverRecommendEditorRecommendAlbums recommendAlbums;
	private DiscoverRecommendHotRecommends hotRecommends;
	private DiscoverRecommendFocusImages images;
	private String msg;
	private DiscoverRecommendSpecialColumn specialColumn;

	public DiscoverRecommend() {
		discoveryColumns = new DiscoverRecommendDiscoveryColumns();
		recommendAlbums = new DiscoverRecommendEditorRecommendAlbums();
		hotRecommends = new DiscoverRecommendHotRecommends();
		images = new DiscoverRecommendFocusImages();
		specialColumn = new DiscoverRecommendSpecialColumn();
	}

	public void parseJSON(JSONObject json) throws JSONException {
		ret = json.getInt("ret");
		discoveryColumns.parseJSON(json.getJSONObject("discoveryColumns"));
		recommendAlbums.parseJSON(json.getJSONObject("editorRecommendAlbums"));
		hotRecommends.parseJSON(json.getJSONObject("hotRecommends"));
		images.parseJSON(json.getJSONObject("focusImages"));
		specialColumn.parseJSON(json.getJSONObject("specialColumn"));
		msg = json.getString("msg");
	}

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public DiscoverRecommendDiscoveryColumns getDiscoveryColumns() {
		return discoveryColumns;
	}

	public void setDiscoveryColumns(DiscoverRecommendDiscoveryColumns discoveryColumns) {
		this.discoveryColumns = discoveryColumns;
	}

	public DiscoverRecommendEditorRecommendAlbums getRecommendAlbums() {
		return recommendAlbums;
	}

	public void setRecommendAlbums(DiscoverRecommendEditorRecommendAlbums recommendAlbums) {
		this.recommendAlbums = recommendAlbums;
	}

	public DiscoverRecommendHotRecommends getHotRecommends() {
		return hotRecommends;
	}

	public void setHotRecommends(DiscoverRecommendHotRecommends hotRecommends) {
		this.hotRecommends = hotRecommends;
	}

	public DiscoverRecommendFocusImages getImages() {
		return images;
	}

	public void setImages(DiscoverRecommendFocusImages images) {
		this.images = images;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DiscoverRecommendSpecialColumn getSpecialColumn() {
		return specialColumn;
	}

	public void setSpecialColumn(DiscoverRecommendSpecialColumn specialColumn) {
		this.specialColumn = specialColumn;
	}
}

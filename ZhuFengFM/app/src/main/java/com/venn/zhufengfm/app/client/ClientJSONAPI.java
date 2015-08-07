package com.venn.zhufengfm.app.client;

import com.venn.zhufengfm.app.uitl.MyLog;

/**
 * Created by VennUser on 2015/7/28.
 */

//发现部分的API接口,返回Json字符串
public class ClientJSONAPI {

	public static final String SERVER_MOBILE = "http://mobile.ximalaya.com";

	private ClientJSONAPI() {

	}

	//获取分类Tag菜单
	//调用接口http://mobile.ximalaya.com/m/category_tag_menu
	//GET方法xgcui
	//type 可选,默认为user
	public static String getCategoryTagMenu(String type) {
		StringBuilder sb = new StringBuilder();
		sb.append(SERVER_MOBILE).append("/m/category_tag_menu");
		if (type != null) {
			sb.append("?type=" + type).append("&device=android");
		}
		String path = sb.toString();
		return getJsonString(path);
	}

	//获取发现Tab菜单
	//调用接口:http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android
	public static String getDiscoverTabs() {
		String path = SERVER_MOBILE + "/mobile/discovery/v1/tabs?device=android";
		return getJsonString(path);
	}

	//发现中的分类部分
	public static String getDiscoverCategories() {
		String path = SERVER_MOBILE + "/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2";
		return getJsonString(path);
	}

	public static String getDiscoverRecommends() {
		String path = SERVER_MOBILE + "/mobile/discovery/v1/recommends?channel=and-f6" +
				"&device=android&includeActivity=true&includeSpecial=true&scale=2&version=4.1.7.1";
		return getJsonString(path);
	}

	public static String getAlbumDetail(String ret) {
		String path = SERVER_MOBILE + "/mobile/others/ca/album/track/203355/true/1/20?device=android&pageSize=20" +
				"&albumId=" + ret + "&isAsc=true";
		return getJsonString(path);
	}

	private static String getJsonString(String path) {
		byte[] buffer = HttpUtils.doGet(path);
		String data = null;
		if (buffer != null) {
			data = new String(buffer);
		}
		return data;
	}
}

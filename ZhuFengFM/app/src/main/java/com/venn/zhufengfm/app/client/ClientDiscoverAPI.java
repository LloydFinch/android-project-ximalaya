package com.venn.zhufengfm.app.client;

/**
 * Created by VennUser on 2015/7/28.
 */

//发现部分的API接口,返回Json字符串
public class ClientDiscoverAPI {

	public static final String SERVER_MOBILE = "http://mobile.ximalaya.com";

	private ClientDiscoverAPI() {

	}

	//获取分类Tag菜单
	//调用接口http://mobile.ximalaya.com/m/category_tag_menu
	//GET方法
	//type 可选,默认为user
	public static String getCategoryTagMenu(String type) {
		String data = null;
		String path = null;
		StringBuilder sb = new StringBuilder();
		sb.append(SERVER_MOBILE).append("/m/category_tag_menu");
		if (type != null) {
			sb.append("?type=" + type).append("&device=android");
		}
		path = sb.toString();
		byte[] buffer = HttpUtils.doGet(path);
		data = new String(buffer);

		return data;
	}

	//获取发现Tab菜单
	//调用接口:http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android
	public static String getDiscoverTabs() {
		String data = null;

		String path = SERVER_MOBILE + "/mobile/discovery/v1/tabs?device=android";
		byte[] buffer = HttpUtils.doGet(path);
		data = new String(buffer);
		return data;
	}

	//发现中的分类部分
	public static String getDiscoverCategories(){
		String data = null;

		String path = SERVER_MOBILE+"/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2";
		byte[] buffer = HttpUtils.doGet(path);
		data = new String(buffer);
		return data;
	}
}

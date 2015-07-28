package com.venn.zhufengfm.app.client;

import android.util.Log;

import java.net.URL;

/**
 * Created by VennUser on 2015/7/28.
 */

//发现部分的API接口
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
}

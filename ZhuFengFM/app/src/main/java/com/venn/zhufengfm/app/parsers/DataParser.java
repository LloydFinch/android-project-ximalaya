package com.venn.zhufengfm.app.parsers;

import com.venn.zhufengfm.app.model.discover.CategoryTagMenu;
import com.venn.zhufengfm.app.model.discover.DiscoverCategory;
import com.venn.zhufengfm.app.model.discover.DiscoverTab;
import com.venn.zhufengfm.app.model.discover.recommend.DiscoverRecommend;
import com.venn.zhufengfm.app.model.player.AlbumDetail;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/28.
 */

//转化数据的工具类,接收JSONObject,返回解析后的List集合
public class DataParser {

	private DataParser() {

	}

	public static List<CategoryTagMenu> parseCategoryTagMenu(JSONObject json) {

		List<CategoryTagMenu> categoryTagMenuList = new ArrayList<CategoryTagMenu>();

		try {
			if (json != null) {
				int code = json.getInt("ret");
				JSONObject data = json.getJSONObject("data");
				int category_count = data.getInt("category_count");
				if (category_count > 0) {
					JSONArray category_list = data.getJSONArray("category_list");

					for (int i = 0; i < category_list.length(); i++) {
						JSONObject jsonObject = category_list.getJSONObject(i);
						CategoryTagMenu categoryTagMenu = new CategoryTagMenu();
						categoryTagMenu.parseJSON(jsonObject);
						categoryTagMenuList.add(categoryTagMenu);
					}
				}
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return categoryTagMenuList;
	}

	public static List<DiscoverTab> parseDiscoverTab(JSONObject jsonObject) {

		List<DiscoverTab> discoverTabs = new ArrayList<DiscoverTab>();
		try {
			int code = jsonObject.getInt("ret");
			if (code == 0) {
				String msg = jsonObject.getString("msg");
				JSONObject tabs = jsonObject.getJSONObject("tabs");
				int count = tabs.getInt("count");
				if (count > 0) {
					JSONArray list = tabs.getJSONArray("list");
					for (int i = 0; i < list.length(); i++) {
						DiscoverTab discoverTab = new DiscoverTab();
						discoverTab.parseJSON(list.getJSONObject(i));
						discoverTabs.add(discoverTab);
					}
				}
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return discoverTabs;
	}

	public static List<DiscoverCategory> parseDiscoverCategory(JSONObject jsonObject) {

		List<DiscoverCategory> discoverCategories = new ArrayList<DiscoverCategory>();
		try {
			int ret = jsonObject.getInt("ret");
			JSONArray list = jsonObject.getJSONArray("list");
			for (int i = 0; i < list.length(); i++) {
				JSONObject json = list.getJSONObject(i);
				DiscoverCategory discoverCategory = new DiscoverCategory();
				discoverCategory.parseJSON(json);
				discoverCategories.add(discoverCategory);
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return discoverCategories;
	}

	public static DiscoverRecommend parseDiscoverRecommend(JSONObject jsonObject) {
		DiscoverRecommend discoverRecommend = new DiscoverRecommend();
		try {
			discoverRecommend.parseJSON(jsonObject);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return discoverRecommend;
	}

	public static AlbumDetail parseAlbumDetail(JSONObject jsonObject) {
		AlbumDetail albumDetail = new AlbumDetail();
		try {
			albumDetail.parseJSON(jsonObject);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return albumDetail;
	}
}

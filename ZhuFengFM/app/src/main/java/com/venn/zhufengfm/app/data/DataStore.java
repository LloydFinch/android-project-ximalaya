package com.venn.zhufengfm.app.data;

import com.venn.zhufengfm.app.model.discover.DiscoverCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by VennUser on 2015/7/29.
 */

//公共数据存储区
public class DataStore {
	private static DataStore ourInstance = new DataStore();
	private List<DiscoverCategory> discoverCategories;

	public static DataStore getInstance() {
		if (ourInstance == null) {
			ourInstance = new DataStore();
		}
		return ourInstance;
	}

	public static void release() {
		ourInstance = null;
	}


	private DataStore() {
		discoverCategories = new ArrayList<DiscoverCategory>();
	}

	public void setDiscoverCategories(List<DiscoverCategory> discoverCategories) {
		if (this.discoverCategories != null && !this.discoverCategories.isEmpty()) {
			this.discoverCategories.clear();
		}
		this.discoverCategories.addAll(discoverCategories);
		Collections.sort(this.discoverCategories);
	}

	//获取已经加载过的分类
	public List<DiscoverCategory> getDiscoverCategories() {
		return discoverCategories;
	}

}

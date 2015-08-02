package com.venn.zhufengfm.app.model.jsontool;

import android.util.Log;
import com.venn.zhufengfm.app.model.discover.recommend.discoveryColumns.DiscoverRecommendDiscoveryColumnsItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */
public abstract class JsonArrayTool {
	public static void getJsonArray(Object object, Class c, JSONObject json) {
		try {
			List toolList = (List) object;
			JSONArray array = json.getJSONArray("list");
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				ParseJsonTool tool = (ParseJsonTool) c.newInstance();
				tool.parseJSON(jsonObject);
				toolList.add(tool);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

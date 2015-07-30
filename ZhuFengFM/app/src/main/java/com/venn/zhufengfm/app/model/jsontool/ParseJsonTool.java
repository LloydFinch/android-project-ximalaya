package com.venn.zhufengfm.app.model.jsontool;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarEntry;

/**
 * Created by VennUser on 2015/7/30.
 */
public interface ParseJsonTool {

	void parseJSON(JSONObject json) throws JSONException;
}

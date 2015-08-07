package com.venn.zhufengfm.app.uitl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by VennUser on 2015/7/31.
 */
public final class SetTextUtil {

	public static void setText(TextView view, String text) {
		view.setText(text == null ? "无法显示" : text);
	}
}

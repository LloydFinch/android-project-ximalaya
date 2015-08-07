package com.venn.zhufengfm.app.uitl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.venn.zhufengfm.app.cache.FileCache;
import com.venn.zhufengfm.app.cache.MemoryCache;
import com.venn.zhufengfm.app.tasks.ImageLoadTask;

/**
 * Created by VennUser on 2015/8/1.
 */
public final class SetImageUtil {
	public static void setImage(boolean needLoad, ImageView imageView, String path, Context context) {
		Object tag = imageView.getTag();

		if (needLoad) {
			imageView.setTag(tag);
			ImageLoadTask task = new ImageLoadTask(imageView, context);
			if (Build.VERSION.SDK_INT >= 11) {
				task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, path);
			} else {
				task.execute(path);
			}
		} else {

			boolean otherLoad = true;
			Bitmap bitmap = MemoryCache.getInstance().getBitmapFromMemory(path);
			if (bitmap == null) {
				byte[] data = FileCache.createInstance(context).loadFile(path);
				if (data != null) {
					bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
				}
				if (bitmap == null) {
					if (tag != null) {
						if (tag instanceof String) {
							if (tag.equals(path)) {
								otherLoad = false;
							}
						}
					}
				} else {
					imageView.setImageBitmap(bitmap);
				}
			} else {
				imageView.setImageBitmap(bitmap);
			}
			if (otherLoad) {
				imageView.setTag(tag);
				ImageLoadTask task = new ImageLoadTask(imageView, context);
				if (Build.VERSION.SDK_INT >= 11) {
					task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, path);
				} else {
					task.execute(path);
				}
			}
		}
	}
}

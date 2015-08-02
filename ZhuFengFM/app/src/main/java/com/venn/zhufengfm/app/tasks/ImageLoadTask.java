package com.venn.zhufengfm.app.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.venn.zhufengfm.app.cache.FileCache;
import com.venn.zhufengfm.app.cache.MemoryCache;
import com.venn.zhufengfm.app.client.HttpUtils;
import com.venn.zhufengfm.app.tasks.BaseTask;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.uitl.ImageSampleUtil;
import com.venn.zhufengfm.app.uitl.MyLog;

/**
 * Created by VennUser on 2015/7/31.
 */

//图片下载的异步任务
public class ImageLoadTask extends AsyncTask<String, Integer, Bitmap> {

	private ImageView imageView;
	private SetImage setImage;
	private String url;
	private Context context;

	public ImageLoadTask(SetImage setImage) {
		this.setImage = setImage;
	}

	public ImageLoadTask(ImageView imageView, Context context) {
		this.imageView = imageView;
		this.context = context;
	}

	protected Bitmap doInBackground(String... params) {
		Bitmap bitmap = null;
		url = params[0].toString();

		if (params != null && params.length > 0) {
			byte[] data = HttpUtils.doGet(params[0]);

			FileCache.createInstance(context).saveFile(url, data);
			if (data != null) {
				bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			}

			//进行二次采样

			//1 只获取尺寸
			BitmapFactory.Options options = new BitmapFactory.Options();

			//2 计算采样比率
			//3 设置Options为实际解析图片并设置采样比率
			options.inJustDecodeBounds = false;
			options.inPurgeable = true;

			//设置解码器可以使用的解码像素颜色,注意透明度与颜色的管理
			//不能使用将自动使用ARGB_8888
			//options.inPreferredConfig = Bitmap.Config.ARGB_4444;

			options.inSampleSize = ImageSampleUtil.calculateInSampleSize(options, imageView.getWidth(), imageView
					.getHeight());

			BitmapFactory.decodeByteArray(data, 0, data.length, options);
		}

		MyLog.d("bitmap", "--" + (bitmap == null));
		return bitmap;
	}

	protected void onPostExecute(Bitmap bitmap) {
		Object tag = imageView.getTag();

		if (tag != null) {
			if (tag instanceof String) {
				MemoryCache.getInstance().putBitmapToMemoryCache((String) tag, bitmap);
			}
		}

		if (imageView != null && bitmap != null) {
			if (tag != null) {
				if (tag instanceof String) {
					if (tag.equals(url)) {
						imageView.setImageBitmap(bitmap);
					}
				}
			}
		}
	}


	//自定义的接口回调
	interface SetImage {
		void onFinishedLoadImage(Bitmap bitmap);
	}
}

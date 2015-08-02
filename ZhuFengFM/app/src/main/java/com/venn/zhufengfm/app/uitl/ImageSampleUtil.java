package com.venn.zhufengfm.app.uitl;

import android.graphics.BitmapFactory;

/**
 * Created by VennUser on 2015/8/1.
 */

//用于图片采样处理的工具类
public final class ImageSampleUtil {

	private ImageSampleUtil() {}

	//通过options包含的原始尺寸和需要的目标尺寸计算最佳采样率
	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (reqHeight <= 0 || reqWidth <= 0) {
			return inSampleSize;
		}

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}
		return inSampleSize;
	}
}

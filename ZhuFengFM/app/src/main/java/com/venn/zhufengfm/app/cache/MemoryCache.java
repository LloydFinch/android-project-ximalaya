package com.venn.zhufengfm.app.cache;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.util.LruCache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by VennUser on 2015/8/1.
 */

//内存缓存
public class MemoryCache {

	private static MemoryCache ourInstance;

	//Lru缓存,使用了LRU算法,相当于一个HashMap
	private LruCache<String, Bitmap> mMemoryCache;

	//扩大内存利用率
	private HashMap<String, SoftReference<Bitmap>> softCache;

	//Lru缓存最大的缓存数量
	private int maxMemory;

	public static MemoryCache getInstance() {
		if (ourInstance == null) {
			ourInstance = new MemoryCache();
		}
		return ourInstance;
	}

	private MemoryCache() {
		maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

		//设置内存尺寸,一般是最大内存的1/8
		mMemoryCache = new LruCache<String, Bitmap>(maxMemory / 8) {
			protected int sizeOf(String key, Bitmap bitmap) {

				int ret = 0;
				if (Build.VERSION.SDK_INT >= 19) {
					ret = bitmap.getAllocationByteCount();
				} else if (Build.VERSION.SDK_INT >= 12) {
					ret = bitmap.getByteCount();
				} else {

					//一行所占用的字节数
					int rowBytes = bitmap.getRowBytes();

					//高度(行数)
					int height = bitmap.getHeight();

					//一个像素4个字节
					ret = rowBytes * height;
				}
				return ret;

				//return bitmap.getByteCount()//API12以上使用
			}
		};

		softCache = new LinkedHashMap<String, SoftReference<Bitmap>>();
	}

	public void putBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (key != null && bitmap != null) {
			mMemoryCache.put(key, bitmap);
			softCache.put(key, new SoftReference<Bitmap>(bitmap));
		}
	}

	public Bitmap getBitmapFromMemory(String key) {
		Bitmap bitmap = mMemoryCache.get(key);
		if (bitmap == null) {
			SoftReference<Bitmap> bitmapSoftReference = softCache.get(key);
			if (bitmapSoftReference != null) {

				//获取软引用指向的数据
				bitmap = bitmapSoftReference.get();
				if (bitmap != null) {
					mMemoryCache.put(key, bitmap);
				}
			}
		}
		return bitmap;
	}
}

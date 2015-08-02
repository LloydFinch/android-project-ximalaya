package com.venn.zhufengfm.app.cache;

import android.content.Context;
import android.os.Environment;
import com.venn.zhufengfm.app.uitl.StreamUtil;

import java.io.*;
import java.lang.annotation.Retention;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by VennUser on 2015/7/31.
 */

//文件缓存的工具类
//TODO 不熟悉的类
public class FileCache {

	//用来获取CacheDir
	private Context context;

	private static FileCache ourInstance;

	//如果已经存在还要创建就抛出异常
	public static FileCache createInstance(Context context) {

		if (context != null) {
			if (ourInstance == null) {
				ourInstance = new FileCache(context);
			}
			return ourInstance;
		} else {
			throw new IllegalArgumentException("Context must be set");
		}
	}

	//不能使用无参的方法获取
	public FileCache getInstance() {
		if (ourInstance != null) {
			return ourInstance;
		} else {
			throw new IllegalArgumentException("You must invoke createInstance(Context) before this");
		}
	}

	private FileCache(Context context) {
		this.context = context;
	}

	//通过网址加载文件
	public byte[] loadFile(String url) {
		File cacheDir = null;
		byte[] ret = null;
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			cacheDir = context.getExternalCacheDir();
		} else {
			cacheDir = context.getCacheDir();
		}
		if (url != null) {
			String name = MD5(url);
			File file = new File(cacheDir, name);
			if (file.exists()) {
				FileInputStream fin = null;
				try {
					fin = new FileInputStream(file);
					ret = StreamUtil.readStream(fin);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					StreamUtil.close(fin);
				}
			}
		}
		return ret;
	}

	//保存文件
	public void saveFile(String url, byte[] data) {

		File cacheDir = null;
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			// 外部
			cacheDir = context.getExternalCacheDir();
		} else {
			//内部
			cacheDir = context.getCacheDir();
		}
		if (url != null && data != null) {

			// TODO url 转换
			String name = MD5(url);
			File file = new File(cacheDir, name);
			FileOutputStream fot = null;
			try {
				fot = new FileOutputStream(file);
				fot.write(data);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				StreamUtil.close(fot);
			}
		}
	}

	//将url转换成一个唯一的字符串返回
	public static String MD5(String url) {
		String ret = null;
		if (url != null) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] data = md5.digest(url.getBytes());

				//经过md5的字节数组不能new出字符串
				StringBuilder sb = new StringBuilder();
				for (byte b : data) {
					int h = (b >> 4) & 0x0f;
					int l = b & 0x0f;
					sb.append(Integer.toHexString(h)).append(Integer.toHexString(l));
				}
				ret = sb.toString();
				sb = null;
				data = null;
			}
			catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}

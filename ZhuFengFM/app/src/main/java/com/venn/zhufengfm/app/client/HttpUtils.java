package com.venn.zhufengfm.app.client;

import android.os.Build;
import com.venn.zhufengfm.app.uitl.MyLog;
import com.venn.zhufengfm.app.uitl.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;
import java.util.zip.GZIPInputStream;

/**
 * Created by VennUser on 2015/7/28.
 */

//网络工具类,用于处理http请求
public class HttpUtils {

	private static final int TIMEOUT = 10000;

	private HttpUtils() {

	}


	//用于处理GET请求,返回数据的字节数组
	public static byte[] doGet(String path) {

		byte[] data = null;
		URL url = null;
		if (path != null) {

			HttpURLConnection connection = null;
			InputStream inputStream = null;

			try {
				url = new URL(path);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");

				connection.setRequestProperty("Accept:Encoding", "gzip");
				connection.setRequestProperty("User-Agent", "ting_4.1.7(MI2, Android" + Build.VERSION.SDK_INT + ")");

				//Socket打开连接的时间
				connection.setConnectTimeout(TIMEOUT);

				//设置打开链接后读取的最大时间
				connection.setReadTimeout(TIMEOUT);

				//设置自动处理302/307错误的跳转,通常返回200
				connection.setInstanceFollowRedirects(true);

				//设置可读写
				//connection.setDoInput(true);
				//connection.setDoOutput(true);

				//进行连接
				connection.connect();

				if (connection.getResponseCode() == 200) {
					inputStream = connection.getInputStream();

					//获取服务器头信息
					String encoding = connection.getHeaderField("Content-Encoding");
					if (encoding == null) {
						encoding = connection.getHeaderField("content-encoding");
					} else if (encoding.equals("gzip")) {
						//表示数据经过压缩,需要解压缩
						inputStream = new GZIPInputStream(inputStream);
					}

					//读取inputStream中的数据
					data = StreamUtil.readStream(inputStream);
					MyLog.d("HttpUtil1", "--" + (data == null));
				}
			}
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				StreamUtil.close(inputStream);
				StreamUtil.close(connection);
			}
		}
		return data;
	}
}

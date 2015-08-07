package com.venn.zhufengfm.app.uitl;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;

/**
 * Created by VennUser on 2015/7/28.
 */

//IO流操作的工具类
public class StreamUtil {

	private StreamUtil() {

	}

	public static byte[] readStream(InputStream in) {
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		if (in != null) {

			byte[] buff = new byte[128];
			baos = new ByteArrayOutputStream();
			int length = 0;
			try {
				while ((length = in.read(buff)) != -1) {
					baos.write(buff, 0, length);
				}
				data = baos.toByteArray();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				buff = null;
				try {
					baos.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	public static void close(Object stream) {
		if (stream != null) {
			try {
				if (stream instanceof InputStream) {
					((InputStream) stream).close();
				} else if (stream instanceof OutputStream) {
					((OutputStream) stream).close();
				} else if (stream instanceof Reader) {
					((Reader) stream).close();
				} else if (stream instanceof Writer) {
					((Writer) stream).close();
				} else if (stream instanceof HttpsURLConnection) {
					((HttpsURLConnection) stream).disconnect();
				}
			}
			catch (IOException e) {

			}
		}
	}
}

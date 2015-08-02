package com.venn.zhufengfm.app.uitl;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by VennUser on 2015/7/31.
 */

//未捕获异常的处理器
public class UnCaughtExceptionHandlerImpl implements Thread.UncaughtExceptionHandler {

	//用来获取文件路径的上下文
	private Context context;

	public UnCaughtExceptionHandlerImpl(Context context) {
		this.context = context;
	}

	//处理线程的未捕获异常的方法
	public void uncaughtException(Thread thread, Throwable ex) {

		//TODO 将异常信息保存到文件,下次启动就上传到服务器
		if (context != null) {

			File fileDir = context.getFilesDir();
			String state = Environment.getExternalStorageState();
			if (state.equals(Environment.MEDIA_MOUNTED)) {
				fileDir = context.getExternalFilesDir(null);
			}
			File logFile = new File(fileDir, "logFile");
			PrintWriter printWriter = null;
			try {
				printWriter = new PrintWriter(logFile);
				ex.printStackTrace(printWriter);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				StreamUtil.close(printWriter);
			}
		}
		System.exit(111);
	}
}

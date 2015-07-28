package com.venn.zhufengfm.app.tasks;

/**
 * Created by VennUser on 2015/7/28.
 */

//异步任务执行成功之后由onPostExecute()回调
public interface TaskCallback {

	void onTaskFinished(TaskResult result);

}

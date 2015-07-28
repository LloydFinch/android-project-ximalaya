package com.venn.zhufengfm.app.tasks;

/**
 * Created by VennUser on 2015/7/28.
 */

//异步任务结果的描述,用于区分结果属于哪一个Task
public class TaskResult {

	//task的标识
	private int taskId;

	//task数据
	private Object data;

	public TaskResult() {
	}

	public TaskResult(int taskId, Object data) {
		this.taskId = taskId;
		this.data = data;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

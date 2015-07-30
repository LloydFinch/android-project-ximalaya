package com.venn.zhufengfm.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created by VennUser on 2015/7/30.
 */

//所有的Activity继承此Activity即可实现
public class BaseActivity extends FragmentActivity{

	//子类可以重写此方法来返回不同的动画切换效果
	protected  int getEnterAnimationId(){
		return R.anim.anim_slide_to_left;
	}

	protected  int getExitAnimationId(){
		return R.anim.anim_drop_down;
	}

	private TextView textView;

	//被启动的Activity的进入动画
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(getEnterAnimationId(), 0);
	}

	//退出的Activity的退出动画
	public void finish() {
		super.finish();
		overridePendingTransition(0, getExitAnimationId());
	}

	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);

		//TODO 为继承此Activity的Activity设置公共属性
		textView = (TextView) this.findViewById(R.id.common_text);
	}

	public void setTitle(CharSequence title) {

		if(textView!=null){
			textView.setText(title);
		}
	}
}

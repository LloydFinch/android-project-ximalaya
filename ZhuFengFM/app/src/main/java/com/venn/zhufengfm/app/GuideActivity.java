package com.venn.zhufengfm.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.venn.zhufengfm.app.adapters.GuideAdapter;
import com.venn.zhufengfm.app.uitl.Constants;
import com.venn.zhufengfm.app.uitl.PackageUtil;

import java.util.ArrayList;
import java.util.List;

//教程页
public class GuideActivity extends FragmentActivity implements View.OnClickListener {

	private ViewPager guideViewPager;
	private GuideAdapter guideAdapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);

		guideViewPager = (ViewPager) this.findViewById(R.id.guide_view_pager);

		List<Integer> images = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			images.add(R.mipmap.ic_launcher);
		}
		guideAdapter = new GuideAdapter(this, images);
		guideAdapter.setGoOnClickListener(this);
		if (guideViewPager != null) {
			guideViewPager.setAdapter(guideAdapter);
		}

		//设置SharedPreferences
		SharedPreferences preferences = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();

		editor.putString(Constants.SP_KEY_GUIDE_LAST_SHOW_VER, PackageUtil.getPackageVersionName(this));
		editor.commit();
	}


	public void onClick(View v) {
		startNext();
	}

	private void startNext() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	public void onBackPressed() {
		startNext();
	}
}

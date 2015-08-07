package com.venn.zhufengfm.app.activity;

import android.database.sqlite.SQLiteException;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.*;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.activity.BaseActivity;
import com.venn.zhufengfm.app.fragments.CustomFragment;
import com.venn.zhufengfm.app.fragments.DiscoverFragment;
import com.venn.zhufengfm.app.fragments.DownLoadListenFragment;
import com.venn.zhufengfm.app.fragments.ProfileFragment;

import java.io.IOException;


//主界面
public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

	private RadioGroup radioGroup;

	private DiscoverFragment discoverFragment;
	private CustomFragment customFragment;
	private DownLoadListenFragment downLoadListenFragment;
	private ProfileFragment profileFragment;

	private CheckBox checkBoxPlay;
	private MediaPlayer mediaPlayer;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setTitle("主界面");

		radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_bar);
		radioGroup.setOnCheckedChangeListener(this);
		radioGroup.check(R.id.main_tab_item_discover);

		checkBoxPlay = (CheckBox) this.findViewById(R.id.main_tab_item_play);
		checkBoxPlay.setOnClickListener(this);
	}

	protected void onResume() {
		super.onResume();
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource("http://fdfs.xmcdn.com/group8/M08/52/5B/wKgDYFW2envSiMSyATE0a1NxlgI220.mp3");
			mediaPlayer.prepare();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void onStop() {
		mediaPlayer.release();
		super.onStop();
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();

		Fragment fragment = null;
		switch (checkedId) {
			case R.id.main_tab_item_discover:
				fragment = discoverFragment == null ? new DiscoverFragment() : discoverFragment;
				break;
			case R.id.main_tab_item_custom:
				fragment = customFragment == null ? new CustomFragment() : customFragment;
				break;
			case R.id.main_tab_item_download:
				fragment = downLoadListenFragment == null ? new DownLoadListenFragment() : downLoadListenFragment;
				break;
			case R.id.main_tab_item_my:
				fragment = profileFragment == null ? new ProfileFragment() : profileFragment;
				break;
			default:
				break;
		}
		if (fragment != null) {
			transaction.replace(R.id.main_fragment_container, fragment);
			transaction.commit();
		}
	}

	protected int getExitAnimationId() {
		return 0;
	}


	private boolean isPlay = true;

	public void onClick(View v) {
		if (isPlay) {
			Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
			mediaPlayer.start();
		} else {
			if (mediaPlayer.isPlaying()) {
				Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
				mediaPlayer.pause();
			}
		}
		isPlay = !isPlay;
	}
}

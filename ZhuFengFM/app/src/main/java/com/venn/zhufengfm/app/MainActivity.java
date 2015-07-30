package com.venn.zhufengfm.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import com.venn.zhufengfm.app.fragments.CustomFragment;
import com.venn.zhufengfm.app.fragments.DiscoverFragment;
import com.venn.zhufengfm.app.fragments.DownLoadListenFragment;
import com.venn.zhufengfm.app.fragments.ProfileFragment;


//主界面
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

	private RadioGroup radioGroup;

	private DiscoverFragment discoverFragment;
	private CustomFragment customFragment;
	private DownLoadListenFragment downLoadListenFragment;
	private ProfileFragment profileFragment;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setTitle("主界面");

		radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_bar);
		radioGroup.setOnCheckedChangeListener(this);
		radioGroup.check(R.id.main_tab_item_discover);
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
		}
		transaction.replace(R.id.main_fragment_container, fragment);
		transaction.commit();
	}

	protected int getExitAnimationId() {
		return 0;
	}
}

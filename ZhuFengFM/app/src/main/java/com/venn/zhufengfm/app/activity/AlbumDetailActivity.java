package com.venn.zhufengfm.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.adapters.AlbumDetailAdapter;
import com.venn.zhufengfm.app.model.player.Album;
import com.venn.zhufengfm.app.model.player.AlbumDetail;
import com.venn.zhufengfm.app.parsers.DataParser;
import com.venn.zhufengfm.app.tasks.TaskCallback;
import com.venn.zhufengfm.app.tasks.TaskResult;
import com.venn.zhufengfm.app.tasks.impl.AlbumDetailTask;
import com.venn.zhufengfm.app.uitl.Constants;
import com.venn.zhufengfm.app.uitl.MyLog;
import com.venn.zhufengfm.app.uitl.SetImageUtil;
import com.venn.zhufengfm.app.uitl.SetTextUtil;
import org.json.JSONObject;

@ContentView(R.layout.activity_album_detail)
public class AlbumDetailActivity extends BaseActivity implements TaskCallback {

	@ViewInject(R.id.album_detail_head_image)
	private ImageView imageView;

	@ViewInject(R.id.album_detail_image)
	private ImageView imageViewHead;

	@ViewInject(R.id.album_detail_author_name)
	private TextView textViewName;

	@ViewInject(R.id.album_detail_intro)
	private TextView textViewIntro;

	@ViewInject(R.id.album_detail_tags)
	private TextView textViewTags;

	@ViewInject(R.id.album_detail_list)
	private ListView listView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ViewUtils.inject(this);

		Intent intent = getIntent();
		int albumId = -1;
		if (intent != null) {
			albumId = intent.getIntExtra("albumId", -1);
		}
		AlbumDetailTask task = new AlbumDetailTask(this);
		task.execute(String.valueOf(albumId));
	}

	public void onTaskFinished(TaskResult result) {
		if (result.getTaskId() == Constants.TASK_ALBUM_DETAIL) {
			Object data = result.getData();
			if (data != null) {
				AlbumDetail albumDetail = DataParser.parseAlbumDetail((JSONObject) data);
				//TODO 利用albumDetail中的数据填充相应的布局

				Album album = albumDetail.getAlbum();

				SetTextUtil.setText(textViewName, album.getNickname());
				SetTextUtil.setText(textViewIntro, album.getIntro());
				SetTextUtil.setText(textViewTags, album.getTags());

				SetImageUtil.setImage(true, imageView, album.getCoverSmall(), this);
				SetImageUtil.setImage(true, imageViewHead, album.getAvatarPath(), this);

				AlbumDetailAdapter adapter = new AlbumDetailAdapter(albumDetail.getTracks(), this);
				listView.setAdapter(adapter);

			} else {

			}
		}
	}
}

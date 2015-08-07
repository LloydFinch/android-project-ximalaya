package com.venn.zhufengfm.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.model.player.TrackItem;
import com.venn.zhufengfm.app.model.player.Tracks;
import com.venn.zhufengfm.app.uitl.SetTextUtil;

import java.util.List;

/**
 * Created by VennUser on 2015/8/6.
 */
public class AlbumDetailAdapter extends BaseAdapter {

	private Tracks tracks;
	private Context context;
	private List<TrackItem> trackItemList;

	public AlbumDetailAdapter(Tracks tracks, Context context) {
		this.tracks = tracks;
		this.context = context;
		trackItemList = tracks.getTrackItemList();
	}

	public int getCount() {

		return trackItemList.size();
	}

	public Object getItem(int position) {
		return trackItemList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public int getItemViewType(int position) {
		int type = 0;
		switch (position) {
			case 0:
				type = 0;
				break;
			case 1:
				type = 1;
				break;
			default:
				type = 2;
				break;
		}

		return type;
	}

	public int getViewTypeCount() {
		return 3;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		int type = getItemViewType(position);
		Object item = getItem(position);
		switch (type) {
			case 0:
				view = bindAlbumTab(convertView, parent);
				break;
			case 1:
				view = bindHead(convertView, parent);
				break;
			default:
				view = bindItem(item, convertView, parent);
				break;
		}

		return view;
	}

	private View bindAlbumTab(View convertView, ViewGroup parent) {
		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout.item_album_player_tab, parent,
				false) : convertView;

		HolderView1 holderView1 = (HolderView1) view.getTag();
		if (holderView1 == null) {
			holderView1 = new HolderView1();
			holderView1.checkBox1 = (CheckBox) view.findViewById(R.id.album_detail_tab1);
			holderView1.checkBox2 = (CheckBox) view.findViewById(R.id.album_detail_tab2);
			holderView1.checkBox3 = (CheckBox) view.findViewById(R.id.album_detail_tab3);

			view.setTag(holderView1);
		}

		return view;
	}

	private View bindHead(View convertView, ViewGroup parent) {
		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout.item_album_player_head, parent,
				false) : convertView;

		HolderView2 holderView2 = (HolderView2) view.getTag();
		if (holderView2 == null) {
			holderView2 = new HolderView2();
			holderView2.textView = (TextView) view.findViewById(R.id.album_detail_head_count);
			holderView2.checkBox1 = (CheckBox) view.findViewById(R.id.album_detail_head_choose);
			holderView2.checkBox2 = (CheckBox) view.findViewById(R.id.album_detail_head_sort);

			view.setTag(holderView2);
		}

		holderView2.textView.setText("共" + tracks.getTotalCount() + "集");
		return view;
	}

	private View bindItem(Object item, View convertView, ViewGroup parent) {
		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout.album_detail_item, parent,
				false) : convertView;

		HolderView3 holderView3 = (HolderView3) view.getTag();
		if (holderView3 == null) {
			holderView3 = new HolderView3();
			holderView3.textViewIntro = (TextView) view.findViewById(R.id.album_detail_item_intro);
			holderView3.textViewDays = (TextView) view.findViewById(R.id.album_detail_item_day);
			holderView3.checkBox1 = (CheckBox) view.findViewById(R.id.album_detail_item_playTimes);
			holderView3.checkBox2 = (CheckBox) view.findViewById(R.id.album_detail_item_duration);
			holderView3.checkBox3 = (CheckBox) view.findViewById(R.id.album_detail_item_comment);
			holderView3.checkBox4 = (CheckBox) view.findViewById(R.id.album_detail_item_download);

			view.setTag(holderView3);
		}

		TrackItem trackItem = (TrackItem) item;

		SetTextUtil.setText(holderView3.textViewIntro, trackItem.getTitle());
		SetTextUtil.setText(holderView3.textViewDays, "" + trackItem.getProcessState());
		SetTextUtil.setText(holderView3.checkBox1, "" + trackItem.getPlayTimes());
		SetTextUtil.setText(holderView3.checkBox2, "" + trackItem.getDuration() / 3600);
		SetTextUtil.setText(holderView3.checkBox3, "" + trackItem.getComments());

		return view;
	}

	public static class HolderView1 {
		CheckBox checkBox1, checkBox2, checkBox3;
	}

	public static class HolderView2 {
		TextView textView;
		CheckBox checkBox1, checkBox2;
	}

	public static class HolderView3 {
		TextView textViewIntro, textViewDays;
		CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
	}
}

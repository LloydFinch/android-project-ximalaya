package com.venn.zhufengfm.app.adapters;

import android.content.Context;

import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.venn.zhufengfm.app.MyView.MyViewPager;
import com.venn.zhufengfm.app.MyView.PinnedSectionListView;
import com.venn.zhufengfm.app.R;
import com.venn.zhufengfm.app.fragments.discover.DiscoverRecommendFragment;
import com.venn.zhufengfm.app.model.discover.recommend.DiscoverRecommend;
import com.venn.zhufengfm.app.model.discover.recommend.discoveryColumns.DiscoverRecommendDiscoveryColumns;
import com.venn.zhufengfm.app.model.discover.recommend.discoveryColumns.DiscoverRecommendDiscoveryColumnsItem;
import com.venn.zhufengfm.app.model.discover.recommend.editorRecommends.DiscoverRecommendEditorRecommendAlbums;
import com.venn.zhufengfm.app.model.discover.recommend.editorRecommends.DiscoverRecommendEditorRecommendAlbumsItem;
import com.venn.zhufengfm.app.model.discover.recommend.focusImages.DiscoverRecommendFocusImages;
import com.venn.zhufengfm.app.model.discover.recommend.focusImages.DiscoverRecommendFocusImagesItem;
import com.venn.zhufengfm.app.model.discover.recommend.hotRecommends.DiscoverRecommendHotRecommendsItem;
import com.venn.zhufengfm.app.model.discover.recommend.hotRecommends.DiscoverRecommendHotRecommendsItems;
import com.venn.zhufengfm.app.model.discover.recommend.specialColumn.DiscoverRecommendSpecialColumn;
import com.venn.zhufengfm.app.model.discover.recommend.specialColumn.DiscoverRecommendSpecialColumnItem;
import com.venn.zhufengfm.app.uitl.Constants;
import com.venn.zhufengfm.app.uitl.MyLog;
import com.venn.zhufengfm.app.uitl.SetImageUtil;
import com.venn.zhufengfm.app.uitl.SetTextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VennUser on 2015/7/30.
 */

//发现部分的推荐的Adapter,支持多布局的处理
public class DiscoverRecommendAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {

	private Context context;

	//adapter接收的数据
	private DiscoverRecommend recommend;

	private View.OnClickListener clickListener;
	private ViewPager.OnPageChangeListener pageChangeListener;

	public DiscoverRecommendAdapter(Context context) {
		this.context = context;
	}

	public DiscoverRecommendAdapter(Context context, DiscoverRecommend recommend) {
		this.context = context;
		this.recommend = recommend;
	}

	public DiscoverRecommendAdapter(Context context, DiscoverRecommend recommend, View.OnClickListener clickListener,
	                                ViewPager.OnPageChangeListener pageChangeListener) {
		this.context = context;
		this.recommend = recommend;
		this.clickListener = clickListener;
		this.pageChangeListener = pageChangeListener;
	}

	//设置实际的数据,需要在主线程调用
	public void setRecommend(DiscoverRecommend recommend) {
		this.recommend = recommend;
		notifyDataSetChanged();
	}

	public int getCount() {
		int count = 4;
		if (recommend != null) {
			count += recommend.getHotRecommends().getItemsList().size();
		}
		return count;
	}

	public Object getItem(int position) {

		Object ret = null;
		switch (position) {
			case 0:
				ret = recommend.getImages();
				break;
			case 1:
				ret = recommend.getRecommendAlbums();
				break;
			case 2:
				ret = recommend.getSpecialColumn();
				break;
			case 3:
				ret = recommend.getDiscoveryColumns();
				break;
			default:
				ret = recommend.getHotRecommends().getItemsList().get(position - 4);
				break;
		}
		return ret;
	}

	public int getViewTypeCount() {

		return 5;
	}

	public int getItemViewType(int position) {
		int ret = 0;
		Object item = getItem(position);

		if (item instanceof DiscoverRecommendFocusImages) {
			ret = 0;
		} else if (item instanceof DiscoverRecommendEditorRecommendAlbums) {
			ret = 1;
		} else if (item instanceof DiscoverRecommendSpecialColumn) {
			ret = 2;
		} else if (item instanceof DiscoverRecommendDiscoveryColumns) {
			ret = 3;
		} else if (item instanceof DiscoverRecommendHotRecommendsItems) {
			ret = 4;
		}
		return ret;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;

		Object item = getItem(position);
		int itemType = getItemViewType(position);
		switch (itemType) {
			case 0:
				view = bindFocusImage(item, convertView, parent);
				break;
			case 1:
				view = bindEditorRecommendView(item, convertView, parent);
				break;
			case 2:
				view = bindSpecialColumnsView(item, convertView, parent);
				break;
			case 3:
				view = bindDiscoverColumnsView(item, convertView, parent);
				break;
			case 4:
				view = bindHotColumnsView(item, convertView, parent);
				break;
		}
		return view;
	}

	//小编推荐
	private View bindEditorRecommendView(Object item, View convertView, ViewGroup parent) {

		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout
				.item_deicover_recommend_editor, parent, false) : convertView;

		ViewHolderType1 holderType1 = (ViewHolderType1) view.getTag();
		if (holderType1 == null) {
			holderType1 = new ViewHolderType1();
			holderType1.textTitle = (TextView) view.findViewById(R.id.item_dis_rec_eidtor);
			holderType1.textMore = (TextView) view.findViewById(R.id.item_dis_rec_more);
			holderType1.button1 = (ImageButton) view.findViewById(R.id.item_disc_rec_line1_image);
			holderType1.button2 = (ImageButton) view.findViewById(R.id.item_disc_rec_line2_image);
			holderType1.button3 = (ImageButton) view.findViewById(R.id.item_disc_rec_line3_image);
			holderType1.textView1 = (TextView) view.findViewById(R.id.item_disc_rec_line1_text);
			holderType1.textView2 = (TextView) view.findViewById(R.id.item_disc_rec_line2_text);
			holderType1.textView3 = (TextView) view.findViewById(R.id.item_disc_rec_line3_text);
			view.setTag(holderType1);
		}

		DiscoverRecommendEditorRecommendAlbums albums = (DiscoverRecommendEditorRecommendAlbums) item;

		if (albums != null) {

			String title = albums.getTitle();
			SetTextUtil.setText(holderType1.textTitle, title);
			holderType1.textMore.setTag(Constants.EDITOR);
			holderType1.textMore.setOnClickListener(clickListener);
			if (!albums.isHasMore()) {
				holderType1.textMore.setVisibility(View.INVISIBLE);
			}

			List<DiscoverRecommendEditorRecommendAlbumsItem> items = albums.getItemList();

			DiscoverRecommendEditorRecommendAlbumsItem item0 = items.get(0);
			DiscoverRecommendEditorRecommendAlbumsItem item1 = items.get(1);
			DiscoverRecommendEditorRecommendAlbumsItem item2 = items.get(2);

			SetTextUtil.setText(holderType1.textView1, item0.getTrackTitle());
			SetTextUtil.setText(holderType1.textView2, item1.getTrackTitle());
			SetTextUtil.setText(holderType1.textView3, item2.getTrackTitle());

			SetImageUtil.setImage(holderType1.button1, item0.getCoverLarge(), context);
			SetImageUtil.setImage(holderType1.button2, item1.getCoverLarge(), context);
			SetImageUtil.setImage(holderType1.button3, item2.getCoverLarge(), context);

		} else {
			MyLog.d("albums state", "albums is null");
		}
		return view;
	}

	//精品推荐
	private View bindSpecialColumnsView(Object item, View convertView, ViewGroup parent) {

		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout
				.item_discover_recommend_special, parent, false) : convertView;
		ViewHolderType2 holderType2 = (ViewHolderType2) view.getTag();
		if (holderType2 == null) {

			holderType2 = new ViewHolderType2();

			//顶部标题栏
			holderType2.textTitle = (TextView) view.findViewById(R.id.item_disc_rec_spec_title);
			holderType2.textMore = (TextView) view.findViewById(R.id.item_disc_rec_spec_more);

			//第一个栏目
			holderType2.imageView1 = (ImageView) view.findViewById(R.id.item_disc_rec_spec_line1_image);
			holderType2.block1text1 = (TextView) view.findViewById(R.id.item_disc_rec_spec_line1_right_text1);
			holderType2.block1text2 = (TextView) view.findViewById(R.id.item_disc_rec_spec_line1_right_text2);
			holderType2.block1text3 = (TextView) view.findViewById(R.id.item_disc_rec_spec_line1_right_text3);

			//第二个栏目
			holderType2.imageView2 = (ImageView) view.findViewById(R.id.item_disc_rec_spec_line2_image);
			holderType2.block2text1 = (TextView) view.findViewById(R.id.item_disc_rec_spec_line2_right_text1);
			holderType2.block2text2 = (TextView) view.findViewById(R.id.item_disc_rec_spec_line2_right_text2);
			holderType2.block2text3 = (TextView) view.findViewById(R.id.item_disc_rec_spec_line2_right_text3);

			view.setTag(holderType2);
		}

		DiscoverRecommendSpecialColumn specialColumn = (DiscoverRecommendSpecialColumn) item;
		holderType2.textTitle.setText(specialColumn.getTitle());
		if (!specialColumn.isHasMore()) {
			holderType2.textMore.setVisibility(View.INVISIBLE);
		}

		List<DiscoverRecommendSpecialColumnItem> itemList = specialColumn.getItemList();
		DiscoverRecommendSpecialColumnItem item0 = itemList.get(0);
		DiscoverRecommendSpecialColumnItem item1 = itemList.get(1);

		SetTextUtil.setText(holderType2.block1text1, item0.getTitle());
		SetTextUtil.setText(holderType2.block1text2, item0.getSubtitle());
		SetTextUtil.setText(holderType2.block1text3, item0.getFootnote());
		SetTextUtil.setText(holderType2.block2text1, item1.getTitle());
		SetTextUtil.setText(holderType2.block2text2, item1.getSubtitle());
		SetTextUtil.setText(holderType2.block2text3, item1.getFootnote());

		//holderType2.imageView1.setImageResource(R.mipmap.ic_launcher);
		//holderType2.imageView2.setImageResource(R.mipmap.ic_launcher);

		SetImageUtil.setImage(holderType2.imageView1, item0.getCoverPath(), context);
		SetImageUtil.setImage(holderType2.imageView2, item1.getCoverPath(), context);

		return view;
	}

	//发现新奇
	private View bindDiscoverColumnsView(Object item, View convertView, ViewGroup parent) {

		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout
				.item_discover_recommend_discover, parent, false) : convertView;

		ViewHolderType3 holderType3 = (ViewHolderType3) view.getTag();
		if (holderType3 == null) {
			holderType3 = new ViewHolderType3();

			holderType3.textTitle = (TextView) view.findViewById(R.id.item_disc_rec_disc_title);
			holderType3.textMore = (TextView) view.findViewById(R.id.item_disc_rec_disc_more);

			holderType3.imageView1 = (ImageView) view.findViewById(R.id.item_disc_rec_disc_image1);
			holderType3.imageView2 = (ImageView) view.findViewById(R.id.item_disc_rec_disc_image2);
			holderType3.imageView3 = (ImageView) view.findViewById(R.id.item_disc_rec_disc_image3);
			holderType3.imageView4 = (ImageView) view.findViewById(R.id.item_disc_rec_disc_image4);

			holderType3.line1Text1 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line1_right_text1);
			holderType3.line1Text2 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line1_right_text2);
			holderType3.line2Text1 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line2_right_text1);
			holderType3.line2Text2 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line2_right_text2);
			holderType3.line3Text1 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line3_right_text1);
			holderType3.line3Text2 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line3_right_text2);
			holderType3.line4Text1 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line4_right_text1);
			holderType3.line4Text2 = (TextView) view.findViewById(R.id.item_disc_rec_disc_line4_right_text2);

			view.setTag(holderType3);
		}

		DiscoverRecommendDiscoveryColumns discoveryColumns = (DiscoverRecommendDiscoveryColumns) item;
		SetTextUtil.setText(holderType3.textTitle, discoveryColumns.getTitle());

		List<DiscoverRecommendDiscoveryColumnsItem> itemList = discoveryColumns.getItemList();
		DiscoverRecommendDiscoveryColumnsItem item0 = itemList.get(0);
		DiscoverRecommendDiscoveryColumnsItem item1 = itemList.get(1);
		DiscoverRecommendDiscoveryColumnsItem item2 = itemList.get(2);
		DiscoverRecommendDiscoveryColumnsItem item3 = itemList.get(3);

		SetTextUtil.setText(holderType3.line1Text1, item0.getTitle());
		SetTextUtil.setText(holderType3.line1Text2, item0.getSubtitle());
		SetTextUtil.setText(holderType3.line2Text1, item1.getTitle());
		SetTextUtil.setText(holderType3.line2Text2, item1.getSubtitle());
		SetTextUtil.setText(holderType3.line3Text1, item2.getTitle());
		SetTextUtil.setText(holderType3.line3Text2, item2.getSubtitle());
		SetTextUtil.setText(holderType3.line4Text1, item3.getTitle());
		SetTextUtil.setText(holderType3.line4Text2, item3.getSubtitle());

		SetImageUtil.setImage(holderType3.imageView1, item0.getCoverPath(), context);
		SetImageUtil.setImage(holderType3.imageView2, item1.getCoverPath(), context);
		SetImageUtil.setImage(holderType3.imageView3, item2.getCoverPath(), context);
		SetImageUtil.setImage(holderType3.imageView4, item3.getCoverPath(), context);

		return view;
	}

	//热门推荐
	private View bindHotColumnsView(Object item, View convertView, ViewGroup parent) {

		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout
				.item_deicover_recommend_editor, parent, false) : convertView;

		ViewHolderType1 holderType1 = (ViewHolderType1) view.getTag();
		if (holderType1 == null) {

			holderType1 = new ViewHolderType1();
			holderType1.textTitle = (TextView) view.findViewById(R.id.item_dis_rec_eidtor);
			holderType1.textMore = (TextView) view.findViewById(R.id.item_dis_rec_more);
			holderType1.button1 = (ImageButton) view.findViewById(R.id.item_disc_rec_line1_image);
			holderType1.button2 = (ImageButton) view.findViewById(R.id.item_disc_rec_line2_image);
			holderType1.button3 = (ImageButton) view.findViewById(R.id.item_disc_rec_line3_image);
			holderType1.textView1 = (TextView) view.findViewById(R.id.item_disc_rec_line1_text);
			holderType1.textView2 = (TextView) view.findViewById(R.id.item_disc_rec_line2_text);
			holderType1.textView3 = (TextView) view.findViewById(R.id.item_disc_rec_line3_text);

			view.setTag(holderType1);
		}

		DiscoverRecommendHotRecommendsItems items = (DiscoverRecommendHotRecommendsItems) item;
		holderType1.textTitle.setText(items.getTitle());

		//对于热门推荐点击时,包含了categoryId,通过它作为点击事件的入口
		holderType1.textTitle.setTag(Constants.HOT + items.getCategoryId());
		if (!items.isHasMore()) {
			holderType1.textMore.setVisibility(View.INVISIBLE);
		}

		List<DiscoverRecommendHotRecommendsItem> itemList = items.getItemList();
		DiscoverRecommendHotRecommendsItem item0 = itemList.get(0);
		DiscoverRecommendHotRecommendsItem item1 = itemList.get(1);
		DiscoverRecommendHotRecommendsItem item2 = itemList.get(2);


		SetTextUtil.setText(holderType1.textView1, item0.getTrackTitle());
		SetTextUtil.setText(holderType1.textView2, item1.getTrackTitle());
		SetTextUtil.setText(holderType1.textView3, item2.getTrackTitle());

		SetImageUtil.setImage(holderType1.button1, item0.getCoverLarge(), context);
		SetImageUtil.setImage(holderType1.button2, item1.getCoverLarge(), context);
		SetImageUtil.setImage(holderType1.button3, item2.getCoverLarge(), context);

		return view;
	}

	//顶部广告
	private View bindFocusImage(Object item, View convertView, ViewGroup parent) {
		View view = convertView == null ? LayoutInflater.from(context).inflate(R.layout.view_pager_my, parent, false)
				: convertView;
		MyViewPager myViewPager = (MyViewPager) view.getTag();
		if (myViewPager == null) {
			myViewPager = (MyViewPager) view.findViewById(R.id.pager_view_my);
			view.setTag(myViewPager);
		}
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500,
				Gravity.CENTER);
		myViewPager.setLayoutParams(params);
		myViewPager.addOnPageChangeListener(pageChangeListener);

		List<ImageView> imageViewList = new ArrayList<ImageView>();
		DiscoverRecommendFocusImages focusImages = (DiscoverRecommendFocusImages) item;
		List<DiscoverRecommendFocusImagesItem> itemList = focusImages.getItemList();
		for (int i = 0; i < itemList.size(); i++) {
			String path = itemList.get(i).getPic();
			ImageView imageView = new ImageView(context);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			SetImageUtil.setImage(imageView, path, context);
			imageViewList.add(imageView);
		}
		myViewPager.setAdapter(new MyViewPagerAdapter(imageViewList));
		myViewPager.setCurrentItem(0);

		ImageView imageView = (ImageView) view.findViewById(R.id.focus);
		DiscoverRecommendFragment.setView(imageView, myViewPager);

		return view;
	}

	public boolean isItemViewTypePinned(int viewType) {
		return true;
	}

	//小编推荐,热门推荐的布局
	private class ViewHolderType1 {

		public TextView textTitle, textMore;
		public LinearLayout block1, block2, block3;
		public ImageButton button1, button2, button3;
		public TextView textView1, textView2, textView3;
	}

	//精品推荐的布局
	private class ViewHolderType2 {
		public TextView textTitle, textMore;
		public LinearLayout block1, block2;
		public ImageView imageView1, imageView2;
		public TextView block1text1, block1text2, block1text3;
		public TextView block2text1, block2text2, block2text3;

	}

	//发现新奇的布局
	private class ViewHolderType3 {
		public TextView textTitle, textMore;
		public ImageView imageView1, imageView2, imageView3, imageView4;
		public TextView line1Text1, line1Text2;
		public TextView line2Text1, line2Text2;
		public TextView line3Text1, line3Text2;
		public TextView line4Text1, line4Text2;
	}
}

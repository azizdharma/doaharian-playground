package com.androidbegin.parsecustomlistview;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<Doa> doalist = null;
	private ArrayList<Doa> arraylist;

	public ListViewAdapter(Context context,
			List<Doa> doalist) {
		mContext = context;
		this.doalist = doalist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<Doa>();
		this.arraylist.addAll(doalist);
	}

	public class ViewHolder {
		TextView title;
	}

	@Override
	public int getCount() {
		return doalist.size();
	}

	@Override
	public Doa getItem(int position) {
		return doalist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextViews in listview_item.xml
			holder.title = (TextView) view.findViewById(R.id.title);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		holder.title.setText(doalist.get(position).getTitle());

		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemActivity Class
				Intent intent = new Intent(mContext, SingleItemActivity.class);

				intent.putExtra("title",(doalist.get(position).getTitle()));
				intent.putExtra("illustration", (doalist.get(position).getIllustration()));
				intent.putExtra("arabic", (doalist.get(position).getArabic()));
				intent.putExtra("spelling",(doalist.get(position).getSpelling()));
				intent.putExtra("translation",(doalist.get(position).getTranslation()));

				mContext.startActivity(intent);
			}
		});

		return view;
	}
}
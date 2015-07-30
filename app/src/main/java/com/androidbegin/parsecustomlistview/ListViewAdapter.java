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
	private List<DataDoa> doalist = null;
	private ArrayList<DataDoa> arraylist;

	public ListViewAdapter(Context context,
			List<DataDoa> doalist) {
		mContext = context;
		this.doalist = doalist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<DataDoa>();
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
	public DataDoa getItem(int position) {
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
			holder.title = (TextView) view.findViewById(R.id.titel);
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
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, SingleItemView.class);

				intent.putExtra("title",(doalist.get(position).getTitle()));
				intent.putExtra("illustration", (doalist.get(position).getIllus()));
				intent.putExtra("spelling",(doalist.get(position).getSpelling()));
				intent.putExtra("objectId",(doalist.get(position).getObj()));
				intent.putExtra("arabic", (doalist.get(position).getArabic()));
				intent.putExtra("trans",(doalist.get(position).getTrans()));

				mContext.startActivity(intent);
			}
		});

		return view;
	}
}
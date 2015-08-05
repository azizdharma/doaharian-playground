package com.androidbegin.parsecustomlistview;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.SaveCallback;

public class MainActivity extends Activity {

    private ParseQueryAdapter<Doa> doalistAdapter;
	private LayoutInflater inflater;
    private ListView doaListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.activity_main);

        // Get from Parse
        loadFromParse();

        // Set up the views
        doaListView = (ListView) findViewById(R.id.listview);
        
        //Set up Parse Query to use in the adapter
        ParseQueryAdapter.QueryFactory<Doa> factory = new ParseQueryAdapter.QueryFactory<Doa>() {
            public ParseQuery<Doa> create(){
                ParseQuery<Doa> query = Doa.getQuery();
                query.fromLocalDatastore();
                return query;
            }
        };

        //Set up adapter
        inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        doalistAdapter = new DoaListAdapter(this, factory);

        // Attach the query adapter to the view
        doaListView = (ListView) findViewById(R.id.listview);
        doaListView.setAdapter(doalistAdapter);

        doaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doa doa = doalistAdapter.getItem(position);
            }
        });
	}

    private void loadFromParse() {
        ParseQuery<Doa> query = Doa.getQuery();
        query.findInBackground(new FindCallback<Doa>() {
            public void done(List<Doa> doas, ParseException e) {
                if (e == null) {
                    ParseObject.pinAllInBackground((List<Doa>) doas, new SaveCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                if (!isFinishing()) {
                                    doalistAdapter.loadObjects();
                                }
                            } else {
                                Log.i("MainActivity", "Error pinning doas: "
                                        + e.getMessage());
                            }
                        }
                    });
                } else {
                    Log.i("MainActivity", "loadFromParse: Error finding pinned doas: "
                                    + e.getMessage());
                }
            }
        });
    }

    private class DoaListAdapter extends ParseQueryAdapter<Doa> {

        public DoaListAdapter(Context context,ParseQueryAdapter.QueryFactory<Doa> queryFactory){
            super(context, queryFactory);
        }

        @Override
        public View getItemView(Doa doa, View view, ViewGroup parent) {

            ViewHolder holder;

            if (view == null) {
                view = inflater.inflate(R.layout.listview_item, parent, false);
                holder = new ViewHolder();
                holder.doaTitle = (TextView) view.findViewById(R.id.title);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            TextView doaTitle = holder.doaTitle;
            doaTitle.setText(doa.getTitle());
            return view;
        }
    }

    private static class ViewHolder {
        TextView doaTitle;
    }
}
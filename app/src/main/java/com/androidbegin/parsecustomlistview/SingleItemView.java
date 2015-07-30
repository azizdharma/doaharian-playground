package com.androidbegin.parsecustomlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemView extends Activity {
	// Declare Variables
	TextView txtObjectId;
	TextView txtArabic;
	TextView txtTitle;
	TextView txtIllustration;
	TextView txtSpelling;
	TextView txtTranslation;
	String titel;
	String illus;
	String spelling;
	String obj;
	String arabic;
	String trans;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleitemview);
		// Retrieve data from MainActivity on item click event
		Intent i = getIntent();

		titel = i.getStringExtra("title");
		illus = i.getStringExtra("illustration");
		spelling = i.getStringExtra("spelling");
		obj = i.getStringExtra("objectId");
		arabic = i.getStringExtra("arabic");
		trans = i.getStringExtra("translation");

		txtTitle = (TextView) findViewById(R.id.titel);
		txtIllustration = (TextView) findViewById(R.id.illus);
		txtSpelling = (TextView) findViewById(R.id.spell);
		txtObjectId = (TextView) findViewById(R.id.obj);
		txtArabic = (TextView) findViewById(R.id.arab);
		txtTranslation = (TextView) findViewById(R.id.transl);

		txtTitle.setText(titel);
		txtIllustration.setText(illus);
		txtSpelling.setText(spelling);
		txtObjectId.setText(obj);
		txtArabic.setText(arabic);
		txtTranslation.setText(trans);
	}
}
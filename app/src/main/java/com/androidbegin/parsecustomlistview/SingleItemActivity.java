package com.androidbegin.parsecustomlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemActivity extends Activity {
	// Declare Variables
	TextView txtTitle;
	TextView txtIllustration;
	TextView txtArabic;
	TextView txtSpelling;
	TextView txtTranslation;
	String title;
	String illustration;
	String arabic;
	String spelling;
	String translation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitvity_single_item);
		// Retrieve data from MainActivity on item click event
		Intent i = getIntent();

		title = i.getStringExtra("title");
		illustration = i.getStringExtra("illustration");
		arabic = i.getStringExtra("arabic");
		spelling = i.getStringExtra("spelling");
		translation = i.getStringExtra("translation");

		txtTitle = (TextView) findViewById(R.id.title);
		txtIllustration = (TextView) findViewById(R.id.illustration);
		txtArabic = (TextView) findViewById(R.id.arabic);
		txtSpelling = (TextView) findViewById(R.id.spelling);
		txtTranslation = (TextView) findViewById(R.id.translation);

		txtTitle.setText(title);
		txtIllustration.setText(illustration);
		txtArabic.setText(arabic);
		txtSpelling.setText(spelling);
		txtTranslation.setText(translation);
	}
}
package com.androidbegin.parsecustomlistview;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;
import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// add Doa subclass
		ParseObject.registerSubclass(Doa.class);

		// Add your initialization code here
		Parse.enableLocalDatastore(getApplicationContext());
		Parse.initialize(this, "HoDPEWhNYvfC4O0pkRUQmQfFYKXbQzP1Hs6wqv4X",
				"JMcCJIJs7EKOOHV0gsPw7t6QJkiQgiSGWeeK7qKU");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}

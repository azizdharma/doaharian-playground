package com.androidbegin.parsecustomlistview;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Doa")
public class Doa extends ParseObject {

	public String getId() {
		return getString("numb");
	}

	public void setId(String id) {
		put("numb", id);
	}

	public String getTitle() {
		return getString("title");
	}

	public void setTitle(String title) {
		put("title", title);
	}

	public String getIllustration() {
		return getString("illustration");
	}

	public void setIllustration(String illustration) {
		put("illustration", illustration);
	}

	public String getArabic() {
		return getString("arabic");
	}

	public void setArabic(String arabic) {
		put("arabic", arabic);
	}

	public String getSpelling() {
		return getString("spelling");
	}

	public void setSpelling(String spelling) {
		put("spelling", spelling);
	}

	public String getTranslation() {
		return getString("translation");
	}

	public void setTranslation(String translation) {
		put("translation", translation);
	}

	public static ParseQuery<Doa> getQuery() {
		return ParseQuery.getQuery(Doa.class);
	}
}
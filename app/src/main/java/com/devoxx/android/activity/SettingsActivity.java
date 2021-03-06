package com.devoxx.android.activity;

import com.devoxx.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import android.support.v7.widget.Toolbar;

@EActivity(R.layout.activity_settings)
public class SettingsActivity extends BaseActivity {

	@ViewById(R.id.toolbar)
	Toolbar toolbar;

	@AfterViews void afterViews() {
		toolbar.setTitle(R.string.settings);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@OptionsItem(android.R.id.home) void onBackClick() {
		finish();
	}
}

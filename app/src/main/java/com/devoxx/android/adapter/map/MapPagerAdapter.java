package com.devoxx.android.adapter.map;

import com.devoxx.android.fragment.map.MapFloorFragment_;
import com.devoxx.android.fragment.map.MapGoogleFragment_;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class MapPagerAdapter extends FragmentStatePagerAdapter {

	private static final int MAP_GOOGLE_POSITION = 0;
	private final int floorsCount;
	private final boolean withMap;
	private final List<String> floorsImages;

	public MapPagerAdapter(FragmentManager fm, int floorsVal, boolean map, List<String> floors) {
		super(fm);
		floorsCount = floorsVal;
		withMap = map;
		floorsImages = floors;
	}

	@Override
	public Fragment getItem(int position) {
		if (withMap && position == MAP_GOOGLE_POSITION) {
			return MapGoogleFragment_.builder().build();
		} else {
			return MapFloorFragment_.builder()
					.imageUrl(floorsImages.get(withMap ? position - 1 : position)).build();
		}
	}

	@Override
	public int getCount() {
		return floorsCount + (withMap ? 1 : 0) /* +1 for Google Map */;
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}

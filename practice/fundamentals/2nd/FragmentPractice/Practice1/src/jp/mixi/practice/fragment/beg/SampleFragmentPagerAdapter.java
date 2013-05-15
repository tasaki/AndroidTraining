package jp.mixi.practice.fragment.beg;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
	
	private static final int PAGE_COUNT = 10;

	public SampleFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return SampleFragment.newInstance(position);
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

}

package com.rca.bottomnavigationview.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rca.bottomnavigationview.model.FragmentItem;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<FragmentItem> fragmentItemList;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragmentItemList = new ArrayList(0);
    }

    public void addFragment(Fragment fragment, String title, int idMenuItem) {

        fragmentItemList.add(new FragmentItem(fragment, title, idMenuItem));
    }

    public void addFragmentItem(FragmentItem fragmentItem) {

        fragmentItemList.add(fragmentItem);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentItemList.get(position).getFragment();
    }

    public int getIndexMenuItemId(int idMenuItem) {

        int index = 0;

        for (FragmentItem item : fragmentItemList) {

            if (item.getIdMenuItem() == idMenuItem) {

                break;
            }

            index++;
        }

        return index;
    }

    @Override
    public int getCount() {

        return fragmentItemList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return fragmentItemList.get(position).getTitle();
    }
}

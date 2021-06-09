package ir.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import ir.mvvm.model.ViewPagerModel_Fragment;
import ir.mvvm.view.ActivityForViewPager_Fragment;

public class SliderViewAdapter_withFragment extends FragmentPagerAdapter {
    List<ViewPagerModel_Fragment> data;
    Context mcontext;
    public SliderViewAdapter_withFragment(Context context, final androidx.fragment.app.FragmentManager fm, List<ViewPagerModel_Fragment> data)
    {
        super(fm);
        mcontext = context.getApplicationContext();
        this.data=data;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return data.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
}

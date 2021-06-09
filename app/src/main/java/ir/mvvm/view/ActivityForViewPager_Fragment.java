package ir.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ir.mvvm.Fragments.Fragment1_forViewPager;
import ir.mvvm.Fragments.Fragment2_forViewPager;
import ir.mvvm.R;
import ir.mvvm.adapter.SliderViewAdapter;
import ir.mvvm.adapter.SliderViewAdapter_withFragment;
import ir.mvvm.databinding.ActivityForViewPagerFragmentBinding;
import ir.mvvm.model.ViewPagerModel;
import ir.mvvm.model.ViewPagerModel_Fragment;

public class ActivityForViewPager_Fragment extends AppCompatActivity {
    ActivityForViewPagerFragmentBinding binding;
    static SliderViewAdapter_withFragment adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_for_view_pager__fragment);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_for_view_pager__fragment);
        binding.setActivityViewPagerFragment(this);
        binding.setFragmentManager(getSupportFragmentManager());
    }

    @BindingAdapter("SET_VIEWPAGER_FR")
    public static void set_viewPager(ViewPager viewPager, ActivityForViewPager_Fragment context) {
        List<ViewPagerModel_Fragment> data = new ArrayList<>();
        data.add(new ViewPagerModel_Fragment("page1", new Fragment1_forViewPager()));
        data.add(new ViewPagerModel_Fragment("page2", new Fragment2_forViewPager()));
        adapter = new SliderViewAdapter_withFragment(context, context.getSupportFragmentManager(),data);
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter("SET_TABLAYOUT_FR")
    public static void set_tablayout(TabLayout tabLayout, ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager, true);
    }
}
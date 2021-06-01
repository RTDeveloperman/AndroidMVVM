package ir.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ir.mvvm.R;
import ir.mvvm.adapter.SliderViewAdapter;
import ir.mvvm.databinding.ActivityForViewPagerBinding;
import ir.mvvm.model.ViewPagerModel;

public class ActivityForViewPager extends AppCompatActivity {
    ActivityForViewPagerBinding binding;
    static SliderViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_for_view_pager);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_for_view_pager);
        binding.setActivityviewPager(this);
        binding.setFragmentManager(getSupportFragmentManager());

    }

    @BindingAdapter("SET_VIEWPAGER")
    public static void set_viewPager(ViewPager viewPager,ActivityForViewPager context) {
        List<ViewPagerModel> data = new ArrayList<>();
        data.add(new ViewPagerModel("page1", "https://random.dog/0afd649d-ec06-403f-aeb5-0262d1750182.jpg"));
        data.add(new ViewPagerModel("page2", "https://random.dog/0afd649d-ec06-403f-aeb5-0262d1750182.jpg"));
        data.add(new ViewPagerModel("page3", "https://random.dog/0afd649d-ec06-403f-aeb5-0262d1750182.jpg"));
        adapter = new SliderViewAdapter(data, context);
        viewPager.setAdapter(adapter);
    }
    @BindingAdapter("SET_TABLAYOUT")
    public static void set_tablayout(TabLayout tabLayout, ViewPager viewPager){
        tabLayout.setupWithViewPager(viewPager,true);
    }
}
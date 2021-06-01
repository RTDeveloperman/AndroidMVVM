package ir.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import java.time.Instant;
import java.util.List;

import ir.mvvm.R;
import ir.mvvm.databinding.ItemSliderviewBinding;
import ir.mvvm.model.ViewPagerModel;

public class SliderViewAdapter extends PagerAdapter {
    List<ViewPagerModel> data;
    Context context;

    public SliderViewAdapter(List<ViewPagerModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(context);
        ItemSliderviewBinding binding= DataBindingUtil.inflate(inflater, R.layout.item_sliderview,container,false);
        binding.setSlider(data.get(position));
        container.addView(binding.getRoot());
        return binding.getRoot();

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
}

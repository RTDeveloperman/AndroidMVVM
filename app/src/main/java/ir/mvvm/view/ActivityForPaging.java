package ir.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import ir.mvvm.R;
import ir.mvvm.adapter.PagingItemAdapter;
import ir.mvvm.databinding.ActivityForPagingBinding;
import ir.mvvm.model.ItemModel_forpaging;
import ir.mvvm.viewmodel.ViewModelForPaging;

public class ActivityForPaging extends AppCompatActivity {
ActivityForPagingBinding binding;
PagingItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_for_paging);
        //setContentView(R.layout.activity_for_paging);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter=new PagingItemAdapter(this);
        ViewModelForPaging viewModelForPaging =new ViewModelProvider(this).get(ViewModelForPaging.class);
        viewModelForPaging.item_list_liveData.observe(this, new Observer<PagedList<ItemModel_forpaging>>() {
            @Override
            public void onChanged(PagedList<ItemModel_forpaging> itemModel_forpagings) {
                adapter.submitList(itemModel_forpagings);
            }
        });
        binding.recyclerview.setAdapter(adapter);
    }
}
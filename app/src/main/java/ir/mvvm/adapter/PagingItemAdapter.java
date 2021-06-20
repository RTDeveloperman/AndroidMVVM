package ir.mvvm.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import ir.mvvm.R;
import ir.mvvm.databinding.ItemRecyclerviewForpagingBinding;
import ir.mvvm.model.ItemModel_forpaging;

public class PagingItemAdapter extends PagedListAdapter<ItemModel_forpaging, PagingItemAdapter.MyviewHolder> {
    Context context;

    public PagingItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    private static DiffUtil.ItemCallback<ItemModel_forpaging> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemModel_forpaging>() {
        @Override
        public boolean areItemsTheSame(@NonNull ItemModel_forpaging oldItem, @NonNull ItemModel_forpaging newItem) {
            return oldItem.answer_id == newItem.answer_id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ItemModel_forpaging oldItem, @NonNull ItemModel_forpaging newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public PagingItemAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemRecyclerviewForpagingBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_recyclerview_forpaging, parent, false);
        return new MyviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PagingItemAdapter.MyviewHolder holder, int position) {
        //List<ItemModel_forpaging> item = new ArrayList<>();
        ItemModel_forpaging items=getItem(position);
        holder.binding.setOwnerItem(items.owner);

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerviewForpagingBinding binding;

        public MyviewHolder(@NonNull ItemRecyclerviewForpagingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}

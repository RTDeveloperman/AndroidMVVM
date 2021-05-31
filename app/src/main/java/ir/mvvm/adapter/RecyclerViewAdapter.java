package ir.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mvvm.R;
import ir.mvvm.databinding.ItemRecyclerviewTophitsBinding;
import ir.mvvm.model.MusicInfo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<MusicInfo> data;

    public RecyclerViewAdapter(Context context, List<MusicInfo> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemRecyclerviewTophitsBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_recyclerview_tophits, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setMusicInfo(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerviewTophitsBinding binding;

        public MyViewHolder(@NonNull ItemRecyclerviewTophitsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
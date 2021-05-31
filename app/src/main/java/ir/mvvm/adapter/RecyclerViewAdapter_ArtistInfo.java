package ir.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mvvm.R;
import ir.mvvm.databinding.ItemRecyclerviewArtistBinding;
import ir.mvvm.databinding.ItemRecyclerviewTophitsBinding;
import ir.mvvm.model.ArtistInfo;

public class RecyclerViewAdapter_ArtistInfo extends RecyclerView.Adapter<RecyclerViewAdapter_ArtistInfo.MyviewHolder> {
    public RecyclerViewAdapter_ArtistInfo(Context context, List<ArtistInfo> data) {
        this.context = context;
        this.data = data;
    }

    Context context;
    List<ArtistInfo> data;

    @NonNull
    @Override
    public RecyclerViewAdapter_ArtistInfo.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        ItemRecyclerviewArtistBinding binding= DataBindingUtil.inflate(inflater, R.layout.item_recyclerview_artist,parent,false);
        return new MyviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter_ArtistInfo.MyviewHolder holder, int position) {
        holder.binding.setArtistInfo(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerviewArtistBinding binding;

        public MyviewHolder(@NonNull ItemRecyclerviewArtistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

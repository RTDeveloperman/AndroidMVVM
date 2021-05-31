package ir.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mvvm.Interface.item_Image_OnClick;
import ir.mvvm.R;
import ir.mvvm.databinding.ItemRecyclerviewImagelistBinding;
import ir.mvvm.model.ImageModel;

public class RecyclerViewAdapter_ImageList extends RecyclerView.Adapter<RecyclerViewAdapter_ImageList.MyviewHolder> {
    List<ImageModel> data;
    Context context;
    item_Image_OnClick listener;

    public RecyclerViewAdapter_ImageList(List<ImageModel> data, Context context,  item_Image_OnClick listener) {
        this.data = data;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemRecyclerviewImagelistBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_recyclerview_imagelist, parent, false);


        return new MyviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.binding.setImageInfo(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.Onclik(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerviewImagelistBinding binding;

        public MyviewHolder(@NonNull ItemRecyclerviewImagelistBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

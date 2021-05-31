package ir.mvvm.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ir.mvvm.Interface.item_Image_OnClick;
import ir.mvvm.R;
import ir.mvvm.adapter.RecyclerViewAdapter_ImageList;
import ir.mvvm.databinding.FragmentImageListBinding;
import ir.mvvm.model.ImageModel;
import ir.mvvm.viewmodel.ViewModelImages;

public class ImageListFragment extends Fragment implements item_Image_OnClick {

    FragmentImageListBinding binding;
    RecyclerView recyclerView;
    RecyclerViewAdapter_ImageList adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_list, container, false);
        recyclerView = binding.rcImagelist;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelImages viewModelImages = new ViewModelProvider(getActivity()).get(ViewModelImages.class);
        MutableLiveData<List<ImageModel>> liveData = viewModelImages.getListMutableLiveData();
        liveData.observe(getActivity(), new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(List<ImageModel> imageModels) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                adapter = new RecyclerViewAdapter_ImageList(imageModels, getActivity(), ImageListFragment.this::Onclik);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void Onclik(ImageModel imageModel) {
        Bundle bundle = new Bundle();
        bundle.putString("Author", imageModel.getAuthor());
        bundle.putString("Download_url", imageModel.getDownload_url());
        bundle.putString("Id", imageModel.getId());
        bundle.putString("getUrl", imageModel.getUrl());
        bundle.putInt("Height", imageModel.getHeight());
        bundle.putInt("Width", imageModel.getWidth());
        Navigation.findNavController(recyclerView).navigate(R.id.action_imageListFragment_to_imageDetailsFragment,bundle);
    }
}
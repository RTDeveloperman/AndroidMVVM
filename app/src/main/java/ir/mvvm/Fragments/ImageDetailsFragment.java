package ir.mvvm.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mvvm.R;
import ir.mvvm.databinding.FragmentImageDetailsBinding;
import ir.mvvm.model.ImageDetailsModel;

public class ImageDetailsFragment extends Fragment {
    FragmentImageDetailsBinding binding;
    ImageDetailsModel DetailsData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_details, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setDetailsInfo(new ImageDetailsModel(getArguments().getString("Author"),
                getArguments().getString("Author"),
                getArguments().getString("getUrl"),
                getArguments().getInt("Height"),
                getArguments().getInt("Width")));


    }
}
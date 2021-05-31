package ir.mvvm.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mvvm.R;
import ir.mvvm.databinding.FragmentPlaylistBinding;

public class PlaylistFragment extends Fragment {


    public PlaylistFragment() {
        // Required empty public constructor
    }

    FragmentPlaylistBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_playlist,container,false);//inflater.inflate(R.layout.fragment_playlist, container, false);
        //View view=binding.getRoot();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnNextFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NavDirections navDirections=PlaylistFragmentDirections.actionPlaylistFragmentToPlayerFragment();
                Navigation.findNavController(binding.btnNextFr).navigate(navDirections);*/
                Bundle mybundle=new Bundle();
                mybundle.putString("Artiste","Shadmehr Aghili");
                Navigation.findNavController(binding.btnNextFr).navigate(R.id.action_playlistFragment_to_playerFragment,mybundle);
            }
        });
    }
}
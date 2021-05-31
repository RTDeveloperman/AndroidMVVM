package ir.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ir.mvvm.R;
import ir.mvvm.adapter.RecyclerViewAdapter;
import ir.mvvm.adapter.RecyclerViewAdapter_ArtistInfo;
import ir.mvvm.databinding.ActivityMainPageBinding;
import ir.mvvm.model.ArtistInfo;
import ir.mvvm.model.LifeCycle;
import ir.mvvm.model.MusicInfo;
import ir.mvvm.viewmodel.ViewModelMainPage;

public class MainPage extends AppCompatActivity {
    ActivityMainPageBinding binding;
    RecyclerView rv_tophits, rv_artist;
    List<MusicInfo> music_info_list = new ArrayList<>();
    List<ArtistInfo> artistInfos_list = new ArrayList<>();
    RecyclerViewAdapter adapter;
    RecyclerViewAdapter_ArtistInfo artiste_adpter;
    LifeCycle lifeCycle;
    ViewModelMainPage viewModelMainPage;
    MutableLiveData<List<ArtistInfo>> artistinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_page);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_page);
        rv_tophits = binding.rvTophit;
        rv_artist = binding.rvArtist;

        viewModelMainPage = new ViewModelProvider(this).get(ViewModelMainPage.class);
        binding.setViewModelMainPage(viewModelMainPage);
        artistinfo = viewModelMainPage.GetArtistInfo();
        artistinfo.observe(this, new Observer<List<ArtistInfo>>() {
            @Override
            public void onChanged(List<ArtistInfo> artistInfos) {
                rv_artist.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                artiste_adpter = new RecyclerViewAdapter_ArtistInfo(getApplicationContext(), artistInfos);
                rv_artist.setHasFixedSize(true);
                rv_artist.setAdapter(artiste_adpter);

            }
        });


        rv_tophits.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new RecyclerViewAdapter(this, music_info_list);
        rv_tophits.setHasFixedSize(true);


       /* rv_artist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        artiste_adpter = new RecyclerViewAdapter_ArtistInfo(this, artistInfos_list);
        rv_artist.setHasFixedSize(true);
        artistInfos_list.add(new ArtistInfo("Adel", "", "https://uk.toluna.com//dpolls_images/2016/04/23/5bc72609-421c-4067-b66e-135d028b76b8.jpg"));
        artistInfos_list.add(new ArtistInfo("Eminem", "", "https://celebmix.com/wp-content/uploads/2020/05/five-of-our-favourite-eminem-performances-01.jpg"));
        artistInfos_list.add(new ArtistInfo("Jennifer", "Lopez", "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTgwMTgyMjU4NjIyMTQ1ODgw/gettyimages-469873772.jpg"));
        artistInfos_list.add(new ArtistInfo("Michael", "Jackson", "https://images.edexlive.com/uploads/user/imagelibrary/2019/8/29/original/michael-jackson-tv-show-joseph-fiennes-1108x0-c-default.jpg"));

        rv_artist.setAdapter(artiste_adpter);*/

        music_info_list.add(new MusicInfo("astronaut in the ocean", "Masked Wolf", "https://behmedia.ir/wp-content/uploads/2021/01/Astronaut-In-The-Ocean.jpg"));
        music_info_list.add(new MusicInfo("Bang Bang", "Nancy Sinatra", "https://www.genius-lyrics.com/wp-content/uploads/2020/11/LWWEWD-Lyrics-Octavian.png"));
        music_info_list.add(new MusicInfo("I'll Never Love Again", "Lady Gaga, Bradley Cooper", "https://cdn11.bigcommerce.com/s-n6h3dlxzq9/images/stencil/1200x1200/products/15178/382955/SLPTVNYL3189__97726.1610648151.jpg"));
        music_info_list.add(new MusicInfo("اگه یه روز بری سفر", "فرامرز اصلانی", "https://picsum.photos/id/1025/4951/3301"));
        rv_tophits.setAdapter(adapter);
        lifeCycle = new LifeCycle();
        lifeCycle.ON_Create();
    }
}
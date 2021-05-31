package ir.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ir.mvvm.model.ArtistInfo;

public class ViewModelMainPage extends ViewModel {
    private MutableLiveData<List<ArtistInfo>> artistInfoMutableLiveData;
    List<ArtistInfo> artistInfos_list = new ArrayList<>();

    public MutableLiveData<List<ArtistInfo>> GetArtistInfo() {
        if (artistInfoMutableLiveData == null) {
            artistInfoMutableLiveData=new MutableLiveData<>();
            SetArtistInfo();
        }
        return artistInfoMutableLiveData;
    }

    private void SetArtistInfo() {
        artistInfos_list.add(new ArtistInfo("Adel", "", "https://uk.toluna.com//dpolls_images/2016/04/23/5bc72609-421c-4067-b66e-135d028b76b8.jpg"));
        artistInfos_list.add(new ArtistInfo("Eminem", "", "https://celebmix.com/wp-content/uploads/2020/05/five-of-our-favourite-eminem-performances-01.jpg"));
        artistInfos_list.add(new ArtistInfo("Adel", "", "https://uk.toluna.com//dpolls_images/2016/04/23/5bc72609-421c-4067-b66e-135d028b76b8.jpg"));
        artistInfos_list.add(new ArtistInfo("Jennifer", "Lopez", "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTgwMTgyMjU4NjIyMTQ1ODgw/gettyimages-469873772.jpg"));
        artistInfos_list.add(new ArtistInfo("Michael", "Jackson", "https://images.edexlive.com/uploads/user/imagelibrary/2019/8/29/original/michael-jackson-tv-show-joseph-fiennes-1108x0-c-default.jpg"));
        artistInfos_list.add(new ArtistInfo("Eminem", "", "https://celebmix.com/wp-content/uploads/2020/05/five-of-our-favourite-eminem-performances-01.jpg"));
        artistInfos_list.add(new ArtistInfo("Jennifer", "Lopez", "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTgwMTgyMjU4NjIyMTQ1ODgw/gettyimages-469873772.jpg"));
        artistInfos_list.add(new ArtistInfo("Michael", "Jackson", "https://images.edexlive.com/uploads/user/imagelibrary/2019/8/29/original/michael-jackson-tv-show-joseph-fiennes-1108x0-c-default.jpg"));
        artistInfos_list.add(new ArtistInfo("Jennifer", "Lopez", "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTgwMTgyMjU4NjIyMTQ1ODgw/gettyimages-469873772.jpg"));

        artistInfoMutableLiveData.setValue(artistInfos_list);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}

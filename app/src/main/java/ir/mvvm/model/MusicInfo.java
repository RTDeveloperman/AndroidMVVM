package ir.mvvm.model;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MusicInfo {
    String music_name;
    String artist_name;
    String category;
    String img_link;
    int duration;

    public MusicInfo(String music_name, String artist_name, String img_link) {
        this.music_name = music_name;
        this.artist_name = artist_name;
        this.img_link = img_link;
    }

    @BindingAdapter({"android:CircleImageView"})
    public static void getImage(CircleImageView imageView,String img_link){
        Picasso.get().load(img_link).into(imageView);

    }


    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }



    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

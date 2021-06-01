package ir.mvvm.model;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ViewPagerModel {
    private String name,image_link;

    public ViewPagerModel() {
    }

    public ViewPagerModel(String name, String image_link) {
        this.name = name;
        this.image_link = image_link;
    }

    @BindingAdapter("IMG_LINK_SLIDER")
    public static void loadImage(ImageView view, String link_img){
        Picasso.get().load(link_img).into(view);
    }



    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

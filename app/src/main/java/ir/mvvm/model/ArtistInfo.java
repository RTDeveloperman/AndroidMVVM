package ir.mvvm.model;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArtistInfo {
    String name;
    String famil;
    String birthdat;
    String style;
    String language;
    String twitter;
    String instagram;
    String image_link;

    @BindingAdapter({"android:CircleImageViewArtist"})
    public static void getImage(CircleImageView imageView, String img_link){
        Picasso.get().load(img_link).into(imageView);

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

    public String getFamil() {
        return famil;
    }

    public void setFamil(String famil) {
        this.famil = famil;
    }

    public String getBirthdat() {
        return birthdat;
    }

    public void setBirthdat(String birthdat) {
        this.birthdat = birthdat;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public ArtistInfo() {
    }

    public ArtistInfo(String name, String famil, String image_link) {
        this.name = name;
        this.famil = famil;
        this.image_link = image_link;
    }
}

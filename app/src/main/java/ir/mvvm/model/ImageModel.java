package ir.mvvm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ImageModel {
    String id, author, url, download_url;
    int width, height;

    @BindingAdapter({"android:GetImageLink"})
    public static void getImageLink(ImageView view, String link) {
        Picasso.get().load("https://random.dog/0afd649d-ec06-403f-aeb5-0262d1750182.jpg").into(view);
       // Picasso.get().load(link).into(view);
    }

    public ImageModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

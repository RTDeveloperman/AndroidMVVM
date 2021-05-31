package ir.mvvm.model;

public class ImageDetailsModel {
    String author, url, download_url;
    int width, height;

    public ImageDetailsModel() {
    }

    public ImageDetailsModel(String author, String url, String download_url, int width, int height) {
        this.author = author;
        this.url = url;
        this.download_url = download_url;
        this.width = width;
        this.height = height;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

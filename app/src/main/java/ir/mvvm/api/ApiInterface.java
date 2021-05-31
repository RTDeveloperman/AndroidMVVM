package ir.mvvm.api;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ir.mvvm.model.ImageModel;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v2/list?page=1&limit=2000")
    Single<List<ImageModel>> getImageList();
}


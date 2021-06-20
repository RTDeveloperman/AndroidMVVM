package ir.mvvm.api;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ir.mvvm.model.ApiStackResponse_forpaging;
import ir.mvvm.model.ImageModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //with RXjava
    @GET("v2/list?page=1&limit=2000")
    Single<List<ImageModel>> getImageList();

    //Whitout RXjava
    @GET("answers")
    Call<ApiStackResponse_forpaging> getApiStackResponse(
            @Query("page") int page,
            @Query("pagesize") int pagesize,
            @Query("site") String site
    );
}


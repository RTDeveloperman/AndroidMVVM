package ir.mvvm.api;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import ir.mvvm.model.ImageModel;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClint {
    String Base_URL = "https://picsum.photos/";
    ApiInterface request;
    Retrofit retrofit;

    public ApiClint() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        request = retrofit.create(ApiInterface.class);
    }
    public Single<List<ImageModel>> GET_IMAGE_LIST(){
        return request.getImageList();
    }
}

package ir.mvvm.api;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import ir.mvvm.model.ApiStackResponse_forpaging;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClint_forPaging {
    String Base_URL = "https://api.stackexchange.com/2.2/";
    static ApiInterface request;
    Retrofit retrofit;
    static ApiClint_forPaging apiClint_forPaging;

    public ApiClint_forPaging() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClint_forPaging getInstance() {
        if (apiClint_forPaging == null) {
            apiClint_forPaging = new ApiClint_forPaging();
        }
        return apiClint_forPaging;
    }

    public ApiInterface getApiResponse() {
        return retrofit.create(ApiInterface.class);
    }
}

package ir.mvvm.api;

import android.util.Log;

import androidx.paging.PageKeyedDataSource;

import org.jetbrains.annotations.NotNull;

import ir.mvvm.model.ApiStackResponse_forpaging;
import ir.mvvm.model.ItemModel_forpaging;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class ItemDataSource_forpaging extends PageKeyedDataSource<Integer, ItemModel_forpaging> {
   public static int PAGE = 1;
   public static int PAGE_SIZE = 10;
   public static String SITE_NAME = "stackoverflow";

    @Override
    public void loadAfter(@NotNull LoadParams<Integer> loadParams, @NotNull LoadCallback<Integer, ItemModel_forpaging> loadCallback) {
        ApiClint_forPaging.getInstance().getApiResponse().getApiStackResponse(loadParams.key, PAGE_SIZE, SITE_NAME).enqueue(new Callback<ApiStackResponse_forpaging>() {
            @Override
            public void onResponse(Call<ApiStackResponse_forpaging> call, Response<ApiStackResponse_forpaging> response) {
                if (response.body() != null) {
                    Integer key = (response.body().has_more) ? loadParams.key + 1 : null;
                    loadCallback.onResult(response.body().items, key);
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse_forpaging> call, Throwable t) {
                Log.d("ERROR", "onFailure: " + t.getMessage());

            }
        });
    }

    @Override
    public void loadBefore(@NotNull LoadParams<Integer> loadParams, @NotNull LoadCallback<Integer, ItemModel_forpaging> loadCallback) {
        ApiClint_forPaging.getInstance().getApiResponse().getApiStackResponse(loadParams.key, PAGE_SIZE, SITE_NAME).enqueue(new Callback<ApiStackResponse_forpaging>() {
            @Override
            public void onResponse(Call<ApiStackResponse_forpaging> call, Response<ApiStackResponse_forpaging> response) {
                if (response.body() != null) {
                    Integer key = (loadParams.key > 1) ? loadParams.key - 1 : null;
                    loadCallback.onResult(response.body().items, key);
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse_forpaging> call, Throwable t) {
                Log.d("ERROR", "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void loadInitial(@NotNull LoadInitialParams<Integer> loadInitialParams, @NotNull LoadInitialCallback<Integer, ItemModel_forpaging> loadInitialCallback) {
        ApiClint_forPaging.getInstance().getApiResponse().getApiStackResponse(PAGE, PAGE_SIZE, SITE_NAME).enqueue(new Callback<ApiStackResponse_forpaging>() {
            @Override
            public void onResponse(Call<ApiStackResponse_forpaging> call, Response<ApiStackResponse_forpaging> response) {
                if (response.body() != null) {
                    loadInitialCallback.onResult(response.body().items, null, PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<ApiStackResponse_forpaging> call, Throwable t) {
                Log.d("ERROR", "onFailure: " + t.getMessage());

            }
        });
    }
}

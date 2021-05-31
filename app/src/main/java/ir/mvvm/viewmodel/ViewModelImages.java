package ir.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.mvvm.api.ApiClint;
import ir.mvvm.model.ImageModel;

public class ViewModelImages extends ViewModel {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiClint apiClint;
    private MutableLiveData<List<ImageModel>> listMutableLiveData;

    public MutableLiveData<List<ImageModel>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData=  new MutableLiveData<>();
            apiClint = new ApiClint();
            compositeDisposable.add(apiClint.GET_IMAGE_LIST()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<List<ImageModel>>() {
                        @Override
                        public void onSuccess(@NonNull List<ImageModel> imageModels) {
                            listMutableLiveData.setValue(imageModels);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.i("onError", e.getMessage() + "");
                        }
                    }));
        }
        return listMutableLiveData;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}

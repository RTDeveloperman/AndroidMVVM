package ir.mvvm.api;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import org.jetbrains.annotations.NotNull;

import ir.mvvm.model.ItemModel_forpaging;

public class ItemDataSourceFactory_forpaging extends DataSource.Factory {
    MutableLiveData<PageKeyedDataSource<Integer, ItemModel_forpaging>> sourceMutableLiveData =new MutableLiveData<>();

    public MutableLiveData<PageKeyedDataSource<Integer, ItemModel_forpaging>> getSourceMutableLiveData() {
        return sourceMutableLiveData;
    }

    @NotNull
    @Override
    public DataSource create() {
        ItemDataSource_forpaging itemDataSource_forpaging =new ItemDataSource_forpaging();
        sourceMutableLiveData.postValue(itemDataSource_forpaging);
        return itemDataSource_forpaging;
    }
}

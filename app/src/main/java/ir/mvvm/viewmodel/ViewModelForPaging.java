package ir.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import ir.mvvm.api.ItemDataSourceFactory_forpaging;
import ir.mvvm.api.ItemDataSource_forpaging;
import ir.mvvm.model.ItemModel_forpaging;

public class ViewModelForPaging extends ViewModel {
   public static LiveData<PagedList<ItemModel_forpaging>> item_list_liveData;
    public static LiveData<PageKeyedDataSource<Integer,ItemModel_forpaging>> sourceLiveData;
    public ViewModelForPaging(){
        ItemDataSourceFactory_forpaging itemDataSourceFactory_forpaging=new ItemDataSourceFactory_forpaging();
        sourceLiveData=itemDataSourceFactory_forpaging.getSourceMutableLiveData();
        PagedList.Config  config=new PagedList.Config.Builder().setEnablePlaceholders(false)
                .setPageSize(ItemDataSource_forpaging.PAGE_SIZE)
                .build();
        item_list_liveData= new LivePagedListBuilder(itemDataSourceFactory_forpaging,config).build();
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}

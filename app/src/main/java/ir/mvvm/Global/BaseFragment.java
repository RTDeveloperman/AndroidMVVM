package ir.mvvm.Global;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    protected View currView;
    protected String currLayoutName;
    protected Context mContext;
    private String mClassName = null;
    private boolean isSendData = false;

    public void setLayoutView(int layoutId, LayoutInflater inflater, ViewGroup container) {
        currView = inflater.inflate(layoutId, container, false);

        currLayoutName = getResources().getResourceEntryName(layoutId);
        mClassName = currLayoutName;
        mContext = getContext();
     
    }

    public void setLayoutView(int layoutId, LayoutInflater inflater, ViewGroup container,
            String className) {
        setLayoutView(layoutId, inflater, container);

        mClassName = className;
    }


}

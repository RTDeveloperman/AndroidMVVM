package ir.mvvm.model;

import androidx.fragment.app.Fragment;

public class ViewPagerModel_Fragment {
    private String name;
    private Fragment fragment;

    public ViewPagerModel_Fragment() {
    }

    public ViewPagerModel_Fragment(String name, Fragment fragment) {
        this.name = name;
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}

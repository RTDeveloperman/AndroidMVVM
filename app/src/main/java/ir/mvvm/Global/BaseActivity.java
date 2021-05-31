package ir.mvvm.Global;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ir.mvvm.R;


public class BaseActivity extends AppCompatActivity {
    protected View currView;
    protected String currLayoutName;


    private static void manageFullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();

            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // finally change the color
            window.setStatusBarColor(activity.getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    manageFullScreen(this);
        hideToolbar();
    }

    public void setLayoutView(int layoutID) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        currView = inflater.inflate(layoutID, null);
        currLayoutName = getResources().getResourceEntryName(layoutID);
        setContentView(currView);
        // GlobalFunction.getInstance().manageTheme(this, currView, currLayoutName);
    }
   /* protected Toolbar toolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(getTitle());
        }
        enableDisplayHomeAsUp();
        return toolbar;
    }*/

    protected void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    protected void setSubtitle(String subtitle) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setSubtitle(subtitle);
        }
    }

/*    protected void setCollapsingTitle(SpannableString title) {
        CollapsingToolbarLayout collapsing = findViewById(R.id.toolbar_layout);
        if (collapsing != null) {
            collapsing.setTitle(title);
        }
    }*/

    protected void enableDisplayHomeAsUp() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void disableDisplayHomeAsUp() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    protected void hideToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    protected void showToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
    @Override
    protected void onStart() {
        super.onStart();
        // EasyTracker.getInstance(this).activityStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // GlobalFunction.getInstance().setScreenStatus(getWindow(), this);
    }

    protected void onResumePrayTime() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //EasyTracker.getInstance(this).activityStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
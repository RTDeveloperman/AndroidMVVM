package ir.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ir.mvvm.R;

public class HostActivityForImagesFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_for_images_fragment);
    }
}
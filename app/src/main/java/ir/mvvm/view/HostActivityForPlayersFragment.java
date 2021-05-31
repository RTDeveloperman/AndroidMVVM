package ir.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import ir.mvvm.R;
import ir.mvvm.databinding.ActivityHostForPlayersFragmentBinding;

public class HostActivityForPlayersFragment extends AppCompatActivity {
    ActivityHostForPlayersFragmentBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_host_for_players_fragment);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_host_for_players_fragment);
        navController= Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}
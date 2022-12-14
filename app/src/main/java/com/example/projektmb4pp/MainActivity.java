package com.example.projektmb4pp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    public SQLiteDatabase db;
    SharedPreferences loggedInAs;
    SharedPreferences cart;
    NavController navController;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        loggedInAs = getSharedPreferences("user", Context.MODE_PRIVATE);
        long accountID = loggedInAs.getLong("accountID", -1);
        Log.i("db", "ID: " + accountID);


        cart = getSharedPreferences("cart", Context.MODE_PRIVATE);
        if (cart.contains("cart")){
            Log.i("cart", "Cart: " + cart.getString("cart", ""));
        } else {
            Log.i("cart", "Cart: " + "Empty");
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        SQLiteOpenHelper sqliteOpenHelper = new DatabaseLMAO.DBHelper(this);
//        db = sqliteOpenHelper.getWritableDatabase();

    }
}

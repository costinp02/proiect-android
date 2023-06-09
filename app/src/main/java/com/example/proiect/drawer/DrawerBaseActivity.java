package com.example.proiect.drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.proiect.food.FoodMenuActivity;
import com.example.proiect.main.MainActivity;
import com.example.proiect.location.MapsActivity;
import com.example.proiect.R;
import com.example.proiect.UserActivity;
import com.google.android.material.navigation.NavigationView;


public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activity_container);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){
            case R.id.nav_user:
                startActivity(new Intent(this, UserActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_map:
                startActivity(new Intent(this, MapsActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_menu:
                startActivity(new Intent(this, FoodMenuActivity.class));
                overridePendingTransition(0,0);
                break;

            default:
                break;

        }
        return false;
    }

    protected void setActivityTitle(String activityTitle){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(activityTitle);
        }
    }


}
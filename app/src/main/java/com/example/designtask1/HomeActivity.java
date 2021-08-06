package com.example.designtask1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager viewPager;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        getTabs();


        drawerLayout = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new AlertFragment());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new AlertFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alerts:
                //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new AlertFragment()).commit();
                Toast.makeText(this, "Alerts", Toast.LENGTH_SHORT).show();
                break;

            case R.id.messaging:
                //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new MessagingFragment()).commit();
                Toast.makeText(this, "Messages", Toast.LENGTH_SHORT).show();
                break;

            case R.id.status:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new StatusFragment()).commit();
                Toast.makeText(this, "Status", Toast.LENGTH_SHORT).show();
                break;

            case R.id.live:
                //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new LiveFragment()).commit();
                Toast.makeText(this, "live", Toast.LENGTH_SHORT).show();
                break;

            case R.id.profile:
                //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new ProfileFragment()).commit();
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new SettingsFragment()).commit();
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.info:
                //getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new InfoFragment()).commit();
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            {
            super.onBackPressed();
            }
    }

    //
    public void getTabs()
    {
        final ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable()
        {
            @Override
            public void run()
            {

                viewPagerAdapter.addFragment(MembersFragment.getInstance(),"MEMBERS");
                viewPagerAdapter.addFragment(GroupsFragment.getInstance(),"GROUPS");
                viewPagerAdapter.addFragment(DepartmentsFragment.getInstance(),"DEPARTMENTS");

                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }
}
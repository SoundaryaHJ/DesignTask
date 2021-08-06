package com.example.designtask1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

@SuppressWarnings("ALL")
public class MessageActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Button now = findViewById(R.id.now);
        Button later = findViewById(R.id.later);
        Button cancel = findViewById(R.id.cancel);

        BottomNavigationView bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemReselectedListener(navListener);

    }




    private BottomNavigationView.OnNavigationItemReselectedListener navListener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;


                    switch (item.getItemId()) {
                        case R.id.nav_alert:
                            selectedFragment = new BottomFragment();
                            Toast.makeText(MessageActivity.this, "Selected Alert", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.nav_live:
                            selectedFragment = new BottomFragment();
                            Toast.makeText(MessageActivity.this, "Selected live", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.nav_select:
                            selectedFragment = new BottomFragment();
                            Toast.makeText(MessageActivity.this, "Selected list", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.nav_message:
                            selectedFragment = new MsgFragment();
                            Toast.makeText(MessageActivity.this, "Selected msg page", Toast.LENGTH_SHORT).show();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                }
            };
}

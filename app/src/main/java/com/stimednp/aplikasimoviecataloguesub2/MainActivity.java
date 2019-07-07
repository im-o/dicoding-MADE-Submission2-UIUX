package com.stimednp.aplikasimoviecataloguesub2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_tollbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        ViewPager viewPager = findViewById(R.id.view_pager_main);
        TabLayout tabLayout = findViewById(R.id.tab_layout_main);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        String titleTab1 = getResources().getString(R.string.name_tab1_movies);
        String titleTab2 = getResources().getString(R.string.name_tab2_tvshow);
        tabAdapter.addFragment(new TabMoviesFragment(), titleTab1);
        tabAdapter.addFragment(new TabTvShowFragment(), titleTab2);

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private int[] tabIcons = {
            R.drawable.ic_movie_white_24dp,
            R.drawable.ic_live_tv_black_24dp
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_right_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idMenu =item.getItemId();
        if (idMenu == R.id.change_set_lang){
            Intent changeLangIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(changeLangIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}

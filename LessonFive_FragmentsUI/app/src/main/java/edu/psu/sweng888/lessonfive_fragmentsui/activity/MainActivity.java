package edu.psu.sweng888.lessonfive_fragmentsui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import edu.psu.sweng888.lessonfive_fragmentsui.R;
import edu.psu.sweng888.lessonfive_fragmentsui.data.BookDatabaseHelper;
import edu.psu.sweng888.lessonfive_fragmentsui.fragments.AddBookFragment;
import edu.psu.sweng888.lessonfive_fragmentsui.fragments.BooksListFragment;
import edu.psu.sweng888.lessonfive_fragmentsui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    /** Step 1: create a reference to the DrawerLayout */
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** Step 2: Get the DrawerLayout object from the layout XML file */
        mDrawerLayout = findViewById(R.id.nav_drawer_layout);

        /** Step 3: Get the NavigationView object from the layout SML file */
        mNavigationView = findViewById(R.id.nav_view);

        /** Step 4: Set the listener for the NavigationView. The Main Activity should
         * implement the interface NavigationView.OnNavigationItemSelectedListener */
        mNavigationView.setNavigationItemSelectedListener(this);

        /** Step 5: Set up the ActionBarDrawerToggle */
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, // Activity / Context
                mDrawerLayout, // DrawerLayout
                R.string.navigation_drawer_open, // String to open
                R.string.navigation_drawer_close // String to close
        );
        /** Step 6: Include the mActionBarDrawerToggle as the listener to the DrawerLayout.
         *  The synchState() method is used to synchronize the state of the navigation drawer */
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        /** Step 7:Set the default fragment to the HomeFragment */
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {// Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_book_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BooksListFragment()).commit();
                break;
            case R.id.nav_add_book:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddBookFragment()).commit();
                break;
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
        }

        /** Close the navigation drawer */
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /** Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.nav_drawer_items, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

}
package com.example.quotes.gitaramayanaupdesh;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private FrameLayout mFrameLayout;
    private String [] mItemsList;
    private NavigationView mNavigationView;

    /**
     * * void onCreate(Bundle) is overridden.
     * * It is called at the time of creation of the activity (MainActivity.java).
     */

    protected void onCreate(Bundle onSavedInstanceState){

        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        setSupportActionBar(mToolbar);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,mToolbar,R.string.openDrawer,R.string.closeDrawer);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        mItemsList = getResources().getStringArray(R.array.menu_items_list);

        mNavigationView = (NavigationView) findViewById(R.id.navigationDrawer_layout);
        mNavigationView.setNavigationItemSelectedListener(MainActivity.this);
    }

    /**
     ** The method void onBackPressed(void) is an overridden method.
     ** It handles the action when the user pressed the back button on the phone.
     ** It closes the navigation drawer,if it is open,when the user presses the back button.
     */

    public void onBackPressed(){

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    /**
     ** The method boolean onNavigationItemSelected(MenuItem) is an overridden method.
     ** It performs the mentioned instructions in the method as defined by the developer according to the
     ** menu chosen in the Navigation Drawer menu.
     */

    public boolean onNavigationItemSelected(MenuItem menuItem){

        setActionBarTitle(menuItem);

        switch (menuItem.getItemId()){

            case R.id.gita_english:

                break;
            case R.id.gita_hindi:

                break;
            case R.id.ramayana_english:

                break;
            case R.id.ramayana_hindi:

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * * The method void setActionBarTitle(MenuItem) sets the title of the action bar according to the items
     * * selected from the navigation drawer menu.
     */

    public void setActionBarTitle(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.gita_english:
                getSupportActionBar().setTitle(mItemsList[0]);
                break;
            case R.id.gita_hindi:
                getSupportActionBar().setTitle(mItemsList[1]);
                break;
            case R.id.ramayana_english:
                getSupportActionBar().setTitle(mItemsList[2]);
                break;
            case R.id.ramayana_hindi:
                getSupportActionBar().setTitle(mItemsList[3]);
                break;
            default:
                getSupportActionBar().setTitle(R.string.app_name);
        }
    }
}

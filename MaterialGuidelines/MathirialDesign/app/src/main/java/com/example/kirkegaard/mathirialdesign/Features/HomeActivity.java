package com.example.kirkegaard.mathirialdesign.Features.Features;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.kirkegaard.mathirialdesign.Features.Features.Dialogs.DialogsActivity;
import com.example.kirkegaard.mathirialdesign.Features.Features.Lists.GroupedListActivity;
import com.example.kirkegaard.mathirialdesign.Features.Features.LottieAnimations.LottieAnimationsActivity;
import com.example.kirkegaard.mathirialdesign.Features.Features.MasterDetails.ItemListActivity;
import com.example.kirkegaard.mathirialdesign.Features.Features.Pagers.PagerDropdownActivity;
import com.example.kirkegaard.mathirialdesign.Features.Features.Pagers.PagerTabStripActivity;
import com.example.kirkegaard.mathirialdesign.R;
import com.example.kirkegaard.mathirialdesign.Features.Features.Transactions.SharedTransactionFragmentHolderActivity;
import com.example.kirkegaard.mathirialdesign.Features.Features.Transactions.SharedTransactionAActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Button revealButton = (Button)findViewById(R.id.reveal_button);
        revealButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                NavigateWithReveal(view);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_gallery:
                break;

            case R.id.nav_slideshow:
                break;

            case R.id.nav_manage:
                break;

            case R.id.nav_scrolling:
                NavigateToPage(ScrollingActivity.class);
                break;

            case R.id.nav_dialogs:
                NavigateToPage(DialogsActivity.class);
                break;

            case R.id.nav_bottom_nav:
                NavigateToPage(BottomNavigationActivity.class);
                break;

            case R.id.nav_master_details:
                NavigateToPage(ItemListActivity.class);
                break;

            case R.id.nav_fullscreen:
                NavigateToPage(FullscreenActivity.class);
                break;

            case R.id.nav_tabbed_pager:
                NavigateToPage(PagerTabStripActivity.class);
                break;

            case R.id.nav_dropdown_pager:
                NavigateToPage(PagerDropdownActivity.class);
                break;

            case R.id.nav_shared_transaction:
                NavigateToPage(SharedTransactionAActivity.class);
                break;

            case R.id.nav_fragments_shared_transaction:
                NavigateToPage(SharedTransactionFragmentHolderActivity.class);
                break;

            case R.id.nav_lottie_animations:
                NavigateToPage(LottieAnimationsActivity.class);
                break;

            case R.id.nav_log_cat:
                NavigateToPage(LogCatActivity.class);
                break;

            case R.id.nav_adapters:
                NavigateToPage(GroupedListActivity.class);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void NavigateToPage(Class<?> activityClass)
    {
        Intent intent = new Intent(this, activityClass);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    private void NavigateWithReveal(View view)
    {
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                        this,
                        view,
                        "transition");

        int[] locationOnScreen = new int[2];
        view.getLocationInWindow(locationOnScreen);

        int revalX = (int)(locationOnScreen[0] + view.getWidth() / 2);
        int revalY = (int)(locationOnScreen[1] + view.getHeight() / 2);

        //int revalX = (int)(view.getX() + view.getWidth() / 2);
        //int revalY = (int)(view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(this, RevealActivity.class);
        intent.putExtra(RevealActivity.EXTRA_CIRCULAR_REVEAL_X, revalX);
        intent.putExtra(RevealActivity.EXTRA_CIRCULAR_REVEAL_Y, revalY);

        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}

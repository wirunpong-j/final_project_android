package com.bellkung.anidesu.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bellkung.anidesu.adapter.AnimeListPagerAdapter;
import com.bellkung.anidesu.api.ApiConfig;
import com.bellkung.anidesu.api.NetworkConnectionManager;
import com.bellkung.anidesu.api.OnNetworkCallbackListener;
import com.bellkung.anidesu.api.model.Token;
import com.bellkung.anidesu.R;
import com.bellkung.anidesu.model.User;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, User.UserDataListener,
        MaterialSearchBar.OnSearchActionListener, OnNetworkCallbackListener {

    private FirebaseAuth mAuth;
    private User user;

    @BindView(R.id.nav_view) NavigationView mNavigationView;
    @BindView(R.id.fab) FloatingActionButton mFab;
    @BindView(R.id.searchBar) MaterialSearchBar mSearchBar;
    @BindView(R.id.anime_list_pager) ViewPager mAnimePager;
    @BindView(R.id.nts_center) SmartTabLayout mSmartTabStrip;

    private static DrawerLayout mDrawer;
    private static ConstraintLayout mLoadingView;
    private static AVLoadingIndicatorView mAvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        this.mDrawer = findViewById(R.id.drawer_layout);
        this.mLoadingView = findViewById(R.id.loadingView);
        this.mAvi = findViewById(R.id.avi);

        showLoadingView();

        this.mNavigationView.setNavigationItemSelectedListener(this);

        this.mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.mSearchBar.setOnSearchActionListener(this);
        this.mSearchBar.inflateMenu(R.menu.activity_home_drawer);
        this.mSearchBar.setCardViewElevation(10);

        this.mAuth = FirebaseAuth.getInstance();
        this.mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser fbUser = firebaseAuth.getCurrentUser();
                if (fbUser != null) {
                    user = new User(fbUser.getUid());
                    user.listener = HomeActivity.this;
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void updateUI(User user) {
        if (user != null) {

            // Access Token
            new NetworkConnectionManager().callServer(this);

            this.user = user;
            TextView fullnameTextView = this.mNavigationView.getHeaderView(0).findViewById(R.id.fullnameTextView);
            TextView emailTextView = this.mNavigationView.getHeaderView(0).findViewById(R.id.emailTextView);
            ImageView profileImage = this.mNavigationView.getHeaderView(0).findViewById(R.id.profileImage);

            fullnameTextView.setText(this.user.getDisplay_name());
            emailTextView.setText(this.user.getEmail());
            Glide.with(getApplicationContext()).load(this.user.getImage_url_profile()).into(profileImage);
        }

    }

    private void Display(int id) {
        switch(id) {
            case R.id.nav_home:
                this.mSearchBar.setPlaceHolder(getString(R.string.nav_name_home));
                AnimeListPagerAdapter animeListPagerAdapter = new AnimeListPagerAdapter(getSupportFragmentManager());
                this.mAnimePager.setAdapter(animeListPagerAdapter);
                this.mSmartTabStrip.setViewPager(this.mAnimePager);
                this.mNavigationView.setCheckedItem(R.id.nav_home);
                break;

            case R.id.nav_anime_list:
                this.mNavigationView.setCheckedItem(R.id.nav_anime_list);
                break;

            case R.id.nav_anime_review:
                this.mNavigationView.setCheckedItem(R.id.nav_anime_review);
                break;

            case R.id.nav_profile:
                this.mNavigationView.setCheckedItem(R.id.nav_profile);
                break;

            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                break;
        }

    }

    // User.UserDataListener : Change when login is success.
    @Override
    public void onDataChanged() {
        updateUI(this.user);
    }

    @Override
    public void onBackPressed() {
        if (this.mDrawer.isDrawerOpen(GravityCompat.START)) {
            this.mDrawer.closeDrawer(GravityCompat.START);
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
        Display(item.getItemId());

        this.mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {

    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }

    @Override
    public void onButtonClicked(int buttonCode) {
        switch (buttonCode){
            case MaterialSearchBar.BUTTON_NAVIGATION:
                this.mDrawer.openDrawer(Gravity.LEFT);
                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                break;
            case MaterialSearchBar.BUTTON_BACK:
                this.mSearchBar.disableSearch();
                break;
        }
    }

    @Override
    public void onResponse(String action, Call call, Response response) {
        switch(action) {
            case ApiConfig.ACCESS_TOKEN:
                onNavigationItemSelected(this.mNavigationView.getMenu().getItem(0));
                Token token = (Token) response.body();
                Toast.makeText(this, token.getAccess_token(),
                        Toast.LENGTH_SHORT).show();
                hideLoadingView();
                break;
        }
    }

    @Override
    public void onBodyError(ResponseBody responseBodyError) {
        Log.i("Status", "onBodyError");
    }

    @Override
    public void onBodyErrorIsNull() {
        Log.i("Status", "onBodyErrorIsNull");
    }

    @Override
    public void onFailure(Throwable t) {
        Log.i("Status", "onFailure");
    }

    public static void showLoadingView() {
        mAvi.show();
        mLoadingView.setVisibility(View.VISIBLE);
        mDrawer.setClickable(false);
    }

    public static void hideLoadingView() {
        mLoadingView.setVisibility(View.INVISIBLE);
        mDrawer.setClickable(true);
    }

}

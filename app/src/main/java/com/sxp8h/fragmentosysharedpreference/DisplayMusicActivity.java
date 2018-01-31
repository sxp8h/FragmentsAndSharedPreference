package com.sxp8h.fragmentosysharedpreference;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sxp8h.fragmentosysharedpreference.Beans.Artist;
import com.sxp8h.fragmentosysharedpreference.Fragments.ContentFragment;
import com.sxp8h.fragmentosysharedpreference.Fragments.MenuFragment;
import com.sxp8h.fragmentosysharedpreference.Interface.ArtistListener;

public class DisplayMusicActivity extends AppCompatActivity implements ArtistListener {

    private MenuFragment menuFragment;
    private ContentFragment contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_music);
        // Fragments START
            // Prepare fragments
        menuFragment = MenuFragment.newInstance();
        contentFragment = ContentFragment.newInstance();
        // 1) Fragment Manager
        FragmentManager fm = getSupportFragmentManager();
        // 2) Begin transaction
        FragmentTransaction ft = fm.beginTransaction();
        // 3) Paste fragments
        ft.add(R.id.menuFrame, menuFragment);
        ft.add(R.id.holderFrame, contentFragment);
        // 4) Commit changes
        ft.commit();
        // Fragments END
    }

    // Interface for notificate from MenuFragment to edit ContainerFragment
    @Override
    public void onArtistSelected(Artist artist) {
        contentFragment.changeDataArtist(artist);
    }
}

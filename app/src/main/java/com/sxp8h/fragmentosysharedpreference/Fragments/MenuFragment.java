package com.sxp8h.fragmentosysharedpreference.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sxp8h.fragmentosysharedpreference.Beans.Artist;
import com.sxp8h.fragmentosysharedpreference.Interface.ArtistListener;
import com.sxp8h.fragmentosysharedpreference.R;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private ArtistListener artistListener;
    private ArrayList<Artist> listArtist = new ArrayList<>();

    // Singleton START
    private static MenuFragment menuFragment;

    public static MenuFragment newInstance() {
        if(menuFragment== null){
            menuFragment = new MenuFragment();
        }
        return menuFragment;
    }

    public static MenuFragment newInstance(Bundle params) {
        menuFragment = newInstance();
        if(params != null){
            menuFragment.setArguments(params);
        }
        return menuFragment;
    }
    // Singleton END

    public MenuFragment() {
        // Required empty public constructor
    }

    // Fragment Life Cycle START
        // onAttach -> Interface callback
        // onCreate -> Transfer data between activity & fragment
        // onCreateView -> Prepare View for fragment
        // onActivityCreated ->

    // Interface for notificate from here to edit DisplayMusicActivity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        artistListener = (ArtistListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            // TODO
        }
    }

    private ImageView wizkhalifaImage;
    private ImageView eminemImage;
    private ImageView lildickyImage;
    private ImageView badbunnyImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        if(view != null){
            wizkhalifaImage = view.findViewById(R.id.wizkhalifaImage);
            eminemImage = view.findViewById(R.id.eminemImage);
            lildickyImage = view.findViewById(R.id.lildickyImage);
            badbunnyImage = view.findViewById(R.id.badbunnyImage);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listArtist.add(new Artist("Wiz Khalifa", "Professional smoker"));
        listArtist.add(new Artist("Eminem", "Professional Choker"));
        listArtist.add(new Artist("Lil Dicky", "Professional Retarded"));
        listArtist.add(new Artist("Bad Bunny", "Professional Fucker"));

        wizkhalifaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                artistListener.onArtistSelected(listArtist.get(0));
            }
        });
        eminemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                artistListener.onArtistSelected(listArtist.get(1));
            }
        });
        lildickyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                artistListener.onArtistSelected(listArtist.get(2));
            }
        });
        badbunnyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                artistListener.onArtistSelected(listArtist.get(3));
            }
        });
    }

    // Fragment Life Cycle END
}

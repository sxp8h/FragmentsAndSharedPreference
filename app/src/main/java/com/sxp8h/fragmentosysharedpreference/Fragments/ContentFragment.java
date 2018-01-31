package com.sxp8h.fragmentosysharedpreference.Fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxp8h.fragmentosysharedpreference.Beans.Artist;
import com.sxp8h.fragmentosysharedpreference.R;

public class ContentFragment extends Fragment {

    // Singleton START
    private static ContentFragment contentFragment;

    public static ContentFragment newInstance() {
        if(contentFragment== null){
            contentFragment = new ContentFragment();
        }
        return contentFragment;
    }

    public static ContentFragment newInstance(Bundle params) {
        contentFragment = newInstance();
        if(params != null){
            contentFragment.setArguments(params);
        }
        return contentFragment;
    }
    // Singleton END


    public ContentFragment() {
        // Required empty public constructor
    }

    private ImageView artistImage;
    private TextView txtArtistName;
    private TextView txtArtistDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        if(view != null){
            artistImage = view.findViewById(R.id.artistImage);
            txtArtistName = view.findViewById(R.id.txtArtistName);
            txtArtistDescription = view.findViewById(R.id.txtArtistDescription);
        }

        return view;
    }

    public void changeDataArtist(Artist artist){
        txtArtistName.setText(artist.getName());
        txtArtistDescription.setText(artist.getDescription());
        artistImage.setImageDrawable(getPhotoArtist(artist));
    }

    private Drawable getPhotoArtist(Artist artist){
        //listArtist.add(new Artist("Wiz Khalifa", "Professional smoker"));
        //listArtist.add(new Artist("Eminem", "Professional Choker"));
        //listArtist.add(new Artist("Lil Dicky", "Professional Retarded"));
        //listArtist.add(new Artist("Bad Bunny", "Professional Fucker"));
        Drawable photo = null;
        switch (artist.getName()){
            case "Wiz Khalifa":
                photo = ResourcesCompat.getDrawable(getResources(), R.drawable.wizkhalifa, null);
                break;
            case "Eminem":
                photo = ResourcesCompat.getDrawable(getResources(), R.drawable.eminem, null);
                break;
            case "Lil Dicky":
                photo = ResourcesCompat.getDrawable(getResources(), R.drawable.lildicky, null);
                break;
            case "Bad Bunny":
                photo = ResourcesCompat.getDrawable(getResources(), R.drawable.badbunny, null);
                break;
            default:
                break;
        }
        return photo;
    }
}

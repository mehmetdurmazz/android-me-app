package com.udacityprojects.devstd.androidme.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacityprojects.devstd.androidme.R;
import com.udacityprojects.devstd.androidme.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    // Mandatory constructor for instantiating the fragment
    public BodyPartFragment() {
    }

    /*
        Inflates the fragment layout and sets any image resources
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the AndroidMe fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);


        // Set the image resource to display
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return rootView;
    }

}

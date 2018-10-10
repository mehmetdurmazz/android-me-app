package com.udacityprojects.devstd.androidme.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacityprojects.devstd.androidme.R;

import java.util.List;

public class BodyPartFragment extends Fragment {

    // Tag for logging
    private static final String TAG = "BodyPartFragment";

    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> imageIdList;
    private int imageIdIndex;


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


        if (imageIdList != null) {
            imageView.setImageResource(imageIdList.get(imageIdIndex));
        } else {
            Log.v(TAG, "This fragment has a null list of image id's.");
        }

        return rootView;
    }

    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed
    public void setImageIdList(List<Integer> imageIdList) {
        this.imageIdList = imageIdList;
    }

    public void setImageIdIndex(int imageIdIndex) {
        this.imageIdIndex = imageIdIndex;
    }


}

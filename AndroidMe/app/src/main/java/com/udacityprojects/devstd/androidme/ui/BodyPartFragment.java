package com.udacityprojects.devstd.androidme.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacityprojects.devstd.androidme.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // Final strings to store information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


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

        if (savedInstanceState != null) {
            imageIdList = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            imageIdIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Inflate the AndroidMe fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        //( imageView should be final, since it's being accessed now by an inner class )
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);


        if (imageIdList != null) {
            imageView.setImageResource(imageIdList.get(imageIdIndex));
            final int imageIdListSizeBorder = imageIdList.size() - 1;

            imageView.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 if (imageIdIndex < imageIdListSizeBorder) {
                                                     imageIdIndex++;
                                                 } else {
                                                     // The end of list has been reached, so return to beginning index
                                                     imageIdIndex = 0;
                                                 }
                                                 imageView.setImageResource(imageIdList.get(imageIdIndex));
                                             }
                                         }


            );
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

    /*
     * Save the current state of this fragment
     *
     * */

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) imageIdList);
        currentState.putInt(LIST_INDEX, imageIdIndex);
    }
}

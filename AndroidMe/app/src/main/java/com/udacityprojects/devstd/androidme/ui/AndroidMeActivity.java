package com.udacityprojects.devstd.androidme.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacityprojects.devstd.androidme.R;
import com.udacityprojects.devstd.androidme.data.AndroidImageAssets;


// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // BodyPartFragment instance
        BodyPartFragment headFragment = new BodyPartFragment();

        // Set the list of image id's for the head fragment and set the position to the second image in the list
        headFragment.setImageIdList(AndroidImageAssets.getHeads());
        headFragment.setImageIdIndex(1);


        // Use a FragmentManager and transaction to add the fragment to the screen
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Fragment transaction
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit();


        // Create and display the body and leg BodyPartFragments

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setImageIdList(AndroidImageAssets.getBodies());
        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit();

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setImageIdList(AndroidImageAssets.getLegs());
        fragmentManager.beginTransaction()
                .add(R.id.leg_container, legFragment)
                .commit();

    }
}

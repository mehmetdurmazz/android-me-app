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

        // Only create new fragments when there is no previously saved state
        if (savedInstanceState == null) {

            // BodyPartFragment instance
            BodyPartFragment headFragment = new BodyPartFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIdList(AndroidImageAssets.getHeads());

            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setImageIdIndex(headIndex);


            // Use a FragmentManager and transaction to add the fragment to the screen
            FragmentManager fragmentManager = getSupportFragmentManager();

            // Fragment transaction
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();


            // Create and display the body and leg BodyPartFragments

            BodyPartFragment bodyFragment = new BodyPartFragment();

            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setImageIdIndex(bodyIndex);

            bodyFragment.setImageIdList(AndroidImageAssets.getBodies());
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIdList(AndroidImageAssets.getLegs());

            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setImageIdIndex(legIndex);

            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();

        }
    }
}

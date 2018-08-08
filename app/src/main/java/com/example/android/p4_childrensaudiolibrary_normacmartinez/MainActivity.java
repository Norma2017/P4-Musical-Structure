package com.example.android.p4_childrensaudiolibrary_normacmartinez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view that shows the children's stories category
        final TextView stories = findViewById(R.id.stories);

        // Set a clicklistener on that View
        stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link StoriesActivity}
                Intent storiesIntent = new Intent(MainActivity.this,StoriesActivity.class);

                // Start the new activity
                startActivity(storiesIntent);

            }
        });

        // Find the view that shows the Fables category
        final TextView fables = findViewById(R.id.fables);

        // Set a clicklistener on that View
        fables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Create a new intent to open the {@link FablesActivity}
                Intent fablesIntent = new Intent(MainActivity.this,FablesActivity.class);
                // Start the new activity
                startActivity(fablesIntent);

            }
        });

    }
}

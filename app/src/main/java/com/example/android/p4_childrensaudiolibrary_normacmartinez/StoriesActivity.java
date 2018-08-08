package com.example.android.p4_childrensaudiolibrary_normacmartinez;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class StoriesActivity extends AppCompatActivity {


    MediaPlayer mMediaplayer;
    int currentPosition;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        //Action bar to comeback to menu located in the activity_main.xml .
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Create a list of stories

        final ArrayList<Story> historias = new ArrayList<Story>();

        historias.add(new Story("Los Tres Cerditos",R.drawable.androidarrobutton,R.raw.audiocuento_los_tres_cerditos));
        historias.add(new Story("Caperucita Roja",R.drawable.androidarrobutton, R.raw.audiocuento_caperucita_roja_cuento_infantil));
        historias.add(new Story("Pinocho",R.drawable.androidarrobutton, R.raw.audiocuento_pinocho));
        historias.add(new Story("El Patito Feo",R.drawable.androidarrobutton,R.raw.audiocuento_el_patito_feo_cuento_infantil));
        historias.add(new Story("Pedro y el Lobo",R.drawable.androidarrobutton,R.raw.audiocuento_pedro_y_el_lobo));
        historias.add(new Story("Ratón De Campo y Ratón de Ciudad",R.drawable.androidarrobutton,R.raw.raton_de_campo_y_raton_de_ciudad));

        // Create an FablesAdapter, whose data source is a list of
        //  Fables. The adapter knows how to create list item views for each item
        // in the list.
        StoryAdapter adapter = new StoryAdapter(this,historias);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = (ListView) findViewById(R.id.storiesView);
        listView.setAdapter(adapter);

        // Set a Item Click Listener to play media player
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // Get position of each story
                Story story = historias.get(position);

                // Stop the Player
                if (currentPosition != position){
                    if (mMediaplayer != null){
                        mMediaplayer.stop();
                    }
                }

                // this would help avoiding lopping song when I click a song is already playing so it start
                if (mMediaplayer != null){
                    currentPosition = position;
                    mMediaplayer.stop();
                }

                // start media player when i choose a song.
                mMediaplayer = MediaPlayer.create(StoriesActivity.this, story.getmAudioResourceId());
                mMediaplayer.start();

            }

        });

        }
        //Stop media when Stories to children are close

        @Override
        protected  void onStop(){
            super.onStop();
            if (mMediaplayer != null){
                mMediaplayer.stop();

        }
    }

    /**
     * Clean up the media player by releasing its resources.
     * @param mOnAudioFocusChangeListener
     */

    private void releaseMediaPlayer(AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener) {
        // If the media player is not null, then it may be currently playing a sound.

        if (mMediaplayer!= null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.

            mMediaplayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.

            mMediaplayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }

}



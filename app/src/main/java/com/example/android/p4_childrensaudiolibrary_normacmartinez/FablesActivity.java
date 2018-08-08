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


public class FablesActivity extends AppCompatActivity {

    MediaPlayer mMediaplayer;
    int currentPosition;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fables);

        //Action bar to comeback to menu located in the activity_main.xml .
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Create a list of stories

        final ArrayList<Fables> fabulas = new ArrayList<Fables>();

        fabulas.add(new Fables(getString(R.string.El_asno_y_las_cigarras),R.drawable.androidarrobutton,R.raw.el_asno_y_las_cigarras));
        fabulas.add(new Fables(getString(R.string.El_cuervo_y_la_zorra),R.drawable.androidarrobutton,R.raw.audiocuento_el_cuervo_y_la_zorra));
        fabulas.add(new Fables(getString(R.string.El_viento_y_el_sol),R.drawable.androidarrobutton,R.raw.el_viento_y_el_sol_fabula_de_esopo));
        fabulas.add(new Fables(getString(R.string.La_cigarra_y_la_hormiga),R.drawable.androidarrobutton,R.raw.la_cigarra_y_la_hormiga));
        fabulas.add(new Fables(getString(R.string.La_zorra_y_las_uvas),R.drawable.androidarrobutton,R.raw.la_zorra_y_las_uvas));
        fabulas.add(new Fables(getString(R.string.El_perro_y_el_reflejo_en_el_rio),R.drawable.androidarrobutton,R.raw.el_perro_y_el_reflejo_en_el_rio));
        fabulas.add(new Fables(getString(R.string.El_caballo_y_el_asno),R.drawable.androidarrobutton,R.raw.el_caballo_y_el_asno_fabulas_de_esopo));
        fabulas.add(new Fables(getString(R.string.El_asno_el_gallo_y_el_león),R.drawable.androidarrobutton,R.raw.el_asno_el_gallo_y_el_leon_fabulas_de_esopo));

        // Create an FablesAdapter, whose data source is a list of
        //  Fables. The adapter knows how to create list item views for each item
        // in the list.
        FablesAdapter adapter = new FablesAdapter(this,fabulas);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = (ListView) findViewById(R.id.fablesView);

        listView.setAdapter(adapter);

        // Set a Item Click Listener to play media player
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get position of each fable in arraylist and save it in a variable.
                Fables fables = fabulas.get(position);

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
                mMediaplayer = MediaPlayer.create(FablesActivity.this, fables.getmAudioResourceId());
                mMediaplayer.start();

                // Start the audio file
                mMediaplayer.start();

            }

        });

    }
    //Stop media when Fables  is close
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


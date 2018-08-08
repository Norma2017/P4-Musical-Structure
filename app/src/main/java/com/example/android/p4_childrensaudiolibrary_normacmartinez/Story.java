package com.example.android.p4_childrensaudiolibrary_normacmartinez;

/**
 * Created by Norma Martinez on 09/04/2018.
 */

public class Story {
    /** Name is the title */
    private String mName;

    /** Image is the resource */
    private int mImageResourceId;

    /** Audio Resource Id for the story */
    private int mAudioResourceId;

    /**Create a new Stories object
     * @param Name is the title of each story
     * @param ImageResourceId is the image arrow
     * @param audioResourceId is the audio
     */

    public Story(String Name, int ImageResourceId,int audioResourceId) {
        mName = Name;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the Story name.
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the image of the play.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


    /**
     * Return the audio resource ID of the story.
     */
    public int getmAudioResourceId(){
        return mAudioResourceId;}

}

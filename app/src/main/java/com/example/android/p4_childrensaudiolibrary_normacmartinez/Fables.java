package com.example.android.p4_childrensaudiolibrary_normacmartinez;

/**
 * Created by Norma Martinez on 10/04/2018.
 */

class Fables {
    /** Nombre is the title */
    private String mNombre;

    /** Image is the resource */
    private int mImagenRecursoId;
    private int mAudioResourceId;

    /**Create a new Word object
     *  @param Nombre is the title of each history
     *
     * @param ImagenRecursoId is the image in the arrow
     *
     * @param audioResourceId
     */
    public Fables(String Nombre, int ImagenRecursoId, int audioResourceId) {
        mNombre = Nombre;
        mImagenRecursoId = ImagenRecursoId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the name.
     */
    public String getName() {
        return mNombre;
    }

    /**
     * Get the image of the word.
     */
    public int getImageResourceId() {
        return mImagenRecursoId;
    }

    /**
     * Return the audio resource ID of the story.
     */

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}

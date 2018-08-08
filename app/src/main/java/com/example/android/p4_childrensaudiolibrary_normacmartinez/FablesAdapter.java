package com.example.android.p4_childrensaudiolibrary_normacmartinez;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Norma Martinez on 10/04/2018.
 */

/*
* FablesAdapter is an  ArrayAdapter that can provide the layout for each list
* based on a data source, which is a list of fables and  objects.
* */

public class FablesAdapter extends ArrayAdapter <Fables> {


    public FablesAdapter(FablesActivity context, ArrayList<Fables> fabulas) {
        super(context, 0, fabulas);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.simple_list_item_2, parent, false);
        }

        // Get the Fables object located at this position in the list.
        Fables currentFables = getItem(position);

        // Find the TextView in the list_item.1xml layout with the ID name_text_view.
        TextView fabulasTextView = (TextView) listItemView.findViewById(R.id.name_text_view);

        // Get the version name from the current Fables object and
        // set this text on the name TextView
        fabulasTextView.setText(currentFables.getName());


        // Find the ImageView in the list_item1.xml layout with ID image.
        ImageView arrowView = (ImageView) listItemView.findViewById(R.id.image);

        // Get the image resource ID from the current Fables object and
        // set the image
        arrowView.setImageResource(Integer.parseInt(String.valueOf(currentFables.getImageResourceId())));

        // Return the whole list item layout (containing 1 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

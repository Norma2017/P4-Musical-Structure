package com.example.android.p4_childrensaudiolibrary_normacmartinez;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Norma Martinez on 08/04/2018.
 */

public class StoryAdapter extends ArrayAdapter <Story> {
    public StoryAdapter(Activity context, ArrayList<Story> historias) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for one TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, historias);
    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.simple_list_item_1, parent, false);
        }

        // Get the stories and located at this position in the list
        Story currentStory = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView historiaTextView = listItemView.findViewById(R.id.name_text_view);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        historiaTextView.setText(currentStory.getName());

        // Find the ImageView in the list_item_1.xml layout.
        ImageView arrowView = listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Stories object and
        // set the image
        arrowView.setImageResource(Integer.parseInt(String.valueOf(currentStory.getImageResourceId())));

        // Return the whole list item layout (containing 1 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

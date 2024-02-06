package edu.psu.sweng888.lessonthree_intents.model;

import edu.psu.sweng888.lessonthree_intents.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(@NonNull Context context, @NonNull List<Course> objects) {
       super(context, R.layout.list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listViewElement = convertView;

        if (listViewElement == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listViewElement = inflater.inflate(R.layout.list_item, parent, false);
        }

        Course course = getItem(position);
        TextView textViewID = listViewElement.findViewById(R.id.course_id);
        TextView textViewCredits = listViewElement.findViewById(R.id.course_credits);
        TextView textViewDescription = listViewElement.findViewById(R.id.course_description);

        textViewID.setText("SWENG: "+course.getID());
        textViewCredits.setText("Credits: "+course.getCredits());
        textViewDescription.setText("Description: "+course.getDescription());

        return listViewElement;

    }
}

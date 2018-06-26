package service;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gef.mymemo.R;

/**
 * Created by gef on 26/06/2018.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder
{
    // TextView intitulé course :
    public TextView textViewLibelleCourse;

    // Constructeur :
    public CourseViewHolder(View itemView)
    {
        super(itemView);
        textViewLibelleCourse = itemView.findViewById(R.id.libelle_course);
    }
}

package service;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.gef.mymemo.R;

import java.util.List;

import model.Course;

/**
 * Created by gef on 26/06/2018.
 */

public class CoursesAdapter extends RecyclerView.Adapter<CourseViewHolder>
{
    // Liste d'objets métier :
    private List<Course> listeCourses;

    // Constructeur :
    public CoursesAdapter(List<Course> listeCourses)
    {
        this.listeCourses = listeCourses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewCourse = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new CourseViewHolder(viewCourse);
    }
    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position)
    {
        holder.textViewLibelleCourse.setText(listeCourses.get(position).intitule);
    }
    @Override
    public int getItemCount()
    {
        return listeCourses.size();
    }

    public  void addItem(String text) {
        listeCourses.add(new Course(text));
        notifyItemInserted(listeCourses.size() - 1);
    }
}

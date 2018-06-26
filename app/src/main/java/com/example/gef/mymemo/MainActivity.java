package com.example.gef.mymemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import service.CoursesAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    //private RecyclerView recyclerView = null;
    private GestureDetector gestureDetector;
    private CoursesAdapter coursesAdapter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // init :
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.liste_courses);

        // listerner :
        recyclerView.addOnItemTouchListener(this);

        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true);

        // layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // contenu d'exemple :
        List<Course> listCourses = new ArrayList<>();
        listCourses.add(new Course("Pommes"));
        listCourses.add(new Course("Poires"));
        listCourses.add(new Course("Cerises"));
        listCourses.add(new Course("Fraises"));
        listCourses.add(new Course("Annanas"));
        listCourses.add(new Course("Litchi"));

        // adapter :
        coursesAdapter = new CoursesAdapter(listCourses);
        recyclerView.setAdapter(coursesAdapter);

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent event)
            {
                return true;
            }
        });
    }

    public void onClick(View view) {
        EditText editText = findViewById(R.id.saisie_note);
        coursesAdapter.addItem(editText.getText().toString());
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)
    {
        if (gestureDetector.onTouchEvent(motionEvent))
        {
            // récupération de l'item cliqué :
            View child = recyclerView.findChildViewUnder(motionEvent.getX(),
                    motionEvent.getY());
            // position dans la liste d'objets métier :
            if (child != null)
            {
                //permet de récupérer la position
                position = recyclerView.getChildAdapterPosition(child);

                Log.i("DEMO", "clic à la position : " + position);

                //Affiche un message avec la position clicer
                Toast.makeText(this , "clic à la position :" + position , Toast.LENGTH_LONG).show();

                return true;
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}



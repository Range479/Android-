package com.example.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private  long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    public void onStart(){
        super.onStart();
        View view =getView(); //获得片段的根视图
        if(view != null){
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }

    public void setWorkout(long id){
        this.workoutId = id;
    }

}

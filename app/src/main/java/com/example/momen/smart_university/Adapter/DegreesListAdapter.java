package com.example.momen.smart_university.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.QuizDegreesList;
import com.example.momen.smart_university.firebase.Student.Subjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AmrGamal on 16/06/2019.
 */

public class DegreesListAdapter extends RecyclerView.Adapter<DegreesListAdapter.recyclerVH> {

    List<QuizDegreesList> date = new ArrayList<>();
    Context context;

    public DegreesListAdapter(List <QuizDegreesList> name, Context context) {
        this.date = name;
        this.context = context;
    }

    @NonNull
    @Override
    public DegreesListAdapter.recyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.degrees_list_item, viewGroup, false);
        return new DegreesListAdapter.recyclerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DegreesListAdapter.recyclerVH holder, final int position) {
        TextView studentName = holder.itemView.findViewById(R.id.s_name);
        studentName.setText(date.get(position).getStudent_name());
        TextView quiz_degree = holder.itemView.findViewById(R.id.degree);
        quiz_degree.setText(String.valueOf(date.get(position).getStudent_degree()));


    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    class recyclerVH extends RecyclerView.ViewHolder {
        public recyclerVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}

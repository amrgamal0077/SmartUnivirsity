package com.example.momen.smart_university.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.momen.smart_university.R;
import com.example.momen.smart_university.firebase.Doctor.DoctorName;
import com.example.momen.smart_university.firebase.Doctor.QuizDegreesList;
import com.example.momen.smart_university.firebase.Doctor.subject;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DegreesListActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,databaseReference2;
    List<QuizDegreesList> degreesList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degrees_list);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Doctors").child(DoctorName.doctorName).child("Subjects");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                subject subject= dataSnapshot.getValue(com.example.momen.smart_university.firebase.Doctor.subject.class);
                databaseReference2=firebaseDatabase.getReference().child("Degrees").child(subject.getName());
                databaseReference2.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        QuizDegreesList  quizDegreesList =dataSnapshot.getValue(QuizDegreesList.class);
                        degreesList.add(quizDegreesList);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

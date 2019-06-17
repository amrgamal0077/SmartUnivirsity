package com.example.momen.smart_university.firebase.Doctor;

/**
 * Created by AmrGamal on 15/06/2019.
 */

public class QuizDegreesList {
    private String student_name;
    private float student_degree;
    public QuizDegreesList(String student_name, float student_degree)
    {
        this.student_degree=student_degree;
        this.student_name=student_name;
    }
    QuizDegreesList()
    {}
    public float getStudent_degree() {
        return student_degree;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_degree(float student_degree) {
        this.student_degree = student_degree;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}

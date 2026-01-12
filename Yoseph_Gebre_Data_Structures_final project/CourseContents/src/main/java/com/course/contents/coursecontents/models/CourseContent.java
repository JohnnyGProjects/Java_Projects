package com.course.contents.coursecontents.models;


import com.course.contents.coursecontents.ds.linkedlist.LinkedList;

public class CourseContent {
    private String name;
    private LinkedList<Assignment> assignments;
    private Assignment midterm;
    private Assignment finalExam;

    public CourseContent(String name, LinkedList<Assignment> assignments, Assignment midterm, Assignment finalExam) {
        this.name = name;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(LinkedList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Assignment getMidterm() {
        return midterm;
    }

    public void setMidterm(Assignment midterm) {
        this.midterm = midterm;
    }

    public Assignment getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(Assignment finalExam) {
        this.finalExam = finalExam;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Course: " + name + "\n";
        result += "Assignments: \n";
        for (int i = 0; i < assignments.size(); i++) {
            result += assignments.get(i) + "\n";
        }
        result += midterm + "\n";
        result += finalExam + "\n";
        return result;
    }
}

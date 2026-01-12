package com.course.contents.coursecontents.models;


import com.course.contents.coursecontents.models.enums.AssignmentType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Assignment implements Comparable<Assignment> {
    private String name;
    private int weight;
    private AssignmentType type;
    private LocalDate submissionDate;

    public Assignment(String name, String submissionDate, int weight) {
        this.name = name;
        this.weight = weight;
        setSubmissionDate(submissionDate);
        System.out.println(name);
        if (name.contains("Final") || name.contains("MidTerm"))
            this.type = AssignmentType.EXAM;
        else
            this.type = AssignmentType.HOMEWORK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        this.submissionDate = LocalDate.parse(submissionDate, formatter);
    }

    @Override
    public int compareTo(Assignment o) {
        //compare on submission date
        //if submission date is the same, compare on weight
        if (this.submissionDate.isEqual(o.submissionDate)) {
            return o.weight - this.weight;
        }
        return this.submissionDate.compareTo(o.submissionDate);
    }

    @Override
    public String toString() {
        String result = "";
        if (type == AssignmentType.HOMEWORK) {
            result += name + " (HW) - " + weight + "% - Due: " + submissionDate;
        }
        else {
            result += name + " (Exam) - " + weight + "% - Due: " + submissionDate;
        }
        return result;
    }
}

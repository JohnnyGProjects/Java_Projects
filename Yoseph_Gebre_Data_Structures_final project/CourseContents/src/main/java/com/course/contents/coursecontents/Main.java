package com.course.contents.coursecontents;

import com.course.contents.coursecontents.ds.dictionary.Dictionary;
import com.course.contents.coursecontents.ds.linkedlist.LinkedList;
import com.course.contents.coursecontents.ds.queue.PriorityQueue;
import com.course.contents.coursecontents.models.Assignment;
import com.course.contents.coursecontents.models.CourseContent;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class Main extends Application {
    private static final String FILENAME = "data/contents.txt";
    private static LinkedList<String> list;
    private static Dictionary<String, CourseContent> contents;
    private static PriorityQueue<Assignment> assignments;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        VBox vBox = new VBox();
        Button contentBtn = new Button("View Course Contents");
        Button assignmentBtn = new Button("View Assignments");
        TextArea tf = new TextArea();

        tf.setEditable(false);

        contentBtn.setOnAction(e -> {
            String data = "";
            Iterator<String> iterator = contents.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                data += key + "\n";
                data += contents.get(key) + "\n";
                data += "-----------------------\n";
            }
            tf.setText(data);
        });

        assignmentBtn.setOnAction(e -> {
            String data = "You should go with these assignments in ascending order\nfor better preparation:\n";
            tf.setText(data + assignments.toString());
        });


        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.getChildren().addAll(contentBtn, assignmentBtn, tf);
        root.setCenter(vBox);
        //create a scene
        Scene scene = new Scene(root, 500, 350);
        stage.setTitle("Course Contents");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        load();

        assignmentsDetails();

        //assignments.print();
        launch(args);
    }

    public static void load() {
        contents = new Dictionary<>();
        try {
            FileReader reader = new FileReader(FILENAME);
            Scanner in = new Scanner(reader);
            while (in.hasNext()) {
                list = new LinkedList<>();
                list.add(in.nextLine());
                list.add(in.nextLine());
                int numAssignments = Integer.parseInt(list.get(list.size() - 1).split(" ")[0]);
                for (int i = 0; i < numAssignments; i++) {
                    list.add(in.nextLine().split(":")[1].trim());
                    list.add(in.nextLine().split(":")[1].trim());
                    list.add(in.nextLine().split(":")[1].trim());
                }
                list.add("MidTerm");
                list.add(in.nextLine().split(":")[1].trim());
                list.add(in.nextLine().split(":")[1].trim());

                list.add("Final");
                list.add(in.nextLine().split(":")[1].trim());
                list.add(in.nextLine().split(":")[1].trim());

                CourseContent courseContent = createCourseContent();
                contents.add(courseContent.getName(), courseContent);
                if (in.hasNext()) {
                    in.nextLine();
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static CourseContent createCourseContent() {
        int index = 0;
        String name = list.get(index++);
        int numAssignments = Integer.parseInt(list.get(index++).split(" ")[0]);
        LinkedList<Assignment> assignments = new LinkedList<>();
        for (int i = 0; i < numAssignments; i++) {
            assignments.add(new Assignment(list.get(index++), list.get(index++),
                    Integer.parseInt(list.get(index++).replaceAll("%", ""))));
        }
        Assignment midTerm = new Assignment(list.get(index++), list.get(index++),
                Integer.parseInt(list.get(index++).replaceAll("%", "")));

        Assignment finalExam = new Assignment(list.get(index++), list.get(index++),
                Integer.parseInt(list.get(index++).replaceAll("%", "")));
        return new CourseContent(name, assignments, midTerm, finalExam);
    }

    public static void assignmentsDetails() {
        assignments = new PriorityQueue<>();
        for (Iterator<String> it = contents.keys(); it.hasNext(); ) {
            String key = it.next();
            for (Iterator<Assignment> iter = contents.get(key).getAssignments().iterator(); iter.hasNext(); ) {
                Assignment assignment = iter.next();
                assignments.enqueue(assignment);
            }
        }
    }
}
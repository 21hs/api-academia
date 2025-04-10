package classes;

import java.util.ArrayList;
import java.util.List;

public class WorkoutClass {
    private int id;
    private String name; // Nome da aula (ex: Spinning, Pilates)
    private String description;
    private int durationMinutes; // duração da aula em minutos
    private String instructor;
    private List<Feedback> feedbacks = new ArrayList<>();

    public WorkoutClass() {}

    public WorkoutClass(String name, String description, int durationMinutes, String instructor, List<Feedback> feedbacks) {
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.instructor = instructor;
        this.feedbacks = feedbacks;
    }

    public WorkoutClass(int id, String name, String description, int durationMinutes, String instructor, List<Feedback> feedbacks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.instructor = instructor;
        this.feedbacks = feedbacks;
    }

    public WorkoutClass(int id, String name, String description, int durationMinutes, String instructor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public String getInstructor() {
        return instructor;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }
}

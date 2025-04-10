package repository;

import java.util.ArrayList;
import java.util.List;

import classes.Feedback;
import classes.WorkoutClass;

public class WorkoutClassRepository {
    private static WorkoutClassRepository instance;
    private List<WorkoutClass> workoutClasses = new ArrayList<>();

    private static int id = 1;
    private static int idFeedback = 1;

    private WorkoutClassRepository() {
        WorkoutClass spinning = new WorkoutClass(id++, "Spinning", "Aula intensa de bicicleta estacionária", 45, "Carlos");
        spinning.addFeedback(new Feedback(idFeedback++, "Joana", "Muito puxado, mas valeu a pena!", 5));
        spinning.addFeedback(new Feedback(idFeedback++, "Pedro", "Poderia ter mais pausas", 3));
    
        WorkoutClass pilates = new WorkoutClass(id++, "Pilates", "Aula de fortalecimento e alongamento", 60, "Ana");
        pilates.addFeedback(new Feedback(idFeedback++, "Marina", "Muito boa pra alongar, adorei!", 5));
    
        WorkoutClass hiit = new WorkoutClass(id++, "HIIT", "Treino intervalado de alta intensidade", 30, "Marcos");
        hiit.addFeedback(new Feedback(idFeedback++, "Luiz", "Intenso demais pra iniciantes", 2));
    
        WorkoutClass alongamento = new WorkoutClass(id++, "Alongamento", "Aula focada em flexibilidade e relaxamento", 40, "Bruna");
        alongamento.addFeedback(new Feedback(idFeedback++, "Renata", "Bem relaxante, ótima depois da musculação", 4));
        alongamento.addFeedback(new Feedback(idFeedback++, "Felipe", "Muito leve, queria algo mais intenso", 1));
    
        workoutClasses.add(spinning);
        workoutClasses.add(pilates);
        workoutClasses.add(hiit);
        workoutClasses.add(alongamento);
    }
    

    public static WorkoutClassRepository getInstance() {
        if (instance == null) {
            instance = new WorkoutClassRepository();
        }
        return instance;
    }

    public void addWorkoutClass(WorkoutClass workoutClass) {
        workoutClass = new WorkoutClass(id++, workoutClass.getName(), workoutClass.getDescription(), workoutClass.getDurationMinutes(), workoutClass.getInstructor());
        workoutClasses.add(workoutClass);
    }

    public void addFeedback(int workoutClassId, Feedback feedback) {
        for (WorkoutClass workoutClass : workoutClasses) {
            if (workoutClass.getId() == workoutClassId) {
                feedback = new Feedback(idFeedback++, feedback.getMemberName(), feedback.getComment(), feedback.getRating());
                workoutClass.addFeedback(feedback);
                return;
            }
        }
    }

    public List<WorkoutClass> getWorkoutClasses() {
        return workoutClasses;
    }

    public WorkoutClass getWorkoutClass(int id) {
        for (WorkoutClass workoutClass : workoutClasses) {
            if (workoutClass.getId() == id) {
                return workoutClass;
            }
        }
        return null;
    }

    public void removeWorkoutClass(String name) {
        for (WorkoutClass workoutClass : workoutClasses) {
            if (workoutClass.getName().equals(name)) {
                workoutClasses.remove(workoutClass);
                return;
            }
        }
    }
}

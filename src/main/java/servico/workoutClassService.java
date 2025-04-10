package servico;

import java.util.List;

import classes.Feedback;
import classes.WorkoutClass;
import repositorio.WorkoutClassRepository;

public class workoutClassService {
    private WorkoutClassRepository WorkoutClassRepository;

    public workoutClassService(WorkoutClassRepository workoutClassRepository) {
        this.WorkoutClassRepository = workoutClassRepository;
    }

    public void addWorkoutClass(WorkoutClass workoutClass) {
        if (workoutClass.getName() == null || workoutClass.getName().isEmpty()) {
            throw new IllegalArgumentException("O nome da aula é obrigatório");
        }
        if (workoutClass.getInstructor() == null || workoutClass.getInstructor().isEmpty()) {
            throw new IllegalArgumentException("O nome do instrutor é obrigatório");
        }
        if (workoutClass.getDurationMinutes() <= 0) {
            throw new IllegalArgumentException("A duração da aula deve ser maior que 0 minutos");
        }
        WorkoutClassRepository.addWorkoutClass(workoutClass);
    }

    public void addFeedback(int idClass, Feedback feedback) {
        WorkoutClassRepository.addFeedback(idClass, feedback);
    }

    public List<WorkoutClass> getWorkoutClasses() {
        return WorkoutClassRepository.getWorkoutClasses();
    }

    public WorkoutClass getWorkoutClass(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id da aula deve ser maior que 0");
        }
        return WorkoutClassRepository.getWorkoutClass(id);
    }

    public void removeWorkoutClass(String name) {
        WorkoutClassRepository.removeWorkoutClass(name);
    }
}

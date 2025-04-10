package rotas;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import classes.WorkoutClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositorio.WorkoutClassRepository;
import servico.workoutClassService;

@WebServlet("/aulas") // endpoint atualizado
public class WorkoutClassServlet extends HttpServlet {
    private WorkoutClassRepository repository;
    private workoutClassService workoutService;

    @Override
    public void init() throws ServletException {
        this.repository = WorkoutClassRepository.getInstance();
        this.workoutService = new workoutClassService(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<WorkoutClass> workoutClasses = workoutService.getWorkoutClasses();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(workoutClasses);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        WorkoutClass workoutClass = mapper.readValue(req.getReader(), WorkoutClass.class);
        workoutService.addWorkoutClass(workoutClass);
        resp.setStatus(201);
    }
}

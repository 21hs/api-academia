package rotas;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import classes.Feedback;
import classes.WorkoutClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositorio.WorkoutClassRepository;
import servico.workoutClassService;

@WebServlet("/feedback")
public class FeedBackServlet extends HttpServlet {
    private WorkoutClassRepository repository;
    private workoutClassService workoutService;

    @Override
    public void init() throws ServletException {
        this.repository = WorkoutClassRepository.getInstance();
        this.workoutService = new workoutClassService(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<WorkoutClass> classes = workoutService.getWorkoutClasses();
        for (WorkoutClass workoutClass : classes) {
            if (workoutClass.getId() == id) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> classData = new HashMap<>();
                classData.put("workoutClass", workoutClass);
                String json = mapper.writeValueAsString(classData);
                resp.setContentType("application/json");
                resp.getWriter().write(json);
                return;
            }
        }
        resp.setStatus(404);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(req.getParameter("id"));
        Feedback feedback = mapper.readValue(req.getReader(), Feedback.class);
        List<WorkoutClass> classes = workoutService.getWorkoutClasses();
        for (WorkoutClass workoutClass : classes) {
            if (workoutClass.getId() == id) {
                workoutService.addFeedback(id, feedback);
                resp.setStatus(201);
                return;
            }
        }
        resp.setStatus(404);
    }
}

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

@WebServlet("/aulas")
public class WorkoutClassServlet extends HttpServlet {
    private WorkoutClassRepository repository;

    @Override
    public void init() throws ServletException {
        this.repository = WorkoutClassRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<WorkoutClass> classes = repository.getWorkoutClasses();

        // Criar uma lista customizada contendo apenas os campos desejados
        List<Object> simplifiedClasses = classes.stream().map(c -> {
            return new Object() {
                public int id = c.getId();
                public String name = c.getName();
                public String description = c.getDescription();
                public int durationMinutes = c.getDurationMinutes();
                public String instructor = c.getInstructor();
               
            };
        }).collect(java.util.stream.Collectors.toList());
        

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(simplifiedClasses);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}

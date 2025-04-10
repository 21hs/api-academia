import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import rotas.FeedBackServlet;
import rotas.WorkoutClassServlet;

public class Jetty {
    public static void main(String[] args) {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new WorkoutClassServlet()), "/aulas");
        context.addServlet(new ServletHolder(new FeedBackServlet()), "/feedback");

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

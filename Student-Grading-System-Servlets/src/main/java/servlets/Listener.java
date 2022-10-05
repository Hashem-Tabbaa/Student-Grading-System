package servlets;


import data.crud.student.StudentCrudImpl;
import data.crud.studentsCourses.StudentsCoursesCrudImpl;
import services.LoginService;
import services.MarksService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("The application listener will instantiate the services and add them to the servlet context")
public class Listener implements ServletContextListener {

    static final public String LoginService = "loginService";
    static final public String MarksService = "marksService";

    private final LoginService loginService;
    private final MarksService marksService;

    public Listener() {
        super();
        loginService = new LoginService(new StudentCrudImpl());
        marksService = new MarksService(new StudentsCoursesCrudImpl());
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized");
        servletContextEvent.getServletContext().setAttribute(LoginService, loginService);
        servletContextEvent.getServletContext().setAttribute(MarksService, marksService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().removeAttribute(LoginService);
        servletContextEvent.getServletContext().removeAttribute(MarksService);
    }
}

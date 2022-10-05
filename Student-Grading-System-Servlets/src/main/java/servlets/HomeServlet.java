package servlets;

import model.Statistics;
import model.StudentsCourses;
import services.MarksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private MarksService marksService;

    @Override
    public void init(){
        marksService = (MarksService) getServletContext().getAttribute(Listener.MarksService);
    }

    public HomeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("username"));
        if(request.getSession().getAttribute("username") == null){
            response.sendRedirect("/login");
            return;
        }
        List<StudentsCourses> studentsCourses = marksService.getStudentCourses
                (request.getSession().getAttribute("username").toString());
        for(StudentsCourses sc : studentsCourses){
            System.out.println(sc);
        }
        request.setAttribute("studentsCourses", studentsCourses);
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

}

package servlets;

import data.crud.studentsCourses.StudentsCoursesCrudImpl;
import model.Statistics;
import services.MarksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    private MarksService marksService;

    @Override
    public void init(){
        marksService = (MarksService) getServletContext().getAttribute(Listener.MarksService);
    }

    public StatisticsServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String course_name = request.getParameter("course_name");
        if(username == null || course_name == null){
            response.sendRedirect("/login");
            return;
        }
        System.out.println(username);
        System.out.println(course_name);
        List<Statistics> statistics = marksService.getStatistics(request.getParameter("course_name"));
        request.setAttribute("statistics", statistics);
        request.setAttribute("course_name", course_name);
        request.getRequestDispatcher("/WEB-INF/views/statistics.jsp").forward(request, response);
    }

}

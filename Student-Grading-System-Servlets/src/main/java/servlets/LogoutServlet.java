package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    public LogoutServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        req.getSession().invalidate();
        res.sendRedirect("/home");
    }


}

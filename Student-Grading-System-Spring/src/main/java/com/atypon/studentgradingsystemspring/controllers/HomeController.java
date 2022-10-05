package com.atypon.studentgradingsystemspring.controllers;

import com.atypon.studentgradingsystemspring.model.StudentsCourses;
import com.atypon.studentgradingsystemspring.services.MarksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final MarksService marksService;

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("username") == null){
            return "redirect:/login";
        }
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);

        List<StudentsCourses> studentsCourses =
                marksService.getStudentCourses((String) request.getSession().getAttribute("username"));
        for(StudentsCourses studentsCourses1 : studentsCourses){
            System.out.println(studentsCourses1);
        }
        model.addAttribute("studentsCourses", studentsCourses);
        request.setAttribute("studentCourse", new StudentsCourses());
        return "home";
    }



}

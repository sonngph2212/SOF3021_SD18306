package fpt.com.assignment.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

@Controller
@RequestMapping("/")
public class DemoAjaxController {

    @GetMapping
    public String demo(HttpServletRequest request, HttpServletResponse response) {
        return "/user/home/demo";
    }
}

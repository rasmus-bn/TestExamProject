package dk.projectsbygroup7.testproject.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello teacher";
    }
}

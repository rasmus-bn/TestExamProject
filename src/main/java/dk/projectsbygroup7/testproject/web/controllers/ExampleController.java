package dk.projectsbygroup7.testproject.web.controllers;

import dk.projectsbygroup7.testproject.pojos.Subject;
import dk.projectsbygroup7.testproject.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired // Makes spring instantiate the service automatically
    ExampleService service;

    @RequestMapping("/hello")
    public String helloWorld() {
        return service.getExampleString();
    }
}

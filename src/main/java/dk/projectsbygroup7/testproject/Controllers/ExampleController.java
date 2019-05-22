package dk.projectsbygroup7.testproject.Controllers;

import dk.projectsbygroup7.testproject.Services.ServiceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired // Makes spring instantiate the service automatically
    ServiceExample service;

    @RequestMapping("/hello")
    public String helloWorld() {
        return service.getExampleString();
    }
}

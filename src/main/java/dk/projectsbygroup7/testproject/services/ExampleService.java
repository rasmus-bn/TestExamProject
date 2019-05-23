package dk.projectsbygroup7.testproject.services;

import org.springframework.stereotype.Service;

@Service // makes sure that the spring framework can instantiate the service automatically
public class ExampleService {
    public String getExampleString() {
        return "Service String";
    }
}

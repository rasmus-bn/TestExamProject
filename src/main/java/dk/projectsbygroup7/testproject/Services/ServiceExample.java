package dk.projectsbygroup7.testproject.Services;

import org.springframework.stereotype.Service;

@Service // makes sure that the spring framework can instantiate the service automatically
public class ServiceExample {
    public String getExampleString() {
        return "Service String";
    }
}

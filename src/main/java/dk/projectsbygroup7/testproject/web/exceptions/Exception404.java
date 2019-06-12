package dk.projectsbygroup7.testproject.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "not found")
public class Exception404 extends RuntimeException {
}

package CountryApi.Exceptions;


import CountryApi.dto.HttpResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@ControllerAdvice
public class ControllerAdvicer {




    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<HttpResponse> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        Map<String, String> errorMap = new HashMap<>();
        constraintViolations.forEach(constraintViolation -> {
            errorMap.put(constraintViolation.getPropertyPath().toString(),
                    constraintViolation.getMessage());
        });

        HttpResponse response = new HttpResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setStatusMessage("Validation failed");
        response.setBody(errorMap.toString()); // You can customize the body format as needed

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

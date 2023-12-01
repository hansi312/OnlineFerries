package Config;

import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> resoucreNotFoundException(NotFoundException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        HttpHeaders h1 = new HttpHeaders();
        h1.set("msg",ex.getMessage());
        return new ResponseEntity<>(body, h1, HttpStatus.NOT_FOUND);
    }
}

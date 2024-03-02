package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Controllers;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.exceptions.FlorNoContentException;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.exceptions.FlorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleRuntimeException (RuntimeException e){
        return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(FlorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException (FlorNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FlorNoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> handleNoContentException (FlorNoContentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
    }



}

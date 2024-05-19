package co.edu.unbosque.serviciosadicionalesapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProveedorExceptionHanler {
    @ExceptionHandler(PorveedorNotFoundException.class)
    public ResponseEntity<BaseResponse> handleNotFoundException(PorveedorNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(new BaseResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}

package zw.co.getsol.blogapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity invalidRequestException(InvalidRequestException ex){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemAlreadyExistException.class)
    public ResponseEntity itemAlreadyExistException(ItemAlreadyExistException ex){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity itemAlreadyExistException(RecordNotFoundException ex){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
    }
}

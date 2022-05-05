package zw.co.getsol.blogapplication.exceptions;

import java.text.MessageFormat;

public class InvalidRequestException extends RuntimeException{
    private String value;
    private Long id;

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, String value) {
        super(MessageFormat.format(message,value));
        this.value = value;
    }

    public InvalidRequestException(String message, Long id) {
        super(MessageFormat.format(message,id));
        this.id = id;
    }
}

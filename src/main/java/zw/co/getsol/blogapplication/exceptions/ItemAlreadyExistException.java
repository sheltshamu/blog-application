package zw.co.getsol.blogapplication.exceptions;

import java.text.MessageFormat;

public class ItemAlreadyExistException extends RuntimeException{
    private Long id;
    private String value;

    public ItemAlreadyExistException(String message, Long id) {
        super(MessageFormat.format(message,id));
        this.id = id;
    }

    public ItemAlreadyExistException(String message, String value) {
        super(MessageFormat.format(message,value));
        this.value = value;
    }

    public ItemAlreadyExistException(String message) {
        super(message);
    }
}

package net.quazar.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TourRequestNotFoundException extends RuntimeException {
    public TourRequestNotFoundException() {
    }

    public TourRequestNotFoundException(String message) {
        super(message);
    }

    public TourRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourRequestNotFoundException(Throwable cause) {
        super(cause);
    }
}

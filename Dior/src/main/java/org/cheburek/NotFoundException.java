package org.cheburek;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Illegal arguments")
public class NotFoundException extends Exception
{
    public NotFoundException(String message) {
        super(message);
    }
}

package org.cheburek;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Illegal arguments")
public class ServerException extends Exception
{
    public ServerException(String message) {
        super(message);
    }
}

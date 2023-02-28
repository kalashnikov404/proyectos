package mx.badak.eva.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    public  ResourceNotFound () { super();}

    public ResourceNotFound(String mensaje){
        super(mensaje);
    }

    public ResourceNotFound(String message, Throwable cause){ super(message, cause);}
}
package mx.telcel.examen.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    /**
     *ResourceNotFound
     * Define las excepciones encontradas de una forma personalizada
     * */

    public ResourceNotFound() { super();}

    public ResourceNotFound(String mensaje){
        super(mensaje);
    }

    public ResourceNotFound(String message, Throwable cause){ super(message, cause);}
}
package mx.telcel.examen.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "operacion")

public class Operacion {
 /**
 *POJO Persona
 * Referenciando entidad persona
 * atributos y acessos
 * */

 @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private Integer id;
    private String numerouno;
    private String numerodos;
    private String nombre;


}


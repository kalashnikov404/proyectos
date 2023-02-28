package mx.badak.eva.api.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name="operacion")
public class Operacion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperacion;


    @Column(name = "numero1")
   private String numeroUno;

    @Column(name = "numero2")
    private String numeroDos;


    @Column(name = "nombre")
    private String nombre;




}

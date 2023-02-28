package mx.badak.eva.api.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="level")
public class Level implements Serializable {
    private static final long serialVersionUID = 6L;
    @Id
    @Column(name = "id_level")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLevel;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "status")
    @NotNull
    private Integer status;
}
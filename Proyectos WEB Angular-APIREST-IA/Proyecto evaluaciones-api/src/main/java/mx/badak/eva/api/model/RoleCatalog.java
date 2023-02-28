package mx.badak.eva.api.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="role_catalog")
public class RoleCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role_catalog")
    private Integer idRoleCatalog;

    @Column(name = "name")
    @NotNull
    private String name;




    @Column(name = "status")
    @NotNull
    private Integer status;

}

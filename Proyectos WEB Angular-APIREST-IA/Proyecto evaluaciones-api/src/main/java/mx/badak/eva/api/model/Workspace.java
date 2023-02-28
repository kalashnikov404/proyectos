package mx.badak.eva.api.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="workspace")
public class Workspace {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_workspace")
    private Integer idWorkspace;

    @Column(name = "name")
    @NotNull
    private String name;



    @Column(name = "logo")
    @NotNull
    private String logo;


    @Column(name = "domain")
    @NotNull
    private String domain;



    @Column(name = "background_image")
    @NotNull
    private String backgroundImage;


    @Column(name = "favicon")
    @NotNull
    private String favicon;


    @Column(name = "manager")
    @NotNull
    private String manager;


    @Column(name = "description")
    @NotNull
    private String description;


    @Column(name = "color")
    @NotNull
    private String color;




    @Column(name = "status")
    @NotNull
    private Integer status;

}

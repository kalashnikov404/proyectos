package mx.badak.eva.api.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;


    @Column(name = "status")
    @NotNull
    private Integer status;


    @Column(name = "registered_date")
    @NotNull
    private Date registeredDate;


    @Column(name = "unsubscribe_date")
    @NotNull
    private Date unsubscribe_date;





}

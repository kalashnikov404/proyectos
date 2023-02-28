package mx.badak.eva.api.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "name")
    @NotNull
    private String name;



    @Column(name = "last_name")
    @NotNull
    private String lastName;



    @Column(name = "mother_last_name")
    @NotNull
    private String motherLastName;


    @Column(name = "email")
    @NotNull
    private String email;



    @Column(name = "status")
    @NotNull
    private Integer status;


    public Person() {

    }
    private String companyName;

    public Person( String name, String  lastName, String motherLastName, String email, String companyName ) {

        this.name = name;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.email = email;
        this.companyName = companyName;

    }

    public Integer getIdPerson() {
        return idPerson;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", motherLastName='" + motherLastName + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}


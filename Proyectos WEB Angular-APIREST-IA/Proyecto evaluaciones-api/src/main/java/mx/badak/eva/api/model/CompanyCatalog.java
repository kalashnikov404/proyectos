package mx.badak.eva.api.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="company_catalog")
public class CompanyCatalog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company_catalog")
    private Integer idCompany;

    @Column(name = "name")
    @NotNull
    private String name;


    @Column(name = "status")
    @NotNull
    private Integer status;

    public CompanyCatalog( ) {

    }
    public CompanyCatalog( String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public Integer getIdCompany() {
        return idCompany;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

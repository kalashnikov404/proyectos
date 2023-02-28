package mx.badak.eva.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidate")
    private Integer idCandidate;

    @Column(name = "status")
    @NotNull
    private Integer status;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_company_catalog", referencedColumnName = "id_company_catalog", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CompanyCatalog companyCatalog;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Person person;



    public Candidate( ) {


    }

    public Candidate( Integer status) {
        this.status = status;

    }

    public Integer getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Integer idCandidate) {
        this.idCandidate = idCandidate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CompanyCatalog getCompanyCatalog() {
        return companyCatalog;
    }

    public void setCompanyCatalog(CompanyCatalog companyCatalog) {
        this.companyCatalog = companyCatalog;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

package mx.badak.eva.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({ "hibernateLazyInitializer"})
@Entity
@Data
@Table(name="question")
public class Question {
    @Id
    @Column(name = "id_question")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuestion;

    @NotNull
    private String name;

    @NotNull
    private String code;

    @NotNull
    private String image;

    @NotNull
    private Integer status;





}

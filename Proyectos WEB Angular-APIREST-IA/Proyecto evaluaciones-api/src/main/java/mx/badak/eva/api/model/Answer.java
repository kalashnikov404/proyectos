package mx.badak.eva.api.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="answer")
public class Answer {
    @Id
    @Column(name = "id_answer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnswer;

    @NotNull
    private Integer correct;

    @NotNull
    private String name;

    @NotNull
    private Integer status;
}
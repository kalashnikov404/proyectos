package mx.badak.eva.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="question_answer")
public class AnswerQuestion {
    @Id
    @Column(name = "id_question_answer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuestionAnswer;

    @NotNull
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_answer", referencedColumnName = "id_answer", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_question", referencedColumnName = "id_question", nullable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Question question;

}

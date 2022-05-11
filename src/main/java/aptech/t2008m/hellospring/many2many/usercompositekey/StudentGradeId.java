package aptech.t2008m.hellospring.many2many.usercompositekey;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class StudentGradeId implements Serializable {
    @Column(name ="grade_id")
    private int gradeId;
    @Column(name = "student_rollnumber")
    private String studentRollnumber;

}

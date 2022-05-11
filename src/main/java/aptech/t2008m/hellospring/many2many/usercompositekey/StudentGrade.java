package aptech.t2008m.hellospring.many2many.usercompositekey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students_grades")
public class StudentGrade {
    /**
     * gradeId: lớp nào
     * studentRollnumber : học sinh nào
     */
    @EmbeddedId
    private StudentGradeId id;// khóa chính phức hợp
    @ManyToOne
    @MapsId("gradeId")
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne
    @MapsId("studentRollnumber")
    @JoinColumn(name = "student_rollnumber")
    private Student student;

    public void add(Set<StudentGrade> studentGrades) {
    }
}




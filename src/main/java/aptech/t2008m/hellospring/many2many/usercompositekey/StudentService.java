package aptech.t2008m.hellospring.many2many.usercompositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student) {
        studentRepository.save(student);
        return student;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(String studentRollNumber) {
        return studentRepository.findById(studentRollNumber);
    }

    public boolean addStudentToClass(Student student, Grade grade) {
        try {
            //lấy thông tin lớp học hiện tại của sinh viên
            Set<StudentGrade> studentGrades = student.getStudentGrades();
            if (studentGrades == null) {
                // trường hợp của join lớp nào thì tạo mới set.
                studentGrades = new HashSet<>();
            }
            // tạo mới đối tượng StudentGrade
            StudentGrade studentGrade = new StudentGrade();
            //set khóa chính phức hợp
            studentGrade.setId(new StudentGradeId(grade.getId(), student.getRollNumber()));
            //set quan hệ ngược lại với grade
            studentGrade.setGrade(grade);
            //set quan hệ ngược lại với student
            studentGrade.setStudent(student);
            //đưa thông tin vào set
            studentGrades.add(studentGrade);
            //update trường studentgrades của sinh viên.
            student.setStudentGrades(studentGrades);
            //save thông tin student đồng thời là save thông tin student grade
            studentRepository.save(student);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
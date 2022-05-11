package aptech.t2008m.hellospring.many2many.usercompositekey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository <Grade,Integer>{

}

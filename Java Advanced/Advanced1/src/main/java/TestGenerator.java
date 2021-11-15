import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

import java.util.List;

public class TestGenerator {
    public static void main(String[] args) {
        ExamRepository repository = new ExamRepository();

//        System.out.println("***********GET ALL Exams***********");
//
//        List<Exam> exams = repository.g();
//
//        for (Exam exam : exams) {
//            System.out.println(exams);
//        }

        System.out.println("\n\n***********CREATE Exam***********");

        Exam exam = new Exam();
        exam.setTitle("Midterm");
        exam.setDuration((short) 90);
        repository.createExam(exam);
    }
}

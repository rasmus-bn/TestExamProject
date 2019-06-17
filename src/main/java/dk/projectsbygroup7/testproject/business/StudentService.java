package dk.projectsbygroup7.testproject.business;

import dk.projectsbygroup7.testproject.business.exceptions.BirthdayChangedException;
import dk.projectsbygroup7.testproject.business.exceptions.UnderAgeException;
import dk.projectsbygroup7.testproject.dataaccess.StudentDAO;
import dk.projectsbygroup7.testproject.paymentservice.PaymentService;
import dk.projectsbygroup7.testproject.pojos.*;
import dk.projectsbygroup7.testproject.timeservice.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    PaymentService paymentService;

    @Autowired
    TimeService time;

    public Enrollment enrollInCourse(CreditCardInfo card, Student student, int courseId) {

        int studentAge = time.calcYearlyDifference(student.getBirthday(), LocalDate.now());
        boolean isOldEnough = studentAge >= 18;
        if (!isOldEnough)
            throw new UnderAgeException();

        ArrayList<Student> studentsWithMail = studentDAO.getByEmail(student.getEmail());

        int studentId = 0;

        if (studentsWithMail.size() > 1) {
            Student studFromDb = studentsWithMail.get(0);
            LocalDate birthdayFromDB = studFromDb.getBirthday();
            if (!birthdayFromDB.equals(student.getBirthday()))
                throw new BirthdayChangedException();

            studentId = studFromDb.getId();
        }
        else {
            studentId = studentDAO.createNew(student);
        }

        Course course = new Course();
        course.setId(courseId);

        Enrollment enrollment = new Enrollment(false, student, course);

        paymentService.performPayment(card);

        System.out.println("before enroll");
        System.out.println(studentDAO.enrollToCourse(enrollment));
        System.out.println("after enroll");
        enrollment.setPaymentRecieved(true);

        return enrollment;
    }
}

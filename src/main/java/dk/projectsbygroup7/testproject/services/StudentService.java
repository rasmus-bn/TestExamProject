package dk.projectsbygroup7.testproject.services;

import dk.projectsbygroup7.testproject.dataaccess.student.StudentDAO;
import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public EnrollmentStatus enrollInCourse(CreditCardInfo card, Student student) {

        boolean isOldEnough = true;

        if (!isOldEnough)
            return EnrollmentStatus.DENIED_DUE_TO_AGE;

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




        throw new NotImplementedException();
    }
}

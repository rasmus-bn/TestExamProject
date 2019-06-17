package dk.projectsbygroup7.testproject.timeservice;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class TimeService {

    public LocalDate getNow(){
        return LocalDate.now();
    }

    public int getCurrentYear() {
        return getNow().getYear();
    }

    public int getCurrentMonth() {
        return getNow().getMonthValue();
    }

    public int getCurrentDayNo() {
        return getNow().getDayOfMonth();
    }

    public int calcYearlyDifference(LocalDate fromDate, LocalDate toDate){
        int diff = Period.between(fromDate, toDate).getYears();
        return Math.abs(diff);
    }
}

package dk.projectsbygroup7.testproject.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class TimeService {

    public LocalDate getNow(){
        return LocalDate.now();
    }

    public long calcYearlyDifference(LocalDate fromDate, LocalDate toDate){
        return YEARS.between(fromDate, toDate);
    }
}

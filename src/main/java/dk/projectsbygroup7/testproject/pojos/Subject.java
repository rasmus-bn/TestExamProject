package dk.projectsbygroup7.testproject.pojos;

public class Subject {
    String subject;
    int initYear;
    boolean is1stSemInit;

    public Subject() {
    }

    public Subject(String subject, int initYear, boolean is1stSemInit) {
        this.subject = subject;
        this.initYear = initYear;
        this.is1stSemInit = is1stSemInit;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getInitYear() {
        return initYear;
    }

    public void setInitYear(int initYear) {
        this.initYear = initYear;
    }

    public boolean isIs1stSemInit() {
        return is1stSemInit;
    }

    public void setIs1stSemInit(boolean is1stSemInit) {
        this.is1stSemInit = is1stSemInit;
    }
}

package dk.projectsbygroup7.testproject.pojos;

public class Subject {
    String name;
    int initYear;
    boolean is1stSemInit;

    public Subject() {
    }

    public Subject(String name, int initYear, boolean is1stSemInit) {
        this.name = name;
        this.initYear = initYear;
        this.is1stSemInit = is1stSemInit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

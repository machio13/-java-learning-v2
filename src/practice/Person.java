package practice;

import java.time.LocalDate;
import java.time.Period;

public record Person(String name, LocalDate birthDay, String gender) {
    public int getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }
}

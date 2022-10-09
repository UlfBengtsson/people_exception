package se.lexicon.ulf.models;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate timeOfBirth;

    public Person(String name)
    {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        name = name.trim();

        if (name.isEmpty() || name.length() < 2)
        {
            throw new IllegalArgumentException("Name must be at least two letters long");
        }

        this.name = name;
    }

    public LocalDate getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(LocalDate timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public int getAge() throws Exception {
        if (timeOfBirth == null)
        {
            throw new Exception("Date of birth not known");
        }

        LocalDate today = LocalDate.now();


        return today.getYear() - timeOfBirth.getYear();
    }
}

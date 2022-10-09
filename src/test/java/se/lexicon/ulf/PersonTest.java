package se.lexicon.ulf;

import org.junit.Test;
import se.lexicon.ulf.models.Person;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class PersonTest
{

    @Test
    public void createPersonOk()
    {
        Person person;

        person = new Person("Test");

        assertNotNull( person );
        assertEquals("Test", person.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPersonBad()
    {
        Person person;

        person = new Person("");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createPersonBadSpace()
    {
        Person person;

        person = new Person(" ");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createPersonBadTwoSpace()
    {
        Person person;

        person = new Person("  ");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createPersonBadSpaceLetterSpace()
    {
        Person person;

        person = new Person(" T ");

    }

    @Test
    public void setPersonBirthDate()
    {
        Person person;
        person = new Person(" Test ");

        person.setTimeOfBirth(LocalDate.of(1982,8,25));
        //person.setTimeOfBirth(LocalDate.parse("1982-08-25"));

        assertEquals(1982, person.getTimeOfBirth().getYear());
        assertEquals(Month.AUGUST, person.getTimeOfBirth().getMonth());
        assertEquals(25, person.getTimeOfBirth().getDayOfMonth());
    }

    @Test
    public void setPersonBirthDateParse()
    {
        Person person;
        person = new Person(" Test ");

        person.setTimeOfBirth(LocalDate.parse("1982-08-25"));

        assertEquals(1982, person.getTimeOfBirth().getYear());
        assertEquals(Month.AUGUST, person.getTimeOfBirth().getMonth());
        assertEquals(25, person.getTimeOfBirth().getDayOfMonth());
    }

    @Test(expected = DateTimeParseException.class)
    public void setPersonBirthDateParseBad()
    {
        Person person;
        person = new Person(" Test ");

        person.setTimeOfBirth(LocalDate.parse("80-52-82"));

    }

    @Test
    public void PersonAge()
    {
        Person person;
        person = new Person(" Test ");
        person.setTimeOfBirth(LocalDate.of(1982,8,25));
        int age = 0;
        int ageOffset = LocalDate.now().getYear() - 2019;// Not a good solution but at them moment we can´t get around LocalDate.now

        try {
            age = person.getAge();
        }
        catch(Exception e)
        {
            age = -1;
        }

        assertEquals((37 + ageOffset), age);
    }

    @Test(expected = Exception.class)
    public void PersonAgeNoBirthDate() throws Exception
    {
        Person person;
        person = new Person(" Test ");

        person.getAge();
    }
}

package crud.spring.dao;

import crud.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18, "ppp@com"));
        people.add(new Person(++PEOPLE_COUNT, "Alex", 25, "top@.mop"));
        people.add(new Person(++PEOPLE_COUNT, "Duk", 13, "ops@.pops"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 87, "ops@.old"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(Person updatePerson, int id) {
        Person toBeUpdated = show(id);
        toBeUpdated.setName(updatePerson.getName());
        toBeUpdated.setAge(updatePerson.getAge());
        toBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

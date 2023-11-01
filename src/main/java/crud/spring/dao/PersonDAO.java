package crud.spring.dao;

import crud.spring.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/personApp1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "javadb";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));


                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person show(int id) {
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Person VALUES (1,?,?,?)");
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Person updatePerson, int id) {
        Person toBeUpdated = show(id);
        toBeUpdated.setName(updatePerson.getName());
        toBeUpdated.setAge(updatePerson.getAge());
        toBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }
}

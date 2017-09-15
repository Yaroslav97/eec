package ua.nure.poliakov.Practice10.task4.db;

import ua.nure.poliakov.Practice10.task4.connection.Close;
import ua.nure.poliakov.Practice10.task4.connection.Connect;
import ua.nure.poliakov.Practice10.task4.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO extends Manager implements DAO {

    private static final String INSERT_USERS = "INSERT INTO users (login, pass, id_role, `name`) VALUES (?,?,?,?)";
    private static final String UPDATE_USERS = "UPDATE users SET name=? WHERE login=?";
    private static final String SELECT = "SELECT * FROM users;";

    private User user;
    private Connect connection;

    @Override
    public void insert(User user) {
        connection = new Connect();
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(INSERT_USERS)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, user.getRole_id());
            preparedStatement.setString(4, user.getName());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateName(String name, String login) {
        connection = new Connect();
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(UPDATE_USERS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, login);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {
        connection = new Connect();
        user = new User();

        Statement statement = null;
        ResultSet result = null;

        try {
            statement = connection.getConnection().createStatement();
            result = statement.executeQuery(SELECT);

            while (result.next()) {

                user.setLogin(result.getString("login"));
                user.setPass(result.getString("pass"));
                user.setRole_id(result.getString("id_role"));
                user.setName(result.getString("name"));

                System.out.println(user);

                Manager.add(user.getLogin(), user.getPass(), user.getRole_id(), user.getName());
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Close.close(result);
            Close.close(statement);
        }
        return getAll();
    }
}
package ua.nure.poliakov.Practice8.DBManagers;

import ua.nure.poliakov.Practice8.connection.Close;
import ua.nure.poliakov.Practice8.connection.Connect;
import ua.nure.poliakov.Practice8.entity.User;
import ua.nure.poliakov.Practice8.managers.UserManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDBManager extends UserManager {
    private static final String INSERT_USERS = "INSERT INTO users (login) VALUES (?)";
    private static final String SELECT_USERS = "SELECT * FROM users";
    private static final String SELECT_USERS_BY_LOGIN = "SELECT * FROM users WHERE login=?";

    private User user;
    private Connect connection;

    public void insertUser(User user) {
        connection = new Connect();
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(INSERT_USERS)) {
            String u = getUser(user.getLogin()) + "";
            if (!u.equals(user.getLogin())) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.execute();
            } else {
                System.out.println("login: " + user.getLogin() + " already exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close.close(connection.getConnection());
        }
    }

    public  List<User> findAllUser() {
        connection = new Connect();
        user = new User();
        ResultSet result = null;
        try (Statement statement = connection.getConnection().createStatement()) {
            result = statement.executeQuery(SELECT_USERS);
            while (result.next()) {
                user.setLogin(result.getString("login"));
                //System.out.println(user);
                if (!getLogins().contains(user.getLogin())) {
                    UserManager.add(user.getLogin());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(result);
            Close.close(connection.getConnection());
        }
        return getUsers();
    }

    public User getUser(String login) {
        connection = new Connect();
        user = new User();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_USERS_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(connection.getConnection());
        }
        return user;
    }
}
package ua.nure.poliakov.SummaryTask4.dao.edition_dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import ua.nure.poliakov.SummaryTask4.dao.close.Close;
import ua.nure.poliakov.SummaryTask4.dao.entity.Edition;
import ua.nure.poliakov.SummaryTask4.dao.connection.PoolConnection;
import ua.nure.poliakov.SummaryTask4.dao.user_dao.UserDAO;
import ua.nure.poliakov.SummaryTask4.dao.user_dao.UserDAOImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditionDAOImplement implements EditionDAO {

    private static final String INSERT_INTO_EDITIONS = "INSERT INTO editions (`name`, subject, price) VALUES(?,?,?)";
    private static final String INSERT_INTO_SUBSCRIBES = "INSERT INTO subscribes (login, edition) VALUES(?,?)";
    private static final String UPDATE_EDITIONS = "UPDATE editions SET name=?, subject=?, price=? WHERE id=?";
    private static final String DELETE_EDITIONS = "DELETE FROM editions WHERE id=?";
    private static final String DELETE_SUBSCRIBE = "DELETE FROM subscribes WHERE login=? AND edition=?";
    private static final String SELECT_EDITIONS = "SELECT * FROM editions WHERE id=?";
    private static final String SELECT_ALL_EDITIONS_SORT_BY_ID = "SELECT * FROM editions ORDER BY id";
    private static final String SELECT_ALL_EDITIONS_SORT_BY_NAME = "SELECT * FROM editions ORDER BY name";
    private static final String SELECT_ALL_EDITIONS_SORT_BY_SUBJECT = "SELECT * FROM editions ORDER BY subject";
    private static final String SELECT_ALL_EDITIONS_SORT_BY_PRICE = "SELECT * FROM editions ORDER BY price";
    private static final String SELECT_SUBSCRIBE = "SELECT login, edition FROM subscribes WHERE login=? AND edition=?";
    private static final String SELECT_ID = "SELECT id FROM editions WHERE id=?";
    private static final String SELECT_ALL_SUBSCRIBES_BY_LOGIN = "SELECT * FROM subscribes WHERE login=?";
    private static final String SELECT_EDITION_BY_NAME_AND_SUBJECT = "SELECT * FROM editions WHERE `name`=? && subject=?";
    private static final String SELECT_BY_NAME = "SELECT * FROM editions WHERE name LIKE ? ORDER BY name";
    private static final String SELECT_BY_PRICE = "SELECT * FROM editions WHERE price BETWEEN ? AND ? ORDER BY price";
    private static final String SELECT_BY_SUB = "SELECT editions.*, count(subscribes.login) " +
            "FROM editions, subscribes WHERE editions.id = subscribes.edition GROUP BY subscribes.edition " +
            "ORDER BY editions.name";
    private static final String SELECT_EDITION_INFO = "SELECT editions.id, editions.name, editions.subject, " +
            "count(subscribes.login), sum(editions.price) FROM editions, subscribes " +
            "WHERE editions.id=? AND editions.id = subscribes.edition GROUP BY subscribes.edition ORDER BY editions.name";
    private static final String SELECT_EDITION_BY_SUBJECT = "SELECT * FROM editions WHERE subject=? ORDER BY name";

    private ComboPooledDataSource dataSource = PoolConnection.getPool();
    private UserDAO userDAO = new UserDAOImplement();
    private Edition edition;

    @Override
    public void addEdition(Edition edition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_EDITIONS);
            preparedStatement.setString(1, edition.getName());
            preparedStatement.setString(2, edition.getSubject());
            preparedStatement.setDouble(3, edition.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(preparedStatement);
            Close.close(connection);
        }
    }

    @Override
    public void updateEdition(Edition edition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_EDITIONS);
            preparedStatement.setString(1, edition.getName());
            preparedStatement.setString(2, edition.getSubject());
            preparedStatement.setDouble(3, edition.getPrice());
            preparedStatement.setInt(4, edition.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(preparedStatement);
            Close.close(connection);
        }
    }

    @Override
    public void deleteEdition(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_EDITIONS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(preparedStatement);
            Close.close(connection);
        }
    }

    @Override
    public Edition getEdition(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_EDITIONS);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                edition = new Edition(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("subject"),
                        resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return edition;
    }

    @Override
    public List<Edition> getAllSortEditions(String sort) {
        List<Edition> editionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            switch (sort) {
                case "id":
                    preparedStatement = connection.prepareStatement(SELECT_ALL_EDITIONS_SORT_BY_ID);
                    break;
                case "name":
                    preparedStatement = connection.prepareStatement(SELECT_ALL_EDITIONS_SORT_BY_NAME);
                    break;
                case "subject":
                    preparedStatement = connection.prepareStatement(SELECT_ALL_EDITIONS_SORT_BY_SUBJECT);
                    break;
                case "price":
                    preparedStatement = connection.prepareStatement(SELECT_ALL_EDITIONS_SORT_BY_PRICE);
                    break;
                case "rank":
                    preparedStatement = connection.prepareStatement(SELECT_BY_SUB);
                    break;
                default:
                    preparedStatement = connection.prepareStatement(SELECT_ALL_EDITIONS_SORT_BY_SUBJECT);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionList.add(new Edition(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("subject"),
                        resultSet.getDouble("price"),
                        sort.equals("rank") ? resultSet.getInt(5) : 0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return editionList;
    }

    @Override
    public boolean isContains(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isContain = false;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt("id") == id) {
                    isContain = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return isContain;
    }

    @Override
    public void subscribe(String login, int idEdition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_SUBSCRIBES);
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, idEdition);
            preparedStatement.executeUpdate();
            userDAO.updateScore(login, "withdraw", getEdition(idEdition).getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(preparedStatement);
            Close.close(connection);
        }
    }

    @Override
    public boolean isSubscribe(String login, int idEdition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isSubscribe = false;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_SUBSCRIBE);
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, idEdition);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("login").equals(login) &&
                        resultSet.getInt("edition") == idEdition) {
                    isSubscribe = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return isSubscribe;
    }

    @Override
    public List<Edition> getAllSubscribes(String login) {
        List<Edition> editionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_SUBSCRIBES_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionList.add(new Edition(
                        getEdition(resultSet.getInt("edition")).getId(),
                        getEdition(resultSet.getInt("edition")).getName(),
                        getEdition(resultSet.getInt("edition")).getSubject(),
                        getEdition(resultSet.getInt("edition")).getPrice()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return editionList;
    }

    @Override
    public void unsubscribe(String login, int idEdition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_SUBSCRIBE);
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, idEdition);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(preparedStatement);
            Close.close(connection);
        }
    }

    @Override
    public boolean isSameEdition(String name, String subject) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean same = false;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_EDITION_BY_NAME_AND_SUBJECT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, subject);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("name").equals(name) &&
                        resultSet.getString("subject").equals(subject)) {
                    same = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return same;
    }

    @Override
    public List<Edition> searchByName(String name) {
        List<Edition> editionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionList.add(new Edition(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("subject"),
                        resultSet.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return editionList;
    }

    @Override
    public List<Edition> filterByPrice(double from, double to) {
        List<Edition> editionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BY_PRICE);
            preparedStatement.setDouble(1, from);
            preparedStatement.setDouble(2, to);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionList.add(new Edition(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("subject"),
                        resultSet.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return editionList;
    }

    @Override
    public List<Edition> getEditionInfo(int id) {
        List<Edition> editionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_EDITION_INFO);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionList.add(new Edition(
                        resultSet.getInt("editions.id"),
                        resultSet.getString("editions.name"),
                        resultSet.getString("editions.subject"),
                        resultSet.getDouble(5),
                        resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return editionList;
    }

    @Override
    public List<Edition> getEditionsBySubject(String subject) {
        List<Edition> editionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_EDITION_BY_SUBJECT);
            preparedStatement.setString(1, subject);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionList.add(new Edition(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("subject"),
                        resultSet.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(preparedStatement);
            Close.close(connection);
        }
        return editionList;
    }
}

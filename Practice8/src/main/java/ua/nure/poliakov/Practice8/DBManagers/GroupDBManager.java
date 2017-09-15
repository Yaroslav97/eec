package ua.nure.poliakov.Practice8.DBManagers;

import ua.nure.poliakov.Practice8.connection.Close;
import ua.nure.poliakov.Practice8.connection.Connect;
import ua.nure.poliakov.Practice8.entity.Group;
import ua.nure.poliakov.Practice8.entity.User;
import ua.nure.poliakov.Practice8.managers.GroupManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDBManager extends GroupManager {
    private static final String INSERT_GROUPS = "INSERT INTO groups (name) VALUES (?)";
    private static final String UPDATE_GROUPS = "UPDATE groups SET name=? WHERE id=?";
    private static final String DELETE_GROUPS = "DELETE FROM groups WHERE name=?";
    private static final String SELECT_BY_NAME = "SELECT * FROM groups WHERE name=?";
    private static final String SELECT_FROM_GROUPS = "SELECT * FROM groups";
    private static final String SELECT_FROM_UG = "SELECT * FROM usergroups WHERE user=?";
    private static final String INSERT_USERGROUPS = "INSERT INTO usergroups (user, `group`) VALUES (?, ?)";

    private Connect connection;
    private Group group;

    public void insertGroup(Group group) {
        connection = new Connect();
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(INSERT_GROUPS)) {
            String g = getGroup(group.getName()).toString() + "";
            if (!g.equals(group.getName())) {
                preparedStatement.setString(1, group.getName());
                preparedStatement.execute();
            } else {
                System.out.println("group: " + group.getName() + " already exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(connection.getConnection());
        }
    }

    public List<Group> findAllGroup() {
        group = new Group();
        connection = new Connect();
        ResultSet resultSet = null;
        try (Statement statement = connection.getConnection().createStatement()) {
            resultSet = statement.executeQuery(SELECT_FROM_GROUPS);
            while (resultSet.next()) {
                group.setName(resultSet.getString("name"));
                //System.out.println(group);
                if (!getNames().contains(group.getName())) {
                    add(group.getName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(connection.getConnection());
        }
        return getGroups();
    }

    public Group getGroup(String name) {
        group = new Group();
        connection = new Connect();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_BY_NAME)) {
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                group.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(connection.getConnection());
        }
        return group;
    }

    public void deleteGroup(Group group) {
        connection = new Connect();
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_GROUPS)) {
            preparedStatement.setString(1, group.getName());
            preparedStatement.executeUpdate();
            System.out.println("group: " + group.getName() + " is removed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(connection.getConnection());
        }
    }

    public void updateGroup(Group group, int id) {
        connection = new Connect();
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(UPDATE_GROUPS)) {
            preparedStatement.setString(1, group.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println("update group: " + group);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Close.close(connection.getConnection());
        }
    }

    public void setGroupsForUser(User user, Group... groups) throws SQLException {
        connection = new Connect();
        connection.getConnection().setAutoCommit(false);

        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(INSERT_USERGROUPS)) {

            for (int i = 0; i < groups.length; i++) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, groups[i].getName());
                preparedStatement.execute();
            }

            connection.getConnection().commit();
            System.out.println("added successfully");

        } catch (SQLException e) {
            System.out.println(e);
            connection.getConnection().rollback();
        } finally {
            Close.close(connection.getConnection());
        }
    }

    public List<String> getUserGroups(User login) {
        ResultSet resultSet = null;
        connection = new Connect();

        List<String> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_FROM_UG)) {
            preparedStatement.setString(1, login.getLogin());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(resultSet);
            Close.close(connection.getConnection());
        }
        return list;
    }
}
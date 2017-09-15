package ua.nure.poliakov.Practice10.task4.db;

import ua.nure.poliakov.Practice10.task4.entity.User;

import java.util.List;

public interface DAO<T extends User> {
   void insert(T object);
   void updateName(String name, String login);
   List<T> getAllUser();
}
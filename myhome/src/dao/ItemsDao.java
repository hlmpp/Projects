package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsDao {

    public List<Items> getAllItems() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Items> itemsList = new ArrayList<>();

        try {
            connection = DBHelper.getConnection();
            String sql = "select * from items;";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
               Items item = new Items();
               item.setId(resultSet.getInt("id"));
               item.setName(resultSet.getString("name"));
               item.setCity(resultSet.getString("city"));
               item.setNumber(resultSet.getInt("number"));
               item.setPrice(resultSet.getInt("price"));
               item.setPicture(resultSet.getString("picture"));

               itemsList.add(item);
            }

            return itemsList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }

                if (statement != null) {
                    statement.close();
                    statement = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Items getItemsById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Items> itemsList = new ArrayList<>();

        try {
            connection = DBHelper.getConnection();
            String sql = "select * from items WHERE id=?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setCity(resultSet.getString("city"));
                item.setNumber(resultSet.getInt("number"));
                item.setPrice(resultSet.getInt("price"));
                item.setPicture(resultSet.getString("picture"));

                return item;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {

                    resultSet.close();
                    resultSet = null;
                }

                if (statement != null) {
                    statement.close();
                    statement = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Items> getViewList(String list) {

        List<Items> itemsList = new ArrayList<>();

        if (list != null && list.length() > 0) {
            String[] arr = list.split(",");

            if (arr.length >= 5) {
                for (int i = arr.length - 1; i >= arr.length - 5; i--) {
                    itemsList.add(getItemsById(Integer.parseInt(arr[i])));
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    itemsList.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            return itemsList;
        } else {
            return null;
        }

    }
}

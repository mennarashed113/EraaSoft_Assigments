package com.item.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;

public class ItemServiceImpl implements ItemService {

	private DataSource dataSource;
	
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean addItem(Item item) {
		 Connection connection = null;
	        Statement statement = null;
	        try {
	            connection = dataSource.getConnection();
	            statement = connection.createStatement();

	            String sql = "INSERT INTO items (NAME, PRICE, TOTAL_NUMBER) VALUES ('"
	                    + item.getName() + "', "
	                    + item.getPrice() + ", "
	                    + item.getTotalNumber() + ")";

	            System.out.println("sql --> " + sql);
	            statement.execute(sql);

	            return true;
	        } catch (SQLException e) {
	        	System.out.println("---> " + e.getMessage());
	        } finally {
	            try {
	                if (connection != null) connection.close();
	                if (statement != null) statement.close();
	            } catch (SQLException e) {
	            	System.out.println("---> " + e.getMessage());
	            }
	        }
	        
	        return false;
	}

	@Override
	public boolean removeItem(Long id) {
		Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "DELETE FROM items WHERE id = " + id;

            statement.execute(sql);
            
            return true;
        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
        return false;
	}

	@Override
	public boolean editItem(Item item) {
		Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "UPDATE items SET NAME = '" + item.getName() + "', "
                    + "PRICE = " + item.getPrice() + ", "
                    + "TOTAL_NUMBER = " + item.getTotalNumber()
                    + " WHERE id = " + item.getId();

            statement.execute(sql);
            return true;
        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
        return false;
	}

	@Override
	public Item loadItem(Long id) {
		Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            
            String sql = "SELECT * FROM items WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql); // 1 row

            Item item = new Item();
            if (resultSet.next()) {
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setTotalNumber(resultSet.getInt("total_number"));
            }

            return item;

        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
        return null;
	}

	@Override
	public List<Item> loadItems() {
		Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM items ORDER BY id";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Item> items = new ArrayList<>();
            
            while (resultSet.next()) { // 5
                Item item = new Item();

                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setTotalNumber(resultSet.getInt("total_number"));

                items.add(item);
            }

            return items;

        } catch (SQLException e) {
            System.out.println("---> " + e.getMessage());
        } finally {
              try {
            	  if (connection != null) connection.close();
            	  if (statement != null) statement.close();
			} catch (SQLException e) {
				System.out.println("---> " + e.getMessage());
			}
              
        }
        return new ArrayList<>();
	}

}

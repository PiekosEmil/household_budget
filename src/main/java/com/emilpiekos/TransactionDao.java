package com.emilpiekos;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class TransactionDao {

    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/household", "root", "javadev");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            ;
        }
    }

    public void insertTransaction() {
        UsersInOut.printText("Input type income/outgo");
        String type = UsersInOut.inputText();
        UsersInOut.printText("Input description (Max. 100 chars)");
        String description = UsersInOut.inputText();
        UsersInOut.printText("Input amount");
        BigDecimal amount = BigDecimal.valueOf(UsersInOut.inputNumber());
        UsersInOut.printText("Input date (YYYY-MM-DD HH:MM:SS)");
        Timestamp date = Timestamp.valueOf(UsersInOut.inputText());
        try {
            String sql = "INSERT INTO household.transactions (type, description, amount, date) VALUE (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setBigDecimal(3, amount);
            preparedStatement.setTimestamp(4, date);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Something went wrong! Try again!");
        }
    }

    public void updateTransaction() {
        UsersInOut.printText("Which transaction would you like to update?");
        Integer id = UsersInOut.inputNumber();
        printTransaction(id);
        UsersInOut.printText("What would you like to update?");
        UsersInOut.printUpdatingOptions();
        Integer option = UsersInOut.inputNumber();
        switch (option) {
            case 1 -> {
                updateId(id);
            }
            case 2 -> {
                updateType(id);
            }
            case 3 -> {
                updateDescription(id);
            }
            case 4 -> {
                updateAmount(id);
            }
            case 5 -> {
                updateDate(id);
            }
            default -> System.out.println("Invalid option");
        }

    }

    private void updateDate(Integer id) {
        try {
            UsersInOut.printText("Input new transaction date:");
            String newDate = UsersInOut.inputText();
            String sql = "UPDATE household.transactions SET date = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newDate);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Transaction updated: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Something went wrong! Try again!");
        }
    }

    private void updateAmount(Integer id) {
        try {
            UsersInOut.printText("Input new transaction amount:");
            Integer newAmount = UsersInOut.inputNumber();
            String sql = "UPDATE household.transactions SET amount = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newAmount);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Transaction updated: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Something went wrong! Try again!");
        }
    }

    private void updateDescription(Integer id) {
        try {
            UsersInOut.printText("Input new transaction description:");
            String newDescription = UsersInOut.inputText();
            String sql = "UPDATE household.transactions SET description = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newDescription);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Transaction updated: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Something went wrong! Try again!");
        }
    }

    private void updateType(Integer id) {
        try {
            UsersInOut.printText("Input new transaction type:");
            String newType = UsersInOut.inputText();
            String sql = "UPDATE household.transactions SET type = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newType);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Transaction updated: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Something went wrong! Try again!");
        }
    }

    private void updateId(Integer id) {
        try {
            UsersInOut.printText("Input new transaction id:");
            Integer newId = UsersInOut.inputNumber();
            String sql = "UPDATE household.transactions SET id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newId);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Transaction updated: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Something went wrong! Try again!");
        }
    }

    public void deleteTransaction() {
        UsersInOut.printText("Which transaction would you like to delete?");
        Integer id = UsersInOut.inputNumber();
        try {
            String sql = "DELETE FROM household.transactions WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            UsersInOut.printText("Transaction deleted: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Conection failed!");
        }
    }

    public void showTransactions(String typeEnum) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM household.transactions WHERE type = ?");
            preparedStatement.setString(1, typeEnum);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
                System.out.printf("%d, %s, %s, %.2f, %tF %tR\n", id, type, description, amount, date, date);
            }
        } catch (SQLException e) {
            System.out.println("Conection failed!");
        }
    }

    private void printTransaction(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM household.transactions WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer id1 = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
                System.out.printf("%d, %s, %s, %.2f, %tF %tR\n", id1, type, description, amount, date, date);
            }
        } catch (SQLException e) {
            System.out.println("Conection failed!");
        }
    }
}
package com.codegym.finalproject.service;

import com.codegym.finalproject.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements IService<Room>{
    Connection connection = ConnectToMySQL.getConnection();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public RoomService(){

    }
    @Override
    public void add(Room room) {
        String sql = "insert into room (customerName, phone, time, idPayment, note) \n" +
                "values (?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,room.getCustomerName());
            preparedStatement.setString(2,room.getPhone());
            preparedStatement.setString(3,room.getTime());
            preparedStatement.setInt(4,room.getIdPayment());
            preparedStatement.setString(5, room.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Room room) {
        String sql = "update room\n" +
                "set customerName = ?, phone = ?, time = ?, idPayment = ?, note = ?\n" +
                "where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,room.getCustomerName());
            preparedStatement.setString(2,room.getPhone());
            preparedStatement.setString(3,room.getTime());
            preparedStatement.setInt(4,room.getIdPayment());
            preparedStatement.setString(5, room.getNote());
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from room where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }

    @Override
    public Room findById(int id) {
        Room room = null;
        String sql = "select * from room where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
                String customerName = resultSet.getString("customerName");
                String phone = resultSet.getString("phone");
                String time = resultSet.getString("time");
                int idPayment = resultSet.getInt("idPayment");
                String note = resultSet.getString("note");
                room = new Room(id,customerName,phone,time,idPayment,note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return room;
    }

    @Override
    public List<Room> getAll() {
        List<Room> roomList = new ArrayList<>();
        String sql = "select a.*, b.name as paymentName from room a join paymentMethod b on a.idPayment = b.id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String customerName = resultSet.getString("customerName");
                String phone = resultSet.getString("phone");
                String time = resultSet.getString("time");
                int idPayment = resultSet.getInt("idPayment");
                String note = resultSet.getString("note");
                String paymentName = resultSet.getString("paymentName");
                Room room = new Room(id,customerName,phone,time,idPayment,note,paymentName);
                roomList.add(room);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomList;
    }

    public boolean checkValidatePhone (String phone){
        String phoneRegex = "^(0[3|5|7|8|9])+([0-9]{8})$";
        return !phone.matches(phoneRegex);
    }

    public boolean checkExistPhone(String phone){
        String sql = "select * from room where phone = ?;";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Room> showRoomByName(String customerName){
        List<Room> roomList = new ArrayList<>();
        String sql = "select a.*,b.name as paymentName from room a join paymentMethod b on a.idPayment = b.id where customerName like ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+customerName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                customerName = resultSet.getString("customerName");
                String phone = resultSet.getString("phone");
                String time = resultSet.getString("time");
                int idPayment = resultSet.getInt("idPayment");
                String note = resultSet.getString("note");
                String paymentName = resultSet.getString("paymentName");
                Room room = new Room(id,customerName,phone,time,idPayment,note,paymentName);
                roomList.add(room);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomList;
    }

    public boolean checkValidDate(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(time, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

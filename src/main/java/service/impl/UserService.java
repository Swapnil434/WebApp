package service.impl;

import dto.User;
import dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<dto.User> getUsers() {
        List<dto.User> users = new ArrayList<>();
        String sql = "SELECT * FROM public.HMC";

        try (Connection conn = dbconnection.DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("checkin"),
                        rs.getString("checkout"),
                        rs.getString("roomtype")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(String username, String email, String checkin, String checkout, String roomtype) {
        String sql =  "INSERT INTO \"user\" ( username, email, checkin, checkout, roomtype) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection conn = dbconnection.DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, checkin);
            stmt.setString(4, checkout);
            stmt.setString(5, roomtype);

            stmt.executeUpdate();
            System.out.println("User inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

       }

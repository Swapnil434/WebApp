package service.impl;

import dto.User;
import dbconnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM public.\"HMC\"";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("checkin"),
                        rs.getString("checkout"),
                        rs.getString("roomtype")
                );
                user.setId(rs.getInt("id"));

                String foodItemsStr = rs.getString("fooditems");
                if (foodItemsStr != null && !foodItemsStr.isEmpty()) {
                    user.setFoodItems(Arrays.asList(foodItemsStr.split(",")));
                }

                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO public.\"HMC\" (username, email, checkin, checkout, roomtype, fooditems) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCheckin());
            stmt.setString(4, user.getCheckout());
            stmt.setString(5, user.getRoomtype());

            String foodItemsStr = user.getFoodItems() != null ?
                    String.join(",", user.getFoodItems()) : "";
            stmt.setString(6, foodItemsStr);

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE public.\"HMC\" SET username=?, email=?, checkin=?, checkout=?, roomtype=?, fooditems=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCheckin());
            stmt.setString(4, user.getCheckout());
            stmt.setString(5, user.getRoomtype());

            String foodItemsStr = user.getFoodItems() != null ?
                    String.join(",", user.getFoodItems()) : "";
            stmt.setString(6, foodItemsStr);

            stmt.setInt(7, user.getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM public.\"HMC\" WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

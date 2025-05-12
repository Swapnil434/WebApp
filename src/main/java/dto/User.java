package dto;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String checkin;
    private String checkout;
    private String roomtype;
    private List<String> foodItems;

    public User() {
    }

    public User(String username, String email, String checkin, String checkout, String roomtype) {
        this.username = username;
        this.email = email;
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomtype = roomtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<String> foodItems) {
        this.foodItems = foodItems;
    }
}

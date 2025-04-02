//package servletcontroller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////@WebServlet("/Register")
//public class RegistrationServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Get form parameters
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
//        String dob = request.getParameter("dob");
//        String gender = request.getParameter("gender");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String country = request.getParameter("country");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String confirmPassword = request.getParameter("confirmPassword");
//        String terms = request.getParameter("terms");
//
//        // Server-side validation
//        String errorMessage = validateRegistration(
//                firstName, lastName, dob, gender, email, phone,
//                address, country, username, password, confirmPassword, terms
//        );
//
//        if (errorMessage != null) {
//            // Set error message and preserve form data
//            request.setAttribute("errorMessage", errorMessage);
//            request.setAttribute("firstName", firstName);
//            request.setAttribute("lastName", lastName);
//            request.setAttribute("dob", dob);
//            request.setAttribute("gender", gender);
//            request.setAttribute("email", email);
//            request.setAttribute("phone", phone);
//            request.setAttribute("address", address);
//            request.setAttribute("country", country);
//            request.setAttribute("username", username);
//
//            // Forward back to the form page
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//        } else {
//            // Successful registration - redirect to success page
//            response.sendRedirect("success.jsp");
//        }
//    }
//
//    private String validateRegistration(
//            String firstName, String lastName, String dob, String gender,
//            String email, String phone, String address, String country,
//            String username, String password, String confirmPassword, String terms) {
//
//        // Validate first name
//        if (firstName == null || firstName.trim().isEmpty()) {
//            return "First name is required";
//        } else if (firstName.trim().length() < 2) {
//            return "First name must be at least 2 characters";
//        }
//
//        // Validate last name
//        if (lastName == null || lastName.trim().isEmpty()) {
//            return "Last name is required";
//        } else if (lastName.trim().length() < 2) {
//            return "Last name must be at least 2 characters";
//        }
//
//        // Validate date of birth
//        if (dob == null || dob.trim().isEmpty()) {
//            return "Date of birth is required";
//        }
//
//        // Validate gender
//        if (gender == null || gender.trim().isEmpty()) {
//            return "Gender is required";
//        }
//
//        // Validate email
//        if (email == null || email.trim().isEmpty()) {
//            return "Email is required";
//        } else if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
//            return "Please enter a valid email address";
//        }
//
//        // Validate phone
//        if (phone == null || phone.trim().isEmpty()) {
//            return "Phone number is required";
//        } else if (!phone.matches("\\d{10}")) {
//            return "Please enter a valid 10-digit phone number";
//        }
//
//        // Validate address
//        if (address == null || address.trim().isEmpty()) {
//            return "Address is required";
//        } else if (address.trim().length() < 10) {
//            return "Address must be at least 10 characters";
//        }
//
//        // Validate country
//        if (country == null || country.trim().isEmpty()) {
//            return "Country is required";
//        }
//
//        // Validate username
//        if (username == null || username.trim().isEmpty()) {
//            return "Username is required";
//        } else if (username.trim().length() < 4) {
//            return "Username must be at least 4 characters";
//        }
//
//        // Validate password
//        if (password == null || password.trim().isEmpty()) {
//            return "Password is required";
//        } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
//            return "Password must contain at least 8 characters, including uppercase, lowercase, and a number";
//        }
//
//        // Validate confirm password
//        if (!password.equals(confirmPassword)) {
//            return "Passwords do not match";
//        }
//
//        // Validate terms
//        if (terms == null) {
//            return "You must agree to the terms and conditions";
//        }
//
//        return null; // No errors
//    }
//}
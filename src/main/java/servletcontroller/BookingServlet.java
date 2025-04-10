package servletcontroller;

import dto.User;
import service.impl.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userService.getUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("userlist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        String roomtype = request.getParameter("roomtype");

        User user = new User(username, email, checkin, checkout, roomtype);
        boolean success = userService.addUser(user);

        if (success) {
            request.setAttribute("message", "Booking successful!");
        } else {
            request.setAttribute("message", "Booking failed. Please try again.");
        }

        response.sendRedirect("BookingServlet");
    }
}

package servletcontroller;


import dto.User;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user-list")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("fetchUsers".equals(action)) {
            fetchUsers(request, response);
        } else {
            response.getWriter().println("This is the existing doGet method.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addUser".equals(action)) {
            String username = request.getParameter("name");
            String email = request.getParameter("email");
            String checkin = request.getParameter("checkin");
            String checkout = request.getParameter("checkout");
            String roomtype = request.getParameter("roomType");

            UserService userService = new UserService();
            userService.addUser(username, email, checkin, checkout, roomtype);

            response.sendRedirect("user-list?action=fetchUsers"); // Redirect to user list
        }
    }

    private void fetchUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = userService.getUsers();

        request.setAttribute("users", users);

        // Forwarding to JSP
//        request.getRequestDispatcher("UserList.jsp").forward(request, response);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserList.jsp");
                requestDispatcher.forward(request, response);
    }
}

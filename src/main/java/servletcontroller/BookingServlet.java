package servletcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Define theA? servlet URL pattern
@WebServlet(name = "BookingServlet",value="/BookingServlet")
public class BookingServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    // Store bookings in-memory (for testing)
    private List<String> bookings = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get user input from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        String roomType = request.getParameter("roomType");

        System.out.println(name);
        System.out.println(email);
        System.out.println(checkin);
        System.out.println(checkout);
        System.out.println(roomType);
        // Validate inputs
//        if (name == null || email == null || checkin == null || checkout == null || roomType == null ||
//                name.isEmpty() || email.isEmpty() || checkin.isEmpty() || checkout.isEmpty() || roomType.isEmpty()) {
//            out.println("<h3 style='color:red;'>Error: All fields are required!</h3>");
//            return;
//        }

    }
}

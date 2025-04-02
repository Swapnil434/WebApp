<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System</title>
    <link rel="stylesheet" href="styles.css">
    <script src="script.js"></script>


</head>
<body>

    <header>
        <h1>Hotel Management System</h1>
    </header>

    <section id="booking" >
        <h2>Book a Room</h2>
 <form action="BookingServlet" method="post">
             <label for="name">UserName:</label>
            <input type="text" name ="name" required/>

            <label for="email">Email:</label>
            <input type="email" name = "email" id="email" required>

            <label for="checkin">Check-in Date:</label>
            <input type="date" name ="checkin" id="checkin" required>

            <label for="checkout">Check-out Date:</label>
            <input type="date" name = "checkout" id="checkout" required>

            <label for="roomType">Room Type:</label>
                      <select  name = "roomType" id="roomType" required>
                <option value="single">Single Room</option>
                <option value="double">Double Room</option>
                <option value="suite">Suite</option>
            </select>

            <input type="submit" name="Book Now"/>
        </form>
        <p id="bookingMessage"></p>
    </section>

    <section id="rooms">
        <h2>Available Rooms</h2>
        <div class="room">
            <h3>Single Room</h3>
            <p>Price: rs1000/night</p>
        </div>
        <div class="room">
            <h3>Double Room</h3>
            <p>Price: rs1500/night</p>
        </div>
        <div class="room">
            <h3>Suite</h3>
            <p>Price: rs2000/night</p>
        </div>
    </section>

</body>
</html>

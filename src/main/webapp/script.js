document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("bookingForm");
    const message = document.getElementById("bookingMessage");

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const username = document.getElementById("username").value.trim();
        const email = document.getElementById("email").value.trim();
        const checkin = document.getElementById("checkin").value;
        const checkout = document.getElementById("checkout").value;
        const roomtype = document.getElementById("roomtype").value;

        if (!username || !email || !checkin || !checkout || !roomtype) {
            message.textContent = "Please fill in all fields.";
            message.style.color = "red";
            return;
        }

        if (new Date(checkin) >= new Date(checkout)) {
            message.textContent = "Check-out date must be later than check-in date.";
            message.style.color = "red";
            return;
        }

        message.textContent = `Booking confirmed for ${username} in a ${roomtype} from ${checkin} to ${checkout}.`;
        message.style.color = "green";
    });
});

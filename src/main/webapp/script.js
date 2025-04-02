document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("bookingForm");
    const message = document.getElementById("bookingMessage");

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const checkin = document.getElementById("checkin").value;
        const checkout = document.getElementById("checkout").value;
        const roomType = document.getElementById("roomType").value;

        if (!name || !email || !checkin || !checkout || !roomType) {
            message.textContent = "Please fill in all fields.";
            message.style.color = "red";
            return;
        }

        if (new Date(checkin) >= new Date(checkout)) {
            message.textContent = "Check-out date must be later than check-in date.";
            message.style.color = "red";
            return;
        }

        message.textContent = `Booking confirmed for ${name} in a ${roomType} from ${checkin} to ${checkout}.`;
        message.style.color = "green";
    });
});

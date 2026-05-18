// A simple script to add a little browser interaction

// 1. Generate bus seats (1 to 20) dynamically
const busLayout = document.getElementById('busLayout');
const selectedSeatInput = document.getElementById('selectedSeat');
let selectedSeatsArray = [];

for (let i = 1; i <= 20; i++) {
    // Create a new seat div
    let seat = document.createElement('div');
    seat.classList.add('seat');
    seat.innerText = i;
    
    // Create an aisle after every 2nd seat in a row
    if (i % 4 === 2) {
        seat.classList.add('aisle');
    }

    // Add click logic for multiple selection
    seat.addEventListener('click', function() {
        const seatName = "Seat " + i;
        
        // If already selected, deselect it
        if (seat.classList.contains('selected')) {
            seat.classList.remove('selected');
            // Remove from array
            selectedSeatsArray = selectedSeatsArray.filter(s => s !== seatName);
        } 
        // If not selected, select it
        else {
            seat.classList.add('selected');
            // Add to array
            selectedSeatsArray.push(seatName);
        }
        
        // Update hidden input that will be sent to Java (comma separated)
        selectedSeatInput.value = selectedSeatsArray.join(", ");
    });

    // Add the seat to the layout
    busLayout.appendChild(seat);
}

// 2. Form submission and validation
document.getElementById('bookingForm').addEventListener('submit', function(event) {
    
    // Check if the user selected a seat
    if (!selectedSeatInput.value) {
        event.preventDefault(); // Stop the form from submitting!
        alert("🚌 Please select a seat from the bus layout before booking!");
        return;
    }
    
    // Get the name entered by the user
    let name = document.getElementById('passengerName').value;
    
    // Print a friendly message to the browser's Developer Console
    console.log("Preparing to book ticket for: " + name + " in " + selectedSeatInput.value);
    
    // Form will now successfully submit to Java!
});

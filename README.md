# Simple Bus Booking System

A beginner-friendly bus booking web application built using Java, HTML, CSS, and JavaScript. This project demonstrates a lightweight HTTP server implementation in Java without relying on heavy frameworks like Spring Boot.

## Features

- **Java HTTP Server**: Uses Java's built-in `HttpServer` to serve static files and handle API requests.
- **Interactive UI**: HTML/CSS/JS frontend with a visual bus seat selection layout.
- **Dynamic Pricing**: Calculates ticket prices based on the selected destination and number of seats.
- **PDF Generation**: Generates and downloads a colorful PDF ticket using `html2pdf.js`.
- **No External Dependencies**: The backend runs purely on standard Java libraries.

## Project Structure

```
SimpleBusBooking/
├── src/
│   └── Main.java       # The Java HTTP server and request handlers
├── public/
│   ├── index.html      # The main booking form and UI
│   ├── style.css       # Styling for the application
│   └── script.js       # Frontend logic for seat selection
└── README.md           # Project documentation
```

## How to Run

1. Make sure you have Java installed on your machine (Java 11 or higher recommended).
2. Open your terminal or command prompt and navigate to the project directory:
   ```bash
   cd path/to/SimpleBusBooking
   ```
3. Compile the Java source code:
   ```bash
   javac src/Main.java
   ```
4. Run the compiled Java program (make sure your working directory is the root of the project so the server can find the `public` folder):
   ```bash
   java -cp src Main
   ```
5. Open your web browser and go to: [http://localhost:8080](http://localhost:8080)

## Usage

- Fill in your name, select a destination, and pick a travel date.
- Click on the interactive bus layout to select your desired seat(s).
- Submit the form by clicking "Book Ticket".
- You will be redirected to a success page displaying your booking details and total price.
- Click "Download Ticket as PDF" to save your generated ticket.

## Technologies Used
- **Backend**: Java (`com.sun.net.httpserver`)
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **PDF Library**: `html2pdf.js` (client-side)

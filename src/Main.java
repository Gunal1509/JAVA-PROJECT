import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Welcome to your Simple Bus Booking Backend!
 * We are using Java's built-in HttpServer so you don't need any complex setups like Spring Boot.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 1. Create a simple web server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 2. Map URLs (paths) to Handlers
        // When someone visits http://localhost:8080/, we serve the index.html file
        server.createContext("/", new FileHandler("public/index.html", "text/html"));
        
        // When the HTML requests the CSS file, we serve it
        server.createContext("/style.css", new FileHandler("public/style.css", "text/css"));
        
        // When the HTML requests the JS file, we serve it
        server.createContext("/script.js", new FileHandler("public/script.js", "application/javascript"));

        // When the HTML form is submitted to "/book", we process it
        server.createContext("/book", new BookingHandler());

        // 3. Start the server
        server.setExecutor(null); // creates a default executor
        System.out.println("=================================================");
        System.out.println("🚀 Bus Booking Server is running!");
        System.out.println("👉 Open your web browser and go to: http://localhost:8080");
        System.out.println("=================================================");
        server.start();
    }

    /**
     * A simple handler to read files (HTML, CSS, JS) from the disk and send them to the browser.
     */
    static class FileHandler implements HttpHandler {
        private final String filePath;
        private final String contentType;

        public FileHandler(String filePath, String contentType) {
            this.filePath = filePath;
            this.contentType = contentType;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                // Read the file content from the "public" folder
                byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
                
                // Send success response (HTTP Status 200 OK)
                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.sendResponseHeaders(200, fileBytes.length);
                
                // Write the file data to the browser
                OutputStream os = exchange.getResponseBody();
                os.write(fileBytes);
                os.close();
            } catch (IOException e) {
                // If the file is not found, send a 404 error
                String error = "404 File Not Found";
                exchange.sendResponseHeaders(404, error.length());
                OutputStream os = exchange.getResponseBody();
                os.write(error.getBytes());
                os.close();
            }
        }
    }

    /**
     * A handler to process the booking form submission when the user clicks "Book Ticket".
     */
    static class BookingHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Check if the request is a POST request (which is how HTML forms send data)
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                
                // Read the form data sent by the browser
                InputStream is = exchange.getRequestBody();
                String formData = new String(is.readAllBytes());
                
                // Print the raw data to our Java console to see it working!
                System.out.println("🎉 New Booking Received! Raw Data: " + formData);

                // Quick and simple parsing of the form data
                String passengerName = "Unknown";
                String destination = "Unknown";
                String date = "Unknown";
                String seatNumber = "Unknown";

                for (String param : formData.split("&")) {
                    String[] pair = param.split("=");
                    if (pair.length == 2) {
                        String key = pair[0];
                        // Decode any special characters or spaces
                        String value = java.net.URLDecoder.decode(pair[1], "UTF-8");
                        if (key.equals("passengerName")) passengerName = value;
                        if (key.equals("destination")) destination = value;
                        if (key.equals("date")) date = value;
                        if (key.equals("seatNumber")) seatNumber = value;
                    }
                }

                // FEATURE 1: Calculate Price based on Destination
                int basePrice = 50; // Default price
                if (destination.equals("New York")) basePrice = 45;
                else if (destination.equals("Los Angeles")) basePrice = 80;
                else if (destination.equals("Chicago")) basePrice = 55;
                else if (destination.equals("Miami")) basePrice = 65;

                // Count the number of selected seats
                int numberOfSeats = 1;
                if (!seatNumber.equals("Unknown") && !seatNumber.trim().isEmpty()) {
                    numberOfSeats = seatNumber.split(",").length;
                }
                
                // Calculate total based on number of passengers/seats
                int ticketPrice = basePrice * numberOfSeats;

                // FEATURE 2: Generate a random Booking ID
                int randomId = (int) (Math.random() * 90000) + 10000; // Random 5-digit number
                String bookingId = "BUS-" + randomId;

                // FEATURE 3: Seat number is now selected by the user in the frontend!

                // FEATURE 4: Capture exact booking time
                String bookingTime = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // Create a colorful success webpage with a PDF download button
                String responseHtml = "<!DOCTYPE html><html><head><meta charset='UTF-8'>" +
                        "<title>Booking Success</title>" +
                        "<!-- Importing html2pdf library to easily create PDFs! -->" +
                        "<script src='https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js'></script>" +
                        "<style>" +
                        "body{font-family:sans-serif;background:#d4edda;color:#155724;text-align:center;padding:50px;}" +
                        ".ticket{background:white;color:black;border:2px dashed #4ecdc4;border-radius:10px;padding:20px;width:350px;margin:20px auto;text-align:left;}" +
                        ".btn{background:#4ecdc4;color:white;border:none;padding:10px 20px;border-radius:5px;cursor:pointer;font-size:16px;margin:10px;}" +
                        ".btn:hover{background:#45b7aa;}" +
                        ".price{color:#ff6b6b; font-size:24px; text-align:right; margin:0;}" +
                        "</style>" +
                        "</head><body>" +
                        "<h1>✅ Booking Successful!</h1>" +
                        "<p>Thank you! Your bus ticket has been booked.</p>" +
                        
                        "<!-- This is the ticket that will be converted to PDF -->" +
                        "<div id='ticket' class='ticket'>" +
                        "<h2>🚌 Bus Ticket</h2>" +
                        "<hr/>" +
                        "<p><strong>Booking ID:</strong> " + bookingId + "</p>" +
                        "<p><strong>Name:</strong> " + passengerName + "</p>" +
                        "<p><strong>To:</strong> " + destination + "</p>" +
                        "<p><strong>Date:</strong> " + date + "</p>" +
                        "<p><strong>Booked On:</strong> " + bookingTime + "</p>" +
                        "<p><strong>Seats:</strong> " + seatNumber + " (" + numberOfSeats + " ticket/s)</p>" +
                        "<hr/>" +
                        "<p class='price'><strong>Total: $" + ticketPrice + "</strong></p>" +
                        "</div>" +
                        
                        "<button class='btn' onclick='downloadPDF()'>Download Ticket as PDF 📥</button>" +
                        "<br><a href='/' style='color:#155724; font-weight:bold;display:inline-block;margin-top:20px;'>Go Back to Booking Page</a>" +
                        
                        "<script>" +
                        "function downloadPDF() {" +
                        "  var element = document.getElementById('ticket');" +
                        "  html2pdf().from(element).save('BusTicket_" + passengerName.replace(" ", "") + ".pdf');" +
                        "}" +
                        "</script>" +
                        "</body></html>";

                // Send the success webpage to the browser
                byte[] responseBytes = responseHtml.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                exchange.sendResponseHeaders(200, responseBytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(responseBytes);
                os.close();
            } else {
                // If it's not a POST request, tell the browser it's not allowed
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }
}

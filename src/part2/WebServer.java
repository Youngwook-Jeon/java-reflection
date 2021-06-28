package part2;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class WebServer {

    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(
                RestrictedConstructorAccess.getRestrictedConstructorAccess().getServerAddress(),
                0
        );
        httpServer.createContext("/greeting").setHandler(exchange -> {
            String responseMessage =
                    RestrictedConstructorAccess.getRestrictedConstructorAccess().getGreetingMessage();
            exchange.sendResponseHeaders(200, responseMessage.length());
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        System.out.println(String.format("Starting server on address %s: %d",
                RestrictedConstructorAccess.getRestrictedConstructorAccess().getServerAddress().getHostName(),
                RestrictedConstructorAccess.getRestrictedConstructorAccess().getServerAddress().getPort()));
        httpServer.start();
    }
}

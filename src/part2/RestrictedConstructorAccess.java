package part2;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;

// a class to config a server
public class RestrictedConstructorAccess {

    private static RestrictedConstructorAccess restrictedConstructorAccess;
    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private RestrictedConstructorAccess(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if (restrictedConstructorAccess == null) {
            restrictedConstructorAccess = this;
        }
    }

    public static RestrictedConstructorAccess getRestrictedConstructorAccess() {
        return restrictedConstructorAccess;
    }

    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

}

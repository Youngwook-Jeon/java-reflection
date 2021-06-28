package part2;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainForWebServer {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        initConfiguration();
        WebServer webServer = new WebServer();
        webServer.startServer();
    }

    public static void initConfiguration() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<RestrictedConstructorAccess> constructor =
                RestrictedConstructorAccess.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        constructor.newInstance(8000, "Good Day!");
    }
}

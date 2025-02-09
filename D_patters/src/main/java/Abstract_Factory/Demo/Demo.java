package Abstract_Factory.Demo;

import Abstract_Factory.Client.Application;
import Abstract_Factory.Factories.GUIFactory;
import Abstract_Factory.Factories.MacOSFactory;
import Abstract_Factory.Factories.WindowsFactory;

public class Demo {
    /**
     * Application picks the factory type and creates it at runtime
     * depending on the configuration or environment variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}

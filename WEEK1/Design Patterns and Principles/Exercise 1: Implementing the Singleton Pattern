public class SingletonPatternExample {

    private static class Logger {
        private static final Logger INSTANCE = new Logger();

        private Logger() {}

        public void log(String message) {
            System.out.println(message); 
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        if (logger1 == logger2) {
            System.out.println("Singleton pattern implemented correctly");
        } else {
            System.out.println("Singleton pattern implementation failed");
        }

        logger1.log("This is a log message");
    }
}

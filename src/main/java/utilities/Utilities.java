package utilities;

public class Utilities {
    private final Logs logs = new Logs();

    public void waitSeconds(int n) {
        try {
            Thread.sleep(n * 1000L);
        } catch (InterruptedException interruptedException) {
            logs.error(interruptedException.getLocalizedMessage());
        }
    }
}

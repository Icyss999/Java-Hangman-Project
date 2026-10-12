
public class TimeTracker {
private long startTime;
private long endTime;
private boolean running = false;
private boolean started = false;

public void start(){
    startTime = System.nanoTime();
    endTime = 0;
    running = true;
    started = true;

}

public int stop(){
    if(running){
        endTime = System.nanoTime();
        running = false;
    }
    return getElapsedSeconds();
}
public int getElapsedSeconds(){
    if (!started) {
        return 0;
    }
    long currentTime = running ? System.nanoTime() : endTime;
    int timeElapsed = (int) ((currentTime - startTime) / 1_000_000_000L);
    return timeElapsed;
}
}


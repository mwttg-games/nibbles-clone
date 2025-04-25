package io.github.mwttg.nibbles.utilities;

public class Timer {

    private long lastTick;

    private Timer(final long lastTick) {
        this.lastTick = lastTick;
    }

    // in seconds
    public float getDeltaTime() {
        final var currentTick = System.currentTimeMillis();
        final var delta = (currentTick - lastTick) / 1000.0f;
        lastTick = currentTick;
        return delta;
    }

    public static Timer initialize() {
        return new Timer(System.currentTimeMillis());
    }
}

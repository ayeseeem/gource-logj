package org.ayeseeem.gource.log;

import java.awt.Color;
import java.time.Instant;
import java.util.Objects;

public class LogEntry {

    public final Instant timestamp;
    public final String username;
    public final Change change;
    public final Color color;

    public LogEntry(Instant timestamp, String username, Change change, Color color) {
        Objects.requireNonNull(timestamp);
        this.timestamp = timestamp;

        Objects.requireNonNull(username);
        this.username = username;

        Objects.requireNonNull(change);
        this.change = change;

        this.color = color;
    }

    public LogEntry(Instant timestamp, String username, Change change) {
        this(timestamp, username, change, null);
    }

}

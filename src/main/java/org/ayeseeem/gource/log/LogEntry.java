package org.ayeseeem.gource.log;

import java.awt.Color;
import java.time.Instant;
import java.util.Objects;

public class LogEntry {

    // TODO: ICM 2024-01-20: this page suggests unix timestamp only, but main README states 8601 too - ISO https://github.com/acaudwell/Gource/wiki/Custom-Log-Format
    public final Instant timestamp;
    public final String username;
    public final Update update;
    public final String file;
    public final Color color;

    public LogEntry(Instant timestamp, String username, Update update, String file, Color color) {
        Objects.requireNonNull(timestamp);
        this.timestamp = timestamp;

        Objects.requireNonNull(username);
        this.username = username;

        Objects.requireNonNull(update);
        this.update = update;

        Objects.requireNonNull(file);
        this.file = file;

        this.color = color;
    }

    public LogEntry(Instant timestamp, String username, Update update, String file) {
        this(timestamp, username, update, file, null);
    }

}

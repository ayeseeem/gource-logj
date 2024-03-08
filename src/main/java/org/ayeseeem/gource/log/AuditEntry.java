package org.ayeseeem.gource.log;

import java.time.Instant;
import java.util.Objects;

public class AuditEntry {

    public final Instant timestamp;
    public final String username;
    public final Change change;

    public AuditEntry(Instant timestamp, String username, Change change) {
        Objects.requireNonNull(timestamp);
        this.timestamp = timestamp;

        Objects.requireNonNull(username);
        this.username = username;

        Objects.requireNonNull(change);
        this.change = change;
    }

}

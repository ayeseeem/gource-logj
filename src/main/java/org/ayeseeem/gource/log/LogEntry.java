package org.ayeseeem.gource.log;

import java.awt.Color;
import java.util.Objects;

public class LogEntry {

    public final AuditEntry auditEntry;
    public final Color color;

    public LogEntry(AuditEntry auditEntry, Color color) {
        Objects.requireNonNull(auditEntry);
        this.auditEntry = auditEntry;

        this.color = color;
    }

    public LogEntry(AuditEntry auditEntry) {
        this(auditEntry, null);
    }

}

package org.ayeseeem.gource.log;

import java.util.List;
import java.util.stream.Collectors;

public class Log {

    public final List<LogEntry> entries;

    public Log(List<LogEntry> entries) {
        this.entries = entries;
    }

    public static Log create(List<AuditEntry> auditLog, Colorizer colorizer) {
        List<LogEntry> logEntries = auditLog.stream()
                .map(auditEntry -> new LogEntry(auditEntry, colorizer.color(auditEntry)))
                .collect(Collectors.toList());

        return new Log(logEntries);
    }

}

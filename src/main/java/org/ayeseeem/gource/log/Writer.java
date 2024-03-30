package org.ayeseeem.gource.log;

import java.awt.Color;
import java.io.PrintStream;
import java.time.Instant;

public class Writer {

    public static void write(Log log) {
        write(log, System.out);
    }

    public static void write(Log log, PrintStream to) {
        log.entries.forEach(entry -> to.println(output(entry)));
    }

    static String output(LogEntry entry) {
        return String.format("%s|%s|%s|%s|%s",
                output(entry.auditEntry.timestamp),
                entry.auditEntry.username,
                output(entry.auditEntry.change.update),
                entry.auditEntry.change.file,
                output(entry.color));
    }

    static String output(Instant timestamp) {
        return timestamp.toString();
    }

    static String output(Update update) {
        return update.toString().substring(0, 1);
    }

    // HACK: ICM 2024-01-26: ref: https://stackoverflow.com/questions/3607858/convert-a-rgb-color-value-to-a-hexadecimal-string
    static String output(Color color) {
        if (color == null) {
            return "";
        }
        return String.format("#%06X", 0xFFFFFF & color.getRGB());
        //return color.toString();
    }

}

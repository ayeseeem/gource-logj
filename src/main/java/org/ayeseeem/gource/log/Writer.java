package org.ayeseeem.gource.log;

import java.awt.Color;
import java.time.Instant;
import java.util.List;

public class Writer {

    public static void write(List<LogEntry> log) {
        log.forEach(entry -> System.out.println(output(entry)));
    }

    static String output(LogEntry entry) {
        return String.format("%s|%s|%s|%s|%s",
                output(entry.timestamp),
                entry.username,
                output(entry.update),
                entry.file,
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

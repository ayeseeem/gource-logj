package org.ayeseeem.gource.log;

import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static org.ayeseeem.gource.log.Update.ADDED;
import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExampleTest {

    @Test
    public void testGenerateExample() {
        List<LogEntry> log = Arrays.asList(
                new LogEntry(Instant.parse("2023-01-01T01:11:11Z"), "the_user", ADDED, "root", WHITE),
                new LogEntry(Instant.parse("2023-02-01T02:22:22Z"), "the_user", ADDED, "root/README", BLUE),
                new LogEntry(Instant.parse("2023-03-01T03:33:33Z"), "the_user", ADDED, "root/the/file", RED),
                new LogEntry(Instant.parse("2023-04-01T04:44:44Z"), "the_user", MODIFIED, "root/the/file", RED),
                new LogEntry(Instant.parse("2023-05-01T05:55:55Z"), "the_user", ADDED, "root/the/file2", GREEN));

        assertThat(log.size(), is(5));
        Writer.write(log);
    }

}

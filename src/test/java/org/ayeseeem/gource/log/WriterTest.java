package org.ayeseeem.gource.log;

import static java.awt.Color.RED;
import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;

import org.junit.Test;

public class WriterTest {

    @Test
    public void testOutput_AllArgs() {
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED), RED);

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.change.update, is(MODIFIED));
        assertThat(entry.change.file, is("the/file"));
        assertThat(entry.color, is(RED));

        assertThat(Writer.output(entry), is("2024-01-26T00:01:02Z|the_user|M|the/file|#FF0000"));
    }

    @Test
    public void testOutput_NoColor() {
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED));

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.change.update, is(MODIFIED));
        assertThat(entry.change.file, is("the/file"));
        assertThat(entry.color, is(nullValue()));

        assertThat(Writer.output(entry), is("2024-01-26T00:01:02Z|the_user|M|the/file|"));
    }

}

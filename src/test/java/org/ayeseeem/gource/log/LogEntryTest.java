package org.ayeseeem.gource.log;

import static java.awt.Color.RED;
import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;

import org.junit.Test;

public class LogEntryTest {

    @Test
    public void testConstructor_AllArgs() {
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", MODIFIED, "the/file", RED);

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.update, is(MODIFIED));
        assertThat(entry.file, is("the/file"));
        assertThat(entry.color, is(RED));
    }

    @Test
    public void testConstructor_NoColor() {
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", MODIFIED, "the/file");

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.update, is(MODIFIED));
        assertThat(entry.file, is("the/file"));
        assertThat(entry.color, is(nullValue()));
    }

}
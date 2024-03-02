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
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED), RED);

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.change.update, is(MODIFIED));
        assertThat(entry.change.file, is("the/file"));
        assertThat(entry.color, is(RED));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_TimestampIsRequired() {
        new LogEntry(null, "some_user", new Change("some/file", MODIFIED), RED);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_UsernameIsRequired() {
        new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), null, new Change("some/file", MODIFIED), RED);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_ChangeIsRequired() {
        new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "some_user", null, RED);
    }

    @Test
    public void testConstructor_AllArgs_ColorIsNotRequired() {
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED), null);

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.change.update, is(MODIFIED));
        assertThat(entry.change.file, is("the/file"));
        assertThat(entry.color, is(nullValue()));
    }

    @Test
    public void testConstructor_NoColor() {
        LogEntry entry = new LogEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED));

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.change.update, is(MODIFIED));
        assertThat(entry.change.file, is("the/file"));
        assertThat(entry.color, is(nullValue()));
    }

}

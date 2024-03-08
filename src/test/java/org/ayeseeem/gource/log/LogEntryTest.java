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
        LogEntry entry = new LogEntry(
                new AuditEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED)),
                RED);

        assertThat(entry.auditEntry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.auditEntry.username, is("the_user"));
        assertThat(entry.auditEntry.change.update, is(MODIFIED));
        assertThat(entry.auditEntry.change.file, is("the/file"));
        assertThat(entry.color, is(RED));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_AuditEntryIsRequired() {
        new LogEntry(null, RED);
    }

    @Test
    public void testConstructor_AllArgs_ColorIsNotRequired() {
        LogEntry entry = new LogEntry(
                new AuditEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED)),
                null);

        assertThat(entry.auditEntry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.auditEntry.username, is("the_user"));
        assertThat(entry.auditEntry.change.update, is(MODIFIED));
        assertThat(entry.auditEntry.change.file, is("the/file"));
        assertThat(entry.color, is(nullValue()));
    }

    @Test
    public void testConstructor_NoColor() {
        LogEntry entry = new LogEntry(
                new AuditEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user", new Change("the/file", MODIFIED)));

        assertThat(entry.auditEntry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.auditEntry.username, is("the_user"));
        assertThat(entry.auditEntry.change.update, is(MODIFIED));
        assertThat(entry.auditEntry.change.file, is("the/file"));
        assertThat(entry.color, is(nullValue()));
    }

}

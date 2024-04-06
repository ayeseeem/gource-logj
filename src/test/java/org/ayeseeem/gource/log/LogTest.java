package org.ayeseeem.gource.log;

import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LogTest {

    @Test
    public void testLog() {
        LogEntry entry = new LogEntry(
                new AuditEntry(Instant.parse("2001-02-03T04:05:06Z"), "a_user", new Change("some/file", MODIFIED)),
                RED);
        List<LogEntry> entries = Arrays.asList(entry);

        Log subject = new Log(entries);

        assertThat(subject.entries, is(entries));
    }

    @Test
    public void testCreate() {
        Colorizer colorizer = entry -> entry.username.equals("fred") ? BLUE : BLACK;

        List<AuditEntry> auditLog = Arrays.asList(
                new AuditEntry(Instant.now(), "fred", new Change("some/file", MODIFIED)),
                new AuditEntry(Instant.now(), "not fred", new Change("some/file", MODIFIED)));

        Log result = Log.create(auditLog, colorizer);

        assertThat(result.entries.get(0).auditEntry.username, is("fred"));
        assertThat(result.entries.get(0).color, is(BLUE));

        assertThat(result.entries.get(1).auditEntry.username, is("not fred"));
        assertThat(result.entries.get(1).color, is(BLACK));
    }

}

package org.ayeseeem.gource.log;

import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;

import org.junit.Test;

public class AuditEntryTest {

    @Test
    public void testConstructor_AllArgs() {
        AuditEntry entry = new AuditEntry(Instant.parse("2024-01-26T00:01:02Z"), "the_user",
                new Change("the/file", MODIFIED));

        assertThat(entry.timestamp, is(Instant.parse("2024-01-26T00:01:02Z")));
        assertThat(entry.username, is("the_user"));
        assertThat(entry.change.update, is(MODIFIED));
        assertThat(entry.change.file, is("the/file"));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_TimestampIsRequired() {
        new AuditEntry(null, "some_user", new Change("some/file", MODIFIED));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_UsernameIsRequired() {
        new AuditEntry(Instant.parse("2024-01-26T00:01:02Z"), null, new Change("some/file", MODIFIED));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_AllArgs_ChangeIsRequired() {
        new AuditEntry(Instant.parse("2024-01-26T00:01:02Z"), "some_user", null);
    }

}

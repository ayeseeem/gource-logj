package org.ayeseeem.gource.log;

import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static org.ayeseeem.gource.log.Update.ADDED;
import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExampleTest {

    private static final List<LogEntry> EG = Arrays.asList(
            new LogEntry(Instant.parse("2023-01-01T01:11:11Z"), "the_user", ADDED, "root", WHITE),
            new LogEntry(Instant.parse("2023-02-01T02:22:22Z"), "the_user", ADDED, "root/README", BLUE),
            new LogEntry(Instant.parse("2023-03-01T03:33:33Z"), "the_user", ADDED, "root/the/file", RED),
            new LogEntry(Instant.parse("2023-04-01T04:44:44Z"), "the_user", MODIFIED, "root/the/file", RED),
            new LogEntry(Instant.parse("2023-05-01T05:55:55Z"), "the_user", ADDED, "root/the/file2", GREEN));

    @Test
    public void testGenerateExample() throws Exception {
        PrintStream egOut = new PrintStream(Paths.get("src/test/resources/example.log").toFile());

        Writer.write(EG, egOut);

        List<String> generated = Files.readAllLines(Paths.get("src/test/resources/example.log"));
        assertThat(generated.size(), is(EG.size()));
        assertThat(generated.size(), is(5));

        assertThat(generated.get(0), is("2023-01-01T01:11:11Z|the_user|A|root|#FFFFFF"));
        assertThat(generated.get(1), is("2023-02-01T02:22:22Z|the_user|A|root/README|#0000FF"));
        assertThat(generated.get(2), is("2023-03-01T03:33:33Z|the_user|A|root/the/file|#FF0000"));
        assertThat(generated.get(3), is("2023-04-01T04:44:44Z|the_user|M|root/the/file|#FF0000"));
        assertThat(generated.get(4), is("2023-05-01T05:55:55Z|the_user|A|root/the/file2|#00FF00"));
    }

    @Test
    public void testWrite_Example_MatchesGoldBrick() throws Exception {
        List<String> expected = Files.readAllLines(Paths.get("src/test/resources/example-goldbrick.log"));
        assertThat(expected.size(), is(EG.size()));

        Path tempFile = Files.createTempFile(null, null);
        PrintStream temp = new PrintStream(tempFile.toFile());
        Writer.write(EG, temp);

        List<String> actual = Files.readAllLines(tempFile);
        assertThat(actual.size(), is(EG.size()));
        assertThat(actual.size(), is(5));
        for (int i = 0; i < actual.size(); i++) {
            assertThat(expected.get(i), is(actual.get(i)));
        }
    }

}

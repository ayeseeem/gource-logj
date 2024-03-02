package org.ayeseeem.gource.log;

import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.ayeseeem.gource.log.Update.ADDED;
import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.approvaltests.Approvals;
import org.junit.Test;

public class ExampleTest {

    private static final List<LogEntry> EG = Arrays.asList(
            new LogEntry(Instant.parse("2023-01-01T01:11:11Z"), "the_user", new Change("root", ADDED), WHITE),
            new LogEntry(Instant.parse("2023-02-01T02:22:22Z"), "the_user", new Change("root/README", ADDED), BLUE),
            new LogEntry(Instant.parse("2023-03-01T03:33:33Z"), "the_user", new Change("root/the/file", ADDED), RED),
            new LogEntry(Instant.parse("2023-04-01T04:44:44Z"), "the_user", new Change("root/the/file", MODIFIED), RED),
            new LogEntry(Instant.parse("2023-05-01T05:55:55Z"), "the_user", new Change("root/the/file2", ADDED), GREEN));

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
    public void testWrite_Example_Matches_ExampleFile() throws Exception {
        String string = readString(Paths.get("src/test/resources/example.log"));

        Approvals.verify(string);
    }

    @Test
    public void testWrite_Example() throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos, true, UTF_8.name())) {

            Writer.write(EG, ps);

            String data = baos.toString(UTF_8.name());
            Approvals.verify(data);
        }
    }

    @Test
    public void verifyApprovalTestsInstallation() {
        Approvals.verify("Approval Tests should verify this string" + NL);
    }

    private static final String NL = String.format("%n");

    // Bodge for Files.readString lacking in Java 8
    private static String readString(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        return String.join(NL, lines) + NL;
    }

}

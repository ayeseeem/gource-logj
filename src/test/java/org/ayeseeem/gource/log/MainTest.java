package org.ayeseeem.gource.log;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MainTest {

    @Test
    public void testSayHello() {
        String message = Main.printHelp();

        assertThat(message, is("Library (and app: TBC) for interacting with Gource custom log format - https://gource.io/"));
    }

}

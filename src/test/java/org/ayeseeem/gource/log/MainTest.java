package org.ayeseeem.gource.log;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

    @Test
    public void testSayHello() {
        String message = Main.sayHello();

        // JUnit only:
        assertEquals("I am a starter project", message);

        // Hamcrest preferred:
        assertThat(message, is("I am a starter project"));
    }

}

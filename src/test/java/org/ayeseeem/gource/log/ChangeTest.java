package org.ayeseeem.gource.log;

import static org.ayeseeem.gource.log.Update.MODIFIED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ChangeTest {

    @Test
    public void testConstructor_AllArgs() {
        Change change = new Change("the/file", MODIFIED);

        assertThat(change.file, is("the/file"));
        assertThat(change.update, is(MODIFIED));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_FileIsRequired() {
        new Change(null, MODIFIED);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_UpdateIsRequired() {
        new Change("some/file", null);
    }

}

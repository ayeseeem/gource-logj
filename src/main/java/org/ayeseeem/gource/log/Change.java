package org.ayeseeem.gource.log;

import java.util.Objects;

public class Change {

    public final String file;
    public final Update update;

    public Change(String file, Update update) {
        Objects.requireNonNull(file);
        this.file = file;

        Objects.requireNonNull(update);
        this.update = update;
    }

}

package org.ayeseeem.gource.log;

import java.awt.Color;

@FunctionalInterface
public interface Colorizer {

    Color color(AuditEntry auditEntry);

}

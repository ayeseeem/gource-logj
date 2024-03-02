`gource-log` Java Library for Gource Custom Log
===============================================

[![Build Status](https://github.com/ayeseeem/gource-logj/actions/workflows/maven.yml/badge.svg)](https://github.com/ayeseeem/gource-logj/actions/workflows/maven.yml)

A simple Java library to handle the [Gource](https://gource.io/)
[Custom Log Format](https://github.com/acaudwell/Gource).


Example
-------

Example log is generated and output by
[`ExampleTest.java`](src/test/java/org/ayeseeem/gource/log/ExampleTest.java)'s
`testGenerateExample()`.
It is captured in
[`example.log`](src/test/resources/example.log)
and you can try it out using this command (Windows path):

```console
gource src\test\resources\example.log
```

To confirm the details of timestamp, you can slow the playback down by
adding `-s 3600` to the command.


Coding Standard
---------------

Basic standard is [icm-java-style](https://github.com/ayeseeem/icm-java-style/).

The [POM](pom.xml) is configured with the
[Spotless](https://github.com/diffplug/spotless)
[Maven plugin](https://github.com/diffplug/spotless/tree/main/plugin-maven)
to check/fix the basics.

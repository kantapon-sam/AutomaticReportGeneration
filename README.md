# AutomaticReportGeneration

## Run with JDK 8

This project is configured for Java 8 bytecode (`javac.source=1.8` and `javac.target=1.8` in `nbproject/project.properties`).

Use JDK 8 to build/run:

```bash
export JAVA_HOME=/path/to/jdk8
export PATH="$JAVA_HOME/bin:$PATH"
java -version
javac -version
ant clean jar
java -jar dist/AutomaticReportGeneration.jar
```

Expected Java version output should be `1.8.x`.

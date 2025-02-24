# Utils package for me gusta

### Integration in pom.xml:
```xml
<!-- Add jitpack repository -->
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<!-- Add dependency -->
<dependency>
<groupId>com.github.TomBock</groupId>
<artifactId>MCUtils</artifactId>
<version>VERSION</version>
</dependency>

<!-- Add shade plugin -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.6.0</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <relocations>
            <relocation>
                <pattern>com.bocktom.utils</pattern>
                <shadedPattern>YOUR.ORG.shades.utils</shadedPattern>
            </relocation>
        </relocations>
    </configuration>
</plugin>
```
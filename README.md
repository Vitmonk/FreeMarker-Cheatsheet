# FreeMarker Cheatsheet
Showcase for various FreeMarker directives / functions which are not easily found on the Internet.

In case you have an web app project with spring, its preferable to use FreeMarkerViewResolver from spring-webmvc dependency.

If something is not covered in the official documentation (<http://freemarker.org/docs/dgui.html>) or you have problem which is tricky to solve - i am waiting for challenges. 

How to run: import as Maven project and run the Main-Class FreeMarkerApplication. The generated results are reachable under:
* http://localhost:8080/freemarkerHtml

Maven Dependency:

	<dependency>
	    <groupId>org.freemarker</groupId>
	    <artifactId>freemarker</artifactId>
		<version>2.3.25-incubating</version>
	</dependency>

Basics:

* access java constants

Enums:

* iterate over Enum constants
* access specific Enum constant
* call Enum method



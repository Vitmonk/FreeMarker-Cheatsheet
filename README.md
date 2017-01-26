# FreeMarker Cheatsheet
Showcase for various FreeMarker directives / functions which are not easily found on the Internet.

This some classes can be also used as template for non spring java projects if you wish. In case you have an web app project with spring, its preferable to use FreeMarkerViewResolver from spring-webmvc dependency.

If you think something is not covered in the official documentation (<http://freemarker.org/docs/dgui.html>) or you have problem which tricky to solve - i am waiting for challenges. 

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



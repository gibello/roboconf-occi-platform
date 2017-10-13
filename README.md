# roboconf-occi-platform
OCCI Platform connector to bridge Roboconf and Mart Server.

## Build instructions

As of this version, there is still no eclipse update-site for OCCI Studio V2.
DO NOT build using the pom.xml in root directory.

To build:
- Go into roboconf-occi-platform-connector/ directory
- mvn clean install

The connector is then available in roboconf-occi-platform-connector/target (jar file: roboconf.platform.connector-X.Y.Z-SNAPSHOT.jar).

## Deployment instructions (MART server)

in MartServer/org.occiware.mart.jetty/ directory, add the following dependencies to pom.xml:

```
<dependency>
  <groupId>org.occiware</groupId>
  <artifactId>org.eclipse.cmf.occi.platform</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
<dependency>
  <groupId>net.roboconf.eclipse.occi-platform-mart</groupId>
  <artifactId>roboconf.platform.connector</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

Then build: mvn clean install

Note: may require to build OCCI Platform extension (org.eclipse.cmf.occi.platform) in OCCI-Studio project.

## Start MART server

in MartServer/org.occiware.mart.jetty/ directory:
mvn exec:exec

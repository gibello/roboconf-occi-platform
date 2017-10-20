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

## Connect OCCInterface to Roboconf across MART

The following markdown can be served by OCCInterface to issue an application creation request:

```
* Create a OCCI platform application without ID %{ "text": "here", "put": [ { "address": "/application/apache-bash", "data": { "kind":"http://schemas.ogf.org/occi/platform#application", "attributes": { "occi.app.state": "inactive", "occi.app.name": "apache-bash", "occi.app.context": "http://localhost:8181/roboconf-dm", "occi.app.url": "http://www.linagora.com" } } } ] }%(you need to have occi-platform on your server)
```
In this example, the Roboconf DM is available at http://localhost:8181/roboconf-dm, and contains an application whose name is "apache-bash" (change values if necessary in accordance with your own use-case).

When executing the request, the MART roboconf connector will register the application as a resource of kind "Application", then discover all instances of Roboconf components in the application, and register them as resources of kind "Component".

Then, to deploy/start a component, simply execute its "start" action.


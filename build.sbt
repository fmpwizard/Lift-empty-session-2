name := "Lift-empty-session"

scalaVersion := "2.9.1"

scalacOptions += "-deprecation"

scalacOptions += "-unchecked"


resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases",
                "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
                "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
                )



libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.2" % "compile",
  "junit" % "junit" % "4.10" % "test",
  "net.liftweb" %% "lift-webkit" % "2.5-SNAPSHOT" % "compile",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.v20120127" % "container",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.v20120127" % "test->default",
  "com.typesafe.akka" % "akka-actor" % "2.0.2",
  "com.typesafe.akka" % "akka-agent" % "2.0.2",
  "com.typesafe.akka" % "akka-slf4j" % "2.0.2",
  "com.typesafe.akka" % "akka-testkit" % "2.0.2"
)




// coffeescrpted-sbt
seq(coffeeSettings: _*)

seq(webSettings :_*)

// CoffeeScript-Skripte nach webapp/scripts kompilieren
(resourceManaged in (Compile, CoffeeKeys.coffee)) <<= (webappResources in Compile)(_.get.head / "scripts")

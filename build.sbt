name := """prodbox"""
organization := """4stars"""

version := s"1.0.${buildNumber}"
lazy val buildNumber = sys.props.getOrElse("BUILD_NUMBER", default = "0-SNAPSHOT")

lazy val root = (project in file(".")).enablePlugins(PlayScala, JavaServerAppPackaging , DockerPlugin, UniversalPlugin)

scalaVersion := "2.11.7"

resolvers += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"
resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "RoundEights" at "http://maven.spikemark.net/roundeights"
resolvers += "Typesafe repository" at "https://dl.bintray.com/typesafe/maven-releases/"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.10",
  ws,
  /** Test dependencies */
  "org.scalactic" %% "scalactic" % "2.2.6" % "test" withSources(),
  "org.scalatest" %% "scalatest" % "2.2.6",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % "test" withSources(),
  "org.scalacheck" %% "scalacheck"  % "1.12.2" % "test" withSources(),
  "org.mockito" % "mockito-all" % "1.10.19" % "test" withSources(),
  "junit" % "junit" % "4.12" % "test" withSources(),
  "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.50.0" % "test"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

dockerUpdateLatest := true
dockerBaseImage := "netflixoss/java:8"
dockerEntrypoint := Seq("bin/%s" format executableScriptName.value, "-J-Xms1024M", "-J-Xmx2048m", "-J-server")
dockerExposedPorts := Seq(9000)

javaOptions in Test += "-DMONGO_URI=mongodb://localhost:27018/prodbox"

fork in run := false
fork in test := false

import com.trueaccord.scalapb.compiler.Version.scalapbVersion

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

/** Name of project */
name := "BamScraper"

/** Organization */
organization := "com.github.sguzman"

/** Project Version */
version := "1.0"

/** Scala version */
scalaVersion := "2.12.4"

/** Scalac parameters */
scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

/** Javac parameters */
javacOptions ++= Seq("-server")

/** Resolver */
resolvers ++= Seq(
  DefaultMavenRepository,
  Resolver.sonatypeRepo("public"),
  Resolver.typesafeRepo("releases"),
  Resolver.sbtPluginRepo("releases"),
  Resolver.jcenterRepo,
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
)

/** Source Dependencies */
libraryDependencies ++= Seq(
  "net.ruippeixotog" %% "scala-scraper" % "2.1.0",
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "com.outr" %% "scribe" % "2.3.1" ,
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf"
)

/** Make sure to fork on run */
fork in run := true
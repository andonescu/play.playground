name := "hello"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)  

libraryDependencies +=  "net.sf.barcode4j" % "barcode4j" % "2.1"

play.Project.playScalaSettings

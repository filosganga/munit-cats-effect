ThisBuild / tlBaseVersion := "2.0"

ThisBuild / developers += tlGitHubDev("milanvdm", "Milan van der Meer")
ThisBuild / startYear := Some(2021)

ThisBuild / crossScalaVersions := List("3.1.2", "2.12.16", "2.13.8")

lazy val docs = project
  .in(file("site"))
  .dependsOn(core.jvm)
  .enablePlugins(TypelevelSitePlugin)

lazy val root = tlCrossRootProject.aggregate(core)

lazy val core = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("core"))
  .settings(
    name := "munit-cats-effect",
    libraryDependencies ++= Seq(
      "org.scalameta" %%% "munit" % "1.0.0-M6",
      "org.typelevel" %%% "cats-effect" % "3.3.13"
    )
  )

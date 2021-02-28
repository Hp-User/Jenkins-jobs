def hi = hudson.model.Hudson.instance
   hi.getItems(hudson.model.Project).each {project ->
   println(project.displayName)
   //get statuses for all the latest builds
println("Last build : "+project.lastBuild.result)

}
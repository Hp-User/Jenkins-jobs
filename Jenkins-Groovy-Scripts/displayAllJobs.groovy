import hudson.model.Hudson;
import jenkins.model.Jenkins;

println "Jenkins instance is "+Jenkins.instance

//File root = Jenkins.getInstance().getRootDir();
//println  root
def items = Jenkins.getInstance().items
  for (item in items) {   
	 
	println(item.name)     
  }
 
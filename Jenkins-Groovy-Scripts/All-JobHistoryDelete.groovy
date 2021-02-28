 //delete all jobs build hsitory
def jobs = Jenkins.instance.projects.collect { it } 
jobs.each { job -> job.getBuilds().each { it.delete() }} 
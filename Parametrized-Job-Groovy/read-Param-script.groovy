import hudson.model.*
 
// get current thread / Executor
def thr = Thread.currentThread()
// get current build
def build = thr?.executable
 
 
// get parameters
def parameters = build?.actions.find{ it instanceof ParametersAction }?.parameters
parameters.each {
   println "\nThe parameter ${it.name}:"
   //println it.dump()
   println it.value
   //println "-" * 80
}

// Read the parameter by name ...
def param = "States"
def resolver = build.buildVariableResolver
def value = resolver.resolve(param)
 
 
println "parameter ${param} value : ${value}"
println "The Java classpath is ${System.getProperty("java.ext.dirs")}"

println "The OS is ${System.getProperty("os.name")}"


println "The Os version is ${System.getProperty("os.version")}"

println "The file.separator for os is ${System.getProperty("file.separator")}"

//println "The system properties are ${System.getProperties()}"


Properties props = System.getProperties();
    Enumeration e = props.propertyNames();

    while (e.hasMoreElements()) {
      String key = (String) e.nextElement();
      println(key + " -- " + props.getProperty(key));
    }
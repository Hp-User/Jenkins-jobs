
/*
The Choice parameter DataBase with values adefined as 
Oracle
MySql
MS-SQL
 */
 
import hudson.model.*
import groovy.sql.Sql

 
// get current thread / Executor
def thr = Thread.currentThread()
// get current build
def build = thr?.executable

//Read the the parameter value by name ...
def db_param = "DataBase"
def resolver = build.buildVariableResolver
def db_paramValue = resolver.resolve(db_param)
 
 
println "The parameter ${db_param} value : ${db_paramValue}"

def dbString=""
if(db_paramValue=="Oracle")
  dbString="oracle-schema"

if(db_paramValue=="MySql")
  dbString="mysql-schema"

if(db_paramValue=="MS-SQL")
  dbString="msdb-schema"

println "The jenkins is connecting to  ${dbString}"


def props = [user: "root", password: "MyRootPass123", allowMultiQueries: 'true'] as Properties

 


def url = "jdbc:mysql://localhost:3306/${dbString}"

def driver = "com.mysql.jdbc.Driver"

//Connect to specific database  

def sql = Sql.newInstance(url, props, driver)

//Connect to specific database 
//def sql = Sql.newInstance("jdbc:mysql://localhost:3306/${dbString}", "root","MyRootPass123", "com.mysql.jdbc.Driver")

def data1 = new File("DB-Scripts/data1.sql").text
def data2 = new File("DB-Scripts/data2.sql").text
def data3 = new File("DB-Scripts/data3.sql").text
def data4 = new File("DB-Scripts/data4.sql").text

 sql.execute(data1) 
 sql.execute(data2) 
 sql.execute(data3) 
 sql.execute(data4) 

  //sql.execute("DB-Scripts/data2.sql") 
 

 return true;
	

 return true;
	


	


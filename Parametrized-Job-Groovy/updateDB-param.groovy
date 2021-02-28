
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
def db-paramValue = resolver.resolve(db_param)
 
 
println "The parameter ${db_param} value : ${db-paramValue}"

def dbString=""
if(db-paramValue=="Oracle")
  dbString="oracle-schema"

if(db-paramValue=="MySql")
  dbString="mysql-schema"

if(db-paramValue=="MS-SQL")
  dbString="msdb-schema"

println "The jenkins is connecting to  ${dbString}"


//Connect to specific database 
def sql = Sql.newInstance("jdbc:mysql://localhost:3306/${dbString}", "root",
			   "MyRootPass123", "com.mysql.jdbc.Driver")

 sql.execute("drop table if exists word")

sql.execute("create table word(word_id int, spelling varchar(10), part_of_speech varchar(10),primary key (word_id)) ")

 

        def wid = 51
	   def spelling = "Noha"
	   def pospeech = "MyNoun"
	   def res = sql.execute("insert into word (word_id, spelling, part_of_speech) values (${wid}, ${spelling}, ${pospeech})")

println "The jenkins DB added records to  ${dbString}"

 return true;
	


	



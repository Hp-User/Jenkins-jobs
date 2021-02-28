import groovy.sql.Sql



/*
 *  create table word(word_id int, spelling varchar(10), part_of_speech varchar(10),primary key (word_id)) 
 */
 

	 
		def sql = Sql.newInstance("jdbc:mysql://localhost:3306/test-schema", "root",
			   "MyRootPass123", "com.mysql.jdbc.Driver")
	
	   sql.execute("delete from word where word_id=15")
	
	
	   def wid = 15
	   def spelling = "Nefarious"
	   def pospeech = "Adjective"
	   sql.execute("insert into word (word_id, spelling, part_of_speech) values (${wid}, ${spelling}, ${pospeech})")
	
	   sql.eachRow("select * from word"){ row ->
		  println row.word_id + " " + row.spelling + " " + row.part_of_speech
	   }
	
	   def val = sql.execute("select * from word where word_id = ?", [5])
	   println val
	
	   def nid = 5
	   def newSpelling = "Dastardly"
	   sql.executeUpdate("update word set spelling = ? where word_id = ?", [newSpelling, nid])
	
	   sql.eachRow("select * from word"){ row ->
		  println row.word_id + " " + row.spelling + " " + row.part_of_speech
	   }
	
	
	   println "get last row"
	   sql.eachRow("select * from word"){ row ->
		 (0..2).each{ i ->
		   print "Field[${i}]: "
		   println row.getAt(i)
		 }
		 println "Last field using -1 index = " + row.getAt(-1)
	   }
	
	
	
	
	
	 
	
 
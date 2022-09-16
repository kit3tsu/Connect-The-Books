package be.bf.kit3tsu.connect_the_books.ui.library

import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.util.Visibility

val notes = arrayOf(
    Note(1,"Les Pirates","Ils sont tres tres méchant","/c/docu/app",Visibility.PUBLIC,2),
    Note(2,"Les Marines","Ils sont encore plus méchant","/c/docu/app",Visibility.PUBLIC,2),
    Note(3,"Les Corsaires","Ils sont tres tres fort","/c/docu/app",Visibility.PUBLIC,2),
    Note(4,"Les Mugiwara","Ils sont tres tres gentil","/c/docu/app",Visibility.PUBLIC,3),
    Note(5,"Les Heart Pirates","Ils sont sympa","/c/docu/app",Visibility.PUBLIC,3),
    Note(6,"Les Roks","Ils sont tres tres mais vrmt bcp méchant","/c/docu/app",Visibility.PUBLIC,3),
    Note(7,"Les amiraux","Ils sont tres tres différents","/c/docu/app",Visibility.PUBLIC,4)
)

val markdown = """  
	# Sample  
    ## Hé title
	* Markdown  
	* [Link](https://example.com)  
	![Image](https://example.com/img.png)  
	<a href="https://www.google.com/">Google</a>  
""".trim()
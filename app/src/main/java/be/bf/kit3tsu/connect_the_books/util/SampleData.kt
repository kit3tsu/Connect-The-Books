package be.bf.kit3tsu.connect_the_books.ui.library

import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.entities.NoteTagCrossRef
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import com.example.tfe.data.entity.Book

val folders = arrayOf(
    Directory(0,"Home","root","....", Visibility.PUBLIC,null),
    Directory(1,"Organisation","root/home","....", Visibility.PUBLIC,0),
    Directory(2,"Pirates","root","....", Visibility.PUBLIC,1),
    Directory(3,"Marines","root","....", Visibility.PUBLIC,9),
    Directory(4,"Corsaires","root","....", Visibility.PUBLIC,1),
    Directory(5,"Lieu","root","....", Visibility.PUBLIC,0),
    Directory(6,"Personnage","root","....", Visibility.PUBLIC,2),
    Directory(7,"Personnage","root","....", Visibility.PUBLIC,3),
    Directory(8,"Personnage","root","....", Visibility.PUBLIC,4),
)

val books = arrayOf(
    Book(1,"One Piece Tome 1", "Eichiro Oda", "none",0),
    Book(2,"One Piece Tome 2", "Eichiro Oda", "none",0),
    Book(3,"One Piece Tome 3", "Eichiro Oda", "none",0),
    Book(4,"One Piece Tome 4", "Eichiro Oda", "none",0),
    Book(5,"One Piece Tome 5", "Eichiro Oda", "none",0),
    Book(6,"One Piece Tome 6", "Eichiro Oda", "none",0),
)



val notes = arrayOf(
    Note(1,"Les Pirates","Ils sont tres tres méchant","/c/docu/app", Visibility.PUBLIC,1),
    Note(2,"Les Marines","Ils sont encore plus méchant","/c/docu/app", Visibility.PUBLIC,1),
    Note(3,"Les Corsaires","Ils sont tres tres fort","/c/docu/app", Visibility.PUBLIC,1),
    Note(4,"Les Mugiwara","Ils sont tres tres gentil","/c/docu/app", Visibility.PUBLIC,2),
    Note(5,"Les Heart Pirates","Ils sont sympa","/c/docu/app", Visibility.PUBLIC,2),
    Note(6,"Les Roks","Ils sont tres tres mais vrmt bcp méchant","/c/docu/app", Visibility.PUBLIC,2),
    Note(7,"Les amiraux","Ils sont tres tres différents","/c/docu/app", Visibility.PUBLIC,3),
    Note(7,"Aokiji","De la glace","/c/docu/app", Visibility.PUBLIC,7),
    Note(7,"Akainu","FDD Manma","/c/docu/app", Visibility.PUBLIC,7),
    Note(7,"Kizaru","FDD Luniere","/c/docu/app", Visibility.PUBLIC,7),
)

val tags = arrayOf(
    Tag(1,"Manga"),
    Tag(2,"Fiction"),
    Tag(3,"Aventure"),
    Tag(4,"Mythologie"),
    Tag(5,"Action"),
    Tag(6,"Lu"),
    Tag(7,"Classic"),
    Tag(9,"Personage")
)

val noteWithTag = arrayOf(
    NoteTagCrossRef(8,9),
    NoteTagCrossRef(3,1),
    NoteTagCrossRef(2,1),
    NoteTagCrossRef(1,1),
)

val oneDirectory = Directory(9,"Gouvernement Mondial","root/GM","", Visibility.PUBLIC,1)
val oneBook = Book(7,"One Piece Tome 100","Oda","123456789",0)
val oneNote = Note(8,"Luffy","Future Pirates King", "a path", Visibility.PUBLIC,6)
val oneTag = Tag(8,"Mature")


val markdown = """  
	# Sample  
    ## Hé title
	* Markdown  
	* [Link](https://example.com)  
	![Image](https://example.com/img.png)  
	<a href="https://www.google.com/">Google</a>  
""".trim()
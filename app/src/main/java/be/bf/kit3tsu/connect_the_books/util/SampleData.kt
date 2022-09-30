package be.bf.kit3tsu.connect_the_books.ui.library

import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.entities.Note
import be.bf.kit3tsu.connect_the_books.data.entities.NoteTagCrossRef
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import be.bf.kit3tsu.connect_the_books.data.entities.Book

val folders = listOf<Directory>(
    Directory(0, "Home", Visibility.PUBLIC, null),
    Directory(1, "Organisation", Visibility.PUBLIC, 0),
    Directory(2, "Pirates", Visibility.PUBLIC, 1),
    Directory(3, "Marines", Visibility.PUBLIC, 9),
    Directory(4, "Corsaires", Visibility.PUBLIC, 1),
    Directory(5, "Lieu", Visibility.PUBLIC, 0),
    Directory(6, "Personnage", Visibility.PUBLIC, 2),
    Directory(7, "Personnage", Visibility.PUBLIC, 3),
    Directory(8, "Personnage", Visibility.PUBLIC, 4),
)

val books = arrayOf(
    Book(1, "One Piece Tome 1", "Eichiro Oda", "none", 0),
    Book(2, "One Piece Tome 2", "Eichiro Oda", "none", 0),
    Book(3, "One Piece Tome 3", "Eichiro Oda", "none", 0),
    Book(4, "One Piece Tome 4", "Eichiro Oda", "none", 0),
    Book(5, "One Piece Tome 5", "Eichiro Oda", "none", 0),
    Book(6, "One Piece Tome 6", "Eichiro Oda", "none", 0),
)


val notes = arrayOf(
    Note(1, "Les Pirates","", Visibility.PUBLIC, 1),
    Note(2, "Les Marines","", Visibility.PUBLIC, 1),
    Note(3, "Les Corsaires","", Visibility.PUBLIC, 1),
    Note(4, "Les Mugiwara","", Visibility.PUBLIC, 2),
    Note(5, "Les Heart Pirates","", Visibility.PUBLIC, 2),
    Note(6, "Les Roks","", Visibility.PUBLIC, 2),
    Note(7, "Les amiraux","", Visibility.PUBLIC, 3),
    Note(7, "Aokiji","", Visibility.PUBLIC, 7),
    Note(7, "Akainu","", Visibility.PUBLIC, 7),
    Note(7, "Kizaru","", Visibility.PUBLIC, 7),
)

fun getNotesList(folderId: Int) = notes
fun getSubFoldersList(folderId: Int) = folders
val tags = arrayOf(
    Tag(1, "Manga"),
    Tag(2, "Fiction"),
    Tag(3, "Aventure"),
    Tag(4, "Mythologie"),
    Tag(5, "Action"),
    Tag(6, "Lu"),
    Tag(7, "Classic"),
    Tag(9, "Personage")
)

val noteWithTag = arrayOf(
    NoteTagCrossRef(8, 9),
    NoteTagCrossRef(3, 1),
    NoteTagCrossRef(2, 1),
    NoteTagCrossRef(1, 1),
)

val oneDirectory = Directory(9, "Gouvernement Mondial",  Visibility.PUBLIC, 1)
val oneBook = Book(7, "One Piece Tome 100", "Oda", "123456789", 0)
val oneNote = Note(8, "Luffy","", Visibility.PUBLIC, 6)
val oneTag = Tag(8, "Mature")


val markdown = """  
	# Sample  
    ## Hé title
	* Markdown  
	* [Link](https://example.com)  
	![Image](https://example.com/img.png)  
	<a href="https://www.google.com/">Google</a>  
""".trim()

fun action(): Unit {

}
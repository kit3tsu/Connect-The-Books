package be.bf.kit3tsu.connect_the_books.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import be.bf.kit3tsu.connect_the_books.data.entities.Directory

data class DirectorySubDirectory(
    @Embedded
    val directory: Directory,
    @Relation(
        parentColumn = "directory_id",
        entityColumn = "directory_parent"
    )
    val subDirectory: List<Directory>
)
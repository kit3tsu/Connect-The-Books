package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySNote
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import kotlinx.coroutines.flow.Flow


@Dao
interface DirectoryDao : BaseDao<Directory> {

    @Query("SELECT * FROM Directory")
    fun getAllDirectories(): Flow<List<Directory>>

    @Query("SELECT * FROM Directory where directory_id = :id")
    fun getDirectoryById(id: Int): Flow<Directory>

//    @Query("SELECT * FROM Directory where directory_parent = 0")
//    fun getRootDirectory():  Flow<List<Directory>>

    @Transaction
    @Query("SELECT * FROM Directory Where directory_parent = :id")
    fun getDirectoriesWithSubDirectories(id: Int?): Flow<List<DirectorySubDirectory>>

    @Transaction
    @Query("SELECT * FROM Directory")
    fun getDirectoriesWithNotes(): Flow<List<DirectorySNote>>

//    @Transaction
//    @Query("SELECT * FROM Note Where directory_id = :id")
//    fun getNotesOfDirectory(id: Int): Flow<List<DirectorySNote>>

}
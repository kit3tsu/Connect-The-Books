package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySNote
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import kotlinx.coroutines.flow.Flow


@Dao
interface DirectoryDao : BaseDao<Directory> {

    @Query("SELECT * FROM Directory")
    fun findAll(): Flow<List<Directory>>

    @Query("SELECT * FROM Directory where directory_id = :id")
    fun findById(id: Int): Flow<Directory>

//    @Query("SELECT * FROM Directory where directory_parent = 0")
//    fun getRootDirectory():  Flow<List<Directory>>

    @Transaction
    @Query("SELECT * FROM Directory")
    fun findSubDirectory(): Flow<List<DirectorySubDirectory>>

    @Transaction
    @Query("SELECT * FROM Directory")
    fun findDirectorySNote(): Flow<List<DirectorySNote>>

}
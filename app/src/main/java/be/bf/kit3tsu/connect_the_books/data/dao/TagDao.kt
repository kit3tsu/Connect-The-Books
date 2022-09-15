package be.bf.kit3tsu.connect_the_books.data.dao

import androidx.room.*
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import be.bf.kit3tsu.connect_the_books.data.relations.TagSNote
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao : BaseDao<Tag> {

    @Query("SELECT * FROM Tag")
    fun findAll(): Flow<List<Tag>>

    @Query("SELECT * FROM Tag WHERE tag_id = :id")
    fun findById(id: Int): Flow<Tag>

    @Transaction
    @Query("SELECT * FROM Tag")
    fun findNotes(): Flow<List<TagSNote>>
}
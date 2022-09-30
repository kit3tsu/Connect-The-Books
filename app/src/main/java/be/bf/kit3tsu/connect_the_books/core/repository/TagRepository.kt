package be.bf.kit3tsu.connect_the_books.core.repository

import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import kotlinx.coroutines.flow.Flow

interface TagRepository {
    suspend fun getTags(): Flow<List<Tag>>

    suspend fun getTagById(id: Int?): Flow<Tag>

    suspend fun insertTag(tag: Tag)

    suspend fun deleteTag(tag: Tag)
}
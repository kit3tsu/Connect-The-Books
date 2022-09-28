package be.bf.kit3tsu.connect_the_books.data.Repository

import android.os.Parcel
import android.os.Parcelable
import be.bf.kit3tsu.connect_the_books.core.repository.TagRepository
import be.bf.kit3tsu.connect_the_books.data.dao.TagDao
import be.bf.kit3tsu.connect_the_books.data.entities.Tag
import kotlinx.coroutines.flow.Flow

class TagRepositoryImpl(private  val dao: TagDao) :TagRepository {

    override suspend fun getTags(): Flow<List<Tag>> {
        return dao.findAll()
    }

    override suspend fun getTagById(id: Int): Flow<Tag> {
        return dao.findById(id)
    }

    override suspend fun insertTag(tag: Tag) {
        dao.insert(tag)
    }

    override suspend fun deleteTag(tag: Tag) {
        dao.delete(tag)
    }
}
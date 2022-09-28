package be.bf.kit3tsu.connect_the_books.data.Repository

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.dao.DirectoryDao
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import kotlinx.coroutines.flow.Flow

class DirectoryRepositoryImpl(private val dao: DirectoryDao) :DirectoryRepository  {
    override suspend fun getDirectorys(): Flow<List<Directory>> {
        return dao.findAll()
    }

    override suspend fun getDirectoryById(id: Int): Flow<Directory> {
        return dao.findById(id)
    }

    override suspend fun insertDirectory(directory: Directory) {
        dao.insert(directory)
    }

    override suspend fun deleteDirectory(directory: Directory) {
        dao.delete(directory)
    }
}
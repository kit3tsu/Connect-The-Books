package be.bf.kit3tsu.connect_the_books.data.Repository

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.dao.DirectoryDao
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySNote
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import kotlinx.coroutines.flow.Flow

class DirectoryRepositoryImpl(private val dao: DirectoryDao) : DirectoryRepository {
    override suspend fun getDirectories(): Flow<List<Directory>> {
        return dao.getAllDirectories()
    }

//    override suspend fun getRootDirectory(): Flow<List<Directory>> {
//        return dao.getRootDirectory()
//    }

    override suspend fun getDirectoryById(id: Int): Flow<Directory> {
        return dao.getDirectoryById(id)
    }

    override suspend fun insertDirectory(directory: Directory) {
        dao.insert(directory)
    }

    override suspend fun deleteDirectory(directory: Directory) {
        dao.delete(directory)
    }

    override suspend fun getDirectorySNotes(): Flow<List<DirectorySNote>> {
        return dao.getDirectoriesWithNotes()
    }

    override suspend fun getDirectorySSubDirectories(id: Int?): Flow<List<DirectorySubDirectory>> {
        return dao.getDirectoriesWithSubDirectories(id)
    }
}
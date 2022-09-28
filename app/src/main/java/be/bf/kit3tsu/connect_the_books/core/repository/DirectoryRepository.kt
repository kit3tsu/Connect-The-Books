package be.bf.kit3tsu.connect_the_books.core.repository

import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import kotlinx.coroutines.flow.Flow

interface DirectoryRepository {
    suspend fun getDirectorys(): Flow<List<Directory>>

    suspend fun getDirectoryById(id: Int): Flow<Directory>

    suspend fun insertDirectory(directory: Directory)

    suspend fun deleteDirectory(directory: Directory)
}
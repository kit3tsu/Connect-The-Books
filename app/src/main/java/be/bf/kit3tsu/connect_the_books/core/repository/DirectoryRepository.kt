package be.bf.kit3tsu.connect_the_books.core.repository

import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySNote
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import kotlinx.coroutines.flow.Flow

interface DirectoryRepository {
    suspend fun getDirectories(): Flow<List<Directory>>

    //suspend fun getRootDirectory(): Flow<List<Directory>>

    suspend fun getDirectoryById(id: Int): Flow<Directory>

    suspend fun insertDirectory(directory: Directory)

    suspend fun deleteDirectory(directory: Directory)

    suspend fun getDirectorySNotes(): Flow<List<DirectorySNote>>

    suspend fun getDirectorySSubDirectories(): Flow<List<DirectorySubDirectory>>
}
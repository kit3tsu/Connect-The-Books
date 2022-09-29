package be.bf.kit3tsu.connect_the_books.core.usecases.shared

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import kotlinx.coroutines.flow.Flow

class GetDirectory (private val repository: DirectoryRepository) {
    suspend operator fun invoke(id: Int): Flow<Directory> {
        return repository.getDirectoryById(id)
    }
}
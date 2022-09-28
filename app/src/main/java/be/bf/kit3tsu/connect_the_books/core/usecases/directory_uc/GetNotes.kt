package be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySNote
import kotlinx.coroutines.flow.Flow

class GetNotes (private val repository: DirectoryRepository) {
    suspend operator fun invoke(): Flow<List<DirectorySNote>> {
        return repository.getDirectorySNotes()
    }
}
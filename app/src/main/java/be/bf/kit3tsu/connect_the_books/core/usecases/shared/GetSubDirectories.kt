package be.bf.kit3tsu.connect_the_books.core.usecases.shared

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Directory
import be.bf.kit3tsu.connect_the_books.data.relations.DirectorySubDirectory
import kotlinx.coroutines.flow.Flow

class GetSubDirectories(private val repository: DirectoryRepository) {
    suspend operator fun invoke(id: Int?): Flow<List<DirectorySubDirectory>> {
        //TODO validate data before insert
        return repository.getDirectorySSubDirectories(id)
    }
}
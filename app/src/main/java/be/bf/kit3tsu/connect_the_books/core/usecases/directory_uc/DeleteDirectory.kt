package be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Directory

class DeleteDirectory (private val repository: DirectoryRepository) {
    suspend operator fun invoke(directory: Directory){
        repository.deleteDirectory(directory)
    }
}
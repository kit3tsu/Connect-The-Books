package be.bf.kit3tsu.connect_the_books.core.usecases.shared

import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.data.entities.Directory

class AddDirectory(private val repository: DirectoryRepository) {
    suspend operator fun invoke(directory: Directory) {
        repository.insertDirectory(directory)
    }
}
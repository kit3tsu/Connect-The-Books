package be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc

import be.bf.kit3tsu.connect_the_books.core.usecases.shared.AddDirectory
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.GetDirectory
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.GetSubDirectories

data class DirectoryUseCases(
    val addDirectory: AddDirectory,
    val deleteDirectory: DeleteDirectory,
    val getSubDirectories: GetSubDirectories,
    val getDirectory: GetDirectory,
    val getNotes: GetNotes
) {
}
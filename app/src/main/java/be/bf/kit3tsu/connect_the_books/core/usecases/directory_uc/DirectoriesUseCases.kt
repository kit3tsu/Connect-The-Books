package be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc

data class DirectoriesUseCases(
    val addDirectory: AddDirectory,
    val deleteDirectory: DeleteDirectory,
    val getDirectories: GetDirectories,
    val getDirectory: GetDirectory,
    val getNotes: GetNotes
) {
}
package be.bf.kit3tsu.connect_the_books.core.usecases

data class NoteUseCases(
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val deleteNote: DeleteNote,
    val addNote: AddNote
) {
}
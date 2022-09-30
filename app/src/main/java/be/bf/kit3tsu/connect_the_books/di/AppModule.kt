package be.bf.kit3tsu.connect_the_books.di

import android.app.Application
import android.util.Log
import androidx.room.Room
import be.bf.kit3tsu.connect_the_books.core.repository.BookRepository
import be.bf.kit3tsu.connect_the_books.core.repository.DirectoryRepository
import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.DeleteDirectory
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.DirectoryUseCases
import be.bf.kit3tsu.connect_the_books.core.usecases.directory_uc.GetNotes
import be.bf.kit3tsu.connect_the_books.core.usecases.home_uc.*
import be.bf.kit3tsu.connect_the_books.core.usecases.note_uc.*
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.AddDirectory
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.AddNote
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.GetSubDirectories
import be.bf.kit3tsu.connect_the_books.core.usecases.shared.GetDirectory
import be.bf.kit3tsu.connect_the_books.data.Repository.BookRepositoryImpl
import be.bf.kit3tsu.connect_the_books.data.Repository.DirectoryRepositoryImpl
import be.bf.kit3tsu.connect_the_books.data.Repository.NoteRepositoryImpl
import be.bf.kit3tsu.connect_the_books.data.util.Databases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabases(app: Application): Databases {
        Log.d("Databases", "instance: db done")
        return Room.databaseBuilder(
            app,Databases::class.java,"app_db"
        ).allowMainThreadQueries().build()
//        return Databases.instance(app.applicationContext).createFromAsset("databases/app_db")
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: Databases): NoteRepository {
        return NoteRepositoryImpl(db.noteDao())
    }

    @Provides
    @Singleton
    fun provideBookRepository(db: Databases): BookRepository {
        return BookRepositoryImpl(db.bookDao())
    }

    @Provides
    @Singleton
    fun provideDirectoryRepository(db: Databases): DirectoryRepository {
        return DirectoryRepositoryImpl(db.directoryDao())
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getAllNotes = GetAllNotes(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository),
            deleteNote = DeleteNote(repository)
        )
    }

    @Provides
    @Singleton
    fun provideHomeUseCases(
        bookRepository: BookRepository,
        noteRepository: NoteRepository,
        directoryRepository: DirectoryRepository
    ): HomeUseCases {
        return HomeUseCases(
            addNote = AddNote(noteRepository),
            addBook = AddBook(bookRepository),
            addDirectory = AddDirectory(directoryRepository),
            getBook = GetBook(bookRepository),
            getBooks = GetBooks(bookRepository),
            getDirectory = GetDirectory(directoryRepository),
            getSubDirectories = GetSubDirectories(directoryRepository),
            getRootRepository = GetRootRepository(directoryRepository)
        )
    }

    @Provides
    @Singleton
    fun provideDirectoryUseCases(repository: DirectoryRepository): DirectoryUseCases {
        return DirectoryUseCases(
            addDirectory = AddDirectory(repository),
            deleteDirectory = DeleteDirectory(repository),
            getSubDirectories = GetSubDirectories(repository),
            getDirectory = GetDirectory(repository),
            getNotes = GetNotes(repository)
        )
    }
}
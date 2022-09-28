package be.bf.kit3tsu.connect_the_books.di

import android.app.Application
import androidx.room.Room
import be.bf.kit3tsu.connect_the_books.core.repository.NoteRepository
import be.bf.kit3tsu.connect_the_books.core.usecases.note_uc.*
import be.bf.kit3tsu.connect_the_books.data.Repository.NoteRepositoryImpl
import be.bf.kit3tsu.connect_the_books.data.util.Databases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabases(app:Application):Databases{
//        return Room.databaseBuilder(
//            app,Databases::class.java,"app_db"
//        ).build
        return Databases.instance(app.applicationContext)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:Databases): NoteRepository {
        return NoteRepositoryImpl(db.noteDao())
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            getAllNotes = GetAllNotes(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}
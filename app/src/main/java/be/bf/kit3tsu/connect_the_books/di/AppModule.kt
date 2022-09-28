package be.bf.kit3tsu.connect_the_books.di

import android.app.Application
import androidx.room.Room
import be.bf.kit3tsu.connect_the_books.data.Repository.NoteRepository
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
    fun provideDatabases(app:Application):Databases{
        return Room.databaseBuilder(
            app,Databases::class.java,"app_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:Databases):NoteRepository{
        return NoteRepositoryImpl(db.noteDao())
    }
}
package be.bf.kit3tsu.connect_the_books.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(primaryKeys = ["note_id", "tag_id"],indices = [Index(value = ["tag_id"])])
data class NoteTagCrossRef(
    val note_id: Int,
    val tag_id: Int
) : Parcelable

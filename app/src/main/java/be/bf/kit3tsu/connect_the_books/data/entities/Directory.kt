package be.bf.kit3tsu.connect_the_books.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import be.bf.kit3tsu.connect_the_books.data.util.Visibility
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Directory")
data class Directory constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "directory_id")
    var directoryId: Int? = null, @ColumnInfo(name = "directory_title")
    var title: String,
    @ColumnInfo(name = "directory_visibility")
    var visibility: Visibility,
    @ColumnInfo(name = "directory_parent")
    var parentDirectory: Int?
) : Parcelable
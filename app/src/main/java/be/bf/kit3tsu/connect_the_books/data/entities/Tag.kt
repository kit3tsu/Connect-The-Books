package be.bf.kit3tsu.connect_the_books.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Tag")
data class Tag constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id")
    var tagId: Int = -1,
    @ColumnInfo(name = "tag_Name")
    var name: String
) : Parcelable
package be.bf.kit3tsu.connect_the_books.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import be.bf.kit3tsu.connect_the_books.util.Visibility

@Entity(tableName = "Directory")
data class Directory @Ignore constructor(
    @ColumnInfo(name = "directory_name")
    var name: String,
    @ColumnInfo(name = "directory_path")
    var path: String,
    @ColumnInfo(name = "directory_image")
    var imgSrc: String,
    @ColumnInfo(name = "directory_visibility")
    var visibility: Visibility,
    @ColumnInfo(name = "directory_parent")
    var parentDirectory: Int?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "directory_id")
    var directoryId: Int = -1

    constructor(
        directoryId: Int,
        name: String,
        path: String,
        imgSrc: String,
        visibility: Visibility,
        parentDirectory: Int?
    ) : this(name, path, imgSrc, visibility, parentDirectory) {
        this.directoryId = directoryId
    }
}

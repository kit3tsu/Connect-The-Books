package be.bf.kit3tsu.connect_the_books.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Tag")
data class Tag @Ignore constructor(
    @ColumnInfo(name = "tag_Name")
    var name: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id")
    var tagId : Int = -1
    constructor(tagId:Int,name: String) : this(name){
        this.tagId = tagId
    }
}
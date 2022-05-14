package eu.tuto.bangercat.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music_table")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String,
    val title: String,
    val music: String
)
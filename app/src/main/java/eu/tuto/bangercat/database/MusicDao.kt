package eu.tuto.bangercat.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MusicDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMusic(user: Data)

    @Query("SELECT * FROM music_table ORDER BY ID ASC")
    fun readAllData(): LiveData<List<Data>>

    @Query("SELECT * FROM music_table ORDER BY ID ASC")
    fun searchDatabase(searchQuery: String): Flow<List<Data>>
}
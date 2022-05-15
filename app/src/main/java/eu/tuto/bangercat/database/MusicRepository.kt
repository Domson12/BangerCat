package eu.tuto.bangercat.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class MusicRepository(private val addMusicDao: MusicDao) {
    val readAllData: LiveData<List<Data>> = addMusicDao.readAllData()

    suspend fun addMusic(user: Data){
        addMusicDao.addMusic(user)
    }
    //fun searchDatabase(searchQuery: String): Flow<List<Data>>{
        //return addMusicDao.searchDatabase(searchQuery)
   // }
}
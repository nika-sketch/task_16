package ge.nlatsabidze.task_16.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ge.nlatsabidze.task_16.entitydata.UserInformationTable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(item: UserInformationTable)

    @Query("SELECT * FROM user_table")
    fun getInformation(): LiveData<MutableList<UserInformationTable>>

    @Delete
    suspend fun deleteUser(user: UserInformationTable)

    @Update
    suspend fun updateUser(user: UserInformationTable)
}
package ge.nlatsabidze.task_16.database

import androidx.room.Room
import androidx.room.Database
import ge.nlatsabidze.task_16.App
import androidx.room.RoomDatabase
import ge.nlatsabidze.task_16.dao.UserDao

import ge.nlatsabidze.task_16.entitydata.UserInformationTable

@Database(entities = [UserInformationTable::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        val db by lazy {
            Room.databaseBuilder(
                App.context!!,
                UserDataBase::class.java,
                "Items"
            ).build()
        }
    }
}
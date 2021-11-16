package ge.nlatsabidze.task_16.MainViewModel

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.nlatsabidze.task_16.dao.UserDao
import ge.nlatsabidze.task_16.database.UserDataBase
import ge.nlatsabidze.task_16.entitydata.UserInformationTable
import kotlinx.coroutines.launch


class UserViewModel : ViewModel() {

    private var userdao: UserDao = UserDataBase.db.userDao()

    private val _readData: LiveData<MutableList<UserInformationTable>> = userdao.getInformation()
    val readData: LiveData<MutableList<UserInformationTable>> get() = _readData

    fun addUser(title: String, description: String, url: String) {
        viewModelScope.launch {
            userdao.insertUser(UserInformationTable(title, description, url))
        }
    }

    fun deleteUser(user: UserInformationTable) {
        viewModelScope.launch {
            userdao.deleteUser(user)
        }
    }
}
package ge.nlatsabidze.task_16.entitydata

import androidx.room.*

@Entity(tableName = "user_table")
data class UserInformationTable(
    @ColumnInfo(name = "first_name") val title: String?,
    @ColumnInfo(name = "last_name") val description: String?,
    @ColumnInfo(name = "url") val imgUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

package ir.hoseinahmadi.frenchpastry.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.hoseinahmadi.frenchpastry.data.db.dao.FaveDao
import ir.hoseinahmadi.frenchpastry.data.db.entites.FaveEntities

@Database(entities = [FaveEntities::class], version = 1, exportSchema = false)
abstract class PastryDataBase :RoomDatabase() {

    abstract fun FaveDao():FaveDao

}
package ir.hoseinahmadi.frenchpastry.data.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.hoseinahmadi.frenchpastry.util.Constants.FAVE_TABLE

@Entity
data class FaveEntities(
    @PrimaryKey
    val id:Int,
    val name:String,
    val salePrice:Int,
    val imgAddress:String
)

package ir.hoseinahmadi.frenchpastry.data.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopEntities(
    @PrimaryKey
    val id:Int,
    val title:String,
    val salePrice:Int,
    val priceOr :Int,
    val img:String,
    val count:Int,
)

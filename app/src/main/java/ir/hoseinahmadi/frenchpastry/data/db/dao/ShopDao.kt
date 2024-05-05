package ir.hoseinahmadi.frenchpastry.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.hoseinahmadi.frenchpastry.data.db.entites.ShopEntities
import ir.hoseinahmadi.frenchpastry.ui.screen.basket.TotalDiscountsAndPaid
import ir.hoseinahmadi.frenchpastry.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addShopOrder(item: ShopEntities)

    @Delete
    fun deleteShopOrder(item: ShopEntities)

    @Query("update shopentities set count =:newCount where id=:id")
    fun changeCartItem(id: Int, newCount: Int)

    @Query("select total(count) as count from shopentities")
    fun getCartItemCount(): Flow<Int>

    @Query("select * from shopentities")
    fun getAllItemInShop(): Flow<List<ShopEntities>>
    @Query("SELECT SUM((price * discount / 100) * count) AS totalDiscount, SUM((price - (price * discount / 100)) * count) AS totalPaid FROM shopentities")
    fun getTotalDiscountsAndPaid(): Flow<TotalDiscountsAndPaid>

}
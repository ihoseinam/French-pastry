package ir.hoseinahmadi.frenchpastry.ui.screen.product_detail.comment

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.gson.Gson
import ir.hoseinahmadi.frenchpastry.data.model.product_detail.Comment

@Composable
fun CommentAndRepliesScreen(
    data:String
){
    val item =Gson().fromJson(data,Comment::class.java)

    Text(text = "${item.body}\n ${item.replies[0].body}")

}
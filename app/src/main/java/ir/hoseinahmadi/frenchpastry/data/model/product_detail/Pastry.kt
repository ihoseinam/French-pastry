package ir.hoseinahmadi.frenchpastry.data.model.product_detail

data class Pastry(
    val ID: Int,
    val active_special_discount: Boolean,
    val active_stock: Boolean,
    val bookmark: Boolean,
    val categories: List<Category>,
    val comment_count: Int,
    val comments: List<Comment>,
    val content: String,
    val date: String,
    val date_i18n: String,
    val discount_percent: Int,
    val discount_percent_110n: String,
    val excerpt: String,
    val gallery: List<String>,
    val has_discount: Boolean,
    val materials: List<Material>,
    val max_order: Int,
    val min_order: Int,
    val order_step: Int,
    val price: Int,
    val rate: Rate,
    val related: List<Related>,
    val sale_price: Int,
    val special_discount: Int,
    val special_discount_date: String,
    val status: String,
    val stock: Int,
    val thumbnail: String,
    val title: String,
    val weight: Int,
    val whole_price: String,
    val whole_sale_price: Int
)
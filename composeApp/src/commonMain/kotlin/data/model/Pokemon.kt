package data.model

data class Pokemon(
    val id: Int, val enName:String, val name: String, val description: String, val genus: String, val sprite: String?
) {
    val stringId: String = "#${id.toString().padStart(3, '0')}"
}

package com.cdev.service.tmdb

/**
 * Maps our customer category ids to TMDB categories, but directly
 * returning the matching URL to request the category from TMDB.
 */
class TmdbCategoryMapper {
    companion object {
        fun map(categoryId: String?): String? {
            if (categoryId == null) {
                return null
            }

            return when (categoryId) {
                "1000" -> "" // TODO implement Continue watching
                "1001" -> "/on_the_air"
                "1002" -> "/airing_today"
                "1003" -> "/popular"
                "1004" -> "/top_rated"
                else -> null
            }
        }
    }
}
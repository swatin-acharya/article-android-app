package com.interestingarticles.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey var id: String,
    var date: String,
    var header: String,
    var bannerPictureUrl: String,
    var mainArticleString: String,
    var opinion: String
)
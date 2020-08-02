package com.artamonov.instagrammockpage.models

data class Post(val author: String, var geoTag: String, var description: String,
                var profilePhoto: String? = null,
                var postImagePath: String? = null)

val firstPost = Post(author = "milena_thebrowbar", geoTag = "The Brow Bar Kharkov",
    description = "Beauty @anna_zavadskaya \uD83D\uDC99 @covernumberone #thebrowbarkharkov #makeup",
    profilePhoto = "https://previews.123rf.com/images/domenicogelermo/domenicogelermo1110/domenicogelermo111000010/10802238-portrait-of-beautiful-girl-with-attractive-face-isolated-on-white.jpg",
    postImagePath = "https://blog-www.pods.com/wp-content/uploads/2019/04/MG_1_1_New_York_City-1.jpg")
val secondPost = Post(author = "alex007", geoTag = "Gorky Park Kharkov",
    description = "Beautiful nature! ❤️",
    profilePhoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRS9K8g5VzPoLeJ6fRvhkcSMiMita7eu-KsgA&usqp=CAU",
    postImagePath = "https://media.timeout.com/images/105639289/630/472/image.jpg")



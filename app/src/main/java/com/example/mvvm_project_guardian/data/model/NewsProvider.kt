package com.example.mvvm_project_guardian.data.model

class NewsProvider {

    companion object {
        var news: NewsModel? = null
    }


    /*companion object {
        fun returnApi(): NewsModel{
            return api
        }

    val api =
        NewsModel(
            Response(
                status = "ok",
                userTier = "developer",
                total = 5400,
                startIndex = 1,
                pageSize = 10,
                currentPage = 1,
                pages = 540,
                orderBy = "relevance",
                listOf(
                    Result(
                        id = "media/2021/nov/01/bbc-rejects-complaints-that-it-published-transphobic-article",
                        type = "article",
                        sectionId = "media",
                        sectionName = "Media",
                        webPublicationDate = "2021-11-01T18:43:34Z",
                        webTitle = "BBC rejects complaints that it published transphobic article",
                        webUrl = "https://www.theguardian.com/media/2021/nov/01/bbc-rejects-complaints-that-it-published-transphobic-article",
                        apiUrl = "https://content.guardianapis.com/media/2021/nov/01/bbc-rejects-complaints-that-it-published-transphobic-article",
                        Field(null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null, null),
                        tags = null,
                        isHosted = false,
                        pillarId = "pillar/news",
                        pillarName = "News"
                    )
                )
        )
        )

        }*/
}
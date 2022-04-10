package io.demoapps.comic_characters.ui.main.post

import androidx.lifecycle.*
import io.demoapps.comic_characters.SessionManager
import io.demoapps.comic_characters.models.Posts
import io.demoapps.comic_characters.network.main.MainApi
import io.demoapps.comic_characters.ui.main.MainResource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel
@Inject constructor(
    private val sessionManager: SessionManager,
    private val mainApi: MainApi
) : ViewModel() {

    private var listOfPosts = MediatorLiveData<MainResource<List<Posts>>>()

    fun observePosts(): LiveData<MainResource<List<Posts>>> {
        listOfPosts.value = MainResource.loading(null)

        val source = LiveDataReactiveStreams.fromPublisher(
            mainApi.getPostsFromUser(sessionManager.getAuthUser().value?.data?.userId ?: -1)
                .onErrorReturn(object : Function<Throwable, List<Posts>> {
                    override fun apply(t: Throwable?): ArrayList<Posts> {
                        val post = Posts(-1)
                        val postArrayList = ArrayList<Posts>()
                        postArrayList.add(post)
                        return postArrayList
                    }
                })
                .map(object : Function<List<Posts>, MainResource<List<Posts>>> {
                    override fun apply(posts: List<Posts>): MainResource<List<Posts>> {
                        if (posts.size > 0) {
                            if (posts[0].userId == -1) {
                                return MainResource.error("", null)
                            }
                        }
                        return MainResource.success(posts)
                    }
                })
                .subscribeOn(Schedulers.io())
        )

        listOfPosts.addSource(source, object : Observer<MainResource<List<Posts>>> {
            override fun onChanged(t: MainResource<List<Posts>>?) {
                listOfPosts.value = t
                listOfPosts.removeSource(source)
            }
        })
        return listOfPosts
    }
}
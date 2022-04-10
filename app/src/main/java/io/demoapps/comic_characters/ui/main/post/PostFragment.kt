package io.demoapps.comic_characters.ui.main.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.models.Posts
import io.demoapps.comic_characters.ui.main.MainResource
import io.demoapps.comic_characters.viewmodel.ViewModelProvidersFactory
import javax.inject.Inject

class PostFragment: DaggerFragment() {
    lateinit var postViewModel: PostViewModel

    @Inject
    lateinit var providersFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postViewModel = ViewModelProvider(this, providersFactory).get(PostViewModel::class.java)
        subscribePost()
    }

    private fun subscribePost(){
        //postViewModel.observePosts().removeObserver(viewLifecycleOwnerLiveData)

        postViewModel.observePosts().observe(viewLifecycleOwner, object : Observer<MainResource<List<Posts>>> {
            override fun onChanged(listOfPosts: MainResource<List<Posts>>?) {
                if (listOfPosts != null) {
                    println("------list: ${listOfPosts}")
                }
            }
        })
    }

}

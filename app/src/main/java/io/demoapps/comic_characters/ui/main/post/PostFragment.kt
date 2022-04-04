package io.demoapps.comic_characters.ui.main.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import io.demoapps.comic_characters.R
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
        postViewModel.checkPostViewModel()
        println("--------post fragment working")
    }


}

package io.demoapps.comic_characters.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.viewmodel.ViewModelProvidersFactory
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {
    private lateinit var profileViewModel: ProfileViewModel

    @Inject
    lateinit var providersFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "Profile fragment", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileViewModel = ViewModelProvider(this, providersFactory).get(ProfileViewModel::class.java)
    }
}

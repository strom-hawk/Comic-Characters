package io.demoapps.comic_characters.ui.main.profile

import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import io.demoapps.comic_characters.R
import io.demoapps.comic_characters.models.User
import io.demoapps.comic_characters.ui.auth.AuthResource
import io.demoapps.comic_characters.viewmodel.ViewModelProvidersFactory
import javax.inject.Inject


class ProfileFragment : DaggerFragment() {
    private lateinit var profileViewModel: ProfileViewModel

    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileViewModel = ViewModelProvider(this, providerFactory).get(ProfileViewModel::class.java)
        //subscribeObserver()
        println("-------profile")
    }

/*    private fun subscribeObserver(){
        profileViewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        profileViewModel.getAuthenticatedUser().observe(viewLifecycleOwner, object : Observer<AuthResource<User>>{
            override fun onChanged(user: AuthResource<User>?) {
                if(user != null){
                    when(user.status){
                        AuthResource.AuthStatus.AUTHENTICATED -> {
                            setUserDetails(user.data)
                        }
                        AuthResource.AuthStatus.ERROR -> {
                            setUserError(user.message)
                        }
                    }
                }
            }
        })
    }*/

    private fun setUserDetails(user: User?){
        if(user != null){

        }
    }

    private fun setUserError(message: String?){
        if(message != null){

        }
    }
    
}

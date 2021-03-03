package com.example.themoviedb.ui.login

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.themoviedb.Preferances
import com.example.themoviedb.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        on_regist_button.setOnClickListener {
            onRegister()
        }

        login_button.setOnClickListener {
            userCheck(login_email.text.toString(), login_password.text.toString())
        }
    }

    private fun userCheck(login: String, password: String) {

        if (Preferances.getLogin(requireContext(), login, password)) {
            onLogIn(login)
            closeKeyboard()
        } else {
            Toast.makeText(context, "Incorrect username and password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onLogIn(login: String) {
        Preferances.setUser(requireContext(), login)
        findNavController().navigate(R.id.action_loginFragment_to_nav_home)
    }

    private fun onRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun closeKeyboard() {
        val imm: InputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}
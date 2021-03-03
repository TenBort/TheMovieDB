package com.example.themoviedb.ui.register

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
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registration_button.setOnClickListener {

            closeKeyboard()
            Preferances.setUser(requireContext(), register_email.text.toString())
            if (validateEmailPassword()) {
                val userEmail = register_email.text.toString()
                val userPassword = register_password.text.toString()
                Preferances.setLogin(requireContext(), userEmail, "$userEmail $userPassword")
                findNavController().navigate(R.id.action_nav_registerFragment_to_nav_home)
            }
        }
    }

    private fun closeKeyboard() {
        val imm: InputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    private fun validateEmailPassword(): Boolean {

        if (register_email.text.matches(emailPattern.toRegex()) && register_password.text.length > 4 && register_password.text.length < 20) {
            return true
        } else if (register_email.text.isEmpty()) {
            Toast.makeText(
                context, "Enter email",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else if (register_password.text.isEmpty()) {
            Toast.makeText(
                context, "Enter password",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else if (register_password.text.length < 4) {
            Toast.makeText(
                context, "Password must contain at least 4 characters",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else if (register_password.text.length > 20) {
            Toast.makeText(
                context, "password must be no more than 20 characters",
                Toast.LENGTH_SHORT
            ).show()
            return false
        } else {
            Toast.makeText(
                context, "email is not valid",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
    }
}
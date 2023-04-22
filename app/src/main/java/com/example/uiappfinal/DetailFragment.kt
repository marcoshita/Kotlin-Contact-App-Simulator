package com.example.uiappfinal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"
private const val ARG_PARAM5 = "param5"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var phone: String? = null
    private var name: String? = null
    private var surname: String? = null
    private var email: String? = null
    private var birthdate: String? = null
    private lateinit var db: AppDatabase
    private lateinit var nameInput: EditText
    private lateinit var surnameInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var birthInput: EditText
    private lateinit var emailInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            phone = it.getString(ARG_PARAM1)
            name = it.getString(ARG_PARAM2)
            surname = it.getString(ARG_PARAM3)
            email = it.getString(ARG_PARAM4)
            birthdate = it.getString(ARG_PARAM5)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameInput = view.findViewById(R.id.formName)
        surnameInput = view.findViewById(R.id.formSurname)
        phoneInput = view.findViewById(R.id.formPhone)
        birthInput = view.findViewById(R.id.formBirthdate)
        emailInput = view.findViewById(R.id.formEmail)

        nameInput.setText(name)
        surnameInput.setText(surname)
        phoneInput.setText(phone)
        birthInput.setText(birthdate)
        emailInput.setText(email)

        val callBtn = view.findViewById<ImageView>(R.id.callButton)
        val editBtn = view.findViewById<ImageView>(R.id.detailEditButton)

        callBtn.setOnClickListener(){
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:" + phone))
            startActivity(intent)
        }
        db = AppDatabase.getInstance(requireContext())!!

        editBtn.setOnClickListener(){

            GlobalScope.launch {
                phone?.let { it1 ->
                    db.ContactDAO().updateContact(nameInput.text.toString(), surnameInput.text.toString(), birthInput.text.toString(), emailInput.text.toString(),
                        it1
                    )
                }
                val intent = Intent(context, MainActivity::class.java).apply {
                }
                context?.startActivity(intent)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(phone: String, name: String, surname: String, email: String, birthdate: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, phone)
                    putString(ARG_PARAM2, name)
                    putString(ARG_PARAM3, surname)
                    putString(ARG_PARAM4, email)
                    putString(ARG_PARAM5, birthdate)
                }
            }
    }
}
package ge.nlatsabidze.task_16.fragments

import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ge.nlatsabidze.task_16.BaseFragment
import ge.nlatsabidze.task_16.MainViewModel.UserViewModel
import ge.nlatsabidze.task_16.R
import ge.nlatsabidze.task_16.databinding.FragmentSecondBinding
import ge.nlatsabidze.task_16.entitydata.UserInformationTable


class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun start() {
        returnBackToHomeFragment()
    }

    private fun returnBackToHomeFragment() {
        binding.backToHomeButton.setOnClickListener {
            val result = checkValuesCorrectness()
            if (result) {
                userViewModel.addUser(binding.titleEditText.text.toString(), binding.descriptionEditText.text.toString(), binding.newImageView.text.toString())
                findNavController().navigate(R.id.action_secondFragment_to_homeFragment)
            } else {
                Toast.makeText(requireContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private fun checkValuesCorrectness() : Boolean {

        val titleSize = binding.titleEditText.text.toString().length
        val descriptionSize = binding.descriptionEditText.text.toString().length

        if (titleSize in 6..29 && descriptionSize in 6..299) {
            return true
        }
        return false
    }
}
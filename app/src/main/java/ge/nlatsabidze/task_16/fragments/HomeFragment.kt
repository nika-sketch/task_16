package ge.nlatsabidze.task_16.fragments

import android.os.Parcelable
import android.util.Log.d
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.task_16.BaseFragment
import ge.nlatsabidze.task_16.MainViewModel.UserViewModel
import ge.nlatsabidze.task_16.R
import ge.nlatsabidze.task_16.adapter.UserRecyclerAdapter
import ge.nlatsabidze.task_16.databinding.FragmentHomeBinding
import ge.nlatsabidze.task_16.entitydata.UserInformationTable


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val userViewModel: UserViewModel by activityViewModels()

    private lateinit var userItemAdapter: UserRecyclerAdapter


    override fun start() {

        goToSecondFragment()
        initRecyclerView()
    }

    private fun goToSecondFragment() {
        binding.btnAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
        }
    }

    private fun initRecyclerView() {

        userItemAdapter = UserRecyclerAdapter()

        binding.idRecyclerView.apply {
            adapter = userItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        userViewModel.readData.observe(viewLifecycleOwner, {
            userItemAdapter.userData = it
        })
    }
}
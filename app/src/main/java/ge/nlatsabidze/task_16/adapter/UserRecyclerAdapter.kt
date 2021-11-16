package ge.nlatsabidze.task_16.adapter

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ge.nlatsabidze.task_16.databinding.RecyclerviewItemBinding
import ge.nlatsabidze.task_16.entitydata.UserInformationTable

class UserRecyclerAdapter: RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder>() {

    var userData: MutableList<UserInformationTable> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class UserViewHolder(private val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentData: UserInformationTable


        fun onBind()  {
            currentData = userData[bindingAdapterPosition]
            binding.tvTitle.text = currentData.title
            binding.tvDescription.text = currentData.description
            Glide.with(binding.root.context)
                .load(currentData.imgUrl)
                .apply(RequestOptions().override(150, 210))
                .into(binding.ivItemImage)

            binding.root.setOnLongClickListener {
                deleteItem(bindingAdapterPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRecyclerAdapter.UserViewHolder {
        return UserViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = userData.size

    private fun deleteItem(position: Int) {
        userData.removeAt(position)
        notifyDataSetChanged()
    }
}
package fragments.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.todoappk.databinding.ActivityRowLayoutBinding
import models.ToDoData

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(private val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {


    }

}
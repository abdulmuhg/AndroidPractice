package personal.abdulmughniaf.androidpractice.ui.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*
import personal.abdulmughniaf.androidpractice.R
import personal.abdulmughniaf.androidpractice.foundation.BaseRecyclerAdapter
import personal.abdulmughniaf.androidpractice.models.Task
import personal.abdulmughniaf.androidpractice.view.TodoView

class TaskAdapter (
        taskList: MutableList<Task> = mutableListOf()
): BaseRecyclerAdapter<Task>(taskList){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }

    class ViewHolder(view: View): BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            view.titleView.text = data.title

            data.todo.forEach {todo ->
                val todoView = (LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false) as TodoView).apply {
                    initView(todo)
                }
                view.todoContainer.addView(todoView)
            }

        }

    }
}
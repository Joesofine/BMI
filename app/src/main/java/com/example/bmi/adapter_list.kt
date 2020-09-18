package com.example.bmi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.ArrayList

class adapter_list(context: Context, arr: ArrayList<User>) : ArrayAdapter<String?>(
    context,
    R.layout.list_element
) {
    private var context1 = context
    private val bmiArr: ArrayList<User> = arr
    override fun getCount(): Int {
        return bmiArr.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var viewHolder = ViewHolder()
        if (convertView == null) {
            val mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = mInflater.inflate(R.layout.list_element, parent, false)
            viewHolder.name = convertView!!.findViewById<TextView>(R.id.Name_list)
            viewHolder.bmi = convertView.findViewById<TextView>(R.id.BMI_list)
            convertView.setTag(viewHolder)
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        viewHolder.name?.text = bmiArr[position].Name
        viewHolder.bmi?.text = bmiArr[position].BMI.toString()

        return convertView
    }

    internal class ViewHolder {
        var name: TextView? = null
        var bmi: TextView? = null
    }

    init {
        context1 = context
    }
}

package com.example.bmi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.ArrayList

class adapter_list(context: Context, arr: ArrayList<Person>) : ArrayAdapter<String?>(
    context,
    R.layout.list_element
) {
    private var context1 = context
    private val bmiArr: ArrayList<Person> = arr
    override fun getCount(): Int {
        return bmiArr.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var viewHolder = ViewHolder()
        if (convertView == null) {
            val mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = mInflater.inflate(R.layout.list_element, parent, false)
            viewHolder.Name = convertView!!.findViewById<TextView>(R.id.Name_list)
            viewHolder.BMI = convertView.findViewById<TextView>(R.id.BMI_list)
            convertView.setTag(viewHolder)
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        viewHolder.Name?.text = bmiArr[position].Name
        viewHolder.BMI?.text = bmiArr[position].BMI.toString()

        return convertView
    }

    internal class ViewHolder {
        var Name: TextView? = null
        var BMI: TextView? = null
    }

    init {
        context1 = context
    }
}

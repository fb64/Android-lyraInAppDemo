package com.lyranetwork.demo.payapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.lyranetwork.demo.payapp.R


class SpinnerAdapter(private val ctx: Context, resource: Int, private val contentArray: Array<String>,
                     private val imageArray: Array<Int>) :
        ArrayAdapter<String>(ctx, resource, R.id.paymentMode, contentArray) {

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = inflater.inflate(R.layout.row, parent, false)
        val textView = row.findViewById<TextView>(R.id.paymentMode)
        textView.text = contentArray[position]
        val imageView = row.findViewById<ImageView>(R.id.icon)
        imageView.setImageResource(imageArray[position])
        return row
    }
}
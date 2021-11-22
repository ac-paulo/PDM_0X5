package br.com.ifpb.pdm_0x5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ColorRGBAdapter(var context: Context, var listColor: ArrayList<ColorRGB>) : BaseAdapter() {

    override fun getCount(): Int {
        return this.listColor.count()
    }

    override fun getItem(position: Int): Any {
        return this.listColor.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(this.context).inflate(R.layout.color_layout, parent, false)

        val color = this.listColor.get(position)

        val textColorRGB = view.findViewById<TextView>(R.id.textViewColorRGB)

        textColorRGB.text = "${color.red}, ${color.blue}, ${color.green}"

        view.minimumHeight = 100

        return view
    }
}
package com.tokopedia.filter.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.tokopedia.filter.R
import com.tokopedia.filter.view.models.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.main_item.view.*
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import java.text.DecimalFormat

class ProductAdapter(
        val context: Context,
        val products: List<Product>
): RecyclerView.Adapter<ProductAdapter.ViewHolder>(), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(products[position])
    }
    override fun getItemCount(): Int = products.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val df = DecimalFormat("###,###,###")

        @SuppressLint("SetTextI18n")
        fun bindItem(items: Product) {
            view.title.text = items.name
            view.price.text = "Rp. "+df.format(items.priceInt).replace(',','.')
            view.city.text = items.shop.city

            try {
                val bitmap = BitmapFactory.decodeStream(URL(items.imageUrl).content as InputStream)
                view.image.setImageBitmap(bitmap)
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}
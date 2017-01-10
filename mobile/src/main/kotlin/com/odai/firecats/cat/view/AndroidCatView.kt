package com.odai.firecats.cat.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.odai.firecats.cat.displayer.CatDisplayer
import com.odai.firecats.cat.model.Cat
import com.odai.firecats.imageloader.Crop
import com.odai.firecats.imageloader.load

class AndroidCatView(context: Context, attrs: AttributeSet): CatDisplayer, ImageView(context, attrs) {

    override fun display(cat: Cat) {
        val target = this
        load(cat.image) {
            cropAs { Crop.FIT_CENTER }
            into { target }
        }
    }

}

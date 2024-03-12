package com.rnwnativecomp.customview

import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class ReactImageManager(
    private val callerContext: ReactApplicationContext
) : SimpleViewManager<ImageView>() {

    override fun getName() = REACT_CLASS

    companion object {
        const val REACT_CLASS = "RCTImageViewer"
    }

    override fun createViewInstance(context: ThemedReactContext): ImageView {
        val imageView = ImageView(context)
        imageView.setBackgroundColor(Color.RED)
        return imageView
    }

    @ReactProp(name = "imageUri")
    fun setImageUri(view: ImageView, imageUri: String) {
        Log.d("ReactImageManager", "setImageUri called with URI: $imageUri")
        Glide.with(view.context)
            .load(imageUri)
            .into(view)
    }
}
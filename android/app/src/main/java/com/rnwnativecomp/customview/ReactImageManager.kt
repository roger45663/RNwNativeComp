package com.rnwnativecomp.customview

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewProps
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.facebook.react.views.image.ImageResizeMode
import com.facebook.react.views.image.ReactImageView

class ReactImageManager(
    private val callerContext: ReactApplicationContext
) : SimpleViewManager<ReactImageView>() {

    override fun getName() = REACT_CLASS

    companion object {
        const val REACT_CLASS = "RCTImageViewer"
    }

    override fun createViewInstance(context: ThemedReactContext) =
        ReactImageView(context, Fresco.newDraweeControllerBuilder(), null, callerContext)

    @ReactProp(name = "src")
    fun setSrc(view: ReactImageView, sources: ReadableArray?) {
        view.setSource(sources)
    }

    @ReactProp(name = "borderRadius", defaultFloat = 0f)
    override fun setBorderRadius(view: ReactImageView, borderRadius: Float) {
        view.setBorderRadius(borderRadius)
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    fun setResizeMode(view: ReactImageView, resizeMode: String?) {
        view.setScaleType(ImageResizeMode.toScaleType(resizeMode))
    }

//    override fun createViewInstance(context: ThemedReactContext): ImageView {
//        val imageView = ImageView(context)
//        imageView.setBackgroundColor(Color.RED)
//        return imageView
//    }

//    @ReactProp(name = "imageUri")
//    fun setImageUri(view: ImageView, imageUri: String) {
//        Log.d("ReactImageManager", "setImageUri called with URI: $imageUri")
//        Glide.with(view.context)
//            .load(imageUri)
//            .into(view)
//    }
}
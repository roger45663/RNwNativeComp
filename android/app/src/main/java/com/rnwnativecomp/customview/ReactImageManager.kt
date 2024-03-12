package com.rnwnativecomp.customview

import android.graphics.Color
import android.view.View
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

class ReactImageManager(
    private val callerContext: ReactApplicationContext
) : SimpleViewManager<View>() {

    override fun getName() = REACT_CLASS

    companion object {
        const val REACT_CLASS = "RCTImageViewer"
    }

    override fun createViewInstance(context: ThemedReactContext): View {
        val view = View(context)
        view.setBackgroundColor(Color.BLUE)
        return view
    }
}
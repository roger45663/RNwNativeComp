package com.rnwnativecomp.fragmentview

import android.view.Choreographer
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactPropGroup

class MyViewManager(
    private val reactContext: ReactApplicationContext
) : ViewGroupManager<FrameLayout>() {
    private var propWidth: Int? = null
    private var propHeight: Int? = null

    override fun getName() = REACT_CLASS

    /**
     * Return a FrameLayout which will later hold the Fragment
     */
    override fun createViewInstance(reactContext: ThemedReactContext) =
        FrameLayout(reactContext)

    // 重寫 getCommandsMap 方法，該方法返回一個 Map，將 "create" 命令映射到一個整數
    override fun getCommandsMap() = mapOf("create" to COMMAND_CREATE)

    // 重寫 receiveCommand 方法，該方法處理從 JS 傳來的命令，並調用 createFragment 方法
    override fun receiveCommand(
        root: FrameLayout,
        commandId: String,
        args: ReadableArray?
    ) {
        super.receiveCommand(root, commandId, args)
        val reactNativeViewId = requireNotNull(args).getInt(0)

        when (commandId.toInt()) {
            COMMAND_CREATE -> createFragment(root, reactNativeViewId)
        }
    }

    // 定義 setStyle 方法，該方法用於設置視圖的寬度和高度
    @ReactPropGroup(names = ["width", "height"], customType = "Style")
    fun setStyle(view: FrameLayout, index: Int, value: Int) {
        if (index == 0) propWidth = value
        if (index == 1) propHeight = value
    }

    /**
     * Replace your React Native view with a custom fragment
     */
    fun createFragment(root: FrameLayout, reactNativeViewId: Int) {
        val parentView = root.findViewById<ViewGroup>(reactNativeViewId)
        setupLayout(parentView)

        val myFragment = MyFragment()
        val activity = reactContext.currentActivity as FragmentActivity
        activity.supportFragmentManager
            .beginTransaction()
            .replace(reactNativeViewId, myFragment, reactNativeViewId.toString())
            .commit()
    }

    fun setupLayout(view: View) {
        Choreographer.getInstance().postFrameCallback(object: Choreographer.FrameCallback {
            override fun doFrame(frameTimeNanos: Long) {
                manuallyLayoutChildren(view)
                view.viewTreeObserver.dispatchOnGlobalLayout()
                Choreographer.getInstance().postFrameCallback(this)
            }
        })
    }

    // 定義 manuallyLayoutChildren 方法，該方法用於手動佈局視圖的子視圖
    private fun manuallyLayoutChildren(view: View) {
        val width = requireNotNull(propWidth)
        val height = requireNotNull(propHeight)

        view.measure(
            View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY))

        view.layout(100, 300, width, height)
    }

    companion object {
        private const val REACT_CLASS = "MyViewManager"
        private const val COMMAND_CREATE = 1
    }
}
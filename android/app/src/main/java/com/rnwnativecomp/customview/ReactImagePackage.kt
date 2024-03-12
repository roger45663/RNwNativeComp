package com.rnwnativecomp.customview

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext

class ReactImagePackage: ReactPackage {
    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = listOf(ReactImageManager(reactContext))

    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ): MutableList<NativeModule> = mutableListOf()
}
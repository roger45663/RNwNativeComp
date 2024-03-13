package com.rnwnativecomp.fragmentview

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class MyPackage : ReactPackage {
    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ) = listOf(MyViewManager(reactContext))

    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ): MutableList<NativeModule> = mutableListOf()
}
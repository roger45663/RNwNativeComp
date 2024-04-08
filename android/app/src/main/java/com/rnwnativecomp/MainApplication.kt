package com.rnwnativecomp

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.flipper.ReactNativeFlipper
import com.facebook.soloader.SoLoader
import com.rnwnativecomp.customview.ReactImagePackage
import com.rnwnativecomp.fragmentview.MyPackage
import com.microsoft.codepush.react.CodePush;

class MainApplication : Application(), ReactApplication {

  override val reactNativeHost: ReactNativeHost =
      object : DefaultReactNativeHost(this) {
        override fun getPackages(): List<ReactPackage> =
            PackageList(this).packages.apply {
              // Packages that cannot be autolinked yet can be added manually here, for example:
              // add(MyReactNativePackage())
              add(MyAppPackage())
              add(ReactImagePackage())
              add(MyPackage())
            }

        // 重寫getJSMainModuleName方法，該方法返回一個字符串，表示JS主模塊的名稱
        override fun getJSMainModuleName(): String = "index"

        // 重寫getUseDeveloperSupport方法，該方法返回一個布爾值，表示是否開啟開發者支持
        override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

        // 重寫isNewArchEnabled屬性，該屬性返回一個布爾值，表示是否啟用新架構
        override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
        // 重寫isHermesEnabled屬性，該屬性返回一個布爾值，表示是否啟用Hermes
        override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED

        override fun getJSBundleFile(): String {
          return CodePush.getJSBundleFile()
        }
      }

  override val reactHost: ReactHost
    get() = getDefaultReactHost(this.applicationContext, reactNativeHost)

  // 重寫onCreate方法，該方法在應用創建時被調用
  override fun onCreate() {
    super.onCreate()
    SoLoader.init(this, false)
    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      load()
    }
    ReactNativeFlipper.initializeFlipper(this, reactNativeHost.reactInstanceManager)
  }
}
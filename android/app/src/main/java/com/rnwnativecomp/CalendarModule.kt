package com.rnwnativecomp

import android.util.Log
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.WritableArray

class CalendarModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    // 會被當作 module 的名字
    override fun getName() = "CalendarModule"

    @ReactMethod
    fun createCalendarEvent(name: String, location: String, promise: Promise) {
        Log.d("CalendarModule", "Create event called with name: $name and location: $location")
       try {
           val eventId = "Android!"
           promise.resolve(eventId)
       } catch (e: Throwable) {
           promise.reject("Create Event Error", e)
       }
    }

    override fun getConstants(): MutableMap<String, Any> =
        hashMapOf("DEFAULT_EVENT_NAME" to "New Event")
}
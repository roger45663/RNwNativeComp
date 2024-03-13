package com.rnwnativecomp.fragmentview

// 引入 Android 的 Context 類別，用於存取應用程式的資源和環境
import android.content.Context
// 引入 Android 的 Color 類別，用於操作顏色
import android.graphics.Color
// 引入 Android 的 FrameLayout 類別，用於建立一個可以包含多個子視圖的視圖群組
import android.widget.FrameLayout
// 引入 Android 的 TextView 類別，用於顯示文字
import android.widget.TextView

class CustomView(context: Context) : FrameLayout(context) {
    // 初始化區塊，當 CustomView 的實例被建立時，這個區塊的程式碼將被執行
    init {
        setPadding(16,16,16,16)
        // 為 CustomView 設置背景顏色，使用 Color 類別的 parseColor 方法將顏色碼轉換為顏色值
        setBackgroundColor(Color.parseColor("#5FD3F3"))

        // 建立一個 TextView 的實例，並將其添加到 CustomView 中
        addView(TextView(context).apply {
            // 為 TextView 設置預設文字
            text = "Welcome to Android Fragments with React Native."
        })
    }
}
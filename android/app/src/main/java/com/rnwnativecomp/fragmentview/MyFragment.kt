package com.rnwnativecomp.fragmentview

// 引入 Android 的 Bundle 類別，用於儲存和傳遞資料
import android.os.Bundle
// 引入 Android 的 LayoutInflater 類別，用於將 XML 佈局檔案實例化為視圖對象
import android.view.LayoutInflater
// 引入 Android 的 View 類別，用於建立和操作視圖
import android.view.View
// 引入 Android 的 ViewGroup 類別，用於建立和操作視圖群組
import android.view.ViewGroup
// 引入 Android 的 Fragment 類別，用於建立和操作片段
import androidx.fragment.app.Fragment
import com.rnwnativecomp.fragmentview.CustomView

class MyFragment : Fragment() {
    private lateinit var customView: CustomView

    // 重寫 onCreateView 方法，該方法在片段的視圖被創建時調用
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        customView = CustomView(requireNotNull(context))
        return customView // this CustomView could be any view that you want to render
    }

    // 重寫 onViewCreated 方法，該方法在片段的視圖被創建並且已經返回時調用
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // do any logic that should happen in an `onCreate` method, e.g:
        // customView.onCreate(savedInstanceState);
    }

    // 重寫 onPause 方法，該方法在片段進入暫停狀態時調用
    override fun onPause() {
        super.onPause()
        // do any logic that should happen in an `onPause` method
        // e.g.: customView.onPause();
    }

    // 重寫 onResume 方法，該方法在片段進入恢復狀態時調用
    override fun onResume() {
        super.onResume()
        // do any logic that should happen in an `onResume` method
        // e.g.: customView.onResume();
    }

    // 重寫 onDestroy 方法，該方法在片段被銷毀時調用
    override fun onDestroy() {
        super.onDestroy()
        // do any logic that should happen in an `onDestroy` method
        // e.g.: customView.onDestroy();
    }
}
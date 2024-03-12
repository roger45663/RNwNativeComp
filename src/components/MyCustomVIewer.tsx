import {requireNativeComponent, ViewProps} from 'react-native';

// 定義一個接口，名為 MyCustomViewerProps，並繼承自 ViewProps
interface MyCustomViewerProps extends ViewProps {}

// 使用 requireNativeComponent 函數，創建一個名為 MyCustomViewer 的原生組件
// 'RCTImageViewer' 是原生組件在原生代碼中的名稱
const MyCustomViewer =
  requireNativeComponent<MyCustomViewerProps>('RCTImageViewer');

// 將 MyCustomViewer 組件導出，以便在其他文件中使用
export default MyCustomViewer;

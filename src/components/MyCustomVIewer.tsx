import {requireNativeComponent, ViewProps} from 'react-native';

interface MyCustomViewerProps extends ViewProps {
  imageUri: string;
}

// 使用 requireNativeComponent 函數，創建一個名為 MyCustomViewer 的原生組件
// 'RCTImageViewer' 是原生組件在原生代碼中的名稱
const MyCustomViewer =
  requireNativeComponent<MyCustomViewerProps>('RCTImageViewer');

export default MyCustomViewer;

import React, {useEffect, useRef} from 'react';
import {PixelRatio, UIManager, findNodeHandle} from 'react-native';

import {MyViewManager} from './MyViewManager';

const createFragment = viewId => {
  return UIManager.dispatchViewManagerCommand(
    viewId,
    UIManager.MyViewManager.Commands.create.toString(),
    [viewId],
  );
};

export const MyView = () => {
  const ref = useRef(null);

  useEffect(() => {
    // 使用 findNodeHandle 方法找到 ref 當前的節點並獲取其 ID
    const viewId = findNodeHandle(ref.current);
    createFragment(viewId);
  }, []);

  return (
    <MyViewManager
      style={{
        // 使用 PixelRatio 的 getPixelSizeForLayoutSize 方法將 dpi 轉換為 px，並提供所需的高度
        height: PixelRatio.getPixelSizeForLayoutSize(200),
        // 使用 PixelRatio 的 getPixelSizeForLayoutSize 方法將 dpi 轉換為 px，並提供所需的寬度
        width: PixelRatio.getPixelSizeForLayoutSize(200),
      }}
      ref={ref}
    />
  );
};

import React from 'react';
import {SafeAreaView} from 'react-native';

import NewModuleButton from './src/components/NewModuleButton';
import MyCustomViewer from './src/components/MyCustomVIewer';
import {MyView} from './src/components/MyView';

function App(): React.JSX.Element {
  return (
    <SafeAreaView>
      <NewModuleButton />
      <MyCustomViewer
        style={{width: 200, height: 300}}
        borderRadius={50}
        resizeMode="cover"
        src={[
          {uri: 'https://picsum.photos/200/300', width: 200, height: 300},
          {uri: 'https://picsum.photos/150/300', width: 150, height: 300},
          {uri: 'https://picsum.photos/180/300', width: 180, height: 300},
        ]}
      />
      <MyView />
    </SafeAreaView>
  );
}

export default App;

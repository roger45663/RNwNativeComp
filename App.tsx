import React from 'react';
import {SafeAreaView} from 'react-native';

import NewModuleButton from './src/components/NewModuleButton';
import MyCustomViewer from './src/components/MyCustomVIewer';

function App(): React.JSX.Element {
  return (
    <SafeAreaView>
      <NewModuleButton />
      <MyCustomViewer
        style={{width: 100, height: 100}}
        imageUri="https://picsum.photos/200/300"
      />
    </SafeAreaView>
  );
}

export default App;

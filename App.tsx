import React, {useEffect} from 'react';
import {Alert, Button, SafeAreaView, Text, View} from 'react-native';
import CodePush from 'react-native-code-push';

import NewModuleButton from './src/components/NewModuleButton';
import MyCustomViewer from './src/components/MyCustomVIewer';
import {MyView} from './src/components/MyView';

function App(): React.JSX.Element {
  useEffect(() => {
    checkForUpdate();
  }, []);

  const checkForUpdate = () => {
    CodePush.sync(
      {
        installMode: CodePush.InstallMode.IMMEDIATE,
      },
      status => {
        switch (status) {
          case CodePush.SyncStatus.UP_TO_DATE:
            Alert.alert('提醒', '當前已經是最新版本');
            break;
          case CodePush.SyncStatus.UPDATE_INSTALLED:
            Alert.alert('提醒', '最新版本已安裝');
            break;
          default:
            break;
        }
      },
    );
  };

  return (
    <SafeAreaView>
      {/* <NewModuleButton /> */}
      {/* <MyCustomViewer
        style={{width: 200, height: 300}}
        borderRadius={50}
        resizeMode="cover"
        src={[
          {uri: 'https://picsum.photos/200/300', width: 200, height: 300},
          {uri: 'https://picsum.photos/150/300', width: 150, height: 300},
          {uri: 'https://picsum.photos/180/300', width: 180, height: 300},
        ]}
      /> */}
      {/* <MyView /> */}
      <View style={{backgroundColor: 'purple', height: 200}}>
        <Text style={{color: 'white'}}>我是更新後的內容1</Text>
      </View>
      <View style={{backgroundColor: 'blue', height: 100}}>
        <Text style={{color: 'white'}}>我是更新後的內容2</Text>
      </View>
      <View style={{backgroundColor: 'green', height: 50}}>
        <Text style={{color: 'white'}}>我是更新後的內容3</Text>
      </View>
      <View
        style={{
          backgroundColor: 'black',
          height: 50,
          width: 50,
          marginBottom: 20,
        }}>
        <Text style={{color: 'white'}}>我是更新後的內容4</Text>
      </View>
      <Button title="檢查更新點我" onPress={checkForUpdate} />
    </SafeAreaView>
  );
}

export default CodePush({
  checkFrequency: CodePush.CheckFrequency.ON_APP_START,
})(App);

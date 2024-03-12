import React from 'react';
import {Button} from 'react-native';
import CalendarModule from '../modules/native/CalendarModule';

const NewModuleButton = () => {
  const {DEFAULT_EVENT_NAME} = CalendarModule.getConstants();
  const onSubmit = async () => {
    try {
      const result = await CalendarModule.createCalendarEvent(
        'testName',
        'testLocation',
      );
      console.log('result:', result);
    } catch (e) {
      console.error(e);
    }
  };

  console.log('DEFAULT_EVENT_NAME:', DEFAULT_EVENT_NAME);

  return (
    <Button
      title="Click to invoke your native module!"
      color="#841584"
      onPress={onSubmit}
    />
  );
};

export default NewModuleButton;

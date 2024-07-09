import { NativeModules, Platform } from 'react-native';

const RNAltitudeConverter = Platform.OS === 'android' ? NativeModules.RNAltitudeConverter : {};

module.exports = { RNAltitudeConverter };

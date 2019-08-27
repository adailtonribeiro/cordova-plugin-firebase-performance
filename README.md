# cordova-plugin-firebase-performance<br>[![NPM version][npm-version]][npm-url] [![NPM downloads][npm-downloads]][npm-url]
> Cordova plugin for [Firebase Performance Monitoring](https://firebase.google.com/docs/perf-mon/)

## Installation

    cordova plugin add cordova-plugin-firebase-performance --save

## Supported Platforms

- iOS
- Android

## Methods
Every method returns a promise that fulfills when a call was successful.

### startTrace(traceName)
Start a custom trace.
```js
window.FirebasePerformance.startTrace("my_trace");
```

### incrementMetric(traceName, metricName)
Increment a custom metric.
```js
window.FirebasePerformance.incrementMetric("my_trace", "my_metric_1");
```

### stopTrace(traceName)
Stop the custom trace.
```js
window.FirebasePerformance.stopTrace("my_trace");
```

[npm-url]: https://www.npmjs.com/package/cordova-plugin-firebase-performance
[npm-version]: https://img.shields.io/npm/v/cordova-plugin-firebase-performance.svg
[npm-downloads]: https://img.shields.io/npm/dt/cordova-plugin-firebase-performance.svg

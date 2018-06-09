cordova.define("cordova-plugin-firebase-performance.FirebasePerformance", function(require, exports, module) {
    var exec = require("cordova/exec");
    var PLUGIN_NAME = "FirebasePerformance";
    
      module.exports = {
          startTrace: function(name) {
              return new Promise(function(resolve, reject) {
                  exec(resolve, reject, PLUGIN_NAME, "startTrace", [name]);
              });
          },
          incrementCounter: function(name, counterNamed) {
              return new Promise(function(resolve, reject) {
                  exec(resolve, reject, PLUGIN_NAME, "incrementCounter", [name, counterNamed]);
              });
          },
          stopTrace: function(name) {
              return new Promise(function(resolve, reject) {
                  exec(resolve, reject, PLUGIN_NAME, "stopTrace", [name]);
              });
          },
      };
});
    
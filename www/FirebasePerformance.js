var exec = require("cordova/exec");
var PLUGIN_NAME = "FirebasePerformance";

exports.startTrace = function (name, success, error) {
    exec(success, error, PLUGIN_NAME, "startTrace", [name]);
};
exports.incrementCounter = function (name, counterNamed, success, error) {
    exec(success, error, PLUGIN_NAME, "incrementCounter", [name, counterNamed]);
};
exports.stopTrace = function (name, success, error) {
    exec(success, error, PLUGIN_NAME, "stopTrace", [name]);
};
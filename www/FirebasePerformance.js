var exec = require("cordova/exec");
var PLUGIN_NAME = "FirebasePerformance";

exports.startTrace = function (traceName, success, error) {
    exec(success, error, PLUGIN_NAME, "startTrace", [traceName]);
};
exports.incrementMetric = function (traceName, metricName, success, error) {
    exec(success, error, PLUGIN_NAME, "incrementMetric", [traceName, metricName]);
};
exports.stopTrace = function (traceName, success, error) {
    exec(success, error, PLUGIN_NAME, "stopTrace", [traceName]);
};

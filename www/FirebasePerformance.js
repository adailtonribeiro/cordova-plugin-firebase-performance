var exec = require("cordova/exec");
var PLUGIN_NAME = "FirebasePerformance";

module.exports = {
    logEvent: function(name, params) {
        return new Promise(function(resolve, reject) {
            exec(resolve, reject, PLUGIN_NAME, "logEvent", [name, params || {}]);
        });
    }
};

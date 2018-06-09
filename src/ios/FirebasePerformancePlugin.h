#import <Cordova/CDV.h>

@interface FirebasePerformancePlugin : CDVPlugin

- (void)startTrace:(CDVInvokedUrlCommand*)command;
- (void)incrementCounter:(CDVInvokedUrlCommand*)command;
- (void)stopTrace:(CDVInvokedUrlCommand*)command;
@property (nonatomic, readwrite) NSMutableDictionary* traces;

@end

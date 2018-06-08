#import "FirebasePerformancePlugin.h"

@import Firebase;


@implementation FirebasePerformancePlugin

- (void)pluginInitialize {
    NSLog(@"Starting Firebase Performance plugin");

    if(![FIRApp defaultApp]) {
        [FIRApp configure];
    }
}

@end

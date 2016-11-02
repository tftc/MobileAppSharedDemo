//
//  AppDelegate.m
//  JSPatchDemo
//
//  Created by cloay on 16/6/23.
//  Copyright © 2016年 Cloay. All rights reserved.
//

#import "AppDelegate.h"
#import "JPEngine.h"
#import "objc/runtime.h"

@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
    
    [JPEngine startEngine];
    
    NSString *sourcePath = [[NSBundle mainBundle] pathForResource:@"demo" ofType:@"js"];
    NSLog(@"sourcePath = %@", sourcePath);
    NSString *script = [NSString stringWithContentsOfFile:sourcePath encoding:NSUTF8StringEncoding error:nil];
    NSLog(@"script = %@", script);
    [JPEngine evaluateScript:script];
    
    
//    [JPEngine evaluateScript:@"\
//     var alertView = require('UIAlertView').alloc().init();\
//     alertView.setTitle('Alert');\
//     alertView.setMessage('AlertView from js 😂😂😂'); \
//     alertView.addButtonWithTitle('OK');\
//     alertView.show(); \
//     "];
    
    /*
    Class class = NSClassFromString(@"ViewController");
    id viewController = [[class alloc] init];
    SEL selector = NSSelectorFromString(@"test");
    
    //替换方法
    SEL swizzledSelector = NSSelectorFromString(@"newTest");
    Method swizzledMethod = class_getInstanceMethod([self class], swizzledSelector);
    char *typeDescription = (char *)method_getTypeEncoding(swizzledMethod);
    IMP swizzledImp = class_getMethodImplementation([self class], swizzledSelector);
    class_replaceMethod(class, selector, swizzledImp, typeDescription);
    
    
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Warc-performSelector-leaks"
    [viewController performSelector:selector];
#pragma clang diagnostic pop
    
    */
    
    
    return YES;
}

- (void)newTest{
    NSArray *arr = @[@"1", @"2", @"3"];
    for (int i = 0; i < 3; i++) {
        NSLog(@"AppDelegate index%d = %@", i, arr[i]);
    }
}

- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

@end

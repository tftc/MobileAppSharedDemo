//
//  UIViewController+TCSwizzled.m
//  JSPatchDemo
//
//  Created by cloay on 16/7/5.
//  Copyright © 2016年 Cloay. All rights reserved.
//

#import "UIViewController+TCSwizzled.h"
#import "objc/runtime.h"

@implementation UIViewController (TCSwizzled)
+ (void)load{
    swizzleMethod([self class], @selector(viewDidAppear:), @selector(swizzled_viewDidAppear:));
}

- (void)swizzled_viewDidAppear:(BOOL)animated{
    // call original implementation
    [self swizzled_viewDidAppear:animated];
    
    // Logging
    NSLog(@"TCSwizzled: class = %@", NSStringFromClass([self class]));
}

void swizzleMethod(Class class, SEL originalSelector, SEL swizzledSelector){
    // the method might not exist in the class, but in its superclass
    Method originalMethod = class_getInstanceMethod(class, originalSelector);
    Method swizzledMethod = class_getInstanceMethod(class, swizzledSelector);
    
    // class_addMethod will fail if original method already exists
    BOOL didAddMethod = class_addMethod(class, originalSelector, method_getImplementation(swizzledMethod), method_getTypeEncoding(swizzledMethod));
    
    // the method doesn’t exist and we just added one
    if (didAddMethod) {
        class_replaceMethod(class, swizzledSelector, method_getImplementation(originalMethod), method_getTypeEncoding(originalMethod));
    } else {
        method_exchangeImplementations(originalMethod, swizzledMethod);
    }
}
@end

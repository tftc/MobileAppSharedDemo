//
//  ViewController.m
//  WaxPatchDemo
//
//  Created by cloay on 16/7/4.
//  Copyright © 2016年 Cloay. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(0, 100, [UIScreen mainScreen].bounds.size.width, 100)];
    [label setTextColor:[UIColor colorWithRed:100/255.f green:149/255.f blue:237/255.f alpha:1.f]];
    [label setText:@"😂😂😂尼玛，线上错的！！！"];
//    [label setTextAlignment:NSTextAlignmentCenter];
    [self.view addSubview:label];
    
//    [self test];
}

- (void)test{
    NSArray *arr = @[@"1", @"2", @"3"];
    for (int i = 0; i < 4; i++) {
        NSLog(@"index%d = %@", i, arr[i]);
    }
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end

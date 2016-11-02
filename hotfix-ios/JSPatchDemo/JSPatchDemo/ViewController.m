//
//  ViewController.m
//  JSPatchDemo
//
//  Created by cloay on 16/6/23.
//  Copyright © 2016年 Cloay. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    [self initSubview];
    [self test];
}

- (void)initSubview{
    UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(0, 100, [UIScreen mainScreen].bounds.size.width, 100)];
    [label setTextColor:[UIColor colorWithRed:100/255.f green:149/255.f blue:237/255.f alpha:1.f]];
    [label setText:@"😂😂😂尼玛，这是错的！！！"];
    [self.view addSubview:label];
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

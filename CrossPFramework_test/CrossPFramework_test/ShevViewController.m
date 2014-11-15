//
//  ShevViewController.m
//  CrossPFramework_test
//
//  Created by Shev Yan on 14/11/14.
//  Copyright (c) 2014 com.eyeshang. All rights reserved.
//

#import "ShevViewController.h"
#import "CrossPFramework/CPViewController.h"
#import "CrossPFramework/CPProtocol.h"

@interface ShevViewController () <CPProtocol>

@end

@implementation ShevViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    [[CPViewController sharedInstance] cpInit:@"appID" delegate:self];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)onFetch:(id)sender {
    [[CPViewController sharedInstance] cpFetchAsync];
}

- (void) cpFailedFetch:(NSString *)errorMsg {
    
}

- (void) cpDidFecth {
    [[CPViewController sharedInstance] cpShow:self];
}
@end

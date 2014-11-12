//
//  CPViewController.h
//  x5
//
//  Created by Shev Yan on 10/11/14.
//  Copyright (c) 2014 com.shev.x5. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface CPViewController : UIViewController
+ (instancetype) sharedInstance;
- (void) cpInit:(NSString *)appID;
- (void) cpUninit;
- (void) cpFetchAsync;
- (BOOL) cpIsReady;
- (void) cpShow:(UIViewController *)parentCtrl;
- (void) cpHide;

@end

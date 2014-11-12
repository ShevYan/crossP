//
//  CPViewController.h
//  x5
//
//  Created by Shev Yan on 10/11/14.
//  Copyright (c) 2014 com.shev.x5. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface CPViewController : UIViewController
- (void)handleSingleTap:(UITapGestureRecognizer *)recognizer;
- (void) showCP:(UIViewController *)parent;
- (void) hideCP;

@end
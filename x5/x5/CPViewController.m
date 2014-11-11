//
//  CPViewController.m
//  x5
//
//  Created by Shev Yan on 10/11/14.
//  Copyright (c) 2014 com.shev.x5. All rights reserved.
//

#import "CPViewController.h"

@interface CPViewController ()
@property (nonatomic, strong) UIWebView *webView;

@end


@implementation CPViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}


//The event handling method
- (void)handleSingleTap:(UITapGestureRecognizer *)recognizer {
    CGPoint location = [recognizer locationInView:[recognizer.view superview]];
    
    //Do stuff here...
    [self hideCP];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


///////////
- (void) showCP:(UIViewController *)parent
{
    [parent addChildViewController:self];
    [parent.view addSubview:self.view];
    
    CGRect frame = parent.view.frame;
    self.webView = [[UIWebView alloc] initWithFrame:CGRectMake( 50, 50, frame.size.width-100, frame.size.height-100)];
    [parent.view addSubview:self.webView];
    
    NSURL *url = [NSURL URLWithString:@"http://10.200.78.29:8222/CpSpace/cpSpace.html"];
    NSURLRequest *req = [NSURLRequest requestWithURL:url];
    [self.webView loadRequest:req];
    UITapGestureRecognizer *singleFingerTap =
    [[UITapGestureRecognizer alloc] initWithTarget:self
                                            action:@selector(handleSingleTap:)];
    [self.view addGestureRecognizer:singleFingerTap];
//    [UIView animateWithDuration:10.0 animations:^{
//        webView.alpha = 0.0;
//        webView.alpha = 1.0;
//    }];
//
//    [UIView animateWithDuration:1.0 animations:^{
//        webView.frame = CGRectMake(50-20, 50, parent.frame.size.width-100, parent.frame.size.height-100);
//    } completion:^(BOOL finished) {
//        [UIView animateWithDuration:0.2 animations:^{
//            webView.frame = CGRectMake(50+15, 50, parent.frame.size.width-100, parent.frame.size.height-100);
//        } completion:^(BOOL finished) {
//            [UIView animateWithDuration:0.2 animations:^{
//                webView.frame = CGRectMake(50-10, 50, parent.frame.size.width-100, parent.frame.size.height-100);} completion:^(BOOL finished) {
//                    [UIView animateWithDuration:0.2 animations:^{
//                        webView.frame = CGRectMake(50+5, 50, parent.frame.size.width-100, parent.frame.size.height-100);
//                    } completion:^(BOOL finished) {
//                        [UIView animateWithDuration:0.2 animations:^{
//                            webView.frame = CGRectMake(50, 50, parent.frame.size.width-100, parent.frame.size.height-100);
//                        }];
//                    }];
//                }];
//        }];
//    }];
}



- (void) hideCP
{
    [self.webView removeFromSuperview];
    [self.view removeFromSuperview];
    [self removeFromParentViewController];
}

- (IBAction)clickBackground:(id)sender {
    
    [self removeFromParentViewController];
}
@end

//
//  CPViewController.m
//  x5
//
//  Created by Shev Yan on 10/11/14.
//  Copyright (c) 2014 com.shev.x5. All rights reserved.
//

#import "CPViewController.h"

@interface CPViewController ()
@property (nonatomic, weak) UIView *parentView;
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

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


///////////
- (void) showCP:(UIView *)parent
{
    self.parentView = parent;
    self.view.alpha = 0.5;
    
    [parent addSubview:self.view];
    UIWebView *webView = [[UIWebView alloc] initWithFrame:CGRectMake( 2* parent.frame.size.width, 50, parent.frame.size.width-100, parent.frame.size.height-100)];
    NSURL *url = [NSURL URLWithString:@"http://10.200.78.29:8222/CpSpace/cpSpace.html"];
    NSURLRequest *req = [NSURLRequest requestWithURL:url];
    [webView loadRequest:req];
    [parent addSubview:webView];
//    [UIView animateWithDuration:10.0 animations:^{
//        webView.alpha = 0.0;
//        webView.alpha = 1.0;
//    }];
//
    [UIView animateWithDuration:1.0 animations:^{
        webView.frame = CGRectMake(50-20, 50, parent.frame.size.width-100, parent.frame.size.height-100);
    } completion:^(BOOL finished) {
        [UIView animateWithDuration:0.2 animations:^{
            webView.frame = CGRectMake(50+15, 50, parent.frame.size.width-100, parent.frame.size.height-100);
        } completion:^(BOOL finished) {
            [UIView animateWithDuration:0.2 animations:^{
                webView.frame = CGRectMake(50-10, 50, parent.frame.size.width-100, parent.frame.size.height-100);} completion:^(BOOL finished) {
                    [UIView animateWithDuration:0.2 animations:^{
                        webView.frame = CGRectMake(50+5, 50, parent.frame.size.width-100, parent.frame.size.height-100);
                    } completion:^(BOOL finished) {
                        [UIView animateWithDuration:0.2 animations:^{
                            webView.frame = CGRectMake(50, 50, parent.frame.size.width-100, parent.frame.size.height-100);
                        }];
                    }];
                }];
        }];
    }];
}



- (void) hideCP
{
    [self.view removeFromSuperview];
    self.parentView = nil;
}

- (IBAction)clickBackground:(id)sender {
    [self removeFromParentViewController];
}
@end

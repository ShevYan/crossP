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
@property (nonatomic, copy) NSString *appID;
@property (nonatomic) BOOL isReady;
@property (weak, nonatomic) IBOutlet UIImageView *imageView;
@end


@implementation CPViewController

+ (instancetype) sharedInstance {
    static CPViewController *instance = nil;
    
    if (nil == instance) {
        instance = [[self alloc] init];
    }
    
    return instance;
}

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
    [self cpHide];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    [self cpInit:@""];

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


///////////
- (void) cpInit:(NSString *)appID {
    self.appID = appID;
    dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
        NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:@"http://10.200.78.29:8222/app.json"]];
        NSData *response = [NSURLConnection sendSynchronousRequest:request returningResponse:nil error:nil];
        NSError *jsonParsingError = nil;
        NSArray *jsonArr = [NSJSONSerialization JSONObjectWithData:response options:0 error:&jsonParsingError];
//        if (data != nil) {
//            dispatch_async(dispatch_get_main_queue(), ^{
//                self.imageView.image = image;
//            });
//        }  
    });
}

- (void) cpUninit {
    self.appID = nil;
}

- (void) cpFetchAsync {
    
}

- (BOOL) cpIsReady {
    return self.isReady;
}

- (void) cpShow:(UIViewController *)parentCtrl
{
//    if (![self cpIsReady]) {
//        NSLog(@"CP is not ready! Return directly.");
//        return ;
//    }
    
    [parentCtrl addChildViewController:self];
    [parentCtrl.view addSubview:self.view];
    
    CGRect frame = parentCtrl.view.frame;
    self.webView = [[UIWebView alloc] initWithFrame:CGRectMake( 50, 50, frame.size.width-100, frame.size.height-100)];
    [parentCtrl.view addSubview:self.webView];
    
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

- (void) cpHide
{
    [self.webView removeFromSuperview];
    [self.view removeFromSuperview];
    [self removeFromParentViewController];
}

@end

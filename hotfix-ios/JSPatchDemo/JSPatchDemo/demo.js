// Demo.js
// JSPatchDemo
//
//  Created by cloay on 16/6/23.
//  Copyright © 2016年 Cloay. All rights reserved.
//

require('UILabel, UIScreen, UIColor, NSBundle, NSString, NSRange');


defineClass("ViewController", {
            viewDidLoad: function() {
            
            var appVersion = NSBundle.mainBundle().infoDictionary().valueForKey("CFBundleShortVersionString");
            var versionValue = appVersion.stringByReplacingOccurrencesOfString_withString(".", "").floatValue();
            console.log("version = " + versionValue)
            
            if (versionValue < 12){
                var width = UIScreen.mainScreen().bounds().width;
                console.log(width)
                var label = UILabel.alloc().initWithFrame({x:0, y:100, width:width, height:100});
                label.setTextColor(UIColor.colorWithRed_green_blue_alpha(100 / 255.0, 149 / 255.0, 237 / 255.0, 1.0));
                label.setText("😂😂😂尼玛，笑屎我了！！！");
                label.setTextAlignment(1);
                self.view().addSubview(label);
                self.test();
            } else {
                self.ORIGviewDidLoad();
            }
            
            
        },
        test: function() {
            var arr = ["1", "2", "3"];
            for (var i = 0; i < 3; i++) {
            console.log("index" + i + " = " + arr[i]);
            }
        },
})

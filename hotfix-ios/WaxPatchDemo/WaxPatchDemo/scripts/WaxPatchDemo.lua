waxClass{"ViewController"}

function viewDidLoad(self)
    self.super:viewDidLoad()
    local width = UIScreen:mainScreen():bounds().width
    print(width)
    local label = UILabel:initWithFrame(CGRect(0, 100, width, 100))
    label:setTextColor(UIColor:colorWithRed_green_blue_alpha(100/255.0, 149/255.0, 237/255.0, 1.0));
    label:setText('😂😂😂尼玛，笑屎我了！！！')
    label:setTextAlignment(1)
    self:view():addSubview(label)
end

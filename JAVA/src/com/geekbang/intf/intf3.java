package com.geekbang.intf;


// >>TODO 接口也可以继承接口，接口可以继承多个接口，接口之间的继承要用extends
// >>TODO 接口不可以继承类
// >>TODO 继承的接口可以有重复的方法，但是签名相同时，返回值必须完全一样，否则会编译错误
public interface intf3 extends intf1,intf2 {
    void m3();
}

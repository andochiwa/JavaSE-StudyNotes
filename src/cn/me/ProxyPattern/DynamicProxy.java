package cn.me.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getbelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getbelief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eat " + food);
    }

}

class ProxyFactory {

    /**
     * 调用此方法放回一个被代理类对象
     * @param obj 被代理类对象
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj; //需要被代理类对象赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动调用如下方法:invoke()
    // 将被代理类要执行的方法a的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
    
}

public class DynamicProxy {
    
    public static void main(String[] args) {
        
        // 代理类的对象
        SuperMan superman = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        proxyInstance.eat("香香鸡");
        System.out.println(proxyInstance.getbelief());

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyClothFactory.produceCloth();
    }
    
}

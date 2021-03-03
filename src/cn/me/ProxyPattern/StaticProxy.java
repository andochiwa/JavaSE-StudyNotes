package cn.me.ProxyPattern;
/**
 * 静态代理
 * 代理类的被代理类在编译期间就被确定下来
 */
interface ClothFactory {
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 用被代理类对象进行实例化

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做后续处理");
    }

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

}


class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动服");
    }
    
}

public class StaticProxy {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}

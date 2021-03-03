package cn.me.DateTest;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest{
    public static void main(String[] args) {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lenovoMouse", 34);
        goods[1] = new Goods("dellMouse", 50);
        goods[2] = new Goods("XiaomiMouse", 43);
        goods[3] = new Goods("huaweiMouse", 37);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
        System.out.println();

        Goods[] goods1 = new Goods[4];
        goods1[0] = new Goods("lenovoMouse", 34);
        goods1[1] = new Goods("dellMouse", 50);
        goods1[2] = new Goods("XiaomiMouse", 43);
        goods1[3] = new Goods("huaweiMouse", 37);
        Arrays.sort(goods1, new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods) {
                    var e1 = (Goods)o1;
                    var e2 = (Goods)o2;
                    if(e1.getPrice() != e2.getPrice()) {
                        return Double.compare(e1.getPrice(), e2.getPrice());
                    } else return compare(e1.getName(), e2.getName());
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(goods1));

    }
}

class Goods implements Comparable<Object>{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods [name=" + name + ", price=" + price + "]";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods) {
            var goods = (Goods)o;
            if(this.price > goods.price) return 1;
            else if(this.price < goods.price) return -1;
            else return 0;
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}

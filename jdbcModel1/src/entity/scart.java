package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class scart {
	//商品定义一个集合类
	//商品和价格直接相当于键值对的形式，定义hashMap形式的集合
	private HashMap<ItemsDB,Integer> goods;
	private double totalPrice;
	
	//构造方法，初始化
	public scart(){
		goods=new HashMap<ItemsDB,Integer>();
		totalPrice=0.0;
	}

	
	//属性封装
	public HashMap<ItemsDB, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<ItemsDB, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	//添加商品进购物车
	public boolean addGoods(ItemsDB items,int number){
		//为了不让后加进来的数量替代开始的，而应转变成求和的形式
		if(goods.containsKey(items)){//判断开始是否加入过该商品
			goods.put(items, goods.get(items)+number);
		}
		else{
			goods.put(items, number);
		}
		
		totalPrice();//更新了集合后对应的调用求总价的方法
		return true;
	}
	//删除购物车中的商品
	public boolean reMove(ItemsDB items){
		goods.remove(items);
		totalPrice();
		return true;
	}
	
	//计算商品的总价格
	public double totalPrice(){
		double sum=0.0;
		Set<ItemsDB> keys=goods.keySet();
		Iterator<ItemsDB> iter=keys.iterator();//设置一个迭代器
		while(iter.hasNext()){
			ItemsDB i=iter.next();
			sum+=i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
		
	}
	public static void main(String[] args) {
		//创建商品对象，调用带参的构造方法
		ItemsDB i1=new ItemsDB(1,"cpu",5,234,"beautiful","01.jpg");
		ItemsDB i2=new ItemsDB(2,"bag",2,22,"beautiful","02.jpg");
		ItemsDB i3=new ItemsDB(1,"cpu",5,234,"beautiful","01.jpg");
		System.out.println(i1.getPrice());
		
		scart s=new scart();
		s.addGoods(i1, 3);
		s.addGoods(i2, 1);
		s.addGoods(i3, 1);
		
		Set<Map.Entry<ItemsDB, Integer>> items=s.getGoods().entrySet();
		for(Map.Entry<ItemsDB, Integer> obj:items){
			System.out.println(obj);
		}
		
		System.out.println(s.getTotalPrice());
		
	}

}

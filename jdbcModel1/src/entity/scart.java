package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class scart {
	//��Ʒ����һ��������
	//��Ʒ�ͼ۸�ֱ���൱�ڼ�ֵ�Ե���ʽ������hashMap��ʽ�ļ���
	private HashMap<ItemsDB,Integer> goods;
	private double totalPrice;
	
	//���췽������ʼ��
	public scart(){
		goods=new HashMap<ItemsDB,Integer>();
		totalPrice=0.0;
	}

	
	//���Է�װ
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
	
	
	//�����Ʒ�����ﳵ
	public boolean addGoods(ItemsDB items,int number){
		//Ϊ�˲��ú�ӽ��������������ʼ�ģ���Ӧת�����͵���ʽ
		if(goods.containsKey(items)){//�жϿ�ʼ�Ƿ���������Ʒ
			goods.put(items, goods.get(items)+number);
		}
		else{
			goods.put(items, number);
		}
		
		totalPrice();//�����˼��Ϻ��Ӧ�ĵ������ܼ۵ķ���
		return true;
	}
	//ɾ�����ﳵ�е���Ʒ
	public boolean reMove(ItemsDB items){
		goods.remove(items);
		totalPrice();
		return true;
	}
	
	//������Ʒ���ܼ۸�
	public double totalPrice(){
		double sum=0.0;
		Set<ItemsDB> keys=goods.keySet();
		Iterator<ItemsDB> iter=keys.iterator();//����һ��������
		while(iter.hasNext()){
			ItemsDB i=iter.next();
			sum+=i.getPrice()*goods.get(i);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
		
	}
	public static void main(String[] args) {
		//������Ʒ���󣬵��ô��εĹ��췽��
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

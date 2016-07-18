package entity;
//商品的实体类
public class ItemsDB {
	private int id;
	private String name;
	private int number;
	private int price;
	private String delite;
	private String picture;
	
	public ItemsDB(){
		
	}
	public ItemsDB(int id, String name, int number, int price, String delite,
			String picture) {
		//带参的构造方法里面要对属性进行赋值
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setDelite(delite);
		this.setName(name);
		this.setNumber(number);
		this.setPicture(picture);
		this.setPrice(price);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDelite() {
		return delite;
	}
	public void setDelite(String delite) {
		this.delite = delite;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	//重写toString方法使得购物车的商品按指定格式输出
	public String toString(){
		return "商品编号："+this.getId()+",商品名称："+this.getName()+",商品价格："+this.getPrice()
		+",商品库存"+this.getNumber();
	}
	
	//重写hashCode和equels方法进行记录合并
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getId()+this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj){
			return true;
		}
		if(obj instanceof ItemsDB){
			ItemsDB i=(ItemsDB)obj;
			if(this.getId()==i.getId()&&this.getName().equals(i.getName())){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
}

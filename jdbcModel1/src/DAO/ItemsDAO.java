package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sqlserver.DBHelper;

import entity.ItemsDB;

public class ItemsDAO {
	//���Ҳ���ʾ������Ʒ
	public ArrayList<ItemsDB> getAllitems(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<ItemsDB> list=new ArrayList<ItemsDB>();
		try{
			conn=DBHelper.getConnection();
			String sql="select * from ItemsDB;";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				ItemsDB items=new ItemsDB();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setNumber(rs.getInt("number"));
				items.setPicture(rs.getString("picture"));
				items.setPrice(rs.getInt("price"));
				items.setDelite(rs.getString("delite"));
				list.add(items);
			}
			return list;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		//�ȹر����ݼ��ٹر����Ӽ�
		finally{
			if(rs!=null){
				try{
					rs.close();
					rs=null;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try{
					stmt.close();
					stmt=null;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	}
	//����id���Ҹ���Ʒ����ϸ��Ϣ
	public ItemsDB getItemById(int id){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			conn=DBHelper.getConnection();
			String sql="select * from ItemsDB where id=?;";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs.next()){
				ItemsDB item=new ItemsDB();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				item.setDelite(rs.getString("delite"));
				return item;
			}
			else
				return null;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			if(rs!=null){
				try{
					rs.close();
					rs=null;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try{
					stmt.close();
					stmt=null;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	//������������ǰ������¼
	public ArrayList<ItemsDB> getViewList(String list){
		System.out.print("list"+list.length());
		ArrayList<ItemsDB> item=new ArrayList<ItemsDB>();
		int Count=5;
		if(list!=null&&list.length()>0){
			String[] arr=list.split(",");
			System.out.println("arr.length="+arr.length);
			//ֻ��ʾ��������5����¼
			if(arr.length>5){
				for(int i=arr.length-1;i>arr.length-Count;i--){
					int id=Integer.parseInt(arr[i]);
					item.add(getItemById(id));
				}
			}
			else{
				//���ӵȺŻ���һ�������¼
				//��c.getValueû�и�ֵ��listʱarr.length����ԶΪ1���ͻ�ʹ��itemList.size()==[]
				for(int i=arr.length-1;i>=0;i--){
					int id=Integer.parseInt(arr[i]);
					System.out.print(arr[i]);
					item.add(getItemById(id));
				}
			}
			return item;
		}
		else{
			return null;
		}
	}
}

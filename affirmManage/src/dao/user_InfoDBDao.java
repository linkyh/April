package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.user_InfoDB;
import db.DBHelper;

public class user_InfoDBDao {
	//新增一条
	public void addInfo(user_InfoDB u) throws Exception {
		Connection conn=DBHelper.getConnection();
		String sql=""+"insert into user_InfoDB"+"(account,amount)"+"values(" +
				"?,?)";
		PreparedStatement ptm=conn.prepareStatement(sql);
		ptm.setString(1, u.getAccount());
		ptm.setInt(2, u.getAmount());
		ptm.execute();
	}


	//编辑一条记录
	public void editUser(user_InfoDB u) throws Exception{
		Connection conn=DBHelper.getConnection();
		String sql=""+"update user_InfoDB u"+"set account,amount,"+" where id=? ";
		PreparedStatement ptm=conn.prepareStatement(sql);
		ptm.setString(1, u.getAccount());
		ptm.setInt(2, u.getAmount());
		ptm.execute();
	}



	//删除一条信息
	public void delUder(user_InfoDB u) throws Exception{
		
		Connection conn=DBHelper.getConnection();
		String sql=""+"delete from user_InfoDB u"+"where id=?";
		
		PreparedStatement ptm=conn.prepareStatement(sql);
		ptm.setInt(1, u.getId());
		ptm.execute();
	}
}

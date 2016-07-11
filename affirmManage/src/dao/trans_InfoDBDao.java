package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBHelper;

import model.trans_InfoDB;

public class trans_InfoDBDao {
	
//����һ�����׼�¼
public void addTran(trans_InfoDB t) throws Exception {
	Connection conn=DBHelper.getConnection();
	String sql=""+"insert into trans_InfoDB"+"(source_id,source_accunt,detiation_id,detiation_accunt,amount)"+"values(" +
			"?,?,?,?,?)";
	PreparedStatement ptm=conn.prepareStatement(sql);
	ptm.setInt(1, t.getSource_id());
	ptm.setString(2, t.getSource_accunt());
	ptm.setInt(3, t.getDetiation_id());
	ptm.setString(4, t.getSource_accunt());
	ptm.setInt(5, t.getAmount());
	ptm.execute();
}


//�༭һ����¼
public void editTran(trans_InfoDB t) throws Exception{
	Connection conn=DBHelper.getConnection();
	String sql=""+"update trans_InfoDB"+"set source_id=?,source_accunt=?,detiation_id=?,detiation_accunt=?,amount=?,"+" where id=? ";
	PreparedStatement ptm=conn.prepareStatement(sql);
	ptm.setInt(1, t.getSource_id());
	ptm.setString(2, t.getSource_accunt());
	ptm.setInt(3, t.getDetiation_id());
	ptm.setString(4, t.getSource_accunt());
	ptm.setInt(5, t.getAmount());
	ptm.execute();
}



//ɾ��һ����Ϣ
public void delTran(Integer id) throws Exception{
	
	Connection conn=DBHelper.getConnection();
	String sql=""+"delete from trans_InfoDB"+"where id=?";
	
	PreparedStatement ptm=conn.prepareStatement(sql);
	ptm.setInt(1, id);
	ptm.execute();
}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ParentsUser;

public class ParentsUserDao extends Dao{

	private String baseSql = "select * from ParentsUser where parents_id=? and facility_id=? ";

	public ParentsUser getParentsUserInfo(String parents_id, String facility_id) throws Exception {
		ParentsUser pu = new ParentsUser();
		Connection connection = getConnection();
		PreparedStatement st = null;

		try{
			st = connection.prepareStatement(baseSql);
			st.setString(1,parents_id);
			st.setString(2,facility_id);
			ResultSet rSet = st.executeQuery();

			if(rSet.next()){
				pu.setParents_id(rSet.getString("parents_id"));
				pu.setParents_name(rSet.getString("parents_name"));
				pu.setParents_pass(rSet.getString("parents_pass"));
				pu.setParents_address(rSet.getString("parents_address"));
				pu.setParents_tel(rSet.getString("parents_tel"));
				pu.setParents_mail1(rSet.getString("parents_mail1"));
				pu.setParents_mail2(rSet.getString("parents_mail2"));
				pu.setParents_mail3(rSet.getString("parents_mail3"));
				pu.setFacility_id(rSet.getString("facility_id"));
			}else{
				pu=null;
			}
		}catch(Exception e){
			throw e;
		} finally {
			//
			if(st != null) {
				try {
					st.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}

			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}


		}
		return pu;
	}

	public boolean saveParentsUserInfo(ParentsUser pu) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//実行件数
		int count = 0;

		try{
			//データベースから学生を取得
			ParentsUser old = getParentsUserInfo(pu.getParents_id(), pu.getFacility_id());
			if (old == null) {
				//保護者が存在しなかった場合
				//プリペアードステートメンにINSERT文をセット
				statement = connection.prepareStatement(
						"insert into parentsuser (parents_id, parents_name, parents_pass, parents_address, parents_tel, parents_mail1, parents_mail2, parents_mail3, facility_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				//プリペアードステートメントに値をバインド
				statement.setString(1, pu.getParents_id());
				statement.setString(2, pu.getParents_name());
				statement.setString(3, pu.getParents_pass());
				statement.setString(4, pu.getParents_address());
				statement.setString(5, pu.getParents_tel());
				statement.setString(6, pu.getParents_mail1());
				statement.setString(7, pu.getParents_mail2());
				statement.setString(8, pu.getParents_mail3());
				statement.setString(9, pu.getFacility_id());
			} else {
				//学生が存在した場合
				//プリペアードステートメントにUPDATE文をセット
				statement = connection
						.prepareStatement("update parentsuser set parents_id=?, parents_name=?, parents_pass=?, parents_address=?, parents_tel=?, parents_mail1=?, parents_mail2=?, parents_mail3=?, facility_id=? where parentsuser_id=? and facility_id=?");
				//プリペアードステートメントに値をバインド
				statement.setString(1, pu.getParents_id());
				statement.setString(2, pu.getParents_name());
				statement.setString(3, pu.getParents_pass());
				statement.setString(4, pu.getParents_address());
				statement.setString(5, pu.getParents_tel());
				statement.setString(6, pu.getParents_mail1());
				statement.setString(7, pu.getParents_mail2());
				statement.setString(8, pu.getParents_mail3());
				statement.setString(9, pu.getFacility_id());
				statement.setString(10, pu.getParents_id());
				statement.setString(11, pu.getFacility_id());
			}

			//プリペアードステートメントを実行
			count = statement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			//
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}

			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		if (count > 0) {
			//実行件数が1以上ある場合
			return true;
		} else {
			//実行件数が0件の場合
			return false;
		}

	}

	public ParentsUser parentsLogin() throws Exception{


	}

}

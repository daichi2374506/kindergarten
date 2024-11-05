package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ManageUser;




public class ManageUserDao extends Dao{

	public ManageUser getManageUserInfo(String user_id, String facility_id) throws Exception {
		//先生インスタンス初期化
		ManageUser mu = new ManageUser();

		//データベースへのコネクション
		Connection connection =getConnection();

		//プリペアードステートメント
		PreparedStatement statement=null;

		try{
			//prepareにsql文セット
			statement=connection.prepareStatement("select * from manageuser where user_id=? and facility_id=? ");
			//バインド
			statement.setString(1, user_id);
			statement.setString(2, facility_id);
			//プリペアードステートメント実行
			ResultSet rSet=statement.executeQuery();

			if(rSet.next()){
				mu.setUser_id(rSet.getString("user_id"));
				mu.setUser_pass(rSet.getString("user_pass"));
				mu.setUser_name(rSet.getString("user_name"));
				mu.setFacility_id(rSet.getString("facility_id"));
			}else{
				//リザルトセットが存在しない場合
				//学生インスタンスにnullをセット
				mu=null;
			}
		}catch(Exception e){
			throw e;
		}finally{
			//プリペア閉じる
			if(statement !=null){
				try{
					statement.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
			if(connection !=null){
				try{
					connection.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
		}
		return mu;
	}

	public void saveManageUserInfo() throws Exception {

	}

	public ManageUser login(String user_id, String user_pass,String facility_id) throws Exception {
		ManageUser mu = new ManageUser();
		//データベースへのコネクション
		Connection connection =getConnection();

		//プリペアードステートメント
		PreparedStatement statement=null;

		try{
			//prepareにsql文セット
			statement=connection.prepareStatement("select * from manageuser where user_id=? and user_pass=? and facility_id=? ");
			//バインド
			statement.setString(1, user_id);
			statement.setString(2, user_pass);
			statement.setString(3, facility_id);
			//プリペアードステートメント実行
			ResultSet rSet=statement.executeQuery();

			if(rSet.next()){
				//リザルトセットが存在する場合
				//学生インスタンスに検索結果をセット
				mu.setUser_id(rSet.getString("user_id"));
				mu.setUser_pass(rSet.getString("user_pass"));
				mu.setUser_name(rSet.getString("user_name"));
				mu.setFacility_id(rSet.getString("facility_id"));
			}else{
				//リザルトセットが存在しない場合
				//学生インスタンスにnullをセット
				mu=null;
			}
		}catch(Exception e){
			throw e;
		}finally{
			//プリペア閉じる
			if(statement !=null){
				try{
					statement.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
			if(connection !=null){
				try{
					connection.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
		}
		return mu;
	}

}

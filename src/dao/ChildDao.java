package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Child;

public class ChildDao extends Dao{

	private String baseSql = "select * from Child WHERE facility_id = ?";

	public Child getChildinfo(String facility_id)throws Exception{
		Child child = new Child();
		Connection connection = getConnection();
		PreparedStatement st = null;

		try{
			st = connection.prepareStatement(baseSql);
			st.setString(1,facility_id);
			ResultSet rSet = st.executeQuery();

			if(rSet.next()){
				child.setChild_id(rSet.getString("child_id"));
				child.setChild_name(rSet.getString("child_name"));
				child.setParents_id(rSet.getString("parents_id"));
				child.setClass_id(rSet.getString("class_id"));
				child.setIs_attend(rSet.getBoolean("is_attend"));
				child.setFacility_id(rSet.getString("facility_id"));
			}else{
				child=null;
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
		return child;
	}

	public void saveChildinfo(){

	}
}

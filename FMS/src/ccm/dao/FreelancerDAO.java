package ccm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ccm.data.table.*;
import ccm.util.DBManager;;

public class FreelancerDAO {
	private static FreelancerDAO instance = new FreelancerDAO();

	private FreelancerDAO() {
		super();
	}

	public static FreelancerDAO getInstance() {
		return instance;
	}

	public int insertFL(Freelancer fVo) {
		int result = -1;
		String sql = "insert into freelancer(freeId, freePw, freeEmail, freeJoindate) VALUES(?, ?, ?, now())";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();	//DB연동
			pstmt = conn.prepareStatement(sql);
			// 각각의 변수(?)에 회원가입 화면에 입력한 값을 넣는다.
			pstmt.setString(1, fVo.getFreeId());
			pstmt.setString(2, fVo.getFreePw());
			pstmt.setString(3, fVo.getFreeEmail());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Freelancer getfVo(String id) {
		// TODO Auto-generated method stub

		Connection conn = null;
		String sql = "select * from freelancer where freeId=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Freelancer fVo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				fVo = new Freelancer();

				fVo.setFreeId(rs.getString("freeId"));
				fVo.setFreePw(rs.getString("freePw"));
				fVo.setFreeName(rs.getString("freeName"));
				fVo.setFreePic(rs.getString("freePic"));
				fVo.setFreeBirth(rs.getDate("freeBirth"));
				fVo.setFreesex(rs.getBoolean("freeSex"));
				fVo.setFreePhone(rs.getString("freePhone"));
				fVo.setFreeEmail(rs.getString("freeEmail"));
				fVo.setFreeJoinDate(rs.getDate("freeJoindate"));
				fVo.setFreeDropDate(rs.getDate("freeDropDate"));
				fVo.setFreeClass(rs.getInt("freeClass"));
				fVo.setFreeKosa(rs.getInt("freeKosa"));
				fVo.setFreeMarried(rs.getBoolean("freeMarried"));
				fVo.setFreeFrontAddr(rs.getString("freeFrontaddr"));
				fVo.setFreeRearAddr(rs.getString("freeRearaddr"));
				fVo.setFreeBank(rs.getString("freeBank"));
				fVo.setFreeAccName(rs.getString("freeAccName"));
				fVo.setFreeAccount(rs.getString("freeAccount"));
				fVo.setFreeReviser(rs.getString("freeReviser"));
				fVo.setFreeReviseDate(rs.getDate("freeReviseDate"));
				fVo.setFreeScore(rs.getInt("freeScore"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fVo;
	}

	public List<Freelancer> selectAllFree() {
		String sql = "select * from freelancer order by freeId desc";

		List<Freelancer> list = new ArrayList<Freelancer>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Freelancer fVo = new Freelancer();

				fVo.setFreeId(rs.getString("freeId"));
				fVo.setFreePw(rs.getString("freePw"));
				fVo.setFreeName(rs.getString("freeName"));
				fVo.setFreePic(rs.getString("freePic"));
				fVo.setFreeBirth(rs.getDate("freeBirth"));
				fVo.setFreesex(rs.getBoolean("freeSex"));
				fVo.setFreePhone(rs.getString("freePhone"));
				fVo.setFreeEmail(rs.getString("freeEmail"));
				fVo.setFreeJoinDate(rs.getDate("freeJoindate"));
				fVo.setFreeDropDate(rs.getDate("freeDropDate"));
				fVo.setFreeClass(rs.getInt("freeClass"));
				fVo.setFreeKosa(rs.getInt("freeKosa"));
				fVo.setFreeMarried(rs.getBoolean("freeMarried"));
				fVo.setFreeFrontAddr(rs.getString("freeFrontaddr"));
				fVo.setFreeRearAddr(rs.getString("freeRearaddr"));
				fVo.setFreeBank(rs.getString("freeBank"));
				fVo.setFreeAccName(rs.getString("freeAccName"));
				fVo.setFreeAccount(rs.getString("freeAccount"));
				fVo.setFreeReviser(rs.getString("freeReviser"));
				fVo.setFreeReviseDate(rs.getDate("freeReviseDate"));
				fVo.setFreeScore(rs.getInt("freeScore"));
				
				list.add(fVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
}

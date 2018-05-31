package ccm.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ccm.data.table.*;
import ccm.util.DBManager;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	
	private EmployeeDAO() {
		super();
	}
	
	public static EmployeeDAO getInstance() {
		return instance;
	}
	
	public Employee geteVo(String id) {
		// TODO Auto-generated method stub

		EmployeeDAO eDao;
		Connection conn = null;
		String sql = "select * from employee where empid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee eVo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				eVo = new Employee();

				eVo.setParams(rs);
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
		return eVo;
	}
	
	// 사원 데이터 삽입 작성 필요
	public void insertEmp(Employee eVo) {
		String sql = "insert into employee('empid','emppw','empfrontaddr', 'emprearaddr') VALUES(?, ?, ?, ?)";
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?占쏙옙 占쏙옙 占쏙옙占쏙옙

			pstmt.setString(1, eVo.getEmpId());
			pstmt.setString(2, eVo.getEmpPw());
			pstmt.setString(3, eVo.getEmpDuty());
			pstmt.setString(4, eVo.getEmpName());
			pstmt.setString(5, eVo.getEmpDept());
			pstmt.setString(6, eVo.getEmpPicture());
			pstmt.setDate(7, eVo.getEmpJoinDate());
			pstmt.setDate(8, eVo.getEmpDropDate());
			pstmt.setString(9,eVo.getEmpPhone());
			pstmt.setString(10, eVo.getEmpEmail());
			pstmt.setDate(11, eVo.getEmpBirth());
			pstmt.setBoolean(12, eVo.getEmpSex());
			pstmt.setBoolean(13, eVo.getEmpMarried());
			pstmt.setString(14, eVo.getEmpFrontAddr());
			pstmt.setString(15, eVo.getEmpRearAddr());
			pstmt.setString(16, eVo.getEmpBank());
			pstmt.setString(17, eVo.getEmpAccName());
			pstmt.setString(18, eVo.getEmpAccount());
			
			System.out.println(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Employee> selectAllEmp() {
		String sql = "select * from employee order by empid desc";

		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Employee eVo = new Employee();

				eVo.setEmpId(rs.getString("empId"));
				eVo.setEmpPw(rs.getString("empPw"));
				eVo.setEmpDuty(rs.getString("empDuty"));
				eVo.setEmpName(rs.getString("empName"));
				eVo.setEmpDept(rs.getString("empDept"));
				eVo.setEmpPicture(rs.getString("empPicture"));
				eVo.setEmpJoinDate(rs.getDate("empJoindate"));
				eVo.setEmpDropDate(rs.getDate("empDropdate"));
				eVo.setEmpPhone(rs.getString("empPhone"));
				eVo.setEmpEmail(rs.getString("empEmail"));
				eVo.setEmpBirth(rs.getDate("empBirth"));
				eVo.setEmpSex(rs.getBoolean("empSex"));
				eVo.setEmpMarried(rs.getBoolean("empMarried"));
				eVo.setEmpFrontAddr(rs.getString("empFrontaddr"));
				eVo.setEmpRearAddr(rs.getString("empRearaddr"));
				eVo.setEmpBank(rs.getString("empBank"));
				eVo.setEmpAccName(rs.getString("empAccName"));
				eVo.setEmpAccount(rs.getString("empAccount"));
				
				list.add(eVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	/*public List<FreelancerInterview_view> selectAllInterviewSchdule() {
		String sql = "select * from FreelancerInterview_view"
				+ "where interview= order by msgNum desc";

		List<Message> list = new ArrayList<Message>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Message msgVo = new Message();

				msgVo.setParams(rs);
				
				list.add(msgVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}*/
}

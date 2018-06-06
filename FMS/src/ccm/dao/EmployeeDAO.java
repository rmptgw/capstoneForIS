package ccm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ccm.data.table.Employee;
import ccm.data.table.Interview;
import ccm.data.table.JoinFreelancerInterview_view;
import ccm.data.table.JoinFreelancerSkillInventory;
import ccm.data.table.JoinProj;
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
	
	public void insertEmp(Employee eVo) {
		// 사원 데이터 삽입 작성 필요
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
		// 사원들을 전부 가져오는 메소드
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

	// joinFreelancerSkillInventory뷰에 참여번호(joinNum)로 접근하여 참여상태(freeState)를 업데이트 하는 메소드
	public JoinProj updateFreeStateByJoinNum(String joinNo, String freeState) {
		String sql = "update joinFreelancerSkillInventory set freeState = ? where joinNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, freeState);
			pstmt.setString(2, joinNo);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;

	}
	
	// joinFreelancerInterview 뷰에 joinNum으로 접근하여 면접상태를 1(면접중)로 업데이트 하는 메소드
	public JoinFreelancerInterview_view updateInterviewStateByJoinNum(String joinNum) {
		String sql = "update joinFreelancerInterview "
				+ "set interviewState = 1  where joinNum = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, joinNum);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;

	}
	
	// 인터뷰 한 결과에 대한 사유와 면접상태를 2(면접완료)로 업데이트 하는  메소드
	public Interview updateInterviewReasonByJoinNum(String joinNo, String interviewReason) {
		String sql = "update interview set nothireReason = ?, interviewState='2'"
				+ "where (select interviewNum from joinFreelancerInterview" + 
				"	where joinNum = '?')";
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, interviewReason);
			pstmt.setString(2, joinNo);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;

	}
	
	public Interview updateInterviewStateByJoinNum(String joinNum, String location, String Date) {
		String sql = "update joinFreelancerInterview "
				+ "set interviewState = 1, interviewLocation = ?, interviewDate = ?  where joinNum = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, location);
			pstmt.setString(2, Date);
			pstmt.setString(3, joinNum);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;

	}
	
	// joinFreelancerInterview 뷰에 접근하여 상태(freeState)가 접수완료인 필드를 가져오는 메소드
	public List<JoinFreelancerInterview_view> selectJoinFreeInterview() {
		String sql = "select * from joinFreeLancerInterview where freeState=" +
					" '접수완료' order by joinNum";

		List<JoinFreelancerInterview_view> list = new ArrayList<JoinFreelancerInterview_view>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			System.out.println("-----------------------------");
			System.out.println(rs);
			System.out.println("-----------------------------");
			
			while (rs.next()) {
				JoinFreelancerInterview_view jVo = new JoinFreelancerInterview_view();
				
				System.out.println("-----------------------------");
				System.out.println("joinFreelancerInterview_view에 값 삽입 시작");
				System.out.println("-----------------------------");
				
				jVo.setFreeId(rs.getString("freeId"));
				jVo.setFreeName(rs.getString("freeName"));
				jVo.setInterviewNum(rs.getString("interviewNum"));
				jVo.setInterviewDate(rs.getDate("interviewDate"));
				jVo.setInterviewLocation(rs.getString("interviewLocation"));
				jVo.setInterviewState(rs.getString("interviewState"));
				jVo.setJoinNum(rs.getString("joinNum"));
				jVo.setFreeState(rs.getString("freeState"));
				
				System.out.println("-----------------------------");
				System.out.println("joinFreelancerInterview_view에 값 삽입 끝");
				System.out.println("-----------------------------");
				
				list.add(jVo);

				System.out.println("-----------------------------");
				System.out.println("리스트에 추가");
				System.out.println("-----------------------------");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public List<JoinFreelancerSkillInventory> selectAllJoinFreeSkillInventory() {
		// joinFreelancerSkillInventory뷰에 joinNum으로 접근하여 null이 아닌 데이터를 가져오는 메소드
		String sql = "select * from joinFreelancerSkillInventory "
				+ "where joinNum is not null and freeState = '대기중' order by joinNum";

		List<JoinFreelancerSkillInventory> list = new ArrayList<JoinFreelancerSkillInventory>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				JoinFreelancerSkillInventory jVo = new JoinFreelancerSkillInventory();

				jVo.setJoinNum(rs.getString("joinNum"));
				jVo.setFreeId(rs.getString("freeId"));
				jVo.setFreeName(rs.getString("freeName"));
				jVo.setFreeState(rs.getString("freeState"));
				jVo.setLanguages(rs.getString("languages"));
				jVo.setFrameworks(rs.getString("frameworks"));
				jVo.setCareerYear(rs.getString("projCareerYears"));
				jVo.setJoinProjTime(rs.getString("joinProjTime"));
				jVo.setFreeKosa(rs.getString("freeKosa"));
				jVo.setFreeScore(rs.getString("freeScore"));
				
				list.add(jVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public JoinProj getJoinProjByNo(String no) {
		// joinNum을 통해 joinProj의 데이터를 가져오는 메소드
		// TODO Auto-generated method stub
		String sql = "select * from joinProj where joinNum = ?";

		JoinProj jVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				jVo = new JoinProj();

				jVo.setParams(rs);
				
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
		return jVo;
	}
	
	public JoinFreelancerInterview_view getJoinFreeInterviewByNo(String no) {
		// joinNum을 통해 joinProj의 데이터를 가져오는 메소드
		// TODO Auto-generated method stub
		String sql = "select * from joinFreelancerInterview where joinNum = ?";

		JoinFreelancerInterview_view jVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				jVo = new JoinFreelancerInterview_view();

				jVo.setParams(rs);
				
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
		return jVo;
	}
}

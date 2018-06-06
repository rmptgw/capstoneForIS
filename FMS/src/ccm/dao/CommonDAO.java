package ccm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ccm.data.table.Employee;
import ccm.data.table.Freelancer;
import ccm.data.table.JoinProj;
import ccm.data.table.Message;
import ccm.data.table.Project;
import ccm.data.table.ProjectInfo;
import ccm.util.DBManager;;

public class CommonDAO
{
	private static CommonDAO instance = new CommonDAO();
	private CommonDAO() { 
		super();
	}
	public static CommonDAO getInstance() { 
		return instance; 
		}
	public int loginCheck(String id, String pw, Freelancer loginFree, Employee loginEmp) //로그인할때 아이디랑 비번이 맞는지 체크해주는거
	{
		System.out.println("id = " + id + ", pw = " + pw);
		//쿼리를 직원, 프리랜서 각각 실행해서 결과에 따라 로그인이 달라지게함 
		/*String freeSql = "SELECT FID, FPW, FNAME, FPIC, FBIRTH, FSEX, FPHONE, FEMAIL,"
				+ " FJOINDATE, FDROPDATE, EUCLASS, FCLASS, FMARRIED, FFRONTADDR, FREARADDR,"
				+ " FBANK, FACCNAME, FACCOUNT, REVISER, REVDATE FROM FREELANCER"
				+ " WHERE FID = ? AND FPW = ?";
		String empSql = "SELECT EID, EPW, ECLASS, ENAME, EDEPT, EPIC, EJOINDATE, EDROPDATE,"
				+ " EPHONE, EEMAIL, EBIRTH, ESEX, EMARRIED, EFRONTADDR, EREARADDR, EBANK,"
				+ " EACCNAME, EACCOUNT  FROM EMPLOYEE"
				+ " WHERE EID = ? AND EPW = ?";
				*/
		
		String freeSql = "SELECT * FROM FREELANCER WHERE FREEID = ? AND FREEPW = ?";
		String empSql = "SELECT * FROM EMPLOYEE WHERE EMPID = ? AND EMPPW = ?";
		
		//결과값 -1은 로그인실패 1은 프리랜서로그인 2는 직원로그인
		int res = -1;
		Connection conn = null;
		ResultSet freers = null;
		ResultSet emprs = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(freeSql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			freers = pstmt.executeQuery();
			
			while (freers.next())
			{
				if(freers.getString("FREEID") != null);
				{	
					loginFree.setParams(freers);
					
					res = 1;
					break;
				}
			}
			
			pstmt.close();
			pstmt = conn.prepareStatement(empSql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			emprs = pstmt.executeQuery();
			
			while (emprs.next())
			{
				if(emprs.getString("EMPID") != null);
				{
					loginEmp.setParams(emprs);
					
					res = 2;
					break;
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("왜안되지");
		}
		finally
		{
			DBManager.close(conn, pstmt, freers, emprs);
		}
		
		System.out.println(loginFree == null ? "로그인프리널" : "로그인프리낫널");
		
		return res;
	}
	
	public List<Message> selectAllMsgFree(String id) {
		// 이전에 보내진 메시지를 프리랜서의 아이디로 전부 불러오는 메소드
		String sql = "select * from Message where freeReceiver='"+ id + "' order by msgNum desc";

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
	}
	
	public List<Message> selectAllMsgEmp(String id) {
		// 이전에 보내진 메시지를 사원(관리자)의 아이디로 전부 불러오는 메소드
		String sql = "select * from Message where empReceiver='"+ id + "' order by msgNum desc";

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
	}

	public Message selectOneMsgByNo(String msgNum) {
		// 메시지 번호를 통해 메시지의 정보를 가져오는 메소드
		String sql = "select * from message where msgNum=?";

		Message msgVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msgNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				msgVo = new Message();

				msgVo.setParams(rs);

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return msgVo;
	}
	
	public void insertMsg(Message msgVo) {
		// 새로운 메시지를 보내는 메소드
		String sql = "insert into message(msgNum, prevMsgNum, freeWriter, empWriter, freeReceiver, "
				+ "empReceiver, msgTitle, msgContent, msgSendDate, msgChecked, projNum) "
				+ "values(null, ?, ?, ?, ?, ?, ?, ?, now(), false, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("insertMsg 메소드");
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			// 이전메시지가 없으면 널을 넣어준다.
			if(msgVo.getPrevMsgNum() == null || msgVo.getPrevMsgNum()=="") {
				pstmt.setString(1, null);
				System.out.println("이전 메시지 번호 : null");
			} else {
				pstmt.setInt(1, Integer.parseInt(msgVo.getPrevMsgNum()));
				System.out.println("이전 메시지 번호 : " + msgVo.getPrevMsgNum());
			}
			
			// 프리랜서 작성자가 널이면 널을 넣어준다.
			if(msgVo.getFreeWriter() == null || msgVo.getFreeWriter() == "") {
				pstmt.setString(2, null);
				System.out.println("발신하는 프리랜서 : null");
			} else {
				pstmt.setString(2, msgVo.getFreeWriter());
				System.out.println("발신하는 프리랜서 : " + msgVo.getFreeWriter());
			}
			
			// 사원 작성자가 널이면 널을 넣어준다.
			if(msgVo.getEmpWriter() == null || msgVo.getEmpWriter() == "") {
				pstmt.setString(3, null);
				System.out.println("발신하는 사원(관리자) : null");
			} else {
				pstmt.setString(3, msgVo.getEmpWriter());
				System.out.println("발신하는 사원(관리자) : " + msgVo.getEmpWriter());
			}
			
			// 프리랜서 수신자가 널이면 널을 넣어준다.
			if(msgVo.getFreeReceiver() == null || msgVo.getFreeReceiver() == "") {
				pstmt.setString(4, null);
				System.out.println("수신받는 프리랜서 : null");
			} else {
				pstmt.setString(4, msgVo.getFreeReceiver());
				System.out.println("수신받는 프리랜서 : " + msgVo.getFreeReceiver());
			}
			
			// 사원 수신자가 널이면 널을 넣어준다.
			if(msgVo.getEmpReceiver() == null || msgVo.getEmpReceiver() == "") {
				pstmt.setString(5, null);
				System.out.println("수신받는 사원(관리자) : null");
			} else {
				pstmt.setString(5, msgVo.getEmpReceiver());
				System.out.println("수신받는 사원(관리자) : " + msgVo.getEmpReceiver());
			}

			pstmt.setString(6, msgVo.getMsgTitle());
			pstmt.setString(7, msgVo.getMsgContent());
			
			// 연관된 프로젝트가 없으면(연관 프로젝트가 널이면) 널을 넣어준다.
			if(msgVo.getProjNum() == null || msgVo.getProjNum() == "") {
				pstmt.setString(8, null);
				System.out.println("연관된 프로젝트 번호 : null");
			} else {
				pstmt.setInt(8, Integer.parseInt(msgVo.getProjNum()));
				System.out.println("연관된 프로젝트 번호 : " + msgVo.getProjNum());
			}
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	public void sendInterviewMsg(Message msgVo, String joinNum) {
		// 인터뷰할 사람들에게 면접일정과 장소에 대한 통지를 하는 메소드
		String sql = "insert into message(msgNum, prevMsgNum, freeWriter, empWriter, freeReceiver, "
				+ "empReceiver, msgTitle, msgContent, msgSendDate, msgChecked, projNum) "
				+ "values(null, ?, ?, ?, ?, ?, ?, ?, now(), false, (select projNum from joinProj where joinNum = ?))";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			// 이전메시지가 없으면 널을 넣어준다.
			if(msgVo.getPrevMsgNum() == null || msgVo.getPrevMsgNum()=="") {
				pstmt.setString(1, null);
			} else {
				pstmt.setInt(1, Integer.parseInt(msgVo.getPrevMsgNum()));
			}
			
			// 프리랜서 작성자가 널이면 널을 넣어준다.
			if(msgVo.getFreeWriter() == null || msgVo.getFreeWriter() == "") {
				pstmt.setString(2, null);
			} else {
				pstmt.setString(2, msgVo.getFreeWriter());
			}
			
			// 사원 작성자가 널이면 널을 넣어준다.
			if(msgVo.getEmpWriter() == null || msgVo.getEmpWriter() == "") {
				pstmt.setString(3, null);
			} else {
				pstmt.setString(3, msgVo.getEmpWriter());
			}
			
			// 프리랜서 수신자가 널이면 널을 넣어준다.
			if(msgVo.getFreeReceiver() == null || msgVo.getFreeReceiver() == "") {
				pstmt.setString(4, null);
			} else {
				pstmt.setString(4, msgVo.getFreeReceiver());
			}
			
			// 사원 수신자가 널이면 널을 넣어준다.
			if(msgVo.getEmpReceiver() == null || msgVo.getEmpReceiver() == "") {
				pstmt.setString(5, null);
			} else {
				pstmt.setString(5, msgVo.getEmpReceiver());
			}

			pstmt.setString(6, msgVo.getMsgTitle());
			pstmt.setString(7, msgVo.getMsgContent());
			
			// 연관된 프로젝트가 없으면(연관 프로젝트가 널이면) 널을 넣어준다.
			if(joinNum == null || joinNum == "") {
				pstmt.setString(8, null);
			} else {
				pstmt.setString(8,joinNum);
			}
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	public void updateMsgCheckedDate(String msgNo) {
		// 확인이 되지 않은 메시지를 확인하는 첫 회에 메시지 확인을 해주는 메소드
		String sql = "update message set msgCheckedDate = now(), msgChecked = 1"
				+ " where msgNum = ? and msgChecked = 0";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, msgNo);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public Project selectLastJoinProject() {
		// 가장 최근에 등록된 프로젝트를 가져오는 메소드
		String sql = "select * from project order by projRegisterDate desc limit 1";

		Project pVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				
				pVo = new Project();

				pVo.setParams(rs);
				
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, stmt, rs);

		}

		return pVo;
	}
	
	public Project selectProjectByNo(String projNo) {
		// 가장 최근에 등록된 프로젝트를 가져오는 메소드
		String sql = "select * from project from projNum = ?";

		Project pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				pVo = new Project();

				pVo.setParams(rs);

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return pVo;
	}
	
	public ProjectInfo selectLastRegistProject() {
		// 가장 최근에 등록된 프로젝트의 정보와 그에 관련된 정보(필요인원, 신청인원, 사용언어들, 사용프레임워크들)를 가져오는 메소드
		String sql = "select * from project_info3 order by projRegisterDate desc limit 1";

		ProjectInfo pVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				
				pVo = new ProjectInfo();

				pVo.setParams(rs);
				
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, stmt, rs);

		}

		return pVo;
	}
	
	public List<ProjectInfo> selectAllJoinableProject() {
		// 시작하지 않은 프로젝트들을 가져오는 메소드 
		String sql = "select * from project_info3 where projStartDate >= now() order by projNum desc";

		List<ProjectInfo> list = new ArrayList<ProjectInfo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProjectInfo pVo = new ProjectInfo();

				pVo.setParams(rs);
				
				list.add(pVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}
	
	public ProjectInfo selectOneProjByNo(String No) {
		String sql = "select * from project_info3 where projNum=?";

		ProjectInfo pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, No);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				pVo = new ProjectInfo();

				pVo.setParams(rs);

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return pVo;
	}
	
	public List<JoinProj> selectJoinProjByFreeId(String id) {
		String sql = "select * from joinProject where freeId='"+ id + "' order by joinNum desc";

		List<JoinProj> list = new ArrayList<JoinProj>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				JoinProj jVo = new JoinProj();
				
				jVo.setParamsIncludeProject(rs);
				
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

		System.out.println("getJoinProjByNo 시작");
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

				System.out.println("getJoinProjByNo 진행중");

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
		System.out.println("getJoinProjByNo 종료");

		return jVo;
	}
}

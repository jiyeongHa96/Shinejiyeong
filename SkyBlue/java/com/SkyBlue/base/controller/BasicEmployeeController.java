package com.SkyBlue.base.controller;

import java.util.List;

import com.tobesoft.xplatform.data.PlatformData;
import com.SkyBlue.base.serviceFacade.BaseServiceFacade;

import com.SkyBlue.common.mapper.DatasetBeanMapper;



import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.to.EmployeeBean;
import com.SkyBlue.base.to.EmployeeHireDateBean;


/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;*/

@Controller
public class BasicEmployeeController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	/*사원리스트 조회하기*/	
	@RequestMapping("/base/findEmployeeList.do")
	public void findEmployeeList(@RequestAttribute("inData") PlatformData inData,
								 @RequestAttribute("outData") PlatformData outData) throws Exception{
		  List<EmployeeBean> EmployeeList=baseServiceFacade.findEmployeeList();
		  datasetBeanMapper.beansToDataset(outData, EmployeeList, EmployeeBean.class);
	}
	
	
	/* 사원정보 일괄저장하는 메서드  */
	@RequestMapping("/base/batchEmployee.do")
	public void batchEmployee(@RequestAttribute("inData") PlatformData inData,
			  				  @RequestAttribute("outData") PlatformData outData) throws Exception{
		EmployeeBean employeeBean=datasetBeanMapper.datasetToBean(inData, EmployeeBean.class);
		baseServiceFacade.batchEmployee(employeeBean);
		findEmployeeList(inData,outData); // 사원등록 후 dsEmployee dataset을 새롭게 등록해줘야한다. 기존에 만들어 둔걸 이용한다!
	}
	
	
	/*퇴직자 미포함 사원정보 얻기*/	
	@RequestMapping("/base/findFilterEmployeeList.do")
	public void findFilterEmployeeList(@RequestAttribute("inData") PlatformData inData,
			  						   @RequestAttribute("outData") PlatformData outData) throws Exception{
		  List<EmployeeBean> EmployeeList=baseServiceFacade.findFilterEmployeeList();
		  datasetBeanMapper.beansToDataset(outData, EmployeeList, EmployeeBean.class);
	}

	/*사원기초정보관리*/
	@RequestMapping("/base/batcEditEmployee.do")
	public void batcEditEmployee(@RequestAttribute("inData") PlatformData inData,
			  					 @RequestAttribute("outData") PlatformData outData) throws Exception{
		List<EmployeeBean> employeeList=datasetBeanMapper.datasetToBeans(inData, EmployeeBean.class);
		baseServiceFacade.batcEditEmployee(employeeList);
		findEmployeeList(inData,outData);
	}
	
	/* 모든 사원의 입사정보를 가지고 오는 메서드 */
	@RequestMapping("/base/findEmployeeHireDateList.do")
	public void findEmployeeHireDateList(@RequestAttribute("inData") PlatformData inData,
			  							 @RequestAttribute("outData") PlatformData outData) throws Exception{
		  List<EmployeeHireDateBean> employeeHireDateList=baseServiceFacade.findEmployeeHireDateList();
		  datasetBeanMapper.beansToDataset(outData, employeeHireDateList, EmployeeHireDateBean.class);
	}
	
	/* 재직증명서 가져오는 메서드 */
/*	@RequestMapping("/base/pdfSend.do")
	public void pdfSend(@RequestAttribute("inData") PlatformData inData,
			  			@RequestAttribute("outData") PlatformData outData) throws Exception  {
	      String sEmpCode = inData.getVariable("sEmpCode").getString();
	      System.out.println("!@#$:-----"+sEmpCode);
	        
	      String templatePath = "C:/MiplatformSpring/SkyBlue/src/main/webapp/report/empPdf.jrxml";
	       // 출력할 PDF 파일 경로
	      String destPath1 = "C:/MiplatformSpring/SkyBlue/src/main/webapp/report/"+sEmpCode+".pdf";
	      String destPath2 = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/SkyBlue/report/"+sEmpCode+".pdf";
	      Connection con = null;
	      try {
	      //템플레이트 XML 컴파일
	      JasperReport jasperReport = JasperCompileManager.compileReport(templatePath);
	      Map<String,Object> paramMap = new HashMap<>();
	      paramMap.put("empCode",sEmpCode);
	      //getConnection
	      Class.forName("oracle.jdbc.OracleDriver");
	      con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "insa","insa");
	      //데이타의 동적 바인드
	      JasperPrint print = JasperFillManager.fillReport(jasperReport, paramMap, con);
	      //PDF로 출력
	      JasperExportManager.exportReportToPdfFile(print, destPath1);
	      JasperExportManager.exportReportToPdfFile(print, destPath2);	 
	      }catch (Exception ex) {
	            ex.printStackTrace();
	      }finally{
	         try {
	            if(con.isClosed() == false){
	               con.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	   }*/
	
	@RequestMapping("/base/sendEmail.do")
	public void sendEmail(@RequestAttribute("inData") PlatformData inData,
  					      @RequestAttribute("outData") PlatformData outData) throws Exception {
	      String empCode = inData.getVariable("sEmpCode").getString();
	      String sEmail = inData.getVariable("sEmail").getString();
	      // 메일 관련 정보
	         String host = "smtp.naver.com";
	         final String username = "tlsgjs7764";               //네이버 아이디
	         final String password = "asdasdasddasdasdasasd";      //비밀번호
	         int port=465;
	          
	         // 메일 내용
	         String recipient = sEmail;                   //받는 사람의 이메일
	         String subject = empCode+"님의 재직 증명서 입니다.";    //이메일 제목
	         String body = "확인 후 회신바랍니다";                //이메일 내용
	          
	         Properties props = System.getProperties();
	          
	         props.put("mail.smtp.host", host);
	         props.put("mail.smtp.port", port);
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.smtp.ssl.enable", "true");
	         props.put("mail.smtp.ssl.trust", host);
	           
	         Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	             String un=username;
	             String pw=password;
	             protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(un, pw);
	             }
	         });
	         session.setDebug(true);
	           
	         Message msg = new MimeMessage(session);
	         msg.setFrom(new InternetAddress("tlsgjs7764@naver.com","<tlsgjs7764@naver.com>"));    //첫인자가 보내는 사람 이메일, 두번째 인자가 보내는 사람 이름
	         msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	         msg.setSubject(subject);
	          
	         // 파일첨부를 위한 Multipart
	         Multipart multipart = new MimeMultipart();
	          
	         // BodyPart를 생성
	         BodyPart bodyPart = new MimeBodyPart();
	         bodyPart.setText(body);
	          
	         //Multipart에 BodyPart를 붙인다.
	         multipart.addBodyPart(bodyPart);
	          
	         //이미지를 첨부한다.
	         bodyPart = new MimeBodyPart();
	         String filename = "C:/MiplatformSpring/SkyBlue/src/main/webapp/report/"+empCode+".pdf";
	         //첨부할 파일 경로
	         FileDataSource source = new FileDataSource(filename);
	         bodyPart.setDataHandler(new DataHandler(source));
	         
	         bodyPart.setFileName(empCode+"_재직증명서.pdf");
	         //첨부할 파일의 이름을 바꿔서 보낼수 있음
	         
	         bodyPart.setHeader("Content-ID", "image_id");
	         multipart.addBodyPart(bodyPart);
	          
	         // 이메일 메시지의 내용에 Multipart를 붙인다.
	         msg.setContent(multipart);
	         Transport.send(msg);
	   }
}
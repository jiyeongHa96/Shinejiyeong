package com.SkyBlue.base.serviceFacade;

import java.util.List;
import java.util.Map;

import com.SkyBlue.base.exception.BusinessPlaceNotFoundException;
import com.SkyBlue.base.exception.DeptNotFoundException;
import com.SkyBlue.base.exception.EmpCodeNotFoundException;
import com.SkyBlue.base.exception.PwMissMatchException;
import com.SkyBlue.base.to.AddressBean;
import com.SkyBlue.base.to.AuthorityBean;
import com.SkyBlue.base.to.AuthorityInfoBean;
import com.SkyBlue.base.to.BusinessPlaceBean;
import com.SkyBlue.base.to.CodeBean;
import com.SkyBlue.base.to.CodeInfoBean;
import com.SkyBlue.base.to.CompanyBean;
import com.SkyBlue.base.to.DeptBean;
import com.SkyBlue.base.to.DetailCodeBean;
import com.SkyBlue.base.to.EmployeeBean;
import com.SkyBlue.base.to.EmployeeHireDateBean;
import com.SkyBlue.base.to.EtcSalBean;
import com.SkyBlue.base.to.MenuAuthorityBean;
import com.SkyBlue.base.to.MenuBean;
import com.SkyBlue.base.to.OvertimeSalBean;
import com.SkyBlue.base.to.PositionBean;
import com.SkyBlue.base.to.SidoBean;
import com.SkyBlue.base.to.SigunguBean;
import com.SkyBlue.base.to.SudangInfoBean;



public interface BaseServiceFacade {
	/* 부서 */
	public List<DeptBean> findDeptList(String businessPlaceCode);
	public void batchDept(List<DeptBean> deptList);

	/*사원*/
	public List<EmployeeBean> findEmployeeList();
	public void batchEmployee(EmployeeBean employeeBean);
	public List<EmployeeBean> findFilterEmployeeList();
	public void batcEditEmployee(List<EmployeeBean> employeeList); /*사원기초정보관리 (수정)*/
	public List<EmployeeHireDateBean> findEmployeeHireDateList();/*사원의연차 정보가져 오기 위해서 사원목록 필요함 */
	
	/* 권한및메뉴 */
	public List<MenuBean> findMenuList();	
	public List<MenuAuthorityBean> findMenuAuthorityList(String authorityCode); //로그인 사원의 권한
	public List<MenuAuthorityBean> findMenuAuthorityListAll();//권한 수정 관리시
	public void batchAuthority(AuthorityInfoBean authorityInfoBean);
	
	/* 직급 */
	public List<PositionBean> findPositionList();
	
	/* 호봉 */
	public PositionBean findPosition(String positionCode);
	
	/*권한목록*/
	public List<AuthorityBean> findAuthorityList();
	
	
	/*코드*/
	public List<CodeBean> findCodeList();
	public void batchCode(CodeInfoBean codeInfoBean);
	public void batchDetailCode(List<DetailCodeBean> codeDetailList);
	
	/* 주소 */
	public List<SidoBean> findSido();
	
	public List<SigunguBean> findSiGunGuList(String sido);
	public List<AddressBean> findAddrList(Map<String, Object> addrList);
	
	/*수당*/
	public List<OvertimeSalBean> findOvertimeSalList();
	public List<EtcSalBean> findEtcSalList();
	public void batchSudang(SudangInfoBean sudangInfoBean);
	
	/*회사*/
	public CompanyBean findCompany();
	public void batchCompany(CompanyBean companyBean);
	
	/*사업장*/
	public List<BusinessPlaceBean> findBusinessPlaceList();
	public void batchBusinessPlaceList(List<BusinessPlaceBean> businessPlaceList);
	
	/*로그인*/
	public EmployeeBean checkLogin(String businessPlaceCode,String deptCode,String empCode,String password)throws EmpCodeNotFoundException,BusinessPlaceNotFoundException,DeptNotFoundException,PwMissMatchException;

}

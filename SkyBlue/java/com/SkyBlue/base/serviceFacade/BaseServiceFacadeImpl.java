package com.SkyBlue.base.serviceFacade;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.SkyBlue.base.applicationService.AuthorityAppService;
import com.SkyBlue.base.applicationService.BasicDeptAppService;
import com.SkyBlue.base.applicationService.BasicEmployeeAppService;
import com.SkyBlue.base.applicationService.BasicSalaryAppService;
import com.SkyBlue.base.applicationService.BusinessPlaceAppService;
import com.SkyBlue.base.applicationService.CodeAppService;
import com.SkyBlue.base.applicationService.CompanyAppService;
import com.SkyBlue.base.applicationService.LoginAppService;
import com.SkyBlue.base.applicationService.MenuAppService;
import com.SkyBlue.base.applicationService.PositionAppService;
import com.SkyBlue.base.applicationService.PostAppService;
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

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BaseServiceFacadeImpl implements BaseServiceFacade{
	@Autowired
	private BasicDeptAppService basicDeptAppService;
	@Autowired
	private BasicEmployeeAppService basicEmployeeAppService;
	@Autowired
	private MenuAppService menuAppService;
	@Autowired
	private AuthorityAppService authorityAppService;
	@Autowired
	private PositionAppService positionAppService;
	@Autowired
	private CodeAppService codeAppService;
	@Autowired
	private PostAppService postAppService;
	@Autowired
	private BasicSalaryAppService basicSalaryAppService;
	@Autowired
	private CompanyAppService companyAppService;
	@Autowired
	private BusinessPlaceAppService businessPlaceAppService;
	@Autowired
	private LoginAppService loginAppService;
	
	/* 부서코드목록을 반환하는 메서드 */
	@Override
	public List<DeptBean> findDeptList(String businessPlaceCode) {
		return basicDeptAppService.findDeptList(businessPlaceCode);
	}

	/*로그인시 사원정보 얻어 옴*/
	public List<EmployeeBean> findEmployeeList() {
		
		return basicEmployeeAppService.findEmployeeList();
	}

	/* menu 목록을 들고오는 메서드 */
	@Override
	public List<MenuBean> findMenuList() {
		return menuAppService.findMenuList();
	}
	
	/* 권한에따른 메뉴목록을 들고오는 메서드 */
	@Override
	public List<MenuAuthorityBean> findMenuAuthorityList(String authorityCode) {
		return authorityAppService.findMenuAuthorityList(authorityCode);
	}
	
	
	/* 직급목록을 가져오는 메서드 */
	@Override
	public List<PositionBean> findPositionList() {
		return positionAppService.findPositionList();
	}
	
	/*호봉목록을 가져오는 메서드*/
	public PositionBean findPosition(String positionCode) {
		return positionAppService.findPosition(positionCode);
	}
	
	
	/* 권한목록을 가져오는 메서드 */
	@Override
	public List<AuthorityBean> findAuthorityList() {
		return authorityAppService.findAuthorityList();
	}
	
	/* 사원정보를 일괄저장하는 메서드 */
	@Override
	public void batchEmployee(EmployeeBean employeeBean) {
		basicEmployeeAppService.batchEmployee(employeeBean);
	}
	
	/*퇴직한 사원을 제외한 사원 조회*/
	public List<EmployeeBean> findFilterEmployeeList() {
		
		return basicEmployeeAppService.findFilterEmployeeList();
	}
	
	/*사원기초정보 수정*/
	@Override
	public void batcEditEmployee(List<EmployeeBean> employeeList) {
		basicEmployeeAppService.batcEditEmployee(employeeList);

	}
	
	/*부서정보 수정*/
	@Override
	public void batchDept(List<DeptBean> deptList) {
		basicDeptAppService.batchDept(deptList);
	}
	
	/* 코드목록을 반환하는 메서드 */
	@Override
	public List<CodeBean> findCodeList() {
		return codeAppService.findCodeList();
	}
	
	/* 코드관련된 정보를 일괄적으로 처리하는 메서드(코드 + 상세코드) */
	@Override
	public void batchCode(CodeInfoBean codeInfoBean) {
		codeAppService.batchCode(codeInfoBean);
	}
	/* 코드상세관련 정보를 일괄적으로 처리하는 메서드 (상세코드)*/
	@Override
	public void batchDetailCode(List<DetailCodeBean> codeDetailList) {
		codeAppService.batchDetailCode(codeDetailList);
	}
	
	/* 모든권한의 메뉴를 다 가져오는 메서드 */
	@Override
	public List<MenuAuthorityBean> findMenuAuthorityListAll() {
		return authorityAppService.findMenuAuthorityListAll();
	}
	
	/* 권한, 메뉴관련된 일괄처리를 하는 메서드 */
	@Override
	public void batchAuthority(AuthorityInfoBean authorityInfoBean) {
		authorityAppService.batchAuthority(authorityInfoBean);
	}
	
	/* 특별시,광역시,도를 조회하는 메서드 */
	@Override
	public List<SidoBean> findSido() {
		return postAppService.findSido();
	}
	/* 특별시,광역시,도에 해당하는 시,군,구를 조회하는 메서드 */
	@Override
	public List<SigunguBean> findSiGunGuList(String sido) {
		return postAppService.findSiGunGuList(sido);
	}
	/* 전체조건에 맞는 주소를 가지고 오는 메서드 */
	@Override
	public List<AddressBean> findAddrList(Map<String, Object> addrList) {
		return postAppService.findAddrList(addrList);
	}
	
	
	/* 모든사원의 사원정보, 재직정보를 가지고 오는 메서드 */
	@Override
	public List<EmployeeHireDateBean> findEmployeeHireDateList() {
		return basicEmployeeAppService.findEmployeeHireDateList();
	}
	
	
	/* 연장,야간,휴일수당목록을 가져오는 메서드 */
	@Override
	public List<OvertimeSalBean> findOvertimeSalList() {
		return basicSalaryAppService.findOvertimeSalList();
	}
	/* 기타수당목록을 가져오는 메서드 */
	@Override
	public List<EtcSalBean> findEtcSalList() {
		return basicSalaryAppService.findEtcSalList();
	}
	/*기타 수당 연장수당 등록*/
	@Override
	public void batchSudang(SudangInfoBean sudangInfoBean) {
		basicSalaryAppService.batchSudang(sudangInfoBean);

	}
    /*회사정보 가져오는 메서드*/
	@Override
	public CompanyBean findCompany() {
		return companyAppService.findCompany();
	}

	@Override
	public void batchCompany(CompanyBean companyBean) {

		companyAppService.batchCompany(companyBean);
	}

	/* 부서목록을 조회하는 메서드 */
	@Override
	public List<BusinessPlaceBean> findBusinessPlaceList() {
		 return businessPlaceAppService.findBusinessPlaceList();
	}
	/*부서관리 (등록/삭제/수정)*/
	@Override
	public void batchBusinessPlaceList(List<BusinessPlaceBean> businessPlaceList) {
	   
		businessPlaceAppService.batchBusinessPlaceList(businessPlaceList);
	
	}
	
	public EmployeeBean checkLogin(String businessPlaceCode,String deptCode,String empCode,String password)throws EmpCodeNotFoundException,BusinessPlaceNotFoundException,DeptNotFoundException,PwMissMatchException {
		
		return loginAppService.checkLogin(businessPlaceCode,deptCode,empCode,password);
		
	}

}

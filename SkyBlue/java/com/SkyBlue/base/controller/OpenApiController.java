package com.SkyBlue.base.controller;

import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.SkyBlue.base.to.OpenApiBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class OpenApiController{
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

    protected final Log logger = LogFactory.getLog(this.getClass());
    
	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) throws RuntimeException {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;

		return nValue.getNodeValue();
	}
	@RequestMapping("/base/OpenApiList.do")
	public void OpenApiList(@RequestAttribute("inData") PlatformData inData,
				 			@RequestAttribute("outData") PlatformData outData) throws Exception{
		String FDLCTCD = inData.getVariable("FDLCTCD").getString();
		String PRDTCLCD02 = inData.getVariable("PRDTCLCD02").getString();
		List<OpenApiBean> openApiList = new ArrayList<>();
		OpenApiBean openApiBean = null ;
		
		String url = "http://apis.data.go.kr/1320000/SearchMoblphonInfoInqireService/getMoblphonAcctoKindAreaPeriodInfo?FD_LCT_CD="+FDLCTCD+"&PRDT_CL_CD_02="+PRDTCLCD02+"&numOfRows=40&serviceKey=myPzPUQNnH793f%2FXjs1oNN2Oq9R6HbaBO%2Bve0nI5e%2BZfK1%2FkErdYOyF7GDgbdX2p9OyTWT9E5a9V4gWXAem9Tw%3D%3D"; 
				  	  
		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(url);

		// root tag
		doc.getDocumentElement().normalize();
		 /*System.out.println("Root element :" +
		 doc.getDocumentElement().getNodeName()); //최상위노드 = RESPONSE*/
 
		// 파싱할 tag
		NodeList nList = doc.getElementsByTagName("item");
		//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		try{
			for(int temp = 0; temp < nList.getLength(); temp++){		
				Element eElement = (Element) nList.item(temp);
					openApiBean = new OpenApiBean();	
	/*물품명 */ 		openApiBean.setFdPrdtNm(getTagValue("fdPrdtNm",eElement)); 
	/*관리ID */ 		openApiBean.setAtcId(getTagValue("atcId",eElement));
	/*핸드폰모델코드 */  openApiBean.setMdcd(getTagValue("mdcd",eElement));
	/*습득물 사진이미지 */openApiBean.setFdFilePathImg(getTagValue("fdFilePathImg",eElement));
	/*습득일자*/ 		openApiBean.setFdYmd(getTagValue("fdYmd",eElement));
	/*보관장소*/ 		openApiBean.setDepPlace(getTagValue("depPlace",eElement));
	/*특이사항*/ 		openApiBean.setFdSbjt(getTagValue("fdSbjt",eElement));

					openApiList.add(openApiBean);
			}
		}catch(NullPointerException e) {
			//임시방편으로 넣음..
		}
			datasetBeanMapper.beansToDataset(outData, openApiList, OpenApiBean.class);
		
	}
}

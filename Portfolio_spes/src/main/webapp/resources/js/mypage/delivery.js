/**
 *  택배조회 api
 */

var dtd_companys = new Array();
dtd_companys["우체국택배"] = new Array(13, "http://service.epost.go.kr/trace.RetrieveRegiPrclDeliv.postal?sid1=","1234567890123 (13자리)","1588-1300","http://parcel.epost.go.kr");
dtd_companys["대한통운"] = new Array(10, "http://www.doortodoor.co.kr/servlets/cmnChnnel?tc=dtd.cmn.command.c03condiCrg01Cmd&invc_no=","1234567890 (10자리)", "1588-1255", "http://www.doortodoor.co.kr");
dtd_companys["한진택배"] = new Array(12, "http://www.hanjin.co.kr/Delivery_html/inquiry/result_waybill.jsp?wbl_num=", "1234567890 (10,12자리)", "1588-0011", "http://hanex.hanjin.co.kr");
dtd_companys["로젠택배"] = new Array(11, "http://www.ilogen.com/iLOGEN.Web.New/TRACE/TraceView.aspx?gubun=slipno&slipno=", "12345678901 (11자리)","1588-9988", "http://www.ilogen.com");
dtd_companys["현대택배"] = new Array(12, "http://www.hlc.co.kr/hydex/jsp/tracking/trackingViewCus.jsp?InvNo=", "1234567890 (10,12자리)", "1588-2121", "http://www.hlc.co.kr");
dtd_companys["KG옐로우캡택배"] = new Array(11, "http://www.yellowcap.co.kr/custom/inquiry_result.asp?invoice_no=", "12345678901 (11자리)", "1588-0123", "http://www.yellowcap.co.kr");
dtd_companys["KGB택배"] = new Array(10, "http://www.kgbls.co.kr/sub5/trace.asp?f_slipno=", "1234567890 (10자리)", "1577-4577", "http://www.kgbls.co.kr");
dtd_companys["EMS"] = new Array(13, "http://service.epost.go.kr/trace.RetrieveEmsTrace.postal?ems_gubun=E&POST_CODE=", "EE123456789KR (13자리)", "1588-1300", "http://service.epost.go.kr");
dtd_companys["DHL"] = new Array(0, "http://www.dhl.co.kr/publish/kr/ko/eshipping/track.high.html?pageToInclude=RESULTS&type=fasttrack&AWB=", "1234567890 (10자리)", "1588-0001", "http://www.dhl.co.kr");
dtd_companys["한덱스"] = new Array(10, "http://btob.sedex.co.kr/work/app/tm/tmtr01/tmtr01_s4.jsp?IC_INV_NO=", "1234567890 (10자리)", "1588-9040", "http://www.e-handex.co.kr");
dtd_companys["FedEx"] = new Array(12, "http://www.fedex.com/Tracking?ascend_header=1&clienttype=dotcomreg&cntry_code=kr&language=korean&tracknumbers=", "123456789012 (12자리)", "080-023-8000", "http://www.fedex.com/kr");
dtd_companys["동부익스프레스"] = new Array(12, "http://www.dongbuexpress.co.kr/Html/Delivery/DeliveryCheckView.jsp?item_no=", "123456789012 (12자리)", "1588-8848", "http://www.dongbuexpress.co.kr");
dtd_companys["CJ GLS"] = new Array(12, "http://nexs.cjgls.com/web/service02_01.jsp?slipno=", "123456789012 (12자리)", "1588-5353", "http://www.cjgls.co.kr");
dtd_companys["UPS"] = new Array(25, "http://www.ups.com/WebTracking/track?loc=ko_KR&InquiryNumber1=", "M1234567890 (최대 25자리)", "1588-6886", "http://www.ups.com/content/kr/ko/index.jsx" );
dtd_companys["하나로택배"] = new Array(10, "http://www.hanarologis.com/branch/chase/listbody.html?a_gb=center&a_cd=4&a_item=0&fr_slipno=", "1234567890 (최대 10자리)", "1577-2828", "http://www.hanarologis.com");
dtd_companys["대신택배"] = new Array(13, "http://home.daesinlogistics.co.kr/daesin/jsp/d_freight_chase/d_general_process2.jsp?", "1234567890123 (13자리)", "043-222-4582", "http://apps.ds3211.co.kr");
dtd_companys["경동택배"] = new Array(11, "http://www.kdexp.com/sub4_1.asp?stype=1&p_item=", "12345678901 (최대11자리)", "031-460-2400", "http://www.kdexp.com/");
dtd_companys["이노지스택배"] = new Array(13, "http://www.innogis.net/trace02.asp?invoice=", "1234567890123 (최대13자리)", "1566-4082", "http://www.innogis.net/");
dtd_companys["일양로지스택배"] = new Array(9, "http://www.ilyanglogis.com/functionality/tracking_result.asp?hawb_no=", "123456789 (9자리)", "1588-0002", "http://www.ilyanglogis.com/");
dtd_companys["CVSnet 편의점택배"] = new Array(10, "http://was.cvsnet.co.kr/src/ctod_status.jsp?invoice_no=", "1234567890 (10자리)", "1566-1025", "http://www.cvsnet.co.kr/");
dtd_companys["TNT Express"] = new Array(13, "http://www.tnt.com/webtracker/tracking.do?respCountry=kr&respLang=ko&searchType=CON&cons=", "GE123456789WW (9,13자리)", "1588-0588", "http://www.tnt.com/express/ko_kr/site/home.html");
dtd_companys["HB한방택배"] = new Array(12, "http://www.hbtb.co.kr/search/s_search.asp?f_slipno=", "123456789012 (12자리)", "1588-1059", "http://www.hbtb.co.kr/");
dtd_companys["GTX"] = new Array(12, "http://www.gtx2010.co.kr/del_inquiry_result.html?s_gbn=1&awblno=", "123456789012 (12자리)", "1588-1756", "http://www.gtx2010.co.kr");

var dtd_select_obj = document.getElementById("dtd_select");
var company = dtd_select_obj.options[dtd_select_obj.selectedIndex].value;
if(company == "" ) company = "우체국택배";

function doorToDoorSearch()
{
 var query_obj = document.getElementById('dtd_number_query');
 var query = query_obj.value;
 query = query.replace(' ', '');
 var url = "";
 
 /* 운송장 번호 값 확인 */
 if (company == "UPS") {
  var pattern1 = /^[0-9a-zA-Z]{9,12}$/i;
  var pattern2 = /^[0-9a-zA-Z]{18}$/i;
  var pattern3 = /^[0-9a-zA-Z]{25}$/i;
  if (query.search(pattern1) == -1 && query.search(pattern2) == -1 && query.search(pattern3) == -1) {
   alert(company+"의 운송장 번호 패턴에 맞지 않습니다.");
   query_obj.focus();
   return false;
  }
 } else if (company == "EMS") {
  var pattern = /^[a-zA-Z]{2}[0-9]{9}[a-zA-Z]{2}$/;
  if (query.search(pattern) == -1) {
   alert(company+"의 운송장 번호 패턴에 맞지 않습니다.");
   query_obj.focus();
   return false;
  }
 } else if (company == "한진택배" || company == "현대택배") {
  if (!isNumeric(query)) {
   alert("운송장 번호는 숫자만 입력해주세요.");
   query_obj.focus();
   return false;
  } else if ( query.length != 10 && query.length != 12 ) {
   alert(company+"의 운송장 번호는 10자리 또는 12자리의 숫자로 입력해주세요.");
   query_obj.focus();
   return false;
  }
 } else if (company == "경동택배") {
  if (!isNumeric(query)) {
   alert("운송장 번호는 숫자만 입력해주세요.");
   query_obj.focus();
   return false;
  } else if (query.length != 9 && query.length != 10 && query.length != 11) {
   alert(company+"의 운송장 번호는 9자리 또는 10자리 또는 11자리의 숫자로 입력해주세요.");
   query_obj.focus();
   return false;
  }
 } else if (company == "이노지스택배") {
  if (!isNumeric(query)) {
   alert("운송장 번호는 숫자만 입력해주세요.");
   query_obj.focus();
   return false;
  } else if (query.length > 13) {
   alert(company+"의 운송장 번호는 최대 13자리의 숫자로 입력해주세요.");
   query_obj.focus();
   return false;
  }
 } else if (company == "TNT Express") {
  var pattern1 = /^[a-zA-Z]{2}[0-9]{9}[a-zA-Z]{2}$/;
  var pattern2 = /^[0-9]{9}$/;
  if (query.search(pattern1) == -1 && query.search(pattern2) == -1) {
   alert(company+"의 운송장 번호 패턴에 맞지 않습니다.");
   query_obj.focus();
   return false;
  }
 } else {
  if (!isNumeric(query)) {
   alert("운송장 번호는 숫자만 입력해 주세요.");
   query_obj.focus();   
   return false;
  } else if (dtd_companys[company][0] > 0 && dtd_companys[company][0] != query.length) {
   alert(company+"의 운송장 번호는 "+dtd_companys[company][0]+"자리의 숫자로 입력해 주세요.");
   query_obj.focus();   
   return false;
  }
 }
 /* 링크만들기 */
 if (company == "대신택배") {
  url = dtd_companys[company][1];
  url+= "billno1="+query.substring(0,4);
  url+= "&billno2="+query.substring(4,7);
  url+= "&billno3="+query.substring(7,13);
 } else if (dtd_companys[company][1]) {
  url = dtd_companys[company][1]+query;
 }
 window.open(url,"_blank");
}

function isNumeric(s) {
 var count = 0;
 for (i = 0; i < s.length; i++) {

  if(s.charAt(i)<'0' || s.charAt(i)>'9') {
   count++;
  }
 }
 if(count > 0) {
  return 0;
 } else {
  return 1;
 }
}

function SetDeleveryContents(idx) {
 company = dtd_select_obj.options[idx].value;
 document.getElementById("Dcs01").innerHTML = dtd_companys[company][2];
 document.getElementById("Dcs02").innerHTML = company;
 document.getElementById("Dcs03").innerHTML = dtd_companys[company][3];
 document.getElementById("Dcs04").href  = dtd_companys[company][4];
 document.getElementById("Dcs04").target  = "_blank";
 
}

function checkValidDoor(query) {
 /* 운송장 번호 값 확인 */
 if (company == "UPS") {
  var pattern1 = /^1z[0-9]{16}$/i;
  var pattern2 = /^M[0-9]{10}$/;
  if (query.search(pattern1) == -1 && query.search(pattern2) == -1) {
   lert(company+"의 운송장 번호 패턴에 맞지 않습니다.");
   document.door_to_door_frm.dtd_number_query.focus();
   return false;
  }
 } else if (company == "EMS") {
  var pattern = /^[a-zA-z]{2}[0-9]{9}[a-zA-z]{2}$/;
  if (query.search(pattern) == -1) {
   alert(company+"의 운송장 번호 패턴에 맞지 않습니다.");
   document.door_to_door_frm.dtd_number_query.focus();
   return false;
  }
 } else if (company == "SC 로지스" || company == "한진택배" || company == "현대택배") {
  if (!isNumeric(query)) {
   alert("운송장 번호는 숫자만 입력해주세요.");
   document.door_to_door_frm.dtd_number_query.focus();
   return false;
  } else if ( query.length != 10 && query.length != 12 ) {
   alert(company+"의 운송장 번호는 10자리 또는 12자리의 숫자로 입력해주세요.");
   document.door_to_door_frm.dtd_number_query.focus();
   return false;
  }
 } else {
  if (!isNumeric(query)) {
   alert("운송장 번호는 숫자만 입력해 주세요.");
   document.door_to_door_frm.dtd_number_query.focus();   
   return false;
  } else if (dtd_companys[company][0] > 0 && dtd_companys[company][0] != query.length) {
   alert(company+"의 운송장 번호는 "+dtd_companys[company][0]+"자리의 숫자로 입력해 주세요.");
   document.door_to_door_frm.dtd_number_query.focus();   
   return false;
  }
 }

}
package com.spes.service;

import java.util.List;

import com.spes.model.BestVO;
import com.spes.model.CouponVO;
import com.spes.model.Criteria;
import com.spes.model.EventVO;
import com.spes.model.NewVO;

public interface MainmenuService {
	
	/* 전체상품 조회 */
	public List<NewVO> allmenu() throws Exception;
	
	
	/* 신상품 */
	//신상품 등록
	public void newWrite(NewVO newVO, String file1, String file2) throws Exception;
	
	//신상품 조회
	public List<NewVO> newpageList() throws Exception;
	
	//신상품 디테일 조회
	public NewVO newDetail(int np) throws Exception;
	
	//신상품 수정1
	public void newModify1(NewVO newVO, String file1, String file2) throws Exception;
	
	//신상품 수정2
	public void newModify2(NewVO newVO, String file1, String file2) throws Exception;
	
	//신상품 수정3
	public void newModify3(NewVO newVO, String file1, String file2) throws Exception;
	
	//신상품 수정4
	public void newModify4(NewVO newVO) throws Exception;
	
	//신상품 삭제
	public void newDelete(int np) throws Exception;
	
	
	/* 인기상품 */
	//인기상품 등록
	public void bestWrite(BestVO bestVO, String file1, String file2) throws Exception;
	
	//인기상품 조회
	public List<BestVO> bestpageList() throws Exception;
	
	//인기상품 디테일 조회
	public BestVO bestDetail(int np) throws Exception;
	
	//인기상품 수정1
	public void bestModify1(BestVO bestVO, String file1, String file2) throws Exception;
			
	//인기상품 수정2
	public void bestModify2(BestVO bestVO, String file1, String file2) throws Exception;
				
	//인기상품 수정3
	public void bestModify3(BestVO bestVO, String file1, String file2) throws Exception;
			
	//인기상품 수정4
	public void bestModify4(BestVO bestVO) throws Exception;
			
	//인기상품 삭제
	public void bestDelete(int np) throws Exception;
	
	
	/* 할인/쿠폰 */
	//할인/쿠폰 등록
	public void couponWrite(CouponVO couponVO, String file1, String file2) throws Exception;

	//할인/쿠폰 조회
	public List<CouponVO> couponList() throws Exception;
	
	//할인/쿠폰 디테일 조회
	public CouponVO couponDetail(int np) throws Exception;
	
	//할인/쿠폰 수정1
	public void couponModify1(CouponVO couponVO, String file1, String file2) throws Exception;
			
	//할인/쿠폰 수정2
	public void couponModify2(CouponVO couponVO, String file1, String file2) throws Exception;
				
	//할인/쿠폰 수정3
	public void couponModify3(CouponVO couponVO, String file1, String file2) throws Exception;
			
	//할인/쿠폰 수정4
	public void couponModify4(CouponVO couponVO) throws Exception;
			
	//할인/쿠폰 삭제
	public void couponDelete(int np) throws Exception;
	
	
	/* 이벤트 */
	//할인/쿠폰 등록
	public void eventWrite(EventVO eventVO, String file1, String file2) throws Exception;

	//할인/쿠폰 조회
	public List<EventVO> eventList() throws Exception;
	
	//할인/쿠폰 디테일 조회
	public EventVO eventDetail(int np) throws Exception;
	
	//이벤트 수정1
	public void eventModify1(EventVO eventVO, String file1, String file2) throws Exception;
				
	//이벤트 수정2
	public void eventModify2(EventVO eventVO, String file1, String file2) throws Exception;
					
	//이벤트 수정3
	public void eventModify3(EventVO eventVO, String file1, String file2) throws Exception;
				
	//이벤트 수정4
	public void eventModify4(EventVO eventVO) throws Exception;
				
	//이벤트 삭제
	public void eventDelete(int np) throws Exception;
	
	
	
}

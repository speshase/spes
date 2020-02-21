package com.spes.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spes.model.BestVO;
import com.spes.model.CouponVO;
import com.spes.model.EventVO;
import com.spes.model.NewVO;

@Repository
public class MainmenuMapperImpl implements MainmenuMapper{
	
	@Autowired
	//root-context에 있는 sqlSession의 속성을 가져옴
	private SqlSession sql;
	private static final String namespace="com.spes.mapper.MainmenuMapper";
	
	/* 전체상품 조회 */
	public List<NewVO> allmenu() throws Exception {
		List list = sql.selectList(namespace+".allmenu");
		return list;
	}

	/* 신상품 */
	//신상품 등록
	@Override
	public void newWrite(NewVO newVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".newWrite", map);
	}
	
	//신상품 조회
	@Override
	public List<NewVO> newpageList() throws Exception {
		List list = sql.selectList(namespace+".newpageList");
		return list;
	}

	//신상품 디테일 조회
	@Override
	public NewVO newDetail(int np) throws Exception {
		NewVO newVO = sql.selectOne(namespace+".newDetail", np);
		return newVO;
	}

	//신상품 수정1
	@Override
	public void newModify1(NewVO newVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".newModify1", map);
	}
	
	//신상품 수정2
	@Override
	public void newModify2(NewVO newVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".newModify2", map);
	}
		
	//신상품 수정3
	@Override
	public void newModify3(NewVO newVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".newModify3", map);
	}
	
	//신상품 수정4
	@Override
	public void newModify4(NewVO newVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		sql.update(namespace+".newModify4", map);
	}
	
	//신상품 삭제
	@Override
	public void newDelete(int np) throws Exception {
		sql.delete(namespace+".newDelete", np);
	}
	
	
	/* 인기상품 */
	//인기상품 등록
	@Override
	public void bestWrite(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("인기상품 등록 매퍼--"+bestVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".bestWrite", map);
	}
		
	//신상품 조회
	@Override
	public List<BestVO> bestpageList() throws Exception {
		System.out.println("인기상품 리스트 매퍼----------------");
		List list = sql.selectList(namespace+".bestpageList");
		return list;
	}
	
	//신상품 디테일 조회
	@Override
	public BestVO bestDetail(int np) throws Exception {
		BestVO bestVO = sql.selectOne(namespace+".bestDetail", np);
		return bestVO;
	}
	
	//신상품 수정1
	@Override
	public void bestModify1(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".bestModify1", map);
	}
		
	//신상품 수정2
	@Override
	public void bestModify2(BestVO bestVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".bestModify2", map);
	}
			
	//신상품 수정3
	@Override
	public void bestModify3(BestVO bestVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".bestModify3", map);
	}
		
	//신상품 수정4
	@Override
	public void bestModify4(BestVO bestVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		sql.update(namespace+".bestModify4", map);
	}
		
	//신상품 삭제
	@Override
	public void bestDelete(int np) throws Exception {
		sql.delete(namespace+".bestDelete", np);
	}

	
	/* 할인/쿠폰 */
	//할인/쿠폰 등록
	@Override
	public void couponWrite(CouponVO couponVO, String file1, String file2) throws Exception {
		System.out.println("할인/쿠폰상품 등록 매퍼--"+couponVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".couponWrite", map);
	}

	//할인/쿠폰 조회
	@Override
	public List<CouponVO> couponList() throws Exception {
		System.out.println("할인/쿠폰상품 리스트 매퍼----------------");
		List list = sql.selectList(namespace+".couponList");
		return list;
	}

	//할인/쿠폰 디테일 조회
	@Override
	public CouponVO couponDetail(int np) throws Exception {
		CouponVO couponVO = sql.selectOne(namespace+".couponDetail", np);
		return couponVO;
	}
	
	//할인/쿠폰 수정1
	@Override
	public void couponModify1(CouponVO couponVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".couponModify1", map);
	}
			
	//할인/쿠폰 수정2
	@Override
	public void couponModify2(CouponVO couponVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".couponModify2", map);
	}
				
	//할인/쿠폰 수정3
	@Override
	public void couponModify3(CouponVO couponVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".couponModify3", map);
	}
			
	//할인/쿠폰 수정4
	@Override
	public void couponModify4(CouponVO couponVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		sql.update(namespace+".couponModify4", map);
	}
			
	//할인/쿠폰 삭제
	@Override
	public void couponDelete(int np) throws Exception {
		sql.delete(namespace+".couponDelete", np);
	}
	
	
	/* 이벤트 */
	//이벤트 글등록
	@Override
	public void eventWrite(EventVO eventVO, String file1, String file2) throws Exception {
		System.out.println("할인/쿠폰상품 등록 매퍼--"+eventVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".eventWrite", map);
	}
	
	//이벤트 조회
	@Override
	public List<EventVO> eventList() throws Exception {
		System.out.println("할인/쿠폰상품 리스트 매퍼----------------");
		List list = sql.selectList(namespace+".eventList");
		return list;
	}

	//이벤트 디테일 조회
	@Override
	public EventVO eventDetail(int np) throws Exception {
		EventVO eventVO = sql.selectOne(namespace+".eventDetail", np);
		return eventVO;
	}
	
	//할인/쿠폰 수정1
	@Override
	public void eventModify1(EventVO eventVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".eventModify1", map);
	}
				
	//할인/쿠폰 수정2
	@Override
	public void eventModify2(EventVO eventVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".eventModify2", map);
	}
					
	//할인/쿠폰 수정3
	@Override
	public void eventModify3(EventVO eventVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".eventModify3", map);
	}
				
	//할인/쿠폰 수정4
	@Override
	public void eventModify4(EventVO eventVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		sql.update(namespace+".eventModify4", map);
	}
				
	//할인/쿠폰 삭제
	@Override
	public void eventDelete(int np) throws Exception {
		sql.delete(namespace+".eventDelete", np);
	}
	
}

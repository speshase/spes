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
	//root-context�� �ִ� sqlSession�� �Ӽ��� ������
	private SqlSession sql;
	private static final String namespace="com.spes.mapper.MainmenuMapper";
	
	/* ��ü��ǰ ��ȸ */
	public List<NewVO> allmenu() throws Exception {
		List list = sql.selectList(namespace+".allmenu");
		return list;
	}

	/* �Ż�ǰ */
	//�Ż�ǰ ���
	@Override
	public void newWrite(NewVO newVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".newWrite", map);
	}
	
	//�Ż�ǰ ��ȸ
	@Override
	public List<NewVO> newpageList() throws Exception {
		List list = sql.selectList(namespace+".newpageList");
		return list;
	}

	//�Ż�ǰ ������ ��ȸ
	@Override
	public NewVO newDetail(int np) throws Exception {
		NewVO newVO = sql.selectOne(namespace+".newDetail", np);
		return newVO;
	}

	//�Ż�ǰ ����1
	@Override
	public void newModify1(NewVO newVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".newModify1", map);
	}
	
	//�Ż�ǰ ����2
	@Override
	public void newModify2(NewVO newVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".newModify2", map);
	}
		
	//�Ż�ǰ ����3
	@Override
	public void newModify3(NewVO newVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".newModify3", map);
	}
	
	//�Ż�ǰ ����4
	@Override
	public void newModify4(NewVO newVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("newVO", newVO);
		sql.update(namespace+".newModify4", map);
	}
	
	//�Ż�ǰ ����
	@Override
	public void newDelete(int np) throws Exception {
		sql.delete(namespace+".newDelete", np);
	}
	
	
	/* �α��ǰ */
	//�α��ǰ ���
	@Override
	public void bestWrite(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("�α��ǰ ��� ����--"+bestVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".bestWrite", map);
	}
		
	//�Ż�ǰ ��ȸ
	@Override
	public List<BestVO> bestpageList() throws Exception {
		System.out.println("�α��ǰ ����Ʈ ����----------------");
		List list = sql.selectList(namespace+".bestpageList");
		return list;
	}
	
	//�Ż�ǰ ������ ��ȸ
	@Override
	public BestVO bestDetail(int np) throws Exception {
		BestVO bestVO = sql.selectOne(namespace+".bestDetail", np);
		return bestVO;
	}
	
	//�Ż�ǰ ����1
	@Override
	public void bestModify1(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".bestModify1", map);
	}
		
	//�Ż�ǰ ����2
	@Override
	public void bestModify2(BestVO bestVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".bestModify2", map);
	}
			
	//�Ż�ǰ ����3
	@Override
	public void bestModify3(BestVO bestVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".bestModify3", map);
	}
		
	//�Ż�ǰ ����4
	@Override
	public void bestModify4(BestVO bestVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bestVO", bestVO);
		sql.update(namespace+".bestModify4", map);
	}
		
	//�Ż�ǰ ����
	@Override
	public void bestDelete(int np) throws Exception {
		sql.delete(namespace+".bestDelete", np);
	}

	
	/* ����/���� */
	//����/���� ���
	@Override
	public void couponWrite(CouponVO couponVO, String file1, String file2) throws Exception {
		System.out.println("����/������ǰ ��� ����--"+couponVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".couponWrite", map);
	}

	//����/���� ��ȸ
	@Override
	public List<CouponVO> couponList() throws Exception {
		System.out.println("����/������ǰ ����Ʈ ����----------------");
		List list = sql.selectList(namespace+".couponList");
		return list;
	}

	//����/���� ������ ��ȸ
	@Override
	public CouponVO couponDetail(int np) throws Exception {
		CouponVO couponVO = sql.selectOne(namespace+".couponDetail", np);
		return couponVO;
	}
	
	//����/���� ����1
	@Override
	public void couponModify1(CouponVO couponVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".couponModify1", map);
	}
			
	//����/���� ����2
	@Override
	public void couponModify2(CouponVO couponVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".couponModify2", map);
	}
				
	//����/���� ����3
	@Override
	public void couponModify3(CouponVO couponVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".couponModify3", map);
	}
			
	//����/���� ����4
	@Override
	public void couponModify4(CouponVO couponVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("couponVO", couponVO);
		sql.update(namespace+".couponModify4", map);
	}
			
	//����/���� ����
	@Override
	public void couponDelete(int np) throws Exception {
		sql.delete(namespace+".couponDelete", np);
	}
	
	
	/* �̺�Ʈ */
	//�̺�Ʈ �۵��
	@Override
	public void eventWrite(EventVO eventVO, String file1, String file2) throws Exception {
		System.out.println("����/������ǰ ��� ����--"+eventVO);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.insert(namespace+".eventWrite", map);
	}
	
	//�̺�Ʈ ��ȸ
	@Override
	public List<EventVO> eventList() throws Exception {
		System.out.println("����/������ǰ ����Ʈ ����----------------");
		List list = sql.selectList(namespace+".eventList");
		return list;
	}

	//�̺�Ʈ ������ ��ȸ
	@Override
	public EventVO eventDetail(int np) throws Exception {
		EventVO eventVO = sql.selectOne(namespace+".eventDetail", np);
		return eventVO;
	}
	
	//����/���� ����1
	@Override
	public void eventModify1(EventVO eventVO, String file1, String file2) throws Exception {
		System.out.println("mapper file2="+file2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".eventModify1", map);
	}
				
	//����/���� ����2
	@Override
	public void eventModify2(EventVO eventVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".eventModify2", map);
	}
					
	//����/���� ����3
	@Override
	public void eventModify3(EventVO eventVO, String file1, String file2) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		map.put("file1", file1);
		map.put("file2", file2);
		sql.update(namespace+".eventModify3", map);
	}
				
	//����/���� ����4
	@Override
	public void eventModify4(EventVO eventVO) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("eventVO", eventVO);
		sql.update(namespace+".eventModify4", map);
	}
				
	//����/���� ����
	@Override
	public void eventDelete(int np) throws Exception {
		sql.delete(namespace+".eventDelete", np);
	}
	
}

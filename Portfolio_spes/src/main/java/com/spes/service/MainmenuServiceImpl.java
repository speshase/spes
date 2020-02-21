package com.spes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spes.mapper.MainmenuMapper;
import com.spes.model.BestVO;
import com.spes.model.CouponVO;
import com.spes.model.EventVO;
import com.spes.model.NewVO;

@Service
public class MainmenuServiceImpl implements MainmenuService{
	
	@Autowired
	MainmenuMapper mm;
	
	/* ��ü��ǰ ��ȸ */
	public List<NewVO> allmenu() throws Exception {
		return mm.allmenu();
	}

	/* �Ż�ǰ */
	//�Ż�ǰ ���
	@Override
	public void newWrite(NewVO newVO, String file1, String file2) throws Exception {
		mm.newWrite(newVO, file1, file2);
	}
	
	//�Ż�ǰ ��ȸ
	@Override
	public List<NewVO> newpageList() throws Exception {
		System.out.println("Service mm.newpageList() : "+mm.newpageList());
		return mm.newpageList();
	}
	
	//�Ż�ǰ ������ ��ȸ
	@Override
	public NewVO newDetail(int np) throws Exception {
		return mm.newDetail(np);
	}

	//�Ż�ǰ ����1
	@Override
	public void newModify1(NewVO newVO, String file1, String file2) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+newVO);
		System.out.println("service file2="+file2);
		mm.newModify1(newVO, file1, file2);
	}
	
	//�Ż�ǰ ����2
	@Override
	public void newModify2(NewVO newVO, String file1, String file2) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+newVO);
		mm.newModify2(newVO, file1, file2);
	}
		
	//�Ż�ǰ ����3
	@Override
	public void newModify3(NewVO newVO, String file1, String file2) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+newVO);
		mm.newModify3(newVO, file1, file2);
	}
	
	//�Ż�ǰ ����4
	@Override
	public void newModify4(NewVO newVO) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+newVO);
		mm.newModify4(newVO);
	}

	//�Ż�ǰ ����
	@Override
	public void newDelete(int np) throws Exception {
		mm.newDelete(np);
	}
	
	
	/* �α��ǰ */
	//�α��ǰ ���
	@Override
	public void bestWrite(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("�α��ǰ ��� ����--"+bestVO);
		mm.bestWrite(bestVO, file1, file2);
	}
	
	//�α��ǰ ��ȸ
	@Override
	public List<BestVO> bestpageList() throws Exception {
		System.out.println("�α��ǰ ����Ʈ ����------------------");
		System.out.println("Service mm.bestpageList() : "+mm.bestpageList());
		return mm.bestpageList();
	}

	//�α��ǰ ������ ��ȸ
	@Override
	public BestVO bestDetail(int np) throws Exception {
		return mm.bestDetail(np);
	}
	
	//�Ż�ǰ ����1
	@Override
	public void bestModify1(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+bestVO);
		System.out.println("service file2="+file2);
		mm.bestModify1(bestVO, file1, file2);
	}
		
	//�Ż�ǰ ����2
	@Override
	public void bestModify2(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+bestVO);
		mm.bestModify2(bestVO, file1, file2);
	}
			
	//�Ż�ǰ ����3
	@Override
	public void bestModify3(BestVO bestVO, String file1, String file2) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+bestVO);
		mm.bestModify3(bestVO, file1, file2);
	}
		
	//�Ż�ǰ ����4
	@Override
	public void bestModify4(BestVO bestVO) throws Exception {
		System.out.println("�Ż�ǰ ���� Service Impl : "+bestVO);
		mm.bestModify4(bestVO);
	}

	//�Ż�ǰ ����
	@Override
	public void bestDelete(int np) throws Exception {
		mm.bestDelete(np);
	}

	
	/* ����/���� */
	//����/���� ���
	@Override
	public void couponWrite(CouponVO couponVO, String file1, String file2) throws Exception {
		System.out.println("����/������ǰ ��� ����--"+couponVO);
		mm.couponWrite(couponVO, file1, file2);
		
	}

	//����/���� ��ȸ
	@Override
	public List<CouponVO> couponList() throws Exception {
		System.out.println("����/���� ��ǰ ����Ʈ ����------------------");
		System.out.println("Service mm.couponList() : "+mm.couponList());
		return mm.couponList();
	}

	//����/���� ������ ��ȸ
	@Override
	public CouponVO couponDetail(int np) throws Exception {
		return mm.couponDetail(np);
	}
	
	//�Ż�ǰ ����1
	@Override
	public void couponModify1(CouponVO couponVO, String file1, String file2) throws Exception {
		mm.couponModify1(couponVO, file1, file2);
	}
			
	//�Ż�ǰ ����2
	@Override
	public void couponModify2(CouponVO couponVO, String file1, String file2) throws Exception {
		mm.couponModify2(couponVO, file1, file2);
	}
				
	//�Ż�ǰ ����3
	@Override
	public void couponModify3(CouponVO couponVO, String file1, String file2) throws Exception {
		mm.couponModify3(couponVO, file1, file2);
	}
			
	//�Ż�ǰ ����4
	@Override
	public void couponModify4(CouponVO couponVO) throws Exception {
		mm.couponModify4(couponVO);
	}

	//�Ż�ǰ ����
	@Override
	public void couponDelete(int np) throws Exception {
		mm.couponDelete(np);
	}
	
	
	/* �̺�Ʈ */
	//����/���� ���
	@Override
	public void eventWrite(EventVO eventVO, String file1, String file2) throws Exception {
		mm.eventWrite(eventVO, file1, file2);
		
	}

	//����/���� ��ȸ
	@Override
	public List<EventVO> eventList() throws Exception {
		return mm.eventList();
	}

	//����/���� ������ ��ȸ
	@Override
	public EventVO eventDetail(int np) throws Exception {
		return mm.eventDetail(np);
	}
	
	//�Ż�ǰ ����1
	@Override
	public void eventModify1(EventVO eventVO, String file1, String file2) throws Exception {
		mm.eventModify1(eventVO, file1, file2);
	}
				
	//�Ż�ǰ ����2
	@Override
	public void eventModify2(EventVO eventVO, String file1, String file2) throws Exception {
		mm.eventModify2(eventVO, file1, file2);
	}
					
	//�Ż�ǰ ����3
	@Override
	public void eventModify3(EventVO eventVO, String file1, String file2) throws Exception {
		mm.eventModify3(eventVO, file1, file2);
	}
				
	//�Ż�ǰ ����4
	@Override
	public void eventModify4(EventVO eventVO) throws Exception {
		mm.eventModify4(eventVO);
	}

	//�Ż�ǰ ����
	@Override
	public void eventDelete(int np) throws Exception {
		mm.eventDelete(np);
	}
	

}

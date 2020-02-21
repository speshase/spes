package com.spes.service;

import java.util.List;

import com.spes.model.BestVO;
import com.spes.model.CouponVO;
import com.spes.model.Criteria;
import com.spes.model.EventVO;
import com.spes.model.NewVO;

public interface MainmenuService {
	
	/* ��ü��ǰ ��ȸ */
	public List<NewVO> allmenu() throws Exception;
	
	
	/* �Ż�ǰ */
	//�Ż�ǰ ���
	public void newWrite(NewVO newVO, String file1, String file2) throws Exception;
	
	//�Ż�ǰ ��ȸ
	public List<NewVO> newpageList() throws Exception;
	
	//�Ż�ǰ ������ ��ȸ
	public NewVO newDetail(int np) throws Exception;
	
	//�Ż�ǰ ����1
	public void newModify1(NewVO newVO, String file1, String file2) throws Exception;
	
	//�Ż�ǰ ����2
	public void newModify2(NewVO newVO, String file1, String file2) throws Exception;
	
	//�Ż�ǰ ����3
	public void newModify3(NewVO newVO, String file1, String file2) throws Exception;
	
	//�Ż�ǰ ����4
	public void newModify4(NewVO newVO) throws Exception;
	
	//�Ż�ǰ ����
	public void newDelete(int np) throws Exception;
	
	
	/* �α��ǰ */
	//�α��ǰ ���
	public void bestWrite(BestVO bestVO, String file1, String file2) throws Exception;
	
	//�α��ǰ ��ȸ
	public List<BestVO> bestpageList() throws Exception;
	
	//�α��ǰ ������ ��ȸ
	public BestVO bestDetail(int np) throws Exception;
	
	//�α��ǰ ����1
	public void bestModify1(BestVO bestVO, String file1, String file2) throws Exception;
			
	//�α��ǰ ����2
	public void bestModify2(BestVO bestVO, String file1, String file2) throws Exception;
				
	//�α��ǰ ����3
	public void bestModify3(BestVO bestVO, String file1, String file2) throws Exception;
			
	//�α��ǰ ����4
	public void bestModify4(BestVO bestVO) throws Exception;
			
	//�α��ǰ ����
	public void bestDelete(int np) throws Exception;
	
	
	/* ����/���� */
	//����/���� ���
	public void couponWrite(CouponVO couponVO, String file1, String file2) throws Exception;

	//����/���� ��ȸ
	public List<CouponVO> couponList() throws Exception;
	
	//����/���� ������ ��ȸ
	public CouponVO couponDetail(int np) throws Exception;
	
	//����/���� ����1
	public void couponModify1(CouponVO couponVO, String file1, String file2) throws Exception;
			
	//����/���� ����2
	public void couponModify2(CouponVO couponVO, String file1, String file2) throws Exception;
				
	//����/���� ����3
	public void couponModify3(CouponVO couponVO, String file1, String file2) throws Exception;
			
	//����/���� ����4
	public void couponModify4(CouponVO couponVO) throws Exception;
			
	//����/���� ����
	public void couponDelete(int np) throws Exception;
	
	
	/* �̺�Ʈ */
	//����/���� ���
	public void eventWrite(EventVO eventVO, String file1, String file2) throws Exception;

	//����/���� ��ȸ
	public List<EventVO> eventList() throws Exception;
	
	//����/���� ������ ��ȸ
	public EventVO eventDetail(int np) throws Exception;
	
	//�̺�Ʈ ����1
	public void eventModify1(EventVO eventVO, String file1, String file2) throws Exception;
				
	//�̺�Ʈ ����2
	public void eventModify2(EventVO eventVO, String file1, String file2) throws Exception;
					
	//�̺�Ʈ ����3
	public void eventModify3(EventVO eventVO, String file1, String file2) throws Exception;
				
	//�̺�Ʈ ����4
	public void eventModify4(EventVO eventVO) throws Exception;
				
	//�̺�Ʈ ����
	public void eventDelete(int np) throws Exception;
	
	
	
}

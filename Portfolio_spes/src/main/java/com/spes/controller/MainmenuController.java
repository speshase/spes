package com.spes.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spes.model.BestVO;
import com.spes.model.CouponVO;
import com.spes.model.EventVO;
import com.spes.model.NewVO;
import com.spes.service.MainmenuService;
import com.spes.util.UploadFileUtils;

@Controller
@RequestMapping("/mainMenu")
public class MainmenuController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private MainmenuService newService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//��ü��ǰ ��ȸ
	@RequestMapping(value="allmenu", method = RequestMethod.GET)
	public void allmenu(Model model) throws Exception {
		logger.info("-----> mainManu/allmenu.jsp");
		model.addAttribute("allmenu", newService.allmenu());
		}

	/* �Ż�ǰ */
	//�Ż�ǰ ��� �������̵�
	@RequestMapping(value="/newWrite", method = RequestMethod.GET)
	public String newWrite() throws Exception {
		logger.info("-----> mainManu/newWrite.jsp");
		return "/mainMenu/newWrite";
	}
	
	//�Ż�ǰ ��� -> ��ϿϷ�
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String newPOST(NewVO newVO, Model model) throws Exception {
		System.out.println("-----> �� ��� �Ϸ� mainManu/newPOST Controller");
		System.out.println("newVO : "+newVO);

		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
		
		String file1 = newVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = newVO.getFile2().getOriginalFilename(); //���� ��ü �̸�

		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+newVO.getFile1().getOriginalFilename());
		System.out.println("------------------ file2 size : "+newVO.getFile1().getSize());
		
		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+newVO.getFile2().getOriginalFilename());
		System.out.println("------------------ file2 size : "+newVO.getFile2().getSize());

		if(!newVO.getFile1().getOriginalFilename().equals("")
				&& !newVO.getFile1().getOriginalFilename().equals(null)) {
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile1().getOriginalFilename(), newVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			
		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		if(!newVO.getFile2().getOriginalFilename().equals("")
				&& !newVO.getFile2().getOriginalFilename().equals(null)) {
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile2().getOriginalFilename(), newVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
		newService.newWrite(newVO, file1, file2);
		
		return "redirect:new";
	}

	//�Ż�ǰ ��ȸ(���� ! - DB select)
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newpageList(Model model) throws Exception {
		logger.info("-----> mainManu/new.jsp");
		System.out.println("......."+newService.newpageList());
		model.addAttribute("newProduction", newService.newpageList());
		return "/mainMenu/new";
	}
	
	//�Ż�ǰ ������
	@RequestMapping(value="/newDetail", method = RequestMethod.GET)
	public String newDetail(NewVO newVO, Model model) throws Exception {
		System.out.println("-----> �� ������ NewVO : "+newVO);
		model.addAttribute("detail",newService.newDetail(newVO.getNp()));
		return "/mainMenu/newDetail";
		}
	
	//�Ż�ǰ ����
	@RequestMapping(value="/newModify", method = RequestMethod.GET)
	public void newModify(NewVO newVO, Model model) throws Exception {
		//rttr.addAttribute("sfile1", newVO.getSfile1());
		//rttr.addAttribute("sfile2", newVO.getSfile2());
		
		model.addAttribute("modify",newService.newDetail(newVO.getNp()));
		//return "redirect:newModifyPOST";
	}
	
	//�Ż�ǰ ����
	@RequestMapping(value="/newModify", method = RequestMethod.POST)
	public String newModifyPOST(NewVO newVO, Model model) throws Exception {
		System.out.println("�� ���� �Ϸ� -----------------> ");
		System.out.println("newVO="+newVO);
		
		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
		
		String file1 = newVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = newVO.getFile2().getOriginalFilename(); //���� ��ü �̸�
		
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
		
		
		// file1�� null�̰�, file2�� null�� �ƴϸ�(and)
		if(file1.equals("") && !file2.equals("")){
			System.out.println("sql file1 yes null, file2 not null");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile2().getOriginalFilename(), newVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
			newService.newModify1(newVO, file1, file2);
		}
		
		// file2�� null�̸�, file1�� null�� �ƴϸ� (and)
		else if(!file1.equals("") && file2.equals("")){
			System.out.println("sql file1 not null, file2 yes null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile1().getOriginalFilename(), newVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');			
			newService.newModify2(newVO, file1, file2);
		}	
		
		// file1�� file2�� null�� �ƴϸ�(and),
		else if(!file1.equals("") && !file2.equals("")) {
			System.out.println("sql file1 not null, file2 not null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile1().getOriginalFilename(), newVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile2().getOriginalFilename(), newVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
					
			newService.newModify3(newVO, file1, file2);
		}
		
		// file1�� file2�� null�̸� (and)
		else {
			System.out.println("sql file1 ues null, file2 yes null");
			newService.newModify4(newVO);
		}
		
		if(!newVO.getFile1().getOriginalFilename().equals("")
				&& !newVO.getFile1().getOriginalFilename().equals(null)) {
			System.out.println("aaaaaa");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile1().getOriginalFilename(), newVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			
		} else {
			System.out.println("bbbbbb");
		}
		
		if(!newVO.getFile2().getOriginalFilename().equals("")
				&& !newVO.getFile2().getOriginalFilename().equals(null)) {
			System.out.println("cccccc");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile2().getOriginalFilename(), newVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
			System.out.println("dddddd");
		}
		
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
		
		return "redirect:newDetail?np="+newVO.getNp();
	}
	
	//�Ż�ǰ ����
	@RequestMapping(value="/newDelete", method = RequestMethod.GET)
	public String newDelete(int np, Model model) throws Exception {
		logger.info("-----> �� ���� �Ϸ� mainManu/newDelete Controller" + np);
		newService.newDelete(np);
		return "redirect:new";
	}

	

	/* �α��ǰ */
	
	//�α��ǰ ��� �������̵�
	@RequestMapping(value="/bestWrite", method = RequestMethod.GET)
	public String bestWrite() throws Exception {
		logger.info("-----> mainManu/bestWrite.jsp");
		return "/mainMenu/bestWrite";
	}
	
	//�α��ǰ ��� -> ��ϿϷ�
	@RequestMapping(value="/best", method = RequestMethod.POST)
	public String bestPOST(BestVO bestVO, Model model) throws Exception {
	System.out.println("-----> �� ��� �Ϸ� mainManu/bestPOST Controller");
	System.out.println("newVO : "+bestVO);

		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
		
		String file1 = bestVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = bestVO.getFile2().getOriginalFilename(); //���� ��ü �̸�

		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+bestVO.getFile1().getOriginalFilename());
		System.out.println("------------------ file2 size : "+bestVO.getFile1().getSize());
		
		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+bestVO.getFile2().getOriginalFilename());
		System.out.println("------------------ file2 size : "+bestVO.getFile2().getSize());

		if(!bestVO.getFile1().getOriginalFilename().equals("") && !bestVO.getFile1().getOriginalFilename().equals(null)) {
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile1().getOriginalFilename(), bestVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			
		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		if(!bestVO.getFile2().getOriginalFilename().equals("") && !bestVO.getFile2().getOriginalFilename().equals(null)) {
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile2().getOriginalFilename(), bestVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
		newService.bestWrite(bestVO, file1, file2);
		
		return "redirect:best";
	}
	
	//�α��ǰ ��ȸ(���� ! - DB select)
	@RequestMapping(value="/best", method = RequestMethod.GET)
	public String bestpageList(Model model) throws Exception {
		logger.info("-----> mainManu/bestpageList.jsp");
		System.out.println("......."+newService.bestpageList());
		model.addAttribute("bestProduction", newService.bestpageList());
		return "/mainMenu/best";
	}
	
	//�α��ǰ ������
	@RequestMapping(value="/bestDetail", method = RequestMethod.GET)
	public String bestDetail(BestVO bestVO, Model model) throws Exception {
		System.out.println("-----> �� ������ NewVO : "+bestVO);
		model.addAttribute("detail",newService.bestDetail(bestVO.getNp()));
		return "/mainMenu/bestDetail";
	}
	
	//�α��ǰ ����
	@RequestMapping(value="/bestModify", method = RequestMethod.GET)
	public void bestModify(BestVO bestVO, Model model) throws Exception {
		model.addAttribute("modify",newService.bestDetail(bestVO.getNp()));
	}
	
	//�α��ǰ ����
	@RequestMapping(value="/bestModify", method = RequestMethod.POST)
	public String bestModifyPOST(BestVO bestVO, Model model) throws Exception {
		System.out.println("�� ���� �Ϸ� -----------------> ");
		System.out.println("bestVO="+bestVO);
			
		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
			
		String file1 = bestVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = bestVO.getFile2().getOriginalFilename(); //���� ��ü �̸�
		
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
			
			
			// file1�� null�̰�, file2�� null�� �ƴϸ�(and)
			if(file1.equals("") && !file2.equals("")){
				System.out.println("sql file1 yes null, file2 not null");
				file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile2().getOriginalFilename(), bestVO.getFile2().getBytes(), ymdPath);
				file2 = file2.replace('\\', '/');
				newService.bestModify1(bestVO, file1, file2);
			}
			
			// file2�� null�̸�, file1�� null�� �ƴϸ� (and)
			else if(!file1.equals("") && file2.equals("")){
				System.out.println("sql file1 not null, file2 yes null");
				file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile1().getOriginalFilename(), bestVO.getFile1().getBytes(), ymdPath);
				file1 = file1.replace('\\', '/');			
				newService.bestModify2(bestVO, file1, file2);
			}	
			
			// file1�� file2�� null�� �ƴϸ�(and),
			else if(!file1.equals("") && !file2.equals("")) {
				System.out.println("sql file1 not null, file2 not null");
				file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile1().getOriginalFilename(), bestVO.getFile1().getBytes(), ymdPath);
				file1 = file1.replace('\\', '/');
				file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile2().getOriginalFilename(), bestVO.getFile2().getBytes(), ymdPath);
				file2 = file2.replace('\\', '/');
						
				newService.bestModify3(bestVO, file1, file2);
			}
			
			// file1�� file2�� null�̸� (and)
			else {
				System.out.println("sql file1 ues null, file2 yes null");
				newService.bestModify4(bestVO);
			}
			
			if(!bestVO.getFile1().getOriginalFilename().equals("") && !bestVO.getFile1().getOriginalFilename().equals(null)) {
				System.out.println("aaaaaa");
				file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile1().getOriginalFilename(), bestVO.getFile1().getBytes(), ymdPath);
				file1 = file1.replace('\\', '/');
				
			} else {
				System.out.println("bbbbbb");
			}
			
			if(!bestVO.getFile2().getOriginalFilename().equals("") && !bestVO.getFile2().getOriginalFilename().equals(null)) {
				System.out.println("cccccc");
				file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile2().getOriginalFilename(), bestVO.getFile2().getBytes(), ymdPath);
				file2 = file2.replace('\\', '/');

			} else {
				System.out.println("dddddd");
			}
			
			System.out.println("file1####### : "+file1);
			System.out.println("file2####### : "+file2);
			
			return "redirect:bestDetail?np="+bestVO.getNp();
		}
		
		//�α��ǰ ����
		@RequestMapping(value="/bestDelete", method = RequestMethod.GET)
		public String bestDelete(int np, Model model) throws Exception {
			logger.info("-----> �� ���� �Ϸ� mainManu/bestDelete Controller" + np);
			newService.bestDelete(np);
			return "redirect:best";
		}
		
	
	/* ����/���� */
		
	//����/������ǰ ��� �������̵�
	@RequestMapping(value="/couponWrite", method = RequestMethod.GET)
	public String couponWrite() throws Exception {
		logger.info("-----> mainManu/couponWrite.jsp");
		return "/mainMenu/couponWrite";
	} 
	
	//����/������ǰ ��� -> ��ϿϷ�
	@RequestMapping(value="/coupon", method = RequestMethod.POST)
	public String couponPOST(CouponVO couponVO, Model model) throws Exception {
		System.out.println("-----> �� ��� �Ϸ� mainManu/couponPOST Controller");
		System.out.println("couponVO : "+couponVO);

		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
			
		String file1 = couponVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = couponVO.getFile2().getOriginalFilename(); //���� ��ü �̸�

		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+couponVO.getFile1().getOriginalFilename());
		System.out.println("------------------ file2 size : "+couponVO.getFile1().getSize());
			
		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+couponVO.getFile2().getOriginalFilename());
		System.out.println("------------------ file2 size : "+couponVO.getFile2().getSize());

		if(!couponVO.getFile1().getOriginalFilename().equals("") && !couponVO.getFile1().getOriginalFilename().equals(null)) {
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile1().getOriginalFilename(), couponVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
				
		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
			
		if(!couponVO.getFile2().getOriginalFilename().equals("") && !couponVO.getFile2().getOriginalFilename().equals(null)) {
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile2().getOriginalFilename(), couponVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
			
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
		newService.couponWrite(couponVO, file1, file2);
			
		return "redirect:coupon";
	}

	//����/������ǰ ��ȸ(���� ! - DB select)
	@RequestMapping(value="/coupon", method = RequestMethod.GET)
	public String couponList(Model model) throws Exception {
		logger.info("-----> mainManu/coupon.jsp");
		System.out.println("......."+newService.couponList());
		model.addAttribute("couponProduction", newService.couponList());
		return "/mainMenu/coupon";
	}
	
	//����/������ǰ ������
	@RequestMapping(value="/couponDetail", method = RequestMethod.GET)
	public String couponDetail(CouponVO couponVO, Model model) throws Exception {
		System.out.println("-----> �� ������ couponVO : "+couponVO);
		model.addAttribute("detail",newService.couponDetail(couponVO.getNp()));
		return "/mainMenu/couponDetail";
	}
	
	//����/������ǰ ����
	@RequestMapping(value="/couponModify", method = RequestMethod.GET)
	public void couponModify(CouponVO couponVO, Model model) throws Exception {
		model.addAttribute("modify",newService.couponDetail(couponVO.getNp()));
	}
	
	//�α��ǰ ����
	@RequestMapping(value="/couponModify", method = RequestMethod.POST)
	public String couponModifyPOST(CouponVO couponVO, Model model) throws Exception {
		System.out.println("�� ���� �Ϸ� -----------------> ");
		System.out.println("couponVO="+couponVO);
				
		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
				
		String file1 = couponVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = couponVO.getFile2().getOriginalFilename(); //���� ��ü �̸�
			
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
				
				
		// file1�� null�̰�, file2�� null�� �ƴϸ�(and)
		if(file1.equals("") && !file2.equals("")){
			System.out.println("sql file1 yes null, file2 not null");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile2().getOriginalFilename(), couponVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
			newService.couponModify1(couponVO, file1, file2);
		}
				
		// file2�� null�̸�, file1�� null�� �ƴϸ� (and)
		else if(!file1.equals("") && file2.equals("")){
			System.out.println("sql file1 not null, file2 yes null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile1().getOriginalFilename(), couponVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');			
			newService.couponModify2(couponVO, file1, file2);
		}	
				
		// file1�� file2�� null�� �ƴϸ�(and),
		else if(!file1.equals("") && !file2.equals("")) {
			System.out.println("sql file1 not null, file2 not null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile1().getOriginalFilename(), couponVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile2().getOriginalFilename(), couponVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
							
			newService.couponModify3(couponVO, file1, file2);
		}
			
		// file1�� file2�� null�̸� (and)
		else {
			System.out.println("sql file1 ues null, file2 yes null");
			newService.couponModify4(couponVO);
		}
				
		if(!couponVO.getFile1().getOriginalFilename().equals("") && !couponVO.getFile1().getOriginalFilename().equals(null)) {
			System.out.println("aaaaaa");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile1().getOriginalFilename(), couponVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
					
		} else {
			System.out.println("bbbbbb");
		}
				
		if(!couponVO.getFile2().getOriginalFilename().equals("") && !couponVO.getFile2().getOriginalFilename().equals(null)) {
			System.out.println("cccccc");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile2().getOriginalFilename(), couponVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
			System.out.println("dddddd");
		}
				
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
				
		return "redirect:couponDetail?np="+couponVO.getNp();
		}
			
	//�α��ǰ ����
	@RequestMapping(value="/couponDelete", method = RequestMethod.GET)
	public String couponDelete(int np, Model model) throws Exception {
		logger.info("-----> �� ���� �Ϸ� mainManu/couponDelete Controller" + np);
		newService.couponDelete(np);
		return "redirect:coupon";
	}
	
	

	/* �̺�Ʈ */
	//�̺�Ʈ ��� �������̵�
	@RequestMapping(value="/eventWrite", method = RequestMethod.GET)
	public String eventWrite() throws Exception {
		logger.info("-----> mainManu/eventWrite.jsp");
		return "/mainMenu/eventWrite";
	}
	
	//�̺�Ʈ ���
	//�̺�Ʈ ��� -> ��ϿϷ�
	@RequestMapping(value="/event", method = RequestMethod.POST)
	public String eventPOST(EventVO eventVO, Model model) throws Exception {
		System.out.println("-----> �� ��� �Ϸ� mainManu/newPOST Controller");
		System.out.println("eventVO : "+eventVO);

		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
			
		String file1 = eventVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = eventVO.getFile2().getOriginalFilename(); //���� ��ü �̸�

		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+eventVO.getFile1().getOriginalFilename());
		System.out.println("------------------ file2 size : "+eventVO.getFile1().getSize());
			
		System.out.println("------------------ imgUploadPath : "+imgUploadPath);
		System.out.println("------------------ ymdPath : "+ymdPath);
		System.out.println("------------------ file1 : "+eventVO.getFile2().getOriginalFilename());
		System.out.println("------------------ file2 size : "+eventVO.getFile2().getSize());

		if(!eventVO.getFile1().getOriginalFilename().equals("") && !eventVO.getFile1().getOriginalFilename().equals(null)) {
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile1().getOriginalFilename(), eventVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			
		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
			
		if(!eventVO.getFile2().getOriginalFilename().equals("") && !eventVO.getFile2().getOriginalFilename().equals(null)) {
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile2().getOriginalFilename(), eventVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
		 //fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
			
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
		newService.eventWrite(eventVO, file1, file2);
			
		return "redirect:event";
	}
	
	//�̺�Ʈ ��ȸ(���� ! - DB select)
	@RequestMapping(value="/event", method = RequestMethod.GET)
	public String eventList(Model model) throws Exception {
		logger.info("-----> mainManu/event.jsp");
		System.out.println("......."+newService.eventList());
		model.addAttribute("eventProduction", newService.eventList());
		return "/mainMenu/event";
	}
		
	//�̺�Ʈ ������
	@RequestMapping(value="/eventDetail", method = RequestMethod.GET)
	public String eventDetail(EventVO eventVO, Model model) throws Exception {
		System.out.println("-----> �� ������ eventVO : "+eventVO);
		model.addAttribute("detail",newService.eventDetail(eventVO.getNp()));
		return "/mainMenu/eventDetail";
	}
	
	//�̺�Ʈ ���� ������ �̵�
	@RequestMapping(value="/eventModify", method = RequestMethod.GET)
	public void eventModify(EventVO eventVO, Model model) throws Exception {
		model.addAttribute("modify",newService.eventDetail(eventVO.getNp()));
	}
	
	//�α��ǰ ����
	@RequestMapping(value="/eventModify", method = RequestMethod.POST)
	public String eventModifyPOST(EventVO eventVO, Model model) throws Exception {
		System.out.println("�� ���� �Ϸ� -----------------> ");
		System.out.println("eventVO="+eventVO);
					
		String imgUploadPath = uploadPath + File.separator; //�̹��� ���ε� �����
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //�⵵
					
		String file1 = eventVO.getFile1().getOriginalFilename(); //���� ��ü �̸�
		String file2 = eventVO.getFile2().getOriginalFilename(); //���� ��ü �̸�
				
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
					
					
		// file1�� null�̰�, file2�� null�� �ƴϸ�(and)
		if(file1.equals("") && !file2.equals("")){
			System.out.println("sql file1 yes null, file2 not null");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile2().getOriginalFilename(), eventVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
			newService.eventModify1(eventVO, file1, file2);
		}
					
		// file2�� null�̸�, file1�� null�� �ƴϸ� (and)
		else if(!file1.equals("") && file2.equals("")){
			System.out.println("sql file1 not null, file2 yes null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile1().getOriginalFilename(), eventVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');			
			newService.eventModify2(eventVO, file1, file2);
		}	
					
		// file1�� file2�� null�� �ƴϸ�(and),
		else if(!file1.equals("") && !file2.equals("")) {
			System.out.println("sql file1 not null, file2 not null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile1().getOriginalFilename(), eventVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile2().getOriginalFilename(), eventVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
								
			newService.eventModify3(eventVO, file1, file2);
		}
				
		// file1�� file2�� null�̸� (and)
		else {
			System.out.println("sql file1 ues null, file2 yes null");
			newService.eventModify4(eventVO);
		}
					
		if(!eventVO.getFile1().getOriginalFilename().equals("") && !eventVO.getFile1().getOriginalFilename().equals(null)) {
			System.out.println("aaaaaa");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile1().getOriginalFilename(), eventVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
						
		} else {
			System.out.println("bbbbbb");
		}
					
		if(!eventVO.getFile2().getOriginalFilename().equals("") && !eventVO.getFile2().getOriginalFilename().equals(null)) {
			System.out.println("cccccc");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile2().getOriginalFilename(), eventVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');

		} else {
			System.out.println("dddddd");
		}
					
		System.out.println("file1####### : "+file1);
		System.out.println("file2####### : "+file2);
					
		return "redirect:eventDetail?np="+eventVO.getNp();
		}
				
		//�α��ǰ ����
		@RequestMapping(value="/eventDelete", method = RequestMethod.GET)
		public String eventDelete(int np, Model model) throws Exception {
			logger.info("-----> �� ���� �Ϸ� mainManu/eventDelete Controller" + np);
			newService.eventDelete(np);
			return "redirect:event";
		}
	
	
	
	/* display */
	
	@RequestMapping("/display") @ResponseBody public ResponseEntity<byte[]> getFile(String sfile1, String bfile1, String cfile1, String efile1){
		File file1 = new File("E:\\JAVA_GREEN\\upload\\portfolio_spes\\new\\"+sfile1);
		File file2 = new File("E:\\JAVA_GREEN\\upload\\portfolio_spes\\new\\"+bfile1);
		File file3 = new File("E:\\JAVA_GREEN\\upload\\portfolio_spes\\new\\"+cfile1);
		File file4 = new File("E:\\JAVA_GREEN\\upload\\portfolio_spes\\new\\"+efile1);
		
		System.out.println("sfile1!#!@#!@#!@#!@#!@#!@ : " + sfile1);
		System.out.println("bfile1!#!@#!@#!@#!@#!@#!@ : " + bfile1);
		System.out.println("cfile1!#!@#!@#!@#!@#!@#!@ : " + cfile1);
		System.out.println("efile1!#!@#!@#!@#!@#!@#!@ : " + efile1);
		
		ResponseEntity<byte[]> result = null;
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file1.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file1), header, HttpStatus.OK);
			}catch(IOException e) {   e.printStackTrace();  }
			
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file2.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file2), header, HttpStatus.OK);
			}catch(IOException e) {   e.printStackTrace();  }
			
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file3.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file3), header, HttpStatus.OK);
			}catch(IOException e) {   e.printStackTrace();  }
			
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file3.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file4), header, HttpStatus.OK);
			}catch(IOException e) {   e.printStackTrace();  }
		
			return result;
	}
	
	

}

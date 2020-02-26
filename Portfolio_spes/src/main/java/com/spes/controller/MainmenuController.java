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
	
	//전체상품 조회
	@RequestMapping(value="allmenu", method = RequestMethod.GET)
	public void allmenu(Model model) throws Exception {
		logger.info("-----> mainManu/allmenu.jsp");
		model.addAttribute("allmenu", newService.allmenu());
		}

	/* 신상품 */
	//신상품 등록 페이지이동
	@RequestMapping(value="/newWrite", method = RequestMethod.GET)
	public String newWrite() throws Exception {
		logger.info("-----> mainManu/newWrite.jsp");
		return "/mainMenu/newWrite";
	}
	
	//신상품 등록 -> 등록완료
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String newPOST(NewVO newVO, Model model) throws Exception {
		System.out.println("-----> 글 등록 완료 mainManu/newPOST Controller");
		System.out.println("newVO : "+newVO);

		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
		
		String file1 = newVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = newVO.getFile2().getOriginalFilename(); //파일 전체 이름

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

	//신상품 조회(메인 ! - DB select)
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newpageList(Model model) throws Exception {
		logger.info("-----> mainManu/new.jsp");
		System.out.println("......."+newService.newpageList());
		model.addAttribute("newProduction", newService.newpageList());
		return "/mainMenu/new";
	}
	
	//신상품 디테일
	@RequestMapping(value="/newDetail", method = RequestMethod.GET)
	public String newDetail(NewVO newVO, Model model) throws Exception {
		System.out.println("-----> 글 디테일 NewVO : "+newVO);
		model.addAttribute("detail",newService.newDetail(newVO.getNp()));
		return "/mainMenu/newDetail";
		}
	
	//신상품 수정
	@RequestMapping(value="/newModify", method = RequestMethod.GET)
	public void newModify(NewVO newVO, Model model) throws Exception {
		//rttr.addAttribute("sfile1", newVO.getSfile1());
		//rttr.addAttribute("sfile2", newVO.getSfile2());
		
		model.addAttribute("modify",newService.newDetail(newVO.getNp()));
		//return "redirect:newModifyPOST";
	}
	
	//신상품 수정
	@RequestMapping(value="/newModify", method = RequestMethod.POST)
	public String newModifyPOST(NewVO newVO, Model model) throws Exception {
		System.out.println("글 수정 완료 -----------------> ");
		System.out.println("newVO="+newVO);
		
		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
		
		String file1 = newVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = newVO.getFile2().getOriginalFilename(); //파일 전체 이름
		
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
		
		
		// file1이 null이고, file2가 null이 아니면(and)
		if(file1.equals("") && !file2.equals("")){
			System.out.println("sql file1 yes null, file2 not null");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile2().getOriginalFilename(), newVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
			newService.newModify1(newVO, file1, file2);
		}
		
		// file2가 null이면, file1이 null이 아니면 (and)
		else if(!file1.equals("") && file2.equals("")){
			System.out.println("sql file1 not null, file2 yes null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath,
					newVO.getFile1().getOriginalFilename(), newVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');			
			newService.newModify2(newVO, file1, file2);
		}	
		
		// file1과 file2가 null이 아니면(and),
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
		
		// file1과 file2가 null이면 (and)
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
	
	//신상품 삭제
	@RequestMapping(value="/newDelete", method = RequestMethod.GET)
	public String newDelete(int np, Model model) throws Exception {
		logger.info("-----> 글 삭제 완료 mainManu/newDelete Controller" + np);
		newService.newDelete(np);
		return "redirect:new";
	}

	

	/* 인기상품 */
	
	//인기상품 등록 페이지이동
	@RequestMapping(value="/bestWrite", method = RequestMethod.GET)
	public String bestWrite() throws Exception {
		logger.info("-----> mainManu/bestWrite.jsp");
		return "/mainMenu/bestWrite";
	}
	
	//인기상품 등록 -> 등록완료
	@RequestMapping(value="/best", method = RequestMethod.POST)
	public String bestPOST(BestVO bestVO, Model model) throws Exception {
	System.out.println("-----> 글 등록 완료 mainManu/bestPOST Controller");
	System.out.println("newVO : "+bestVO);

		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
		
		String file1 = bestVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = bestVO.getFile2().getOriginalFilename(); //파일 전체 이름

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
	
	//인기상품 조회(메인 ! - DB select)
	@RequestMapping(value="/best", method = RequestMethod.GET)
	public String bestpageList(Model model) throws Exception {
		logger.info("-----> mainManu/bestpageList.jsp");
		System.out.println("......."+newService.bestpageList());
		model.addAttribute("bestProduction", newService.bestpageList());
		return "/mainMenu/best";
	}
	
	//인기상품 디테일
	@RequestMapping(value="/bestDetail", method = RequestMethod.GET)
	public String bestDetail(BestVO bestVO, Model model) throws Exception {
		System.out.println("-----> 글 디테일 NewVO : "+bestVO);
		model.addAttribute("detail",newService.bestDetail(bestVO.getNp()));
		return "/mainMenu/bestDetail";
	}
	
	//인기상품 수정
	@RequestMapping(value="/bestModify", method = RequestMethod.GET)
	public void bestModify(BestVO bestVO, Model model) throws Exception {
		model.addAttribute("modify",newService.bestDetail(bestVO.getNp()));
	}
	
	//인기상품 수정
	@RequestMapping(value="/bestModify", method = RequestMethod.POST)
	public String bestModifyPOST(BestVO bestVO, Model model) throws Exception {
		System.out.println("글 수정 완료 -----------------> ");
		System.out.println("bestVO="+bestVO);
			
		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
			
		String file1 = bestVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = bestVO.getFile2().getOriginalFilename(); //파일 전체 이름
		
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
			
			
			// file1이 null이고, file2가 null이 아니면(and)
			if(file1.equals("") && !file2.equals("")){
				System.out.println("sql file1 yes null, file2 not null");
				file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile2().getOriginalFilename(), bestVO.getFile2().getBytes(), ymdPath);
				file2 = file2.replace('\\', '/');
				newService.bestModify1(bestVO, file1, file2);
			}
			
			// file2가 null이면, file1이 null이 아니면 (and)
			else if(!file1.equals("") && file2.equals("")){
				System.out.println("sql file1 not null, file2 yes null");
				file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile1().getOriginalFilename(), bestVO.getFile1().getBytes(), ymdPath);
				file1 = file1.replace('\\', '/');			
				newService.bestModify2(bestVO, file1, file2);
			}	
			
			// file1과 file2가 null이 아니면(and),
			else if(!file1.equals("") && !file2.equals("")) {
				System.out.println("sql file1 not null, file2 not null");
				file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile1().getOriginalFilename(), bestVO.getFile1().getBytes(), ymdPath);
				file1 = file1.replace('\\', '/');
				file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, bestVO.getFile2().getOriginalFilename(), bestVO.getFile2().getBytes(), ymdPath);
				file2 = file2.replace('\\', '/');
						
				newService.bestModify3(bestVO, file1, file2);
			}
			
			// file1과 file2가 null이면 (and)
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
		
		//인기상품 삭제
		@RequestMapping(value="/bestDelete", method = RequestMethod.GET)
		public String bestDelete(int np, Model model) throws Exception {
			logger.info("-----> 글 삭제 완료 mainManu/bestDelete Controller" + np);
			newService.bestDelete(np);
			return "redirect:best";
		}
		
	
	/* 할인/쿠폰 */
		
	//할인/쿠폰상품 등록 페이지이동
	@RequestMapping(value="/couponWrite", method = RequestMethod.GET)
	public String couponWrite() throws Exception {
		logger.info("-----> mainManu/couponWrite.jsp");
		return "/mainMenu/couponWrite";
	} 
	
	//할인/쿠폰상품 등록 -> 등록완료
	@RequestMapping(value="/coupon", method = RequestMethod.POST)
	public String couponPOST(CouponVO couponVO, Model model) throws Exception {
		System.out.println("-----> 글 등록 완료 mainManu/couponPOST Controller");
		System.out.println("couponVO : "+couponVO);

		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
			
		String file1 = couponVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = couponVO.getFile2().getOriginalFilename(); //파일 전체 이름

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

	//할인/쿠폰상품 조회(메인 ! - DB select)
	@RequestMapping(value="/coupon", method = RequestMethod.GET)
	public String couponList(Model model) throws Exception {
		logger.info("-----> mainManu/coupon.jsp");
		System.out.println("......."+newService.couponList());
		model.addAttribute("couponProduction", newService.couponList());
		return "/mainMenu/coupon";
	}
	
	//할인/쿠폰상품 디테일
	@RequestMapping(value="/couponDetail", method = RequestMethod.GET)
	public String couponDetail(CouponVO couponVO, Model model) throws Exception {
		System.out.println("-----> 글 디테일 couponVO : "+couponVO);
		model.addAttribute("detail",newService.couponDetail(couponVO.getNp()));
		return "/mainMenu/couponDetail";
	}
	
	//할인/쿠폰상품 수정
	@RequestMapping(value="/couponModify", method = RequestMethod.GET)
	public void couponModify(CouponVO couponVO, Model model) throws Exception {
		model.addAttribute("modify",newService.couponDetail(couponVO.getNp()));
	}
	
	//인기상품 수정
	@RequestMapping(value="/couponModify", method = RequestMethod.POST)
	public String couponModifyPOST(CouponVO couponVO, Model model) throws Exception {
		System.out.println("글 수정 완료 -----------------> ");
		System.out.println("couponVO="+couponVO);
				
		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
				
		String file1 = couponVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = couponVO.getFile2().getOriginalFilename(); //파일 전체 이름
			
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
				
				
		// file1이 null이고, file2가 null이 아니면(and)
		if(file1.equals("") && !file2.equals("")){
			System.out.println("sql file1 yes null, file2 not null");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile2().getOriginalFilename(), couponVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
			newService.couponModify1(couponVO, file1, file2);
		}
				
		// file2가 null이면, file1이 null이 아니면 (and)
		else if(!file1.equals("") && file2.equals("")){
			System.out.println("sql file1 not null, file2 yes null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile1().getOriginalFilename(), couponVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');			
			newService.couponModify2(couponVO, file1, file2);
		}	
				
		// file1과 file2가 null이 아니면(and),
		else if(!file1.equals("") && !file2.equals("")) {
			System.out.println("sql file1 not null, file2 not null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile1().getOriginalFilename(), couponVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, couponVO.getFile2().getOriginalFilename(), couponVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
							
			newService.couponModify3(couponVO, file1, file2);
		}
			
		// file1과 file2가 null이면 (and)
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
			
	//인기상품 삭제
	@RequestMapping(value="/couponDelete", method = RequestMethod.GET)
	public String couponDelete(int np, Model model) throws Exception {
		logger.info("-----> 글 삭제 완료 mainManu/couponDelete Controller" + np);
		newService.couponDelete(np);
		return "redirect:coupon";
	}
	
	

	/* 이벤트 */
	//이벤트 등록 페이지이동
	@RequestMapping(value="/eventWrite", method = RequestMethod.GET)
	public String eventWrite() throws Exception {
		logger.info("-----> mainManu/eventWrite.jsp");
		return "/mainMenu/eventWrite";
	}
	
	//이벤트 등록
	//이벤트 등록 -> 등록완료
	@RequestMapping(value="/event", method = RequestMethod.POST)
	public String eventPOST(EventVO eventVO, Model model) throws Exception {
		System.out.println("-----> 글 등록 완료 mainManu/newPOST Controller");
		System.out.println("eventVO : "+eventVO);

		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
			
		String file1 = eventVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = eventVO.getFile2().getOriginalFilename(); //파일 전체 이름

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
	
	//이벤트 조회(메인 ! - DB select)
	@RequestMapping(value="/event", method = RequestMethod.GET)
	public String eventList(Model model) throws Exception {
		logger.info("-----> mainManu/event.jsp");
		System.out.println("......."+newService.eventList());
		model.addAttribute("eventProduction", newService.eventList());
		return "/mainMenu/event";
	}
		
	//이벤트 디테일
	@RequestMapping(value="/eventDetail", method = RequestMethod.GET)
	public String eventDetail(EventVO eventVO, Model model) throws Exception {
		System.out.println("-----> 글 디테일 eventVO : "+eventVO);
		model.addAttribute("detail",newService.eventDetail(eventVO.getNp()));
		return "/mainMenu/eventDetail";
	}
	
	//이벤트 수정 페이지 이동
	@RequestMapping(value="/eventModify", method = RequestMethod.GET)
	public void eventModify(EventVO eventVO, Model model) throws Exception {
		model.addAttribute("modify",newService.eventDetail(eventVO.getNp()));
	}
	
	//인기상품 수정
	@RequestMapping(value="/eventModify", method = RequestMethod.POST)
	public String eventModifyPOST(EventVO eventVO, Model model) throws Exception {
		System.out.println("글 수정 완료 -----------------> ");
		System.out.println("eventVO="+eventVO);
					
		String imgUploadPath = uploadPath + File.separator; //이미지 업로드 저장소
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath); //년도
					
		String file1 = eventVO.getFile1().getOriginalFilename(); //파일 전체 이름
		String file2 = eventVO.getFile2().getOriginalFilename(); //파일 전체 이름
				
		System.out.println("file1="+file1);
		System.out.println("file2="+file2);
					
					
		// file1이 null이고, file2가 null이 아니면(and)
		if(file1.equals("") && !file2.equals("")){
			System.out.println("sql file1 yes null, file2 not null");
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile2().getOriginalFilename(), eventVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
			newService.eventModify1(eventVO, file1, file2);
		}
					
		// file2가 null이면, file1이 null이 아니면 (and)
		else if(!file1.equals("") && file2.equals("")){
			System.out.println("sql file1 not null, file2 yes null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile1().getOriginalFilename(), eventVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');			
			newService.eventModify2(eventVO, file1, file2);
		}	
					
		// file1과 file2가 null이 아니면(and),
		else if(!file1.equals("") && !file2.equals("")) {
			System.out.println("sql file1 not null, file2 not null");
			file1 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile1().getOriginalFilename(), eventVO.getFile1().getBytes(), ymdPath);
			file1 = file1.replace('\\', '/');
			file2 = ymdPath+"\\"+UploadFileUtils.fileUpload(imgUploadPath, eventVO.getFile2().getOriginalFilename(), eventVO.getFile2().getBytes(), ymdPath);
			file2 = file2.replace('\\', '/');
								
			newService.eventModify3(eventVO, file1, file2);
		}
				
		// file1과 file2가 null이면 (and)
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
				
		//인기상품 삭제
		@RequestMapping(value="/eventDelete", method = RequestMethod.GET)
		public String eventDelete(int np, Model model) throws Exception {
			logger.info("-----> 글 삭제 완료 mainManu/eventDelete Controller" + np);
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

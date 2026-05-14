package com.kopo.hkcode.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	
	
	@Autowired
    private ProductService productService; 
	// 스프링이 beans.xml에 있는 ProductService 객체를 자동으로 꽂아줌	
	
//	@PostMapping
//	@RequestMapping(value = "/productService", method = RequestMethod.GET)
	@GetMapping("/getRegionMaxQty")
    public String getMaxQty(@RequestParam("regionid") String uiFromRegionid, Model model) {
        
		// 비즈니스 로직- 화면으로 입력받은 지역의 최대 매출값 
        String sqlRes = productService.getMaxQtyByRegion(uiFromRegionid);
        
        // 받아온 결과를 모델에 집어 넣는다 key-value
        model.addAttribute("msg", sqlRes);
        
     // views/productPage.jsp 파일 랜더링 ㄱㄱ
        return "productPage"; 
    }
	
	@GetMapping("/")
    public String base() {
		// views/productPage.jsp 파일 랜더링 ㄱㄱ
        return "productPage"; 
    }

}

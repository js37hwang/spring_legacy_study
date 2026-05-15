package com.kopo.hkcode.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	
	// Q controller에서 return하는 것은 jsp 파일명 아니었어?
	// A 그것을 viewResolver(return된 파일명에 경로와 확장자 붙여줌)라고 하는데 
	// 이것은 어노테이션이 붙는 순간 무력화 되므로 파이썬의 엔드포인트=fastapi처럼 사용할 수 있어짐
	@PostMapping("/getMaxQty")
	@ResponseBody
	public Map<String, Object> getMaxQty(@RequestParam("regionid") String regionid) {

		Map<String, Object> response = new HashMap<>();
		String productgroup = "haiteam";

		try {
			// 1. 이미지 3번의 서비스를 호출하여 실제 DB 값을 가져옵니다.
			// String result = productService.getMaxQtyByRegion(regionid, productgroup);
			int maxQty = 500; // 일단 테스트용

			// 2. 응답 데이터 구성
			response.put("regionId", regionid);
			response.put("productGroup", productgroup);
			response.put("maxQty", maxQty);
			response.put("status", "success");

		} catch (Exception e) {
			// 에러 발생 시 상태값 전달
			response.put("status", "error");
			response.put("message", e.getMessage());
		}

		return response;
	}

}

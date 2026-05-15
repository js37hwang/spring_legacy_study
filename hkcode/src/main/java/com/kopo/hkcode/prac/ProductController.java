package com.kopo.hkcode.prac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	// 1. 서비스 객체를 담을 변수를 final로 선언합니다.
	private final ProductService ps;

	// 2. 생성자를 통해 스프링으로부터 ProductService 부품을 주입받습니다.
	public ProductController(ProductService ps) {
		this.ps = ps;
	}

	@PostMapping("/getMaxQty.prac")
	@ResponseBody
	public Map<String, Object> getMaxQty(@RequestParam("regionid") String regionid, String productgroup) {
		Map<String, Object> response = new HashMap<>();

		try {
			// 3. 주입받은 ps를 사용하여 메서드 호출
			List<Map<String, String>> result = ps.getMaxQtyByRegion(regionid, productgroup);

			System.out.println(regionid + productgroup);

			response.put("regionId", regionid);
			response.put("productgroup", productgroup);
			response.put("maxQty", result.get(0).get("maxQty"));
			response.put("manager", result.get(0).get("manager"));
			// response.put("resultList", result); // 리스트 자체
			response.put("status", "success");

		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", e.getMessage());
		}

		return response;
	}
}
package com.kopo.hkcode.prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ProductService")
public class ProductService {
	// 실무 스타일: final 키워드로 안정성 확보- 즉, 한번 생성될 때 들어간 데이터로 고정
	private final DataSource dataSource;

	
	
	@Value("정선황")
	private final List<String> managerList;

	// 생성자 주입: 스프링이 이 생성자를 통해 부품을 꽉 끼워줍니다. -> bean에서 진행되는 작업임
	public ProductService(DataSource dataSource, List<String> managerList) {
		this.dataSource = dataSource;
		this.managerList = managerList;
	}

	// 지역 최대 QTY 조회 로직
	public List<Map<String, String>> getMaxQtyByRegion(String regionId, String productgroup) {
		List<Map<String, String>> result = new ArrayList<>();

		String sql = "SELECT MAX(QTY) as maxQty FROM kopo_channel_seasonality_new WHERE 1=1 AND regionid = ? AND PRODUCT = ? ;" ;

		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, regionId.trim().toUpperCase()); 
			pstmt.setString(2, productgroup.trim().toUpperCase());
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					// 1. 한 줄의 데이터를 담을 HashMap 객체를 생성
					Map<String, String> rowMap = new HashMap<>();

					// 2. 쿼리 결과(maxQty)를 Map에 담기
					rowMap.put("maxQty", String.valueOf(rs.getInt(1)));
					rowMap.put("productgroup", productgroup);

					// 3. 주입받은 담당자 정보(manager)를 Map에 담기
					if (managerList != null && !managerList.isEmpty()) {
						rowMap.put("manager", managerList.get(0));
					} else {
						rowMap.put("manager", "Unknown");
					}

					// 4. 완성된 Map 객체를 리스트에 추가
					result.add(rowMap);
				}
			}
		} catch (Exception e) {
			Map<String, String> rowMap = new HashMap<>();
			rowMap.put("error", e.getMessage());
			result.add(rowMap);
			e.printStackTrace();
		}

		return result;
	}
}

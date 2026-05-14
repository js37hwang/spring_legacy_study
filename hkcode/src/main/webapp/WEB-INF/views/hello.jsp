<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<html> 
<body> 
	<h1>메시지: ${message}</h1> 
</body> 
</html>

<script>
    // 서버에서 넘겨준 ${message} 값을 자바스크립트 변수에 할당
    const serverMessage = "${message}"; 
    console.log("서버에서 받은 메시지:", serverMessage);
    
    // 만약 값이 비어있다면 경고창 띄우기
    if(!serverMessage) {
        console.error("메시지가 비어있습니다! 컨트롤러를 확인하세요.");
    }
</script>

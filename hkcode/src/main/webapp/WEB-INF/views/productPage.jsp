<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB 연동 결과</title>
<style>
    /* 기본 배경 설정: 부드러운 그라데이션 */
    body { 
        font-family: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, sans-serif; 
        background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    /* 메인 카드 박스 */
    .container { 
        background-color: #ffffff;
        padding: 40px; 
        border-radius: 20px; 
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        transition: transform 0.3s ease;
    }

    .container:hover {
        transform: translateY(-5px);
    }

    /* 제목 스타일 */
    h2 { 
        color: #333; 
        margin-bottom: 20px;
        font-weight: 700;
        letter-spacing: -1px;
    }

    /* 구분선 */
    hr {
        border: 0;
        height: 1px;
        background: #eee;
        margin: 20px 0;
    }

    /* 결과 텍스트 영역 */
    .result-box {
        background-color: #f8f9fa;
        padding: 15px;
        border-radius: 12px;
        margin-bottom: 30px;
        border-left: 5px solid #007bff;
    }

    .result-label {
        display: block;
        font-size: 0.85rem;
        color: #6c757d;
        margin-bottom: 5px;
        text-transform: uppercase;
    }

    .result-content {
        font-size: 1.1rem;
        color: #212529;
        font-weight: 600;
        word-break: break-all;
    }

    /* 버튼 스타일 */
    button { 
        background-color: #007bff; 
        color: white; 
        border: none; 
        padding: 12px 25px; 
        border-radius: 8px; 
        cursor: pointer; 
        font-size: 1rem;
        font-weight: 600;
        transition: all 0.2s ease;
        width: 100%;
    }

    button:hover { 
        background-color: #0056b3; 
        box-shadow: 0 4px 12px rgba(0, 123, 255, 0.3);
    }

    button:active {
        transform: scale(0.98);
    }
</style>
</head>
<body>
    <div class="container">
        <h2>📊 데이터 조회 결과</h2>
        <hr>
        <div class="result-box">
            <span class="result-label">조회 내용</span>
            <p class="result-content">${msg}</p>
        </div>
        <button onclick="history.back()">이전 화면으로</button>
    </div>
</body>
</html>



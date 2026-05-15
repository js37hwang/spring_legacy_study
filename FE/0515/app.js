const express = require('express');
const http = require('http');
const path = require('path');
const cors = require('cors');

const app = express();
const server = http.createServer(app).listen(3000);

// =========================
// 🔥 CORS 설정 추가
// =========================
const corsOptions = {
  origin: [
    "http://localhost:3000",
    "http://127.0.0.1:3000", 
    "http://localhost:8181",
    "http://127.0.0.1:8181"
  ],
  methods: ["GET", "POST"],
  credentials: true
};

app.use(cors(corsOptions));

// =========================
// 🔥 body parser 추가 (필수)
// =========================
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// =========================
// 정적 파일 설정
// =========================
app.use('/css', express.static(path.join(__dirname, 'css')));
app.use('/js', express.static(path.join(__dirname, 'js')));

// =========================
// 메인 페이지
// =========================
app.get('/', function (req, res) {
  res.sendFile(path.join(__dirname, 'main.html'));
});

// =========================
// API 호출부 (POST)
// =========================
app.get('/getMaxQty', async function (req, res) {

  const regionid = req.query.regionid;
  const productgroup = req.query.productgroup;

  try {

    // Spring 서버 호출
    const response = await fetch(
      'http://localhost:8181/hkcode/getMaxQty.prac',
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        body:
          `regionid=${encodeURIComponent(regionid)}&productgroup=${encodeURIComponent(productgroup)}`
      }
    );

    const data = await response.json();

    // 프론트로 전달
    res.json(data);

  } catch (error) {

    console.error(error);

    res.status(500).json({
      status: 'error',
      message: '백엔드 호출 실패'
    });
  }
});
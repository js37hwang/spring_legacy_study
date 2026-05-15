async function searchMaxQty() {

  const regionId =
    document.getElementById("regionId").value;

  const productgroup =
    document.getElementById("productgroup").value;

  const resultEl =
    document.getElementById("result");

  if (!regionId || !productgroup) {

    resultEl.className = "error";
    resultEl.innerText =
      "지역 ID와 상품명을 모두 입력해주세요.";

    return;
  }

  resultEl.className = "loading";
  resultEl.innerText = "조회 중입니다...";

  try {

    const response = await fetch(
      `http://localhost:3000/getMaxQty?regionid=${encodeURIComponent(regionId)}&productgroup=${encodeURIComponent(productgroup)}`,
      {
        method: "GET"
      }
    );

    if (!response.ok) {
      throw new Error("서버 호출 실패");
    }

    const data = await response.json();

    const maxQty = data.maxQty;
    const manager = data.manager;
    const region = data.regionId;
    const product = data.productgroup;

    resultEl.className = "result-text";

    resultEl.innerHTML = `
      지역 [${region}]의 상품
      <span style="color:#6ccf48;">
        ${product}
      </span>
      최대 판매량은
      <span style="color:#6ccf48;">
        ${maxQty}
      </span>
      개 입니다.
      <br/><br/>

      <span style="
        font-size:18px;
        color:#7a8a70;
      ">
        조회 담당자 : ${manager}
      </span>
    `;

  } catch (error) {

    console.error(error);

    resultEl.className = "error";

    resultEl.innerText =
      "조회 중 오류가 발생했습니다.";
  }
}
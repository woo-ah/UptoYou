let modalTimer;

function showModal() {
    let inputRequired = $(".input_required");
    for (let each of inputRequired) {
        let tempValue = $.trim($(each).val());
        if (tempValue == null || tempValue === "") {
            alert("별명을 입력하세요");
            $(each).focus();
            return false;
        }
    }
    let username = $("#create_user_username").val();
    document.getElementById("div_error").style.display = 'none';

    $.ajax({
        url: "/api/user", // 회원 가입
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            username: username
        }),
        cache: false,
        success: (response) => {
            if (response.id === -200) {
                showDuplicateMessage(); // 중복 메시지 표시
            } else {

                localStorage.setItem("reqUserId", response.id);
                localStorage.setItem("reqUserUsername", username);
                // 중복되지 않으면 모달 표시
                const modal = document.getElementById("create-modal");
                modal.style.display = "flex"; // 모달 보이기

                // 유저 이름을 모달에 표시
                $(".font_req_username").text(username);
                //document.getElementById("create-modal-username").textContent = username;

                // 2초 후 모달 닫기
                modalTimer = setTimeout(() => {
                    //closeModal();
                    // 다음 페이지로 이동
                    location.replace("/gspeed/description");
                }, 2000);
            }
        },
        error: (xhr, status, error) => {
            console.error("Error occurred:", error);
        },
    });
}

function showDuplicateMessage() {
    document.getElementById("div_error").style.display = 'block';
}

function closeModal() {
    const modal = document.getElementById('create-modal');
    modal.style.display = 'none'; // 모달 숨기기
    clearTimeout(modalTimer); // 타이머 중단
}

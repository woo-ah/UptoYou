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
                // 중복되지 않으면 모달 표시
                const modal = document.getElementById("modal");
                modal.style.display = "flex"; // 모달 보이기

                // 유저 이름을 모달에 표시
                document.getElementById("modal-username").textContent = username;

                // 2초 후 모달 닫기
                modalTimer = setTimeout(() => {
                    closeModal();
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
    // 중복 메시지 표시
    let messageBox = document.getElementById("duplicate-message");
    if (!messageBox) {
        // 메시지 박스가 없으면 생성
        messageBox = document.createElement("p");
        messageBox.id = "duplicate-message";
        messageBox.style.color = "red";
        messageBox.style.fontSize = "16px";
        messageBox.style.marginTop = "10px";
        document.getElementById("create_user_username").parentElement.appendChild(messageBox);
    }
    messageBox.textContent = "중복된 이름입니다. 다른 이름을 입력해주세요.";
}

function closeModal() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none'; // 모달 숨기기
    clearTimeout(modalTimer); // 타이머 중단
}

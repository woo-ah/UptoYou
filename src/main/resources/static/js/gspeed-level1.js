const scoreDisplay = document.getElementById('score');
    const gameContainer = document.getElementById('game-container');
    const countdownDisplay = document.getElementById('countdown');
    const progressBar = document.getElementById('progress-bar');
    const modal = document.getElementById('modal');
    const yesBtn = document.getElementById('yes-btn');

    const userId = localStorage.getItem("reqUserId");
    $("#detail_username").text(localStorage.getItem("reqUserUsername"));

    /*const userId = document.getElementById('user-id').textContent.trim();*/
    let score = 0;
    let timer;
    let gameActive = false;
    let startTime;

    const totalGameTime = 15000; // 게임 시간 15초
    const characterTypes = ['glass', 'bulb', 'mirror'];
    const spawnInterval = 900; // 캐릭터 갱신 주기 (2초)

    function spawnCharacters() {
        gameContainer.innerHTML = ''; // 기존 캐릭터 초기화
        const containerWidth = gameContainer.offsetWidth;
        const containerHeight = gameContainer.offsetHeight;
        const characterSize = 50;
        const characters = [];
        const totalCharacters = Math.floor(Math.random() * 7) + 12; // 12~18개의 캐릭터 생성
        const glassCount = Math.min(3, totalCharacters); // 유리병 최대 3개

        // 유리병 생성
        for (let i = 0; i < glassCount; i++) {
            createCharacter(characters, containerWidth, containerHeight, characterSize, 'glass');
        }

        // 나머지 캐릭터 생성
        for (let i = glassCount; i < totalCharacters; i++) {
            const type = ['bulb', 'mirror'][Math.floor(Math.random() * 2)]; // 전구와 거울 랜덤
            createCharacter(characters, containerWidth, containerHeight, characterSize, type);
        }

        // 화면에 캐릭터 추가
        characters.forEach(({ x, y, type }) => {
            const charDiv = document.createElement('div');
            charDiv.className = `character ${type}`;
            charDiv.style.left = `${x}px`;
            charDiv.style.top = `${y}px`;
            charDiv.dataset.type = type;
            charDiv.textContent = type === 'glass' ? '유리병' : type === 'bulb' ? '전구' : '거울';
            gameContainer.appendChild(charDiv);

            charDiv.addEventListener('click', (event) => {
                if (!gameActive) return;

                const clickedType = event.target.dataset.type;
                if (clickedType === 'glass') {
                    score++;
                    scoreDisplay.textContent = '빠르게 캐치하라! (' + score + '/5)';

                    event.target.remove(); // 클릭된 유리병 즉시 제거

                    if (score === 5) {
                        const endTime = new Date();
                        const timeTaken = ((endTime - startTime) / 1000).toFixed(2);
                        gameActive = false;
                        endGame(true, timeTaken);
                    }
                } else {
                    gameActive = false;
                    endGame(false);
                }
            });
        });
    }

    function createCharacter(characters, containerWidth, containerHeight, characterSize, type) {
        let x, y, overlap;
        do {
            overlap = false;
            x = Math.random() * (containerWidth - characterSize);
            y = Math.random() * (containerHeight - characterSize);

            for (let char of characters) {
                const dx = char.x - x;
                const dy = char.y - y;
                if (Math.sqrt(dx * dx + dy * dy) < characterSize) {
                    overlap = true;
                    break;
                }
            }
        } while (overlap);

        characters.push({ x, y, type });
    }

    function startCountdown() {
        let count = 3;
        countdownDisplay.textContent = count;

        const countdownInterval = setInterval(() => {
            count--;
            if (count > 0) {
                countdownDisplay.textContent = count;
            } else {
                clearInterval(countdownInterval);
                countdownDisplay.textContent = '';

                // progress-bar-container를 보이게 설정
                const progressBarContainer = document.getElementById('progress-bar-container');
                progressBarContainer.style.opacity = '1';
                progressBarContainer.style.visibility = 'visible';

                // 캐릭터를 즉시 생성하고 게임 시작
                spawnCharacters();
                startGame();
            }
        }, 1000);
    }

    function startGame() {
        score = 0;
        gameActive = true;
        startTime = new Date();
        scoreDisplay.textContent = '빠르게 캐치하라! (0/5)';

        const progressInterval = setInterval(() => {
            const elapsedTime = new Date() - startTime;
            const progress = Math.max(0, 100 - (elapsedTime / totalGameTime) * 100);
            progressBar.style.width = progress + '%';

            if (!gameActive) clearInterval(progressInterval);
        }, 100);

        const characterInterval = setInterval(() => {
            if (!gameActive) {
                clearInterval(characterInterval);
                return;
            }
            spawnCharacters();
        }, spawnInterval);

        timer = setTimeout(() => {
            endGame(false);
        }, totalGameTime);
    }


    function endGame(success, timeTaken) {
        clearTimeout(timer);
        gameActive = false;
        progressBar.style.width = '0%';
        gameContainer.innerHTML = '';

        if (success) {
            if (timeTaken) {
                // 모달 표시
                const modal = document.getElementById('modal');
                modal.style.display = 'flex';

                $.ajax({
                    url: "/api/gspeed",
                    type: "POST",
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify({
                        userId: userId,
                        level1: timeTaken
                    }),
                    cache: false,
                    success: (obj_data, status, xhr) => {
                        console.log("AJAX Success:", obj_data.id);
                        localStorage.setItem("gspeedId", obj_data.id);
                        alert("성공적으로 저장되었습니다!");
                        // location.replace(`/game/level3?userId=${userId}`);
                    },
                    error: (xhr, status, error) => {
                        console.error("AJAX Error:", xhr.responseText);
                        alert("서버 저장 중 오류가 발생했습니다.");
                    }
                });

                // "2단계 도전" 버튼 클릭 이벤트 추가
                const nextLevelBtn = document.getElementById('next-level-btn');
                nextLevelBtn.addEventListener('click', () => {
                    location.replace("/gspeed/level2");
                });
            } else {
                alert('시간 초과! 게임이 종료되었습니다.');
            }
        } else {
            alert('유리병이 아닌 다른 캐릭터를 선택했습니다. 게임 오버!');
        }
    }
    window.addEventListener('load', startCountdown);
"use strict";

const generateSecretNumber = function () {
  return Math.trunc(Math.random() * 30) + 1;
};

let secretNumber = generateSecretNumber();
let score = 20;
let highScore = 0;
// Math.random() never actually returns 1. It returns
// a decimal that is strictly less than 1 (from 0 up to 0.999999...).

const numberEl = document.querySelector(".number");
const messageEl = document.querySelector(".message"); //Message display
const guessInp = document.querySelector(".guess"); //input field
const checkBtn = document.querySelector(".check"); //button
const retryBtn = document.querySelector(".again");

const highScoreEl = document.querySelector(".label-highscore");
const scoreEl = document.querySelector(".label-score");

scoreEl.textContent = `💯 Score: ${score}`;
retryBtn.addEventListener("click", handleRetryButton);
checkBtn.addEventListener("click", handleCheckButton);
/* here pass the function as Expression 'without ()'When you 
pass handleCheckButton() with parentheses, JavaScript executes
the function immediately when the page loads rather than waiting 
for the user to click the button. the input field is empty 
when the script first runs.*/

function handleRetryButton() {
  secretNumber = generateSecretNumber();
  numberEl.textContent = "?";
  score = 20;
  scoreEl.textContent = `💯 Score: ${score}`;
  document.querySelector("body").style.backgroundColor = "#222";
  numberEl.style.width =  '15rem';
  guessInp.value="";
  
  // Re-enable the check button
  checkBtn.disabled = false;
}
function handleCheckButton() {
  const guess = Number(guessInp.value);

  // 1. Invalid / Empty Input
  if (!guess) {
    messageEl.textContent = "❌ No Number";
    return;
  }

  // 2. Correct Guess
  if (guess === secretNumber) {
    messageEl.textContent = "🥳 Congrats! You guessed it right";
    numberEl.textContent = secretNumber;

    document.querySelector("body").style.backgroundColor = "#60b347";
    numberEl.style.width =  '30rem';

    if (score > highScore) {
      highScore = score;
      highScoreEl.textContent = `🥇 Highscore: ${highScore}`;
    }
    return;
  }

  // 3. Wrong Guess
  if (score > 1) {
    score--;
    scoreEl.textContent = `💯 Score: ${score}`;
    messageEl.textContent =
      guess < secretNumber ? "📉 Too Low!" : "📈 Too High!";
  } else {
    // Score dropped to 0: Game Over
    score = 0;
    scoreEl.textContent = `💯 Score: ${score}`;
    messageEl.textContent = "😔 You lost! Click retry.";
    numberEl.textContent = "❌";

    // Disable the button when score <= 0
    checkBtn.disabled = true;
  }
}

const cardContainer = document.querySelector("#flashcard-container");
const statusBar = document.querySelector("#status-bar");
const btnPrev = statusBar.querySelector("#prev");
const btnNext = statusBar.querySelector("#next");

/**
 *
 * @param {Event}} event
 */
// Task 1: flip word/ definition
function flipCard(event) {
  const flashcard = event.currentTarget;

  //get word side
  const wordSide = flashcard.querySelector(".word");

  //get definition side
  const defSide = flashcard.querySelector(".definition");

  wordSide.classList.toggle("hidden");
  defSide.classList.toggle("hidden");
}
// //get flashcard
// const flashcard = cardContainer.querySelector('.flashcard-box');

// // listen for click event FlipCard
// flashcard.addEventListener('click', flipCard);

// Task 2: populate data
function createCard(word, definition) {
  const flashcard = document.createElement("div");
  flashcard.classList.add("flashcard-box");
  flashcard.classList.add("hidden");

  //word
  const wordSide = document.createElement("div");
  wordSide.classList.add("flashcard");
  wordSide.classList.add("word");
  wordSide.textContent = word;

  flashcard.appendChild(wordSide);

  //Definition
  const defSide = document.createElement("div");
  defSide.classList.add("flashcard");
  defSide.classList.add("definition");
  defSide.classList.add("hidden");
  defSide.textContent = definition;

  flashcard.appendChild(defSide);

  return flashcard;
}

function populateCards(cardContainer) {
  const cards = [];
  for (const word in KOREAN) {
    const definition = KOREAN[word];

    const flashcard = createCard(word, definition);

    //add to display
    cardContainer.appendChild(flashcard);

    //listen to event
    flashcard.addEventListener("click", flipCard);

    //add to return
    cards.push(flashcard);
  }
  return cards;
}

const cards = populateCards(cardContainer);

const statusNoWords = statusBar.querySelector("span");
statusNoWords.textContent = cards.length;

// Task 3: mouse events - navigation
const statusCurrentIndex = statusBar.querySelector("strong");

// on start: show first word
let currentIndex = 0;

function setIndex(index) {
  // check if valid index
  if (index >= 0 && index < cards.length) {
    // hide current card
    cards[currentIndex].classList.add("hidden");
    // show card at index
    cards[index].classList.remove("hidden");

    // disable/ enable navigating buttons
    if (index == 0) {
      btnPrev.disabled = true;
    } else {
      btnPrev.disabled = false;
    }

    btnNext.disabled = index == cards.length - 1;

    currentIndex = index;
    statusCurrentIndex.textContent = currentIndex + 1;
  }
}
setIndex(currentIndex);

function prevCard() {
  setIndex(currentIndex - 1);
}

function nextCard() {
  setIndex(currentIndex + 1);
}

//get button element
// listen for event
btnPrev.addEventListener("click", prevCard);
btnNext.addEventListener("click", nextCard);

// Task 4: keyboard events - navigation
/**
 *
 * @param {Keyboard Event} event
 */
function onKeyDown(event) {
  switch (event.key) {
    case "ArrowLeft":
      prevCard();
      break;
    case "ArrowRight":
      nextCard();
      break;
  }
}
document.addEventListener("keydown", onKeyDown);

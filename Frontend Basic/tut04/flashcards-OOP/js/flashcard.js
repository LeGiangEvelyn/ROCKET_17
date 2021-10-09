class Flashcard {
  constructor(container, word, definition) {
    this.container = container;
    this.word = word;
    this.definition = definition;

    const card = this._createCard();

    // //add to display
    this.container.appendChild(card);

    this._flipCard = this._flipCard.bind(this);
    // //listen to event
    card.addEventListener("click", this._flipCard);
  }

  _createCard() {
    this.flashcard = document.createElement("div");
    this.flashcard.classList.add("flashcard-box");
    this.flashcard.classList.add("hidden");

    //word
    this.wordSide = document.createElement("div");
    this.wordSide.classList.add("flashcard");
    this.wordSide.classList.add("word");
    this.wordSide.textContent = this.word;

    this.flashcard.appendChild(this.wordSide);

    //Definition
    this.defSide = document.createElement("div");
    this.defSide.classList.add("flashcard");
    this.defSide.classList.add("definition");
    this.defSide.classList.add("hidden");
    this.defSide.textContent = this.definition;

    this.flashcard.appendChild(this.defSide);

    return this.flashcard;
  }
  _flipCard() {
    this.wordSide.classList.toggle("hidden");
    this.defSide.classList.toggle("hidden");
  }
  setVisible(visible) {
    if (visible) {
      this.flashcard.classList.remove("hidden");
    } else this.flashcard.classList.add("hidden");
  }
}

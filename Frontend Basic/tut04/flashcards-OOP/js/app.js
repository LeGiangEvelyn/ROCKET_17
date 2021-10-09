class App {
  constructor(container, words) {
    this.container = container;
    this.words = words;

    //populate cards
    this.cards = this._populateCards();

    //show first card
    this.cards[0].setVisible(true);
    //status bar
    const statusBarContainer = this.container.querySelector("#status-bar");
    this.statusBar = new StatusBar(statusBarContainer, this.cards.length);
  }

  _populateCards() {
    const cards = [];
    for (const word in this.words) {
      const definition = KOREAN[word];

      const cardContainer = this.container.querySelector(
        "#flashcard-container"
      );
      const flashcard = new Flashcard(cardContainer, word, definition);

      //add to return
      cards.push(flashcard);
    }
    return cards;
  }
}

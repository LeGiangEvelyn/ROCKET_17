class StatusBar {
  constructor(container, maxIndex) {
    this.container = container;
    this.maxIndex = maxIndex;

    this.currentIndex = 1;
    this._createStatus();

    this._prevCard = this._prevCard.bind(this);
    this._nextCard = this._nextCard.bind(this);

    this.btnPrev.addEventListener("click", this._prevCard);
    this.btnNext.addEventListener("click", this._nextCard);
  }

  _createStatus() {
    this.btnPrev = document.createElement("button");
    this.btnPrev.textContent = "<";
    this.container.appendChild(this.btnPrev);

    //current index
    this.txtCurrent = document.createElement("strong");
    this.txtCurrent.textContent = 1;
    this.container.appendChild(this.txtCurrent);

    const sep = document.createTextNode("/");
    this.container.appendChild(sep);

    //max Index
    this.txtMax = document.createElement("span");
    this.txtMax.textContent = 10;
    this.container.appendChild(this.txtMax);

    this.btnNext = document.createElement("button");
    this.btnNext.textContent = ">";
    this.container.appendChild(this.btnNext);
  }
  _prevCard() {
    this._setIndex(this.currentIndex - 1);
  }

  _nextCard() {
    this._setIndex(this.currentIndex + 1);
  }
  _setIndex(index) {
    // check if valid index
    if (index >= 0 && index < this.maxIndex) {
      // disable/ enable navigating buttons
      if (index == 0) {
        this.btnPrev.disabled = true;
      } else {
        this.btnPrev.disabled = false;
      }

      this.btnNext.disabled = index == this.maxIndex - 1;

      this.currentIndex = index;
      this.txtCurrent.textContent = this.currentIndex + 1;
    }
  }
}

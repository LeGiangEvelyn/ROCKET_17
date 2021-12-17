//export class
export class Position {
  private static counter: number = 0;

  private id: number;
  private name: PositionName;

  constructor(name: PositionName) {
    this.id = ++Position.counter;
    this.name = name;
  }

  public getId(): number {
    return this.id;
  }

  public getName(): PositionName {
    return this.name;
  }

  /**
   * Setter id
   * @param {number} value
   */
  public setId(value: number) {
    this.id = value;
  }

  /**
   * Setter name
   * @param {string} value
   */
  public setName(value: PositionName) {
    this.name = value;
  }

  public printPosition() {
    console.log("**** Position: ****");
    console.log("ID: " + this.id);
    console.log("Name: " + this.name);
  }
}

export enum PositionName {
  Dev = "Dev",
  Test = "Test",
  Scrummaster = "Scrummaster",
  Pm = "PM",
}

class Person {
  private static counter: number = 0;

  private id: number;
  private name: string;
  constructor(name: string) {
    this.id = ++Person.counter;
    this.name = name;
  }
  public getName(): string {
    return this.name;
  }

  public setName(value: string) {
    this.name = value;
  }
  public printInfor() {
    console.log("ID: " + this.id);
    console.log("name: " + this.name);
  }
}

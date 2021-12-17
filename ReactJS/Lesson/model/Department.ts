//export class
export class Department {
  private static counter: number = 0;

  private id: number;
  private name: string;

  constructor(name: string) {
    this.id = ++Department.counter;
    this.name = name;
  }

  public getId(): number {
    return this.id;
  }

  public getName(): string {
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
  public setName(value: string) {
    this.name = value;
  }

  public printDepartment() {
    console.log("**** Department: ****");
    console.log("ID: " + this.id);
    console.log("name: " + this.name);
  }
}

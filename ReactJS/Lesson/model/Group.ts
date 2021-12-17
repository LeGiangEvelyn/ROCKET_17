import { Account } from "./Account";

export class Group {
  private static counter: number = 0;

  private id: number;
  private name: string;
  private creator: Account;
  private createDate: Date;

  constructor(name: string, creator: Account, createDate: Date) {
    this.id = ++Group.counter;
    this.name = name;
    this.creator = creator;
    this.createDate = createDate;
  }

  /**
   * Getter id
   * @return {number}
   */
  public getId(): number {
    return this.id;
  }

  /**
   * Getter name
   * @return {string}
   */
  public getName(): string {
    return this.name;
  }

  /**
   * Getter creator
   * @return {Account}
   */
  public getCreator(): Account {
    return this.creator;
  }

  /**
   * Getter createDate
   * @return {Date}
   */
  public getCreateDate(): Date {
    return this.createDate;
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

  /**
   * Setter creator
   * @param {Account} value
   */
  public setCreator(value: Account) {
    this.creator = value;
  }

  /**
   * Setter createDate
   * @param {Date} value
   */
  public setCreateDate(value: Date) {
    this.createDate = value;
  }
  public printGroup() {
    console.log("****    Group: ****");
    console.log("ID: " + this.id);
    console.log("Name: " + this.name);
    console.log("Creator: " + this.creator.getFullname());
    console.log("CreateDate: " + this.createDate);
  }
}

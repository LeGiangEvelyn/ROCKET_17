import { Department } from "./Department";
import { Position } from "./Position";

export class Account {
  private static counter: number = 0;

  private id: number;
  private email: string;
  private username: string;
  private fullname: string;
  private department: Department;
  private position: Position;
  private createDate: Date;

  constructor(
    email: string,
    username: string,
    fullname: string,
    department: Department,
    position: Position,
    createDate: Date
  ) {
    this.id = ++Account.counter;
    this.email = email;
    this.username = username;
    this.fullname = fullname;
    this.department = department;
    this.position = position;
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
   * Setter id
   * @param {number} value
   */
  public setId(value: number) {
    this.id = value;
  }

  /**
   * Getter email
   * @return {string}
   */
  public getEmail(): string {
    return this.email;
  }

  /**
   * Setter email
   * @param {string} value
   */
  public setEmail(value: string) {
    this.email = value;
  }

  /**
   * Getter username
   * @return {string}
   */
  public getUsername(): string {
    return this.username;
  }

  /**
   * Getter fullname
   * @return {string}
   */
  public getFullname(): string {
    return this.fullname;
  }

  /**
   * Getter department
   * @return {Department}
   */
  public getDepartment(): Department {
    return this.department;
  }

  /**
   * Getter position
   * @return {Position}
   */
  public getPosition(): Position {
    return this.position;
  }

  /**
   * Setter username
   * @param {string} value
   */
  public setUsername(value: string) {
    this.username = value;
  }

  /**
   * Setter fullname
   * @param {string} value
   */
  public setFullname(value: string) {
    this.fullname = value;
  }

  /**
   * Setter department
   * @param {Department} value
   */
  public setDepartment(value: Department) {
    this.department = value;
  }

  /**
   * Setter position
   * @param {Position} value
   */
  public setPosition(value: Position) {
    this.position = value;
  }

  /**
   * Getter createDate
   * @return {Date}
   */
  public getCreateDate(): Date {
    return this.createDate;
  }

  /**
   * Setter createDate
   * @param {Date} value
   */
  public setCreateDate(value: Date) {
    this.createDate = value;
  }

  public printAccount() {
    console.log("**** Account: ****");
    console.log("ID: " + this.id);
    console.log("Email: " + this.email);
    console.log("Username: " + this.username);
    console.log("Fullname: " + this.fullname);
    console.log("Department: " + this.department.getName());
    console.log("Position: " + this.position.getName());
    console.log("CreateDate: " + this.createDate);
  }
}

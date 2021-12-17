import { Account } from "./model/Account";
import { Department } from "./model/Department";
import { Group } from "./model/Group";
import { Position, PositionName } from "./model/Position";

/************************ */
let department1 = new Department("Marketing");
let department2 = new Department("CEO");
let department3 = new Department("Sale");

department1.printDepartment();

//*********************** */
let position1 = new Position(PositionName.Dev);
let position2 = new Position(PositionName.Pm);
let position3 = new Position(PositionName.Scrummaster);

position1.printPosition();

//************************ */
let account1 = new Account(
  "giangle@gmail.com",
  "giangle",
  "Giang Le",
  department2,
  position2,
  new Date("Dec 15 2019")
);
let account2 = new Account(
  "huongtran@gmail.com",
  "huongtran",
  "Huong Tran",
  department3,
  position3,
  new Date("Dec 12 2020")
);

account2.printAccount();

//*********************** */

let group1 = new Group("Customer Care", account1, new Date("2020/12/11"));
let group2 = new Group("Leader", account2, new Date("2021/12/11"));

group1.printGroup();

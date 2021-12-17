"use strict";
exports.__esModule = true;
var Account_1 = require("./model/Account");
var Department_1 = require("./model/Department");
var Group_1 = require("./model/Group");
var Position_1 = require("./model/Position");
/************************ */
var department1 = new Department_1.Department("Marketing");
var department2 = new Department_1.Department("CEO");
var department3 = new Department_1.Department("Sale");
department1.printDepartment();
//*********************** */
var position1 = new Position_1.Position(Position_1.PositionName.Dev);
var position2 = new Position_1.Position(Position_1.PositionName.Pm);
var position3 = new Position_1.Position(Position_1.PositionName.Scrummaster);
position1.printPosition();
//************************ */
var account1 = new Account_1.Account("giangle@gmail.com", "giangle", "Giang Le", department2, position2, new Date("Dec 15 2019"));
var account2 = new Account_1.Account("huongtran@gmail.com", "huongtran", "Huong Tran", department3, position3, new Date("Dec 12 2020"));
account2.printAccount();
//*********************** */
var group1 = new Group_1.Group("Customer Care", account1, new Date("2020/12/11"));
var group2 = new Group_1.Group("Leader", account2, new Date("2021/12/11"));
group1.printGroup();

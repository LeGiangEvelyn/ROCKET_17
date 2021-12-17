"use strict";
exports.__esModule = true;
exports.Department = void 0;
//export class
var Department = /** @class */ (function () {
    function Department(name) {
        this.id = ++Department.counter;
        this.name = name;
    }
    Department.prototype.getId = function () {
        return this.id;
    };
    Department.prototype.getName = function () {
        return this.name;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Department.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter name
     * @param {string} value
     */
    Department.prototype.setName = function (value) {
        this.name = value;
    };
    Department.prototype.printDepartment = function () {
        console.log("**** Department: ****");
        console.log("ID: " + this.id);
        console.log("name: " + this.name);
    };
    Department.counter = 0;
    return Department;
}());
exports.Department = Department;

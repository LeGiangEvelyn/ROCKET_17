"use strict";
exports.__esModule = true;
exports.Account = void 0;
var Account = /** @class */ (function () {
    function Account(email, username, fullname, department, position, createDate) {
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
    Account.prototype.getId = function () {
        return this.id;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Account.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Getter email
     * @return {string}
     */
    Account.prototype.getEmail = function () {
        return this.email;
    };
    /**
     * Setter email
     * @param {string} value
     */
    Account.prototype.setEmail = function (value) {
        this.email = value;
    };
    /**
     * Getter username
     * @return {string}
     */
    Account.prototype.getUsername = function () {
        return this.username;
    };
    /**
     * Getter fullname
     * @return {string}
     */
    Account.prototype.getFullname = function () {
        return this.fullname;
    };
    /**
     * Getter department
     * @return {Department}
     */
    Account.prototype.getDepartment = function () {
        return this.department;
    };
    /**
     * Getter position
     * @return {Position}
     */
    Account.prototype.getPosition = function () {
        return this.position;
    };
    /**
     * Setter username
     * @param {string} value
     */
    Account.prototype.setUsername = function (value) {
        this.username = value;
    };
    /**
     * Setter fullname
     * @param {string} value
     */
    Account.prototype.setFullname = function (value) {
        this.fullname = value;
    };
    /**
     * Setter department
     * @param {Department} value
     */
    Account.prototype.setDepartment = function (value) {
        this.department = value;
    };
    /**
     * Setter position
     * @param {Position} value
     */
    Account.prototype.setPosition = function (value) {
        this.position = value;
    };
    /**
     * Getter createDate
     * @return {Date}
     */
    Account.prototype.getCreateDate = function () {
        return this.createDate;
    };
    /**
     * Setter createDate
     * @param {Date} value
     */
    Account.prototype.setCreateDate = function (value) {
        this.createDate = value;
    };
    Account.prototype.printAccount = function () {
        console.log("**** Account: ****");
        console.log("ID: " + this.id);
        console.log("Email: " + this.email);
        console.log("Username: " + this.username);
        console.log("Fullname: " + this.fullname);
        console.log("Department: " + this.department.getName());
        console.log("Position: " + this.position.getName());
        console.log("CreateDate: " + this.createDate);
    };
    Account.counter = 0;
    return Account;
}());
exports.Account = Account;

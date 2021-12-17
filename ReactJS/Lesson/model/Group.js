"use strict";
exports.__esModule = true;
exports.Group = void 0;
var Group = /** @class */ (function () {
    function Group(name, creator, createDate) {
        this.id = ++Group.counter;
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
    }
    /**
     * Getter id
     * @return {number}
     */
    Group.prototype.getId = function () {
        return this.id;
    };
    /**
     * Getter name
     * @return {string}
     */
    Group.prototype.getName = function () {
        return this.name;
    };
    /**
     * Getter creator
     * @return {Account}
     */
    Group.prototype.getCreator = function () {
        return this.creator;
    };
    /**
     * Getter createDate
     * @return {Date}
     */
    Group.prototype.getCreateDate = function () {
        return this.createDate;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Group.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter name
     * @param {string} value
     */
    Group.prototype.setName = function (value) {
        this.name = value;
    };
    /**
     * Setter creator
     * @param {Account} value
     */
    Group.prototype.setCreator = function (value) {
        this.creator = value;
    };
    /**
     * Setter createDate
     * @param {Date} value
     */
    Group.prototype.setCreateDate = function (value) {
        this.createDate = value;
    };
    Group.prototype.printGroup = function () {
        console.log("**** Group: ****");
        console.log("ID: " + this.id);
        console.log("Name: " + this.name);
        console.log("Creator: " + this.creator.getFullname());
        console.log("CreateDate: " + this.createDate);
    };
    Group.counter = 0;
    return Group;
}());
exports.Group = Group;

"use strict";
exports.__esModule = true;
exports.PositionName = exports.Position = void 0;
//export class
var Position = /** @class */ (function () {
    function Position(name) {
        this.id = ++Position.counter;
        this.name = name;
    }
    Position.prototype.getId = function () {
        return this.id;
    };
    Position.prototype.getName = function () {
        return this.name;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Position.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter name
     * @param {string} value
     */
    Position.prototype.setName = function (value) {
        this.name = value;
    };
    Position.prototype.printPosition = function () {
        console.log("**** Position: ****");
        console.log("ID: " + this.id);
        console.log("Name: " + this.name);
    };
    Position.counter = 0;
    return Position;
}());
exports.Position = Position;
var PositionName;
(function (PositionName) {
    PositionName["Dev"] = "Dev";
    PositionName["Test"] = "Test";
    PositionName["Scrummaster"] = "Scrummaster";
    PositionName["Pm"] = "PM";
})(PositionName = exports.PositionName || (exports.PositionName = {}));

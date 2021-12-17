//Closure: when execute two() (through one()) outside of lexical scope: still save the result of b,c
//need to tell TypeScript that our file is a module with its own scope: error variable a also declare as global scope of Hello
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
// export {};
// let a = 1;
// function one() {
//   let b = 2;
//   function two() {
//     let c = 3;
//     console.log(a, b, c);
//   }
//   return two;
// }
// const twoResult = one();
// twoResult();
// const date = [15, 12, 2021];
//normal: const day = date[0];
//Destructuring:
//array:
// const [day, month, year] = date;
// //object:
// const person = {
//   first: "Giang",
//   last: "Le",
//   address: {
//     street: "23",
//   },
// };
// //detruct
// const {
//   last,
//   first,
//   address: { street },
//   //   test = "Default",
// } = person;
// console.log(first, last, street);
//String template: using `` to access variable by ${}
// function logger(name: string) {
//   console.log(`My name is ${name}`);
// }
// logger("Giang");
//... operator(Spread operator): trải hết các phần tử của 1 đối tượng có thể lặp(Aray, Obj, String) ra
var arr1 = [1, 2, 3];
var arr2 = [4, 5, 6];
var noimang = __spreadArray(__spreadArray([], arr1, true), arr2, true);
console.log(noimang);
var obj1 = { name: "Giang", age: "22" };
var copyObj1 = __assign({}, obj1);
console.log(copyObj1);

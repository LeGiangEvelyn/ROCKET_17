//Closure: when execute two() (through one()) outside of lexical scope: still save the result of b,c
//need to tell TypeScript that our file is a module with its own scope: error variable a also declare as global scope of Hello

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
// const arr1 = [1, 2, 3];
// const arr2 = [4, 5, 6];
// const noimang = [...arr1, ...arr2];
// console.log(noimang);

// const obj1 = { name: "Giang", age: "22" };
// const copyObj1 = { ...obj1 };
// console.log(copyObj1);

// //Rest Operator: for function: gom lai
// function sum(a: number, b: number, ...n: number[]) {
//     n.forEach(){

//     }
// }

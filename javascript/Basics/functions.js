"use strict";

export function run() {
  // Concrete Function AKA Function Declaration — can be called before declaration
  function calculateAge(birthYear) {
    const currentYear = new Date().getFullYear();
    console.log(`Current Year : ${currentYear}`);
    return currentYear - birthYear;
  }
  console.log(`Age : ${calculateAge(2004)}`);

  // Anonymous Function AKA Function Expression
  const raisePower = function (a, b) {
    return a ** b;
  };
  console.log(`9^3 = ${raisePower(9, 3)}`);

  // Arrow Function
  const calculateSquareRoot = (value) => value ** (1 / 2);
  console.log(`√16 = ${calculateSquareRoot(16)}`);

  // Function calling other function / Recursive
  function generateFibonnaci(a, b, n) {
    if (n <= 0) return "";
    return ` -> ${a + b} ${generateFibonnaci(b, a + b, n - 1)}`;
  }

  function printFibonacci(n) {
    let a = 0,
      b = 1;
    return `${a} -> ${b}${generateFibonnaci(a, b, n - 2)}`;
  }
  console.log(`Fibonacci(10): ${printFibonacci(10)}`);
}

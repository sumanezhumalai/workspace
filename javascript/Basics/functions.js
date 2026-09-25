"use strict";

// ============================================================
//  FUNCTIONS — Declaration, Expression, Arrow, Recursion
// ============================================================
// CONCEPTS TO REMEMBER:
// • Function Declaration: hoisted, can be called before definition
// • Function Expression: stored in variable, NOT hoisted
// • Arrow Function: concise syntax, lexical 'this' binding
// • Recursion: function calling itself with base case to prevent infinite loop
// • Parameters vs Arguments: parameters are placeholders, arguments are actual values
// ============================================================

export function run() {
  // ========== Function Declaration ==========
  // Can be called BEFORE declaration due to hoisting
  function calculateAge(birthYear) {
    const currentYear = new Date().getFullYear();
    console.log(`Current Year : ${currentYear}`);
    return currentYear - birthYear;
  }
  console.log(`Age : ${calculateAge(2004)}`);

  // ========== Function Expression ==========
  // Anonymous function stored in a variable
  // NOT hoisted — must be defined before use
  const raisePower = function (a, b) {
    return a ** b;
  };
  console.log(`9^3 = ${raisePower(9, 3)}`);

  // ========== Arrow Function ==========
  // Concise syntax, implicit return for single expressions
  // Does NOT have its own 'this' context
  const calculateSquareRoot = (value) => value ** (1 / 2);
  console.log(`√16 = ${calculateSquareRoot(16)}`);

  // ========== Recursion ==========
  // Function calling itself — must have base case to stop
  function generateFibonnaci(a, b, n) {
    if (n <= 0) return ""; // Base case
    return ` -> ${a + b} ${generateFibonnaci(b, a + b, n - 1)}`;
  }

  function printFibonacci(n) {
    let a = 0,
      b = 1;
    return `${a} -> ${b}${generateFibonnaci(a, b, n - 2)}`;
  }
  console.log(`Fibonacci(10): ${printFibonacci(10)}`);
}

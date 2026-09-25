"use strict";

// ============================================================
//  ARRAYS — Creation, Manipulation, and Methods
// ============================================================
// CONCEPTS TO REMEMBER:
// • Arrays are zero-indexed, heterogeneous (can mix types)
// • Mutating methods: push(), pop(), shift(), unshift(), splice()
// • Non-mutating: indexOf(), includes(), slice(), concat()
// • push/unshift return NEW length; pop/shift return REMOVED element
// • includes() uses strict equality (===) — type matters!
// • length property reflects array size dynamically
// ============================================================

export function run() {
  // ========== Array Creation & Access ==========
  // JS arrays are heterogeneous — can hold different types
  const hetero = ["Suman", 764, true];
  console.log(hetero);

  console.log("Value at index 0 : " + hetero[0]);
  console.log(`Initial length : ${hetero.length}`);

  // ========== Add Elements ==========
  // push() — add at END (returns updated length)
  let pushReturns = hetero.push("jobless");
  console.log(`after PUSH (returns updated length) : ${pushReturns}`);
  console.log(hetero);

  // unshift() — add at START (returns updated length)
  let unshiftReturns = hetero.unshift("ID1");
  console.log(`after UNSHIFT (returns updated length) : ${unshiftReturns}`);
  console.log(hetero);

  // ========== Remove Elements ==========
  // pop() — remove from END (returns removed element)
  let popReturns = hetero.pop();
  console.log(`after POP (returns popped element) : ${popReturns}`);
  console.log(hetero);

  // shift() — remove from START (returns removed element)
  let shiftReturns = hetero.shift();
  console.log(`after SHIFT (returns removed element) : ${shiftReturns}`);
  console.log(hetero);

  // ========== Search & Check ==========
  // indexOf() — finds the index of element (-1 if not found)
  let index = hetero.indexOf(764);
  console.log(`the index of 764 : ${index}`);

  // includes() — boolean check using strict equality (===)
  console.log(`check if 764 exits : ${hetero.includes(764)}`); // true
  console.log(`check if '764' exits : ${hetero.includes("764")}`); // false — type mismatch

  console.log("Array elements -> " + hetero);
}

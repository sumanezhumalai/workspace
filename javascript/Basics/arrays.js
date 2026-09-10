"use strict";

export function run() {
  // Heterogeneous array — JS arrays can hold different types
  const hetero = ["Suman", 764, true];
  console.log(hetero);

  // Access
  console.log("Value at index 0 : " + hetero[0]);
  console.log(`Initial length : ${hetero.length}`);

  // Push — add at last (returns updated length)
  let pushReturns = hetero.push("jobless");
  console.log(`after PUSH (returns updated length) : ${pushReturns}`);
  console.log(hetero);

  // Unshift — add at first (returns updated length)
  let unshiftReturns = hetero.unshift("ID1");
  console.log(`after UNSHIFT (returns updated length) : ${unshiftReturns}`);
  console.log(hetero);

  // Pop — remove at last (returns removed element)
  let popReturns = hetero.pop();
  console.log(`after POP (returns popped element) : ${popReturns}`);
  console.log(hetero);

  // Shift — remove at first (returns removed element)
  let shiftReturns = hetero.shift();
  console.log(`after SHIFT (returns removed element) : ${shiftReturns}`);
  console.log(hetero);

  // indexOf — finds the index of the element
  let index = hetero.indexOf(764);
  console.log(`the index of 764 : ${index}`);

  // includes — check if element exists (follows Strict Equality ===)
  console.log(`check if 764 exits : ${hetero.includes(764)}`);
  console.log(`check if '764' exits : ${hetero.includes("764")}`);

  console.log("Array elements -> " + hetero);
}

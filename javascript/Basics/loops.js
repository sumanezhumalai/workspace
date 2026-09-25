"use strict";

// ============================================================
//  LOOPS — for, for...of, forEach, while
// ============================================================
// CONCEPTS TO REMEMBER:
// • for loop: traditional, full control (init, condition, increment)
// • for...of: iterates over ITERABLE values (arrays, strings, sets, maps)
// • forEach(): array method, cannot break/continue
// • while: runs while condition is true, useful for unknown iterations
// • continue: skip current iteration; break: exit loop entirely
// • .entries() returns [index, value] pairs for iteration
// ============================================================

export function run() {
  const details = [
    "Suman",
    "Ezhuamalai",
    true,
    "9159468801",
    new Date("2004-10-28"),
    false,
    NaN,
    ["Java", "JavaScript", "HTML", "CSS"],
  ];

  // ========== Traditional for Loop ==========
  // for (let rep = 1; rep <= 10; rep++) { // variable must be 'let' (block-scoped)
  //     console.log(`FOR loop , currently at ${rep}`)
  // }

  // const types = [];

  // for(let i = 0; i < details.length; i++){
  //     if(typeof details[i] == 'number' || typeof details[i] == 'boolean') continue;
  //     console.log(details[i], typeof details[i]);
  //     types.push(typeof details[i])
  // }

  // ========== for...of Loop ==========
  // Modern ES6 syntax for iterating over iterables
  for (const val of details) console.log(val); // Simple value iteration — NO index access

  // Workaround for index access using .entries()
  for (const val of details.entries()) console.log(val); // Returns [index, value] pairs

  // Destructure for cleaner code
  for (const [index, value] of details.entries()) {
    console.log(`${index + 1}: ${value}`);
  }

  // ========== forEach Method ==========
  // Array method — cannot use break/continue
  // types.forEach(element => {
  //     console.log(element);
  //     console.log();
  // });

  // ========== while Loop ==========
  // Runs as long as condition is true — useful for unknown iteration count
  // let i = 1;

  // while (i <= 10) {
  //     console.log(details[i], typeof details[i]);
  //     i++;
  // }

  // let dice = Math.round(Math.random() * 6);

  // while (dice !== 6) {
  //   console.log(`You rolled ${dice}`);
  //   dice = Math.round(Math.random() * 6);
  //   if (dice == 6) console.log("Leaving loop as per the condition ...");
  // }
}

run();
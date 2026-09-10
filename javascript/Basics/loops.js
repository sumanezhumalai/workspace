"use strict";

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

  //for loop
  // for (let rep = 1; rep <= 10; rep++) { // the variable must be declared as 'let'
  //     console.log(`FOR loop , currently at ${rep}`)
  // }

  // const types = [];

  // for(let i = 0; i < details.length; i++){
  //     if(typeof details[i] == 'number' || typeof details[i] == 'boolean') continue;
  //     console.log(details[i], typeof details[i]);
  //     types.push(typeof details[i])
  // }

  //for of loop
  for (const val of details) console.log(val); //cannnot access index in for-of loop
  //workaround
  for (const val of details.entries()) console.log(val); //this will provide key-pair (index,value)
  //destructure the val for ease of use
  for (const [index, value] of details.entries()) {
    console.log(`${index + 1}: ${value}`);
  }

  // For Each
  // types.forEach(element => {
  //     console.log(element);
  //     console.log();
  // });

  //While Loop
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
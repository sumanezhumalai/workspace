"use strict";
// ============================================================
//  PROBLEM: String Manipulation Challenges
// ============================================================
// PRACTICE CONCEPTS:
// • String methods: split(), replace(), trim(), toLowerCase()
// • Regular expressions: /pattern/flags
// • Array destructuring and iteration
// • Template literals and string interpolation
// • padEnd() for formatting
// ============================================================

// export function run() {
///////////////////////////////////////
// Coding Challenge #4
/*
Write a program that receives a list of variable names written in underscore_case and convert them to camelCase.

The input will come from a textarea inserted into the DOM (see code below), and conversion will happen when the button is pressed.

THIS TEST DATA (pasted to textarea)
underscore_case
 first_name
Some_Variable
  calculate_AGE
delayed_departure

SHOULD PRODUCE THIS OUTPUT (5 separate console.log outputs)
underscoreCase      ✅
firstName           ✅✅
someVariable        ✅✅✅
calculateAge        ✅✅✅✅
delayedDeparture    ✅✅✅✅✅

HINT 1: Remember which character defines a new line in the textarea 😉
HINT 2: The solution only needs to work for a variable made out of 2 words, like a_b
HINT 3: Start without worrying about the ✅. Tackle that only after you have the variable name conversion working 😉
HINT 4: This challenge is difficult on purpose, so start watching the solution in case you're stuck. Then pause and continue!

Afterwards, test with your own test data!

GOOD LUCK 😀
*/

// document.body.append(document.createElement("textarea"));
// document.body.append(document.createElement("button"));

// const button = document.querySelector("button");
// button.textContent = "Convert";

// button.addEventListener("click", convert);

// function convert() {
//   const text = document.querySelector("textarea").value;
//   const str = text.split("\n");
//   for (const s of str) {
//     const cleanstr = s.trim().toLowerCase();
// let index = cleanstr.indexOf("_");
// let result = cleanstr.replace(
//   cleanstr.charAt(index++),
//   cleanstr.charAt(index++).toUpperCase(),
// );
// console.log(result);
//   const [first, second] = cleanstr.split("_");
//   const camelSecond = second.replace(second[0], second[0].toUpperCase());
//   console.log(`${(first + camelSecond).padEnd(30)} ✅`);
// }

/*
///////////////////////////////////////
// String Methods Practice


// 🔴 Delayed Departure from FAO to TXL (11h25)
//              Arrival from BRU to FAO (11h45)
//   🔴 Delayed Arrival from HEL to FAO (12h05)
//            Departure from FAO to LIS (12h30)

const getCode = str => str.slice(0, 3).toUpperCase();

for (const flight of flights.split('+')) {
  const [type, from, to, time] = flight.split(';');
  const output = `${type.startsWith('_Delayed') ? '🔴' : ''}${type.replaceAll(
    '_',
    ' '
  )} ${getCode(from)} ${getCode(to)} (${time.replace(':', 'h')})`.padStart(36);
  console.log(output);
}*/

const flights =
  "_Delayed_Departure;fao93766109;txl2133758440;11:25+_Arrival;bru0943384722;fao93766109;11:45+_Delayed_Arrival;hel7439299980;fao93766109;12:05+_Departure;fao93766109;lis2323639855;12:30";

const data = flights.split("+");

for (const row of data) {
  let result = "";
  let [first, second, third, fourth] = row.split(";");

  first = first.replaceAll("_", " ").trim();
  second = second.replaceAll(/[^a-z]/g, "").toUpperCase();
  third = third.replaceAll(/[^a-z]/g, "").toUpperCase();
  fourth = fourth.replace(":", "h");

  console.log(
    `${first.includes("Delayed") ? "🔴" : ""} ${first} ${second} ${third} (${fourth})`,
  );
}

// }
// run();

"use strict";
export function run() {
  function calcAmplitude(temps) {
    let min = Infinity;
    let max = -Infinity;

    debugger;
    for (const temp of temps) {
      if (typeof temp !== "number" || Number.isNaN(temp)) continue;
      if (temp < min) min = temp;
      if (temp > max) max = temp;
    }
    console.log(min, max);
    return max - min;
  }

  //two arrays
  function calcTempsAmplitude(temp1, temp2) {
    const temps = temp1.concat(temp2);
    let min = Infinity;
    let max = -Infinity;

    for (const temp of temps) {
      if (typeof temp !== "number" || Number.isNaN(temp)) continue;
      if (temp < min) min = temp;
      if (temp > max) max = temp;
    }
    console.log(min, max);

    return max - min;
  }

  function printForecast(temps) {
    let str = "... ";
    for (let index = 0; index < temps.length; index++) {
      str += `${temps[index]} in ${index + 1} days ... `;
    }
    console.log(str);
  }

  // const temp1 = [3, -2, -6, -1, "error", 9, 13, 17, 15, 14, 9, 5];
  // const temp2 = ["error", 9, 13, 34, 77, -11];
  // console.log(calcAmplitude(temp1));
  // console.log(" ");
  // console.log(calcTempsAmplitude(temp1, temp2));

  const temps = [17, 21, 23];
  printForecast(temps);
}

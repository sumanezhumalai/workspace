"use strict";

// ============================================================
//  PROBLEM: Temperature Converter (Celsius to Kelvin)
// ============================================================
// PRACTICE CONCEPTS:
// • User input with prompt()
// • Type conversion with Number()
// • Object creation and manipulation
// • Console.table() for formatted output
// ============================================================

export function run() {
  const convertToKelvin = function () {
    const measurement = {
      type: "temp",
      unit: "celsius",
      value: Number(prompt("Degree celsius: ")),
    };

    console.table(measurement);

    const kelvin = measurement.value + 273;

    return kelvin;
  };

  console.log(convertToKelvin());
}

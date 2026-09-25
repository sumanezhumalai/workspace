"use strict";

// ============================================================
//  JAVASCRIPT BASICS — Variables, Template Literals, Type Conversion
// ============================================================
// CONCEPTS TO REMEMBER:
// • let/const for variable declaration (let = mutable, const = immutable)
// • Template Literals use backticks `` with ${} for interpolation
// • Type Conversion: explicit (Number(), String(), Boolean())
// • Type Coercion: implicit conversion (string + number = string)
// • NaN is a special "number" type representing invalid number operations
// ============================================================

export function run() {
  // ========== Variables & Template Literals ==========
  // Template literals allow embedded expressions and multi-line strings
  let adjective = "amazing";
  let isFun = true;
  let fullName = "JavaScript";

  const result = `Hi! I'm ${fullName} and im ${adjective} . im Fun , yes its ${isFun}.`;
  console.log(result);

  // ========== Type Coercion & Conversion ==========
  // Explicit conversion vs implicit coercion
  let year = "1998";
  const num = 537858;

  console.log(Number(year) + 15); // Explicit: String → Number
  console.log(Number(fullName), typeof NaN); // Invalid conversion results in NaN (type: "number")
  console.log(String(num), num + "", num); // Explicit and implicit String conversion

  // Type coercion examples
  console.log("1" + 1); // 11 — + operator coerces number to string
  console.log(1 + "1"); // 11 — same behavior
}

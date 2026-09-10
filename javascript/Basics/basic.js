"use strict";

export function run() {
  // Variables & Template Literals
  let adjective = "amazing";
  let isFun = true;
  let fullName = "JavaScript";

  const result = `Hi! I'm ${fullName} and im ${adjective} . im Fun , yes its ${isFun}.`;
  console.log(result);

  // Type Coercion & Conversion
  let year = "1998";
  const num = 537858;

  console.log(Number(year) + 15);
  console.log(Number(fullName), typeof NaN);
  console.log(String(num), num + "", num);

  console.log("1" + 1); // 11
  console.log(1 + "1"); // 11
}

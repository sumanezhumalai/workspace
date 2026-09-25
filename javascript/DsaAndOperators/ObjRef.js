// ============================================================
//  OBJECT REFERENCES — Primitive vs Reference Types, Copying
// ============================================================
// CONCEPTS TO REMEMBER:
// • Primitives (string, number, boolean, null, undefined, symbol, bigint) are COPIED by value
// • Objects (objects, arrays, functions) are COPIED by reference
// • Assignment copies reference, not object — both variables point to same object
// • Shallow copy: copies top level only — nested objects still share references
// • Deep copy: recursively copies all nested levels — completely independent
// • Shallow copy methods: {...obj}, Object.assign(), [...arr]
// • Deep copy: structuredClone() (modern), JSON.parse(JSON.stringify()) (legacy, limitations)
// ============================================================

export function run() {
  const alex = {
    firstName: "Alex",
    lastName: "Rivera",
  };
  const suman = {
    firstName: "Suman",
    lastName: "Ezhuamalai",
  };
  const jessica = {
    firstName: "Jessica",
    lastName: "Roman",
    family: ["alex", "madina"],
  };

  // ========== Object Reference (Same Reference) ==========
  // Assignment copies REFERENCE, not the object itself
  //   const marriedJessica = jessica; // Both variables point to same object
  //   marriedJessica.lastName = "Suman"; // Modifies the original object

  //   console.log("Before", jessica);
  //   console.log("After", marriedJessica); // Both show updated lastName

  // ========== Shallow Copy ==========
  // Copies top-level properties, but nested objects remain shared references
  //   const jessicaCopy = { ...jessica }; // Spread creates shallow copy
  //   jessicaCopy.lastName = "Suman"; // Does NOT affect original (top-level property)
  //   jessicaCopy.family.push("Suman"); // DOES affect original (nested reference)

  //   console.log(jessica); // family array is also updated in original
  //   // Arrays are objects — their reference is copied, not the array itself
  //   console.log(jessicaCopy);

  // ========== Deep Copy ==========
  // Recursively copies all nested levels — completely independent objects
  const jessicaCloned = structuredClone(jessica); // Modern deep clone method
  jessicaCloned.lastName = "Suman"; // Independent change
  jessicaCloned.family.push("Suman"); // Independent change — doesn't affect original

  console.log(jessica); // Original unchanged
  console.log(jessicaCloned); // Cloned copy with modifications
}

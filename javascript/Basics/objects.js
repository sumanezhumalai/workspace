"use strict";

// ============================================================
//  OBJECTS — Creation, Access, Methods, Dynamic Properties
// ============================================================
// CONCEPTS TO REMEMBER:
// • Objects store key-value pairs (properties can be any type)
// • Two access patterns: dot notation (obj.prop) and bracket notation (obj['prop'])
// • Bracket notation allows computed/dynamic keys and expressions
// • Dot notation is cleaner but requires valid identifiers
// • Methods are functions stored as object properties
// • 'this' keyword refers to the object calling the method
// • Objects are mutable — can add/modify properties anytime
// ============================================================

export function run() {
  // ========== Object Creation ==========
  // Objects use {} with key-value pairs (properties & methods)
  const suman = {
    firstName: "Suman",
    lastName: "Ezhuamalai",
    phoneNumber: "9159468801",
    dob: new Date("2004-10-28"),
    skills: ["Java", "JavaScript", "HTML", "CSS"],

    calcAge: function () {
      const today = new Date();
      let age = today.getFullYear() - this.dob.getFullYear();
      const monthdiff = today.getMonth() - this.dob.getMonth();
      if (
        monthdiff < 0 ||
        (monthdiff === 0 && today.getDate < this.dob.getDate)
      ) {
        age--;
      }
      this.age = age; // Creating property dynamically to cache calculated value

      return age;
    },
  }; // Properties auto-arrange alphabetically in console display

  // ========== Access Patterns ==========
  console.log(suman);
  console.log(suman.calcAge());
  console.log(suman.skills[0]); // Nested array access
  console.log(suman.phoneNumber); // Dot notation

  // ========== Bracket Notation (Dynamic Access) ==========
  console.log(suman["age"]); // Bracket notation — allows expressions

  const Namekey = "Name";
  console.log(suman["first" + Namekey]); // Expression evaluates to "firstName"
  console.log(suman["last" + Namekey]); // Expression evaluates to "lastName"

  // const query = prompt("what property do you wanna get for Suman ? ");
  // console.log(suman[query]) // Bracket notation required for dynamic keys
  // NOTE: suman.query would look for literal property "query" — throws error!

  // ========== Adding New Properties ==========
  // Objects are mutable — can add properties anytime
  suman.isEmployed = false;
  suman["location"] = "Puducherry";
  console.log(suman);
}

// ============================================================
//  THIS KEYWORD — Context, Arrow Functions, Arguments
// ============================================================
// CONCEPTS TO REMEMBER:
// • 'this' in METHOD: refers to the object calling the method
// • 'this' in REGULAR FUNCTION (strict mode): undefined
// • 'this' in ARROW FUNCTION: lexically bound to parent scope (inherits from outer context)
// • Arrow functions DON'T have their own 'this' — use for callbacks inside methods
// • Never use arrow functions as object methods if you need 'this'
// • 'arguments' keyword: available in regular functions, NOT in arrow functions
// • 'use strict' makes 'this' undefined in global context (not window object)
// ============================================================

// 'use strict'; // Already using 'use strict' by default

export function run() {
  // console.log(this); // In strict mode: undefined (not window object)

  // ========== Object Examples ==========
  const alex = {
    firstName: "Alex",
    lastName: "Rivera",
    phoneNumber: "9876543210",
    dob: new Date("2004-10-28"),
    skills: ["Python", "TypeScript", "React", "Node.js"],

    displayThis: function () {
      console.log(this); // 'this' = alex object (caller)
    },
  };

  const suman = {
    firstName: "Suman",
    lastName: "Ezhuamalai",
    phoneNumber: "9159468801",
    dob: new Date("2004-10-28"),
    skills: ["Java", "JavaScript", "HTML", "CSS"],

    displayThis: function () {
      console.log(this); // 'this' = suman object (caller)
    },

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

      // ========== THIS Problem in Regular Function ==========
      //   const isGenz = function () {
      //     console.log(this); // undefined — regular function in strict mode
      //     // In non-strict mode, this would be 'window' object
      //     // In strict mode, 'this' is undefined

      // if (this.dob.getFullYear() >= 2001 && this.dob.getFullYear() <= 2016) {
      //   console.log("You are a GenZ"); // ERROR: cannot access 'dob' of undefined
      // }
      //   };

      // ========== Solution: Arrow Function ==========
      // Arrow functions inherit 'this' from surrounding scope (lexical this)
      const isGenz = () => {
        console.log(this); // Arrow function inherits 'this' from calcAge method
        // Here, 'this' = suman object (one level up in scope chain)

        if (this.dob.getFullYear() >= 2001 && this.dob.getFullYear() <= 2016) {
          console.log("You are a GenZ");
        }
      };

      this.age = age; // Cache calculated age as property

      isGenz(); // Call inner function (uses parent 'this')

      return age;
    },

    // ========== Arrow Function as Method (WRONG) ==========
    greet: () => {
      // Arrow functions DON'T have their own 'this'
      console.log(this); // undefined (inherits from global, which is undefined in strict mode)
      console.log(`Hi!, I'm ${this.firstName}`); // ERROR — cannot read property of undefined
    },
  };

  console.log(suman.calcAge());
  //   suman.greet();  // Will throw error — arrow function method has no proper 'this'

  //   console.log(alex.calcAge()); // Would error — alex has no calcAge method

  //   console.log(suman.calcAge === alex.calcAge); // false — alex has no calcAge property
  //   suman.displayThis();
  //   alex.displayThis();

  // ========== Arguments Keyword ==========
  // Available ONLY in regular functions (not arrow functions)
  const raisePower = function (a, b) {
    console.log(arguments); // Array-like object containing all passed arguments
    return a ** b;
  };

  console.log(raisePower(9, 3));
}

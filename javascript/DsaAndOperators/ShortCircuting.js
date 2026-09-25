// ============================================================
//  SHORT-CIRCUITING — OR (||), AND (&&), Nullish Coalescing (??)
// ============================================================
// CONCEPTS TO REMEMBER:
// • OR (||): returns first TRUTHY value or last value if all falsy
// • AND (&&): returns first FALSY value or last value if all truthy
// • Nullish Coalescing (??): checks for NULL/UNDEFINED only (not 0 or '')
// • OR/AND can return ANY type, not just boolean
// • Use || to set default values (but watch for 0, '', false)
// • Use ?? for numeric defaults where 0 is valid
// • Use && to check existence before executing
// • Falsy values: false, 0, '', null, undefined, NaN
// • Nullish values: null, undefined (NOT 0 or '')
// ============================================================

export function run() {
  const restaurant = {
    name: "Classico Italiano",
    location: "Via Angelo Tavanti 23, Firenze, Italy",
    categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
    starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
    mainMenu: ["Pizza", "Pasta", "Risotto"],

    openingHours: {
      thu: {
        open: 12,
        close: 22,
      },
      fri: {
        open: 11,
        close: 23,
      },
      sat: {
        open: 0, // Open 24 hours
        close: 24,
      },
    },

    order: function (starterIndex, mainIndex) {
      return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
    },
    standardOrder: function (dish1, dish2, dish3) {
      console.log(
        `Your Standard order\'s includes ${dish1} , ${dish2} and ${dish3}`,
      );
    },
  };

  // ========== OR Operator (||) ==========
  // Returns first TRUTHY value or last value if all falsy
  // Can use ANY data type, return ANY data type
  console.log("--- OR ---");
  console.log(3 || "Suman"); // 3 (first truthy) — short-circuits, never checks "Suman"
  console.log("" || "Suman"); // "Suman" (first truthy after falsy "")
  console.log(true || 0); // true (first truthy)
  console.log(undefined || null); // null (last value, both falsy)

  console.log(undefined || 0 || "" || "Hello" || 23 || null); // "Hello" (first truthy)

  // ========== OR for Default Values ==========
  //   restaurant.numGuests = 20;
  //   const guests1 = restaurant.numGuests ? restaurant.numGuests : 10; // Ternary condition
  //   console.log(guests1);

  restaurant.numGuests = 0;
  const guests2 = restaurant.numGuests || 10; // PROBLEM: 0 is falsy, returns 10 instead of 0
  console.log(guests2); // 10 (incorrect when 0 is valid value)

  console.log("\n\n");

  // ========== Nullish Coalescing Operator (??) ==========
  // NOTE: Both methods above fail when value is 0 but valid
  // ?? checks for NULLISH values (null, undefined) NOT falsy (0, '', false)
  console.log("--- Nullish Coalescing Operator ?? ---");
  restaurant.numGuests = 0;
  const guests3 = restaurant.numGuests ?? 10; // Correct: 0 is NOT nullish
  console.log(guests3); // 0 (correct)

  console.log("\n\n\n");

  // ========== AND Operator (&&) ==========
  // Returns first FALSY value or last value if all truthy
  console.log("--- AND ---");

  console.log(0 && "Suman"); // 0 (first falsy) — short-circuits, skips rest
  console.log("" && "Suman"); // "" (first falsy)
  console.log(true && 0); // 0 (first falsy after truthy)
  console.log(undefined && null); // undefined (first falsy)
  console.log(true && 1 && "Hello" && 23 && null && undefined); // null (first falsy)

  // ========== AND for Conditional Execution ==========
  // Traditional if statement
  if (restaurant.orderPizza) {
    restaurant.orderPizza("mushrooms", "spinach");
  }

  // Short-circuit alternative — executes only if first operand is truthy
  console.log(
    restaurant.orderPizza && restaurant.orderPizza("mushrooms", "spinach"),
  );

  // ========== Practical Summary ==========
  // • Use || or ?? to set default values
  // • Use ?? when 0, '', false are valid values (checks only null/undefined)
  // • Use && to check existence before executing (if truthy, execute 2nd operand)
}

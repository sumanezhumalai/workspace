// ============================================================
//  REST PATTERN & PARAMETERS — Collecting into Arrays/Objects
// ============================================================
// CONCEPTS TO REMEMBER:
// • REST looks like SPREAD (...) but does the OPPOSITE
// • SPREAD: expands (on RIGHT of =) → ...arr becomes 1, 2, 3
// • REST: collects (on LEFT of =) → [a, ...rest] collects remaining into array
// • REST must be LAST in destructuring — [a, ...rest, b] is invalid
// • Skipped elements are NOT collected — [a, , ...rest] skips 2nd element
// • Rest parameters allow unlimited function arguments: function(...args)
// • Rest parameters do NOT support default values directly
// • Only ONE rest element allowed per destructure
// ============================================================

export function run() {
  // ========== Sample Data ==========
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

    orderDelivery: function ({
      starterIndex = 1,
      mainIndex = 0,
      time,
      address,
    }) {
      console.log(
        `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}.`,
      );
    },

    standardOrder: function (dish1, dish2, dish3) {
      console.log(
        `Your Standard order\'s includes ${dish1} , ${dish2} and ${dish3}`,
      );
    },

    orderPizza: function (mainIng, ...otherIng) {
      // Rest parameter collects all remaining arguments into array
      // Rest parameters do NOT support default initializers — workaround inside function
      //   otherIng = otherIng.length === 0 ? ["none"] : otherIng;
      console.log(
        `Pizza Type: ${mainIng}, AddOns: ${(otherIng.length === 0 ? ["none"] : otherIng).join(", ")} `,
      );
    },
  };

  // ========== SPREAD vs REST ==========
  // SPREAD — on RIGHT side of = (expands)
  const arr = [1, 2, ...[3, 4]]; // Spread distributes array elements
  console.log(arr);

  // REST — on LEFT side of = (collects)
  const [a, b, ...others] = [1, 2, 3, 4, 5]; // Rest collects remaining elements
  console.log(a, b, others); // 1, 2, [3, 4, 5]

  // ========== REST Pattern Rules ==========
  // REST does NOT collect skipped elements — only collects AFTER last assignment
  const [x, , y, ...rest] = [...restaurant.starterMenu, ...restaurant.mainMenu];
  console.log(x, y, rest); // Skips 2nd element, collects rest

  // Only ONE rest element allowed per destructure
  // const [a, ...middle, b] = [1, 2, 3, 4]; // INVALID — rest must be last

  // ========== REST with Objects ==========
  const { sat, ...weekdays } = { ...restaurant.openingHours }; // Exclude 'sat', collect rest
  console.log(weekdays); // {thu: {...}, fri: {...}}

  // ========== REST Parameters in Functions ==========
  // Variadic functions — accept unlimited arguments
  const add = function (...nums) {
    let sum = 0;
    nums.forEach((e) => {
      sum += e;
    });
    return sum;
  };

  console.log(add(1, 2, 3, 5, 6, 6, 5, 7, 8, 32)); // All args collected into 'nums' array

  restaurant.orderPizza(
    "chicken",
    "pineapple",
    "cheese",
    "peanut",
    "Red Saurce",
  );
  restaurant.orderPizza("pineapples"); // otherIng will be empty array []
}

"use strict";

// ============================================================
//  ARRAY DESTRUCTURING — Unpacking Arrays into Variables
// ============================================================
// CONCEPTS TO REMEMBER:
// • Destructuring unpacks array elements into individual variables
// • Order matters — variables match array positions left-to-right
// • Skip elements using commas with spaces: [a, , b]
// • Swap variables without temp: [a, b] = [b, a]
// • Default values prevent undefined: [a = 0, b = 0] = [10]
// • Works with nested arrays: [a, [b, c]] = [1, [2, 3]]
// • Commonly used with function returns: const [x, y] = getCoordinates()
// ============================================================

export function run() {
  const flights =
    "_Delayed_Departure;fao93766109;txl2133758440;11:25+_Arrival;bru0943384722;fao93766109;11:45+_Delayed_Arrival;hel7439299980;fao93766109;12:05+_Departure;fao93766109;lis2323639855;12:30";

  const italianFoods = new Set([
    "pasta",
    "gnocchi",
    "tomatoes",
    "olive oil",
    "garlic",
    "basil",
  ]);

  const mexicanFoods = new Set([
    "tortillas",
    "beans",
    "rice",
    "tomatoes",
    "avocado",
    "garlic",
  ]);

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
  };

  // ========== Basic Destructuring ==========
  const arr = [3, 4, 5];

  const [x, y, z] = arr; // Unpack array into separate variables
  console.log(x, y, z);

  // ========== Skip Elements ==========
  // Use commas with spaces to skip unwanted elements
  let [a, , b, c] = restaurant.categories; // Skips 2nd element

  console.log(a, b, c);

  // ========== Swapping Variables ==========
  // Swap without temporary variable
  [b, a, c] = [a, b, c];
  console.log(a, b, c);

  // ========== Destructure Function Return ==========
  // Common use case: unpack array returned from function
  const [starter, main] = restaurant.order(2, 0);

  console.log(starter, main);

  // ========== Nested Array Destructuring ==========
  const nested = [2, 4, [5, 6]];
  const [i, j, [k, l]] = nested; // Destructure inner array

  console.log(i, j, k, l);

  // ========== Default Values ==========
  // Prevent undefined by providing fallback values
  const [m = 0, n = 0, o = 0, p = 0] = [a, b]; // o and p get default 0
  console.log(m, n, o, p);
}

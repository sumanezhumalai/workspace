// ============================================================
//  SPREAD OPERATOR (...) — Expanding Iterables
// ============================================================
// CONCEPTS TO REMEMBER:
// • Spread operator: ... (expands iterables into individual elements)
// • Works on iterables: arrays, strings, maps, sets, NOT objects (objects since ES2018)
// • Used where comma-separated values expected: function args, array literals
// • CANNOT use in template literals ${...arr} — syntax error
// • On RIGHT side of = (opposite of REST which is on LEFT)
// • Creates shallow copies — nested references still shared
// • Common uses: copy arrays, merge arrays, pass array as function args
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
  };

  // ========== Basic Spread Operator ==========
  // Expands array elements into individual comma-separated values
  const arr = [1, 2, 3];
  const newArr = [-1, 0, ...arr]; // Distributes arr elements into new array

  console.log(newArr); // Prints as Array object: [-1, 0, 1, 2, 3]
  console.log(...newArr); // Prints individual elements: -1 0 1 2 3

  // ========== Copy Array ==========
  // Creates shallow copy — changes don't affect original
  const newMenu = [...restaurant.mainMenu, "Gnocci"];
  console.log(newMenu);

  // ========== Merge Arrays ==========
  const menu = [...restaurant.starterMenu, ...restaurant.mainMenu];

  // ========== Spread with Strings ==========
  // Strings are iterable — spread into individual characters
  const str = "Suman";
  let name = [...str, " ", ".", "E"];
  console.log(name); // ['S', 'u', 'm', 'a', 'n', ' ', '.', 'E']
  console.log(...name); // S u m a n  . E
  // console.log(`${...name} Ezhumalai`); // ERROR — Spread doesn't work in template literals

  // ========== Spread in Function Arguments ==========
  // Pass array elements as separate arguments
  restaurant.standardOrder(...restaurant.mainMenu); // Expands to: standardOrder("Pizza", "Pasta", "Risotto")

  // ========== Spread with Objects (ES2018+) ==========
  // Spread objects to create shallow copies or merge properties
  const newRestaurant = {
    ...restaurant, // Copy all properties from restaurant
    founder: "Suman Ezhumalai", // Add new properties
    foundingYear: 1960,
  };
  console.log(newRestaurant);
}

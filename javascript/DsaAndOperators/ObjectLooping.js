// ============================================================
//  OBJECT LOOPING — Iterating Over Object Properties
// ============================================================
// CONCEPTS TO REMEMBER:
// • Objects are NOT directly iterable (unlike arrays)
// • Object.keys(obj) — returns array of property names (keys)
// • Object.values(obj) — returns array of property values
// • Object.entries(obj) — returns array of [key, value] pairs
// • Use for...of with Object.entries() for key-value iteration
// • Destructure in loop: for (const [key, value] of Object.entries(obj))
// • Only iterates over enumerable own properties (not inherited)
// ============================================================

export function run() {
  const weekdays = ["mon", "tue", "wed", "thu", "fri", "sat", "sun"];

  const openingHours = {
    [weekdays[3]]: {
      open: 12,
      close: 22,
    },
    [weekdays[4]]: {
      open: 11,
      close: 23,
    },
    [weekdays[6]]: {
      open: 0,
      close: 24,
    },
  };

  const restaurant = {
    name: "Classico Italiano",
    location: "Via Angelo Tavanti 23, Firenze, Italy",
    categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
    starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
    mainMenu: ["Pizza", "Pasta", "Risotto"],
    openingHours,

    order(starterIndex, mainIndex) {
      return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
    },

    orderDelivery({ starterIndex = 1, mainIndex = 0, time, address }) {
      console.log(
        `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}.`,
      );
    },
  };

  // ========== Object.keys() — Property Names ==========
  // Returns array of object's property names (keys)
  const properties = Object.keys(restaurant);
  console.log(properties);

  // ========== Object.values() — Property Values ==========
  // Returns array of object's values (not keys)
  const values = Object.values(restaurant);
  console.log(values);

  // ========== Object.entries() — Key-Value Pairs ==========
  // Returns array of [key, value] pairs — most useful for iteration
  const objectDetail = Object.entries(restaurant);
  console.log("---- Object Entries ----");
  console.log(objectDetail);

  // Iterate over object with destructuring
  for (const [prop, values] of objectDetail) {
    console.log(`Restaurent detail ->  Property: ${prop}, Value: ${values}`);
  }
}
run();

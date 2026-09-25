// ============================================================
//  OPTIONAL CHAINING (?.) — Safe Property Access (ES2020)
// ============================================================
// CONCEPTS TO REMEMBER:
// • Optional chaining: ?. safely accesses nested properties
// • Returns undefined if property doesn't exist (instead of throwing error)
// • Works with objects, arrays, and function calls
// • Combine with nullish coalescing (??) for default values
// • Syntax: obj?.prop, obj?.[expr], obj?.method(), arr?.[index]
// • Short-circuits: stops evaluation if left side is nullish
// • Replaces multiple nested if checks or && chains
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

  // ========== The Problem (Without Optional Chaining) ==========
  // Need multiple existence checks to avoid errors
  if (restaurant.openingHours && restaurant.openingHours.mon) {
    console.log(restaurant.openingHours.mon.open); // Safe but verbose
  }

  // ========== With Optional Chaining ==========
  // Safely access nested properties — returns undefined if any part is nullish
  console.log(restaurant.openingHours?.mon?.open); // undefined (no error)

  // ========== Practical Use Case ==========
  // Loop through weekdays and safely check opening hours
  for (const day of weekdays) {
    // Combine optional chaining with nullish coalescing and OR operator
    console.log(
      `Day: ${day} ->  ${(restaurant.openingHours?.[day]?.open ?? "IS Open") || "Is not Open"}`,
    );
    // ?.[day] — optional chaining with computed property
    // ?? — nullish coalescing for default value
    // || — final fallback for truthy check
  }

  // ========== Optional Chaining with Methods ==========
  // Check if method exists before calling
  console.log(restaurant?.order?.(0, 1) ?? "couldn't order");
  // First ?. checks restaurant exists
  // Second ?. checks order method exists
  // If either is nullish, returns undefined, then ?? provides fallback
}
run();

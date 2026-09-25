// ============================================================
//  ENHANCED OBJECT LITERALS — Modern Object Syntax (ES6)
// ============================================================
// CONCEPTS TO REMEMBER:
// • Shorthand property: { name } instead of { name: name }
// • Shorthand methods: method() {} instead of method: function() {}
// • Computed property names: { [expression]: value } — evaluates expression as key
// • Computed properties must be wrapped in square brackets []
// • Square brackets in object literal = computed property (NOT array!)
// • Can use expressions, variables, or function calls as property names
// ============================================================

export function run() {
  // Enhanced Object literal — [] in object context means computed property name

  // ========== Computed Property Names ==========
  // Can evaluate expressions as property names using [expression]

  // Why [weekdays[3]] Works vs weekdays[3] Fails:
  // • [weekdays[3]] (Correct): Brackets tell JS to evaluate expression first, use result as key
  // • weekdays[3] (Syntax Error): JS expects literal property name, brackets invalid here
  // • Looks like one-element array, but in object literal context = computed property syntax (ES6)

  // ========== Example Objects ==========

  // 1st object
  const weekdays = ["mon", "tue", "wed", "thu", "fri", "sat", "sun"];

  // 2nd object — uses computed property names
  const openingHours = {
    [weekdays[3]]: {
      // Computed property — evaluates to "thu"
      open: 12,
      close: 22,
    },
    [weekdays[4]]: {
      // Computed property — evaluates to "fri"
      open: 11,
      close: 23,
    },
    [`RestDay-${weekdays[6]}`]: {
      // Computed with template literal — evaluates to "RestDay-sun"
      open: 0, // Open 24 hours
      close: 24,
    },
  };

  // 3rd object — demonstrates enhanced object literal features
  const restaurant = {
    name: "Classico Italiano",
    location: "Via Angelo Tavanti 23, Firenze, Italy",
    categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
    starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
    mainMenu: ["Pizza", "Pasta", "Risotto"],

    // ========== Property Shorthand (ES6) ==========
    //openingHours: openingHours, // Before ES6 — redundant
    openingHours, // Modern way — if variable name matches property name

    // ========== Method Shorthand (ES6) ==========
    // Before ES6 — function keyword required
    // order: function (starterIndex, mainIndex) {
    //   return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
    // },

    // Modern way — no 'function' keyword needed
    order(starterIndex, mainIndex) {
      return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
    },

    orderDelivery({ starterIndex = 1, mainIndex = 0, time, address }) {
      console.log(
        `Order received! ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]} will be delivered to ${address} at ${time}.`,
      );
    },
  };

  console.log(restaurant);
  restaurant.order(0, 3);
}

run();

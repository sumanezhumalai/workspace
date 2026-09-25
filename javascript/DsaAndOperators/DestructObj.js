// ============================================================
//  OBJECT DESTRUCTURING — Unpacking Objects into Variables
// ============================================================
// CONCEPTS TO REMEMBER:
// • Destructuring uses property NAMES, not order (unlike arrays)
// • Rename during destructure: {oldName: newName} = obj
// • Default values prevent undefined: {prop = defaultVal} = obj
// • Works with nested objects: {outer: {inner}} = obj
// • Mutating existing variables requires parentheses: ({a, b} = obj)
// • Destructure in function parameters for cleaner code
// • Destructured parameters support default values
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

    // Destructuring in function parameters — very common pattern
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
  };

  // ========== Basic Object Destructuring ==========
  // Extract properties by name (order doesn't matter)
  const { name, openingHours, categories } = restaurant;
  console.log(name, openingHours, categories);

  // ========== Rename Variables ==========
  // Retrieve property but assign to different variable name
  const {
    name: restaurantName,
    openingHours: timing,
    categories: tags,
  } = restaurant;
  console.log(restaurantName, timing, tags);

  // ========== Default Values ==========
  // Set fallback values for non-existent properties
  const { location = "unknown", Menu = [] } = restaurant; // 'Menu' doesn't exist in restaurant
  console.log(location, Menu);

  // ========== Mutating Existing Variables ==========
  const obj = { a: 1, b: 2, c: 3 };
  //   let {a,b} = obj; // Works — declaring new variables
  //   {a,b} = obj; // ERROR: Unexpected token '=' — JS thinks {} is block, not destructure
  let a, b;
  ({ a, b } = obj); // Works — parentheses force expression context

  console.log(a, b);

  // ========== Nested Object Destructuring ==========
  const {
    fri: { open: o, close: c },
  } = openingHours; // Destructure nested 'fri' object
  //   console.log(open,close); // Won't work — variables renamed to 'o' and 'c'
  console.log(o, c);

  // ========== Destructuring in Function Parameters ==========
  // Cleaner API — caller doesn't need to remember parameter order
  restaurant.orderDelivery({
    time: "22:30",
    address: "Via del Sole. 21",
    mainIndex: 2,
    starterIndex: 2,
  });
  // Function uses default values for missing parameters
  restaurant.orderDelivery({
    time: "20:00",
    address: "something",
    // starterIndex and mainIndex use defaults (1 and 0)
  });
}

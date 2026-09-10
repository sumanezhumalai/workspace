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

  // Data needed for first part of the section
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
  };

  //destructuring objects
  const { name, openingHours, categories } = restaurant;
  console.log(name, openingHours, categories);

  //retireve in different variable name
  const {
    name: restaurantName,
    openingHours: timing,
    categories: tags,
  } = restaurant;
  console.log(restaurantName, timing, tags);

  //can set default value too
  const { location = "unknown", Menu = [] } = restaurant; //there is no Menu property up in restaurent Object
  console.log(location, Menu);

  //mutating Array
  const obj = { a: 1, b: 2, c: 3 };
  //   let {a,b} = obj; //works
  //   {a,b} = obj; // error - Uncaught SyntaxError: Unexpected token '='
  let a, b;
  ({ a, b } = obj); //works

  console.log(a, b);

  const {
    fri: { open: o, close: c },
  } = openingHours;
  //   console.log(open,close);
  console.log(o, c);

  //destruction can be done at function argument itlsef - go up and checkout the function
  restaurant.orderDelivery({
    time: "22:30",
    address: "Via del Sole. 21",
    mainIndex: 2,
    starterIndex: 2,
  });
    restaurant.orderDelivery({
    time: "20:00",
    address: "something",

  });
}

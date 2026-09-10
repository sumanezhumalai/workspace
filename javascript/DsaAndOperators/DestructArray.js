"use strict";

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
  };

  //Destructuring Array
  const arr = [3, 4, 5];

  const [x, y, z] = arr;
  console.log(x, y, z);

  //can skip by spaces and holes
  let [a, , b, c] = restaurant.categories;

  console.log(a, b, c);

  //swap
  [b, a, c] = [a, b, c];
  console.log(a, b, c);

  //use case - destructuring an retur array by a function
  const [starter, main] = restaurant.order(2, 0);

  console.log(starter, main);
  
  //nested array destructure
  const nested = [2,4,[5,6]];
  const [i,j,[k,l]] = nested;

  console.log(i,j,k,l);

  //can provide default value too
    const [m = 0 ,n = 0,o = 0, p = 0] =[a,b];
  console.log(m,n,o,p);
  
}

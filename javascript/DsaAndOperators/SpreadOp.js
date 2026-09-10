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

    standardOrder: function (dish1, dish2, dish3) {
      console.log(
        `Your Standard order\'s includes ${dish1} , ${dish2} and ${dish3}`,
      );
    },
  };

  //Spread Operator - works alone and all (Iterables  - arrays, strings , maps , sets - BUT NOT OBJECTS(technically can sonce ES2018))
  // only in places that expects an (arguments into a function or seperated by comma or new array) , NOT IN LITERALS eg TEMPLATE LITERAL ``
  const arr = [1, 2, 3];
  const newArr = [-1, 0, ...arr]; // helpe to distribute the elements to the new array

  console.log(newArr); //prints as Array object
  console.log(...newArr); // prints as element

  //copy array
  const newMenu = [...restaurant.mainMenu, "Gnocci"];
  console.log(newMenu);

  //join arrays
  const menu = [...restaurant.starterMenu, ...restaurant.mainMenu];

  //(Iterables  - arrays, strings , maps , sets - BUT NOT OBJECTS)
  const str = "Suman";
  let name = [...str, " ", ".", "E"];
  console.log(name);
  console.log(...name);
  // console.log(`${...name} Ezhumalai`); // error , Spread operator wont work this way using template literal

  //Spread operator to pass arguments to a function
  restaurant.standardOrder(...restaurant.mainMenu);

  //Spread Objects - supported only at recent JS versiosn
  const newRestaurant = {
    ...restaurant,
    founder: "Suman Ezhumalai",
    foundingYear: 1960,
  };
  console.log(newRestaurant);


}

export function run() {
  //Enhanced Object literal ,object literal - '[]' - we use this literal symbol in most places 

//   You get an error when writing  because JavaScript requires computed property names to be wrapped in square brackets  inside an object literal. 
// Without the outer brackets, JavaScript interprets the text before the colon as a literal string or an invalid identifier, rather than executing the code to find the value inside the array. 
// Why  Works vs. Why  Fails 

// •  (Correct): The outer brackets tell JavaScript, "Evaluate the expression inside these brackets first, and use the result as the key name." JavaScript evaluates  to the string , so the key becomes . 
// •  (Syntax Error): JavaScript expects a standard, literal property name here. Because square brackets are not valid characters for a standard identifier name, the parser breaks and throws a syntax error. 

// Your Question About  
// (isnt it like one element array) It looks exactly like a one-element array, which can be confusing! However, in this specific context, it is not an array. 
// When square brackets are placed on the left side of a colon  inside an object creation, they change meaning. They switch from meaning "array" to meaning "evaluate this expression" (Computed Property Syntax introduced in ES6). 
// A Visual Comparison 
// Here is how JavaScript reads the two different syntax approaches: 

// | Syntax Type | What you write | What JavaScript sees  |
// | --- | --- | --- |
// | Literal (Standard) | — | —  |
// | Computed (Expression) | — | —  |
// | Invalid | — | Syntax Error (Cannot parse)  |




  //1st  object
  const weekdays = ["mon", "tue", "wed", "thu", "fri", "sat", "sun"];

  
  //2nd obj
  const openingHours = {
  [weekdays[3]]: { //we can computer or write a porperty name as expression , above ES6
      open: 12,
      close: 22,
    },
    [weekdays[4]]: {
      open: 11,
      close: 23,
    },
    [`RestDay-${weekdays[6]}`]: {
      open: 0, // Open 24 hours
      close: 24,
    },
  };
  //3rd obj
  const restaurant = {
    name: "Classico Italiano",
    location: "Via Angelo Tavanti 23, Firenze, Italy",
    categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
    starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
    mainMenu: ["Pizza", "Pasta", "Risotto"],
    //openingHours: openingHours, // before Es6  - way of assigning an object to another obj's porperty

    //ES6 , ENhanced obj literal
    openingHours, //modern way of assigning an object to another obj's porperty

    //before Es6  - way of creating an obj's function
    // order: function (starterIndex, mainIndex) {
    //   return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];
    // },

    //ES6 , ENhanced obj literal
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

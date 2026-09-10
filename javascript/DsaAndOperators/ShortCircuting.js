export function run() {
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
    standardOrder: function (dish1, dish2, dish3) {
      console.log(
        `Your Standard order\'s includes ${dish1} , ${dish2} and ${dish3}`,
      );
    },
  };

  // Use ANY data type, return ANY data type,
  console.log("--- OR ---");
  console.log(3 || "Suman"); //always sees the firts value , if its truthy (true)  it returns that or moves on to the other and check
  console.log("" || "Suman");
  console.log(true || 0);
  console.log(undefined || null);

  console.log(undefined || 0 || "" || "Hello" || 23 || null);
  //shortcircuit OR usage example
  //   restaurant.numGuests = 20;
  //   const guests1 = restaurant.numGuests ? restaurant.numGuests : 10; //terenary condition
  //   console.log(guests1);

  restaurant.numGuests = 0;
  const guests2 = restaurant.numGuests || 10; // shorcircuiting
  console.log(guests2);

  console.log("\n\n");

  //NOTE : the above both doesnt work when -   restaurant.numGuests = 0 (where guests = 0 , but return 10)
  //So we use Nillish Coalescing Operator (??) here , it checks for (Nullish values: undefined , null ) not (Falsy valuse like :  0 , '' )
  console.log("--- Nullish Coalescing Operator ?? ---");
  restaurant.numGuests = 0;
  const guests3 = restaurant.numGuests ?? 10; // shorcircuiting
  console.log(guests3);

  console.log("\n\n\n");

  console.log("--- AND ---");

  console.log(0 && "Suman"); //always sees the firts value , if its falsy (false) , it returns that and skips the line totally
  console.log("" && "Suman"); //skips
  console.log(true && 0);
  console.log(undefined && null); //skips
  console.log(true && 1 && "Hello" && 23 && null && undefined); //check until its falsy

  //shortcircuit AND usage example
  if (restaurant.orderPizza) {
    restaurant.orderPizza("mushrooms", "spinach");
  }

  console.log(
    restaurant.orderPizza && restaurant.orderPizza("mushrooms", "spinach"),
  );

  //Practical; application of Logical shorcircuiting
  // use || , ??  to set default value
  // use AND to check exitance of 1st operand ( if true , execute the 2nd operand (statement))
}

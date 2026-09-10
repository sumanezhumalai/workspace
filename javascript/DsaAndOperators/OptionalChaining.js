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

  //the Problem
  if (restaurant.openingHours && restaurant.openingHours.mon) {
    //multi check
    console.log(restaurant.openingHours.mon.open); //here multiple chained objects must pass exot check for predicatble coding
  }

  //with Optional Chaining
  console.log(restaurant.openingHours?.mon?.open);

  for (const day of weekdays) {
    console.log(
      `Day: ${day} ->  ${(restaurant.openingHours?.[day]?.open ?? "IS Open") || "Is not Open"}`, //classic exmple of using Optional changing with Nullish Coalescing operator
    );
  }

  //we can check the excitence of function too before calling 
  console.log(restaurant?.order?.(0,1) ?? "couldn't order");
  
}
run();

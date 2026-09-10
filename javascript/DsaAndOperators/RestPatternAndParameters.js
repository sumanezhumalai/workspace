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

    orderPizza: function (mainIng, ...otherIng) {
      //Rest parameter does not support a default initializer / initial valuse assignment
      //   otherIng = otherIng.length === 0 ? ["none"] : otherIng;
      console.log(
        `Pizza Type: ${mainIng}, AddOns: ${(otherIng.length === 0 ? ["none"] : otherIng).join(", ")} `,
      );
    },
  };

  // SPREAD, because on RIGHT side of =
  const arr = [1, 2, ...[3, 4]]; //spread - distributes the array
  console.log(arr);

  // REST, because on LEFT side of =

  const [a, b, ...others] = [1, 2, 3, 4, 5]; //rest collects unassigned elemets into an array here
  console.log(a, b, others);

  //REST does not collect nay skipped elemenet , only the Right leftover elements of last assigned element
  const [x, , y, ...rest] = [...restaurant.starterMenu, ...restaurant.mainMenu]; //can contain only on Rest Operator while grouping
  console.log(x, y, rest);

  //Rest operations on Object
  const { sat, ...weekdays } = { ...restaurant.openingHours }; //skip sat obj.property and collect the rest
  console.log(weekdays);

  //Rest operations on Functions
  const add = function (...nums) {
    let sum = 0;
    nums.forEach((e) => {
      sum += e;
    });
    return sum;
  };

  console.log(add(1, 2, 3, 5, 6, 6, 5, 7, 8, 32));

  restaurant.orderPizza(
    "chicken",
    "pineapple",
    "cheese",
    "peanut",
    "Red Saurce",
  );
  restaurant.orderPizza("pineapples");
}

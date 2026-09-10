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

  //Object.keys(RealObjectName) -> return the object's properties as an array
  const properties = Object.keys(restaurant);
  console.log(properties);

  //Object.values(RealObjectName) -> returns the Object's values as an array (not properties)
  const values = Object.values(restaurant);
  console.log(values);

  //Object.entries -> returns both the Object's properties and its value as key pair array
  const objectDetail = Object.entries(restaurant);
  console.log("---- Object Entries ----");
  console.log(objectDetail);

  for (const [prop, values] of objectDetail) {
    console.log(`Restaurent detail ->  Property: ${prop}, Value: ${values}`);
  }
}
run();

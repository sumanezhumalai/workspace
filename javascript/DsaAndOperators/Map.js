export function run() {
  // Data needed for first part of the section
  const restaurant = {
    name: "Classico Italiano",
    location: "Via Angelo Tavanti 23, Firenze, Italy",
    categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
    starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
    mainMenu: ["Pizza", "Pasta", "Risotto"],
  };

  //   //Map creation
  //   const rest = new Map();

  //   console.log("----- SET ----");
  //   //Map set()
  //   rest.set("name", "Classico Italiano");
  //   console.log(rest.set("location", "Lisbon, Portugal")); // return the map everytime

  //   //Map chain set()
  //   console.log(
  //     rest
  //       .set(1, ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"]) //can hold multiple keys of different datatype
  //       .set(2, ["Pizza", "Pasta", "Risotto"])
  //       .set("open", 10)
  //       .set("close", 4)
  //       .set(true, "the restaurant is OPEN")
  //       .set(false, "the restaurant is CLOSE"),
  //   );

  //   console.log("----- GET ----");
  //   // Map get()
  //   let time = 12;
  //   console.log(rest.get(time > rest.get("open") && time < rest.get("close")));

  //   console.log(rest.get("location"));
  //   rest.get(1);

  //   console.log("----- HAS ----");
  //   console.log(rest.has(1));

  //   console.log("----- DELETE ----");
  //   console.log(rest.delete(1)); //return boolean value
  //   console.log(rest.has(1));

  //   console.log("----- CLEAR ----");
  //   rest.clear();
  //   console.log(rest);

  //use case
  const question = new Map([
    [
      "question",
      "What is the best dynamic typed programming language in the world",
    ],
    [1, "C"],
    [2, "Java"],
    [3, "JavaScript"],
    [4, "python"],
    ["correct", 4],
    [true, "Correct"],
    [false, "Try Again!"],
  ]);
  //   console.log(question);

  console.log("-- use case --");
  console.log(question.get("question"));
  let answer = 2;
  for (const [key, value] of question) {
    if (typeof key == "number") console.log(`Option ${key}, ${value}`);
  }

  if (question.get("correct") === answer) {
    console.log(question.get(true));
  } else {
    console.log(question.get(false));
  }

  //convert Object to Map
  //   const hotel = new Map(Object.entries(restaurant));
  //   console.log(hotel);
}

run();

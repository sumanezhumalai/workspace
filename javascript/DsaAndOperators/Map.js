// ============================================================
//  MAP — Key-Value Pairs with Any Key Type (ES6)
// ============================================================
// CONCEPTS TO REMEMBER:
// • Maps store key-value pairs with ANY type as key (unlike objects: string/symbol only)
// • Keys maintain insertion order
// • Methods: set(key, val), get(key), has(key), delete(key), clear()
// • set() returns the map — allows method chaining
// • Iterate with for...of — entries, keys, values
// • Convert from object: new Map(Object.entries(obj))
// • Convert to array: [...map] or Array.from(map)
// • Size tracked via .size property
// ============================================================

export function run() {
  // ========== Sample Data ==========
  const restaurant = {
    name: "Classico Italiano",
    location: "Via Angelo Tavanti 23, Firenze, Italy",
    categories: ["Italian", "Pizzeria", "Vegetarian", "Organic"],
    starterMenu: ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"],
    mainMenu: ["Pizza", "Pasta", "Risotto"],
  };

  // ========== Map Creation & Setting ==========
  //   const rest = new Map();

  //   console.log("----- SET ----");
  //   // set(key, value) — adds or updates entry
  //   rest.set("name", "Classico Italiano");
  //   console.log(rest.set("location", "Lisbon, Portugal")); // Returns the map (allows chaining)

  //   // Method chaining with set()
  //   console.log(
  //     rest
  //       .set(1, ["Focaccia", "Bruschetta", "Garlic Bread", "Caprese Salad"]) // Keys can be ANY type
  //       .set(2, ["Pizza", "Pasta", "Risotto"])
  //       .set("open", 10)
  //       .set("close", 4)
  //       .set(true, "the restaurant is OPEN") // Boolean key
  //       .set(false, "the restaurant is CLOSE"),
  //   );

  //   console.log("----- GET ----");
  //   // get(key) — retrieves value by key
  //   let time = 12;
  //   console.log(rest.get(time > rest.get("open") && time < rest.get("close"))); // Boolean key lookup

  //   console.log(rest.get("location"));
  //   rest.get(1);

  //   console.log("----- HAS ----");
  //   console.log(rest.has(1)); // Check if key exists

  //   console.log("----- DELETE ----");
  //   console.log(rest.delete(1)); // Returns boolean — true if deleted
  //   console.log(rest.has(1)); // false

  //   console.log("----- CLEAR ----");
  //   rest.clear(); // Removes all entries
  //   console.log(rest);

  // ========== Practical Use Case ==========
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
    console.log(question.get(true)); // Boolean key
  } else {
    console.log(question.get(false));
  }

  // ========== Convert Object to Map ==========
  //   const hotel = new Map(Object.entries(restaurant)); // Object.entries() returns [key, value] pairs
  //   console.log(hotel);
}

run();

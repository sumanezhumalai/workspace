export function run() {
  //Set is basically a collection of Unique value (no duplicates)
  //Set only consist of iterables like array , string etc

  //creation od Set
  const orderSet = new Set([
    "Pasta",
    "Pizza",
    "Risotto",
    "Pizza",
    "Macroni",
    "Risotto",
    "Pizza",
  ]);

  //   console.log(new Set("Suman Ezhumalai")); //String is also iterable
  //   console.log(new Set()); //can also be empty

  //Set operations
  //   console.log(orderSet);
  //   console.log(orderSet.size);
  //   console.log(orderSet.has("pizza"));
  //   console.log(orderSet.has("Burger"));
  //   orderSet.add("Bread");
  //   orderSet.delete("Macroni");
  //   console.log(orderSet);

  //Accessing - Set doent support Accessing or Retrieval . we use arry for that
  //console.log(orderSet[1]); cannot retrieve coz no index or oder in set
  // so set is not like Array

  // Example
  //   const staff = ["Waiter", "Chef", "Waiter", "Manager", "Chef", "Waiter"];
  //   const roles = new Set(staff); // array to set
  //   console.log(roles);

  //   const staffArr = [...roles];
  //   console.log(staffArr);
  //   console.log(new Set("Suman Ezhumalai").size); // count how many unique letters in my Name

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

  const favoriteFoods = new Set(["pasta", "garlic"]);

  //Modern version ES2025+ - Sets operation and methods

  //intersection
  const commonFoods = italianFoods.intersection(mexicanFoods);
  console.log(`Set Intersection : ${[...commonFoods]}`);

  //union
  const italicMexicFoods = italianFoods.union(mexicanFoods);
  console.log(`Set Union : ${[...italicMexicFoods]}`);

  //difference
  const uniqueItalianFoods = italianFoods.difference(mexicanFoods);
  console.log(`Set Different : ${[...uniqueItalianFoods]}`);

  //symmetricDifference (Unique)
  const uniqueItalicMexicFoods = italianFoods.symmetricDifference(mexicanFoods);
  console.log(
    `Unique- SymmetricDifference ( negation ofd Intersection): ${[...uniqueItalicMexicFoods]}`,
  );

  //isSubsetOf
  // Checks if all items in 'favoriteFoods' exist inside 'italianFoods'
  const isSubset = favoriteFoods.isSubsetOf(italianFoods);
  console.log(`Is Subset : ${isSubset}`); // true

  //isSupersetOf
  // Checks if 'italianFoods' contains all items from 'favoriteFoods'
  const isSuperset = italianFoods.isSupersetOf(favoriteFoods);
  console.log(`Is Superset : ${isSuperset}`); // true

  //isDisjointFrom
  // Checks if two sets share NO common elements (true if intersection is empty)
  const isDisjoint = italianFoods.isDisjointFrom(mexicanFoods);
  console.log(`Is Disjoint : ${isDisjoint}`); // false (because both contain "Gelato")
}
run();

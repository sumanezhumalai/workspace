// ============================================================
//  SET — Collection of Unique Values (ES6)
// ============================================================
// CONCEPTS TO REMEMBER:
// • Sets store UNIQUE values only — duplicates automatically removed
// • Works with iterables: arrays, strings, etc.
// • No index/key-based access — order is insertion order but not meant for retrieval
// • Methods: add(), delete(), has(), clear(), size property
// • Cannot retrieve by index — use for(...of) to iterate
// • Modern ES2025+ methods: intersection(), union(), difference(), symmetricDifference()
// • Set relations: isSubsetOf(), isSupersetOf(), isDisjointFrom()
// • Convert to array: [...set] or Array.from(set)
// ============================================================

export function run() {
  // ========== Set Basics ==========
  // Set stores only UNIQUE values — duplicates automatically removed
  // Works with iterables: array, string, etc.

  // Creation of Set
  const orderSet = new Set([
    "Pasta",
    "Pizza",
    "Risotto",
    "Pizza",
    "Macroni",
    "Risotto",
    "Pizza",
  ]); // Duplicates removed

  //   console.log(new Set("Suman Ezhumalai")); // String is iterable
  //   console.log(new Set()); // Empty set

  // ========== Set Operations ==========
  //   console.log(orderSet);
  //   console.log(orderSet.size); // Property, not method
  //   console.log(orderSet.has("pizza")); // Case-sensitive
  //   console.log(orderSet.has("Burger"));
  //   orderSet.add("Bread"); // Add element
  //   orderSet.delete("Macroni"); // Remove element
  //   console.log(orderSet);

  // ========== Set Access ==========
  // Set does NOT support indexing or retrieval by key — no set[1]
  // Use arrays for ordered access; use sets for uniqueness
  //console.log(orderSet[1]); // undefined — cannot retrieve by index

  // ========== Practical Example ==========
  //   const staff = ["Waiter", "Chef", "Waiter", "Manager", "Chef", "Waiter"];
  //   const roles = new Set(staff); // Array to Set — removes duplicates
  //   console.log(roles);

  //   const staffArr = [...roles]; // Set to Array
  //   console.log(staffArr);
  //   console.log(new Set("Suman Ezhumalai").size); // Count unique letters in name

  // ========== Modern Set Operations (ES2025+) ==========
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

  // Intersection — common elements between sets
  const commonFoods = italianFoods.intersection(mexicanFoods);
  console.log(`Set Intersection : ${[...commonFoods]}`);

  // Union — all elements from both sets (no duplicates)
  const italicMexicFoods = italianFoods.union(mexicanFoods);
  console.log(`Set Union : ${[...italicMexicFoods]}`);

  // Difference — elements in first set but NOT in second
  const uniqueItalianFoods = italianFoods.difference(mexicanFoods);
  console.log(`Set Difference : ${[...uniqueItalianFoods]}`);

  // SymmetricDifference — elements in either set but NOT in both (opposite of intersection)
  const uniqueItalicMexicFoods = italianFoods.symmetricDifference(mexicanFoods);
  console.log(
    `Unique - SymmetricDifference (negation of Intersection): ${[...uniqueItalicMexicFoods]}`,
  );

  // isSubsetOf — checks if all items in first set exist in second
  const isSubset = favoriteFoods.isSubsetOf(italianFoods);
  console.log(`Is Subset : ${isSubset}`); // true

  // isSupersetOf — checks if first set contains all items from second
  const isSuperset = italianFoods.isSupersetOf(favoriteFoods);
  console.log(`Is Superset : ${isSuperset}`); // true

  // isDisjointFrom — checks if two sets have NO common elements (empty intersection)
  const isDisjoint = italianFoods.isDisjointFrom(mexicanFoods);
  console.log(`Is Disjoint : ${isDisjoint}`); // false (they share "tomatoes", "garlic")
}
run();

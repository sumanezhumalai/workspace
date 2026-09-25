// ============================================================
//  STRINGS — Manipulation, Methods, Searching, Transforming
// ============================================================
// CONCEPTS TO REMEMBER:
// • Strings are IMMUTABLE — methods return new strings, don't modify original
// • String indexing: zero-based like arrays (str[0], str[1], etc.)
// • Case methods: toLowerCase(), toUpperCase(), charAt()
// • Search: indexOf(), lastIndexOf(), includes(), startsWith(), endsWith()
// • Extract: slice(start, end), substring(), substr() (deprecated)
// • Transform: replace(), replaceAll(), split(), trim(), padStart(), padEnd()
// • Regular expressions: /pattern/flags — g (global), i (case-insensitive)
// • Template literals preserve whitespace and support multi-line
// ============================================================

export function run() {
  // ========== String Basics ==========
  // Strings are immutable primitives
  const name = "Suman Ezhumalai";
  //   console.log(name[0]); // Access by index
  //   console.log(name[1]);
  //   console.log(name[2]);

  //   console.log("Sakthi"[0]); // Can index string literals directly

  // ========== Searching ==========
  //   console.log(name.indexOf("S")); // First occurrence
  //   console.log(name.lastIndexOf("a")); // Last occurrence
  //   console.log(name.indexOf("Ezhumalai")); // Can search substrings

  // ========== Slicing ==========
  //   console.log(name.slice(5)); // From index 5 to end
  //   console.log(name.slice(-2)); // Negative indices work (from end)
  //   console.log(name.slice(6, name.indexOf("i") + 1)); // Range with computed end

  // ========== Type Check ==========
  //   console.log(typeof name); // "string" — primitive
  //   console.log(typeof new String("javascript")); // "object" — String wrapper
  //   console.log(typeof new String("javascript").slice(4)); // "string" — methods return primitive

  // ========== Case Transformation ==========
  // console.log(name.toLowerCase());
  // console.log(name[0].toLocaleUpperCase() + name.slice(1).toLowerCase()); // Capitalize first letter

  // ========== Replacing ==========
  const price = "288,978,344";
  const priceUS = price.replaceAll(",", "."); // replaceAll() — modern ES2021

  // console.log(price);
  // console.log(priceUS);

  // ========== Regular Expressions ==========
  const str = "hi i am suman!";
  const strReg = str.replace(/ /g, ""); // Remove all spaces using regex — /g flag = global
  console.log(str);
  console.log(strReg);

  // ========== Boolean Checks ==========
  console.log(str.includes("suman")); // Substring check
  console.log(str.startsWith("hello")); // Starts with check

  // ========== Split & Join ==========
  const fullName = "Suman Ezhumalai";
  const arr = fullName.split(" "); // Split string into array
  const [firstName, lastName] = arr; // Destructure array

  const strJoint = arr.join("==="); // Join array back to string with separator
  console.log(arr);
  console.log(firstName, lastName);
  console.log(strJoint);

  // ========== Capitalize Function ==========
  function capitalize(str) {
    const temp = str.split(" ");
    let capTemp = [];

    // temp.forEach((element) => {
    //   capTemp.push(element.charAt(0).toUpperCase() + element.slice(1));
    // });

    for (const element of temp) {
      // capTemp.push(element[0].toUpperCase() + element.slice(1));
      capTemp.push(element.replace(element[0], element[0].toUpperCase()));
    }

    console.log(temp);
    console.log(capTemp);
  }

  capitalize(str);

  // ========== Padding ==========
  const message = "BAZINGA!!!";
  console.log(message.padStart(20, "=")); // Total length must be greater than string length

  // ========== Repeat ==========
  console.log(message.repeat(5)); // Repeat string n times
}
run();

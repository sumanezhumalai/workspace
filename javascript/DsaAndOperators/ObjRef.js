export function run() {
  const alex = {
    firstName: "Alex",
    lastName: "Rivera",
  };
  const suman = {
    firstName: "Suman",
    lastName: "Ezhuamalai",
  };
  const jessica = {
    firstName: "Jessica",
    lastName: "Roman",
    family: ["alex", "madina"],
  };

  //Object Referenece
  //   const marriedJessica = jessica;
  //   marriedJessica.lastName = "Suman";

  //   console.log("Before", jessica);
  //   console.log("After", marriedJessica);

  // Shallow copy
//   const jessicaCopy = { ...jessica };
//   jessicaCopy.lastName = "Suman"; // Does not reflects the change at jessica
//   jessicaCopy.family.push("Suman"); //reflects the change at jessica

//   console.log(jessica); //the family will also updated at the original object 'jessica' .
//   // some the Array is treated as a object , and its reference is copied to 'jessicaCopy'
//   console.log(jessicaCopy);

  //Deep copy
  const jessicaCloned = structuredClone(jessica);
  jessicaCloned.lastName = "Suman";
  jessicaCloned.family.push("Suman");

  console.log(jessica);
  console.log(jessicaCloned);
}

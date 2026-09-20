export function run() {
  // Strings is generally immutable
  const name = "Suman Ezhumalai";
  //   console.log(name[0]);
  //   console.log(name[1]);
  //   console.log(name[2]);

  //   console.log("Sakthi"[0]);

  //   console.log(name.indexOf("S"));
  //   console.log(name.lastIndexOf("a"));
  //   console.log(name.indexOf("Ezhumalai"));

  //   console.log(name.slice(5));
  //   console.log(name.slice(-2)); // negative works too 
  //   console.log(name.slice(6, name.indexOf("i") + 1));

  //   console.log(typeof name);
  //   console.log(typeof new String("javascript"));
  //   console.log(typeof new String("javascript").slice(4));

  // console.log(name.toLowerCase());
  // console.log(name[0].toLocaleUpperCase() + name.slice(1).toLowerCase());

  //replacing
  const price = "288,978,344";
  const priceUS = price.replaceAll(",", ".");

  // console.log(price);
  // console.log(priceUS);

  //regular expression
  const str = "hi i am suman!";
  const strReg = str.replace(/ /g, ""); //removibg all spaces without replaceAll() - by regular expression / /g - g : global
  console.log(str);
  console.log(strReg);

  //Boolean
  console.log(str.includes("suman"));
  console.log(str.startsWith("hello"));

  //split
  const fullName = "Suman Ezhumalai";
  const arr = fullName.split(" ");
  const [firstName, lastName] = arr;

  //join
  const strJoint = arr.join("===");
  console.log(arr);
  console.log(firstName, lastName);
  console.log(strJoint);

  //capitalize
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

  //padding

  const message = "BAZINGA!!!";
  console.log(message.padStart(20, "=")); //the lenght must be greater that the length of the string itself

  //repeat
  console.log(message.repeat(5));
}
run();

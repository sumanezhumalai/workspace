"use strict";

export function run() {
  //like an array (saying just for refrenece) but with property and {}
  const suman = {
    firstName: "Suman",
    lastName: "Ezhuamalai",
    phoneNumber: "9159468801",
    dob: new Date("2004-10-28"),
    skills: ["Java", "JavaScript", "HTML", "CSS"],

    calcAge: function () {
      const today = new Date();
      let age = today.getFullYear() - this.dob.getFullYear();
      const monthdiff = today.getMonth() - this.dob.getMonth();
      if (
        monthdiff < 0 ||
        (monthdiff === 0 && today.getDate < this.dob.getDate)
      ) {
        age--;
      }
      this.age = age; // here we are creating an age property so thay we dony need to calculate everytime

      return age;
    },
  }; // need not worry about order , it auto arranges as per alphabetic order

  //Access and Formats
  console.log(suman);
  console.log(suman.calcAge());
  console.log(suman.skills[0]); //here skill is an array so we could access it elements with index
  console.log(suman.phoneNumber);
  console.log(suman["age"]); // -> can also take expression that results in property string as below

  const Namekey = "Name";
  console.log(suman["first" + Namekey]); //expressions like arr[arr.length - 1]
  console.log(suman["last" + Namekey]);

  // const query = prompt("what property do you wanna get for Suman ? ");
  // console.log(suman[query]) // here suman.query will not work , throws error!

  //can introduce or append new Fields
  suman.isEmployed = false;
  suman["location"] = "Puducherry";
  console.log(suman);
}

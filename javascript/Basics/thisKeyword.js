// 'use strict'; //already using 'use strict' by default

export function run() {
  // console.log(this); //already using 'use strict' by default
  // so wont diaply the window object

  //like an array (saying just for refrenece) but with property and {}

  //alex
  const alex = {
    firstName: "Alex",
    lastName: "Rivera",
    phoneNumber: "9876543210",
    dob: new Date("2004-10-28"),
    skills: ["Python", "TypeScript", "React", "Node.js"],

    displayThis: function () {
      console.log(this);
    },
  };

  //suman
  const suman = {
    firstName: "Suman",
    lastName: "Ezhuamalai",
    phoneNumber: "9159468801",
    dob: new Date("2004-10-28"),
    skills: ["Java", "JavaScript", "HTML", "CSS"],

    displayThis: function () {
      console.log(this);
    },

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

      // .this Problem in Regular function
      //   const isGenz = function () {
      //     console.log(this); //undefined  ,points to gobal scope (which is 'window' object)
      // window is not accessibel 'use strict' - here 'use strict'used by default . so its value is 'undefined' / error

      // if (this.dob.getFullYear() >= 2001 && this.dob.getFullYear() <= 2016) {//error , since .this is 'undefined', cannot access 'dob'
      //   console.log("You are a GenZ");
      // }
      //   };

      //solution - Arrow function
      const isGenz = () => {
        console.log(this); // since arrrow function selects the surrounding parent scope (one level down in stack).
        //  here , suman is selected

        if (this.dob.getFullYear() >= 2001 && this.dob.getFullYear() <= 2016) {
          console.log("You are a GenZ");
        }
      };

      this.age = age;

      isGenz(); //cannot use .this , coz suman has no function named isGenz

      return age;
    },

    greet: () => {
      // this. will not work in arrow function
      console.log(this); // undefined
      console.log(`Hi!, I'm ${this.firstName}`); //will throw error
    },
  };

  console.log(suman.calcAge());
  //   suman.greet();  // this. will not work in arrow function , points to gobal scope (which is 'window' object)
  // window is not accessibel 'use strict' - here 'use strict'used by default . so its value is 'undefined' / error

  //   console.log(alex.calcAge());

  //   console.log(suman.calcAge === alex.calcAge); // we can call calcAge with alex ,
  //  but alex has no calcAge function  . so it returns undefined instead of error . so 'False'
  //   suman.displayThis();
  //   alex.displayThis();

  //argumnet keyword
  const raisePower = function (a, b) {
    console.log(arguments);
    return a ** b;
  };

  console.log(raisePower(9, 3));
}

export function run() {
  const hotel1 = {
    hotelName: "Coromondal",
    owner: "Suman",
    starred: false,
  };

  const hotel2 = {
    hotelName: "Taj",
    owner: "Madhan",
    starred: true,
  };

  //short circuiting
  hotel1.numGuests = hotel1.numGuests || 10;
  hotel2.numGuests = hotel2.numGuests || 20;

  //Logical/Nullish Assignmnet oprator
  //   hotel1.numGuests ??= 10;
  hotel1.numGuests ??= 10;
  hotel2.numGuests ??= 10;

  hotel1.starred &&= false;
  hotel2.starred &&= false;

  console.log(hotel1);
  console.log(hotel2);
}

// ============================================================
//  LOGICAL ASSIGNMENT OPERATORS — ||=, &&=, ??=
// ============================================================
// CONCEPTS TO REMEMBER:
// • ||= assigns if current value is FALSY (similar to short-circuit OR)
// • &&= assigns if current value is TRUTHY
// • ??= assigns if current value is NULLISH (null/undefined only)
// • Preferred over traditional short-circuit patterns for assignment
// • ??= is safer than ||= when 0, '', false are valid values
// • All three are ES2021+ features
// ============================================================

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

  // ========== Traditional Short-Circuit Assignment ==========
  hotel1.numGuests = hotel1.numGuests || 10; // If falsy, assign 10
  hotel2.numGuests = hotel2.numGuests || 20; // If falsy, assign 20

  // ========== Logical Assignment Operators (ES2021) ==========
  // More concise and readable

  // Nullish Assignment (??=) — assigns only if null/undefined
  hotel1.numGuests ??= 10; // Assign 10 only if nullish (safer than ||=)
  hotel2.numGuests ??= 10; // Doesn't overwrite if value exists

  // AND Assignment (&&=) — assigns only if current value is truthy
  hotel1.starred &&= false; // starred is false (falsy), no assignment
  hotel2.starred &&= false; // starred is true (truthy), assigns false

  console.log(hotel1);
  console.log(hotel2);
}

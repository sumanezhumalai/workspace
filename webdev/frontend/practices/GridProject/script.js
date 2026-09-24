"use strict";

let hamburger = document.querySelector(".hamburger");
let nav = document.querySelector(".mobilenav");
let bar1 = document.querySelector(".bar1");
let bar2 = document.querySelector(".bar2");
let bar3 = document.querySelector(".bar3");

hamburger.addEventListener("click", toggleAnimation);

function toggleAnimation() {
  // bar1.toggleAnimation
  hamburger.classList.toggle("active");
  nav.classList.toggle("openDrawer");
  console.log(...hamburger.classList.entries());
  console.log(...nav.classList.entries());
}

"use strict";

const modal = document.querySelector(".modal");
const overlay = document.querySelector(".overlay");
const closeModalBtn = document.querySelector(".close-modal");
const openModalBtn = document.querySelectorAll(".show-modal"); //select all , or ot will select only the first occurence

// for (let i = 0; i < openModalBtn.length ; i++) {
//     console.log(openModalBtn[i].textContent);
// }

//Event Listners (ALL buttons - it is in array form)
//open
openModalBtn.forEach((p) => {
  p.addEventListener("click", openOverlayModal);
});

//close
closeModalBtn.addEventListener("click", closeOverlayModel);
overlay.addEventListener("click", closeOverlayModel);

//key (keydown,keypress,keyup)
document.addEventListener("keydown", globalKeyHandler);

//Event Functions
function globalKeyHandler(e) {
  console.log(e.key);
  if (e.key == "Escape") {
    if (
      !modal.classList.contains("hidden") ||
      !overlay.classList.contains("hidden")
    ) {
      console.log("Model Class has no hidden class, ESC will close");
      closeOverlayModel();
    } else {
      console.log("Model Class has hidden, ESC will not close");
    }
  }
}

function openOverlayModal() {
  modal.classList.remove("hidden");
  overlay.classList.remove("hidden");
}

function closeOverlayModel() {
  modal.classList.add("hidden");
  overlay.classList.add("hidden");
}

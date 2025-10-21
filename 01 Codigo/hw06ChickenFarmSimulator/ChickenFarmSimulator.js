import Chicken from "./Chicken.js";

function main() {
  console.log("This is my Chicken Farm Simulator!");

  // Creamos el primer pollo
  const chicken2 = new Chicken(0, "Maruja", "White", 1, true);

  // Datos del dueño y segundo pollo
  const owner = "Paulo Ramos";
  const id = 1;
  const name = "Lucy";
  const color = "White and Brown";
  const age = 2;
  const isMolting = false;

  // Creamos el segundo pollo
  const chicken = new Chicken(id, name, color, age, isMolting);

  console.log("The chicken is --> " + chicken.toString());
  console.log("chicken id --> " + chicken.getId());
}

main();

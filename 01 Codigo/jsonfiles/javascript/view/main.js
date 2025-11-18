import readline from "readline";
import Doll from "../model/Doll.js";
import DollController from "../controller/DollController.js";

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function ask(question) {
    return new Promise(resolve => rl.question(question, resolve));
}

async function main() {
    const controller = new DollController();
    controller.loadFromJSON("dolls.json");

    while (true) {
        try {
            const id = parseInt(await ask("Ingrese ID Doll (integer): "));
            if (isNaN(id)) {
                console.log("ID must be an integer!");
                continue;
            }

            if (controller.dolls.some(d => d.id === id)) {
                console.log("ID already exists!");
                continue;
            }

            const name = await ask("Doll name: ");
            const material = await ask("Ingrese Doll material: ");
            const priceInput = await ask("Ingrese Doll Price (positive number): ");
            const price = parseFloat(priceInput);

            if (isNaN(price) || price < 0) {
                console.log("Price must be a positive number!");
                continue;
            }

            controller.addDoll(new Doll(id, name.trim(), material.trim(), price));

        } catch (error) {
            console.log("Invalid input.");
            continue;
        }

        const more = (await ask("Add another Doll? (y/n): ")).toLowerCase();
        if (more !== "y") break;
    }

    controller.displayDolls();
    controller.saveToJSON("dolls.json");
    console.log("Datos guardados en dolls.json");

    rl.close();
}

main();

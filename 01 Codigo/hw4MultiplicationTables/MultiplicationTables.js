const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function askNumber() {
    rl.question("Enter a number to see its multiplication table (1-12): ", (input) => {
        const number = parseInt(input);

        if (isNaN(number)) {
            console.log("Please enter a valid number.");
            askNumber();
            return;
        }

        if (number < 1 || number > 12) {
            console.log("You can only enter numbers from 1 to 12.");
            askNumber();
            return;
        }

        console.log(`\nMultiplication table for ${number}:`);
        for (let i = 1; i <= 12; i++) {
            console.log(`${number} x ${i} = ${number * i}`);
        }

        rl.question("\nDo you want to see another table? (yes/no): ", (choice) => {
            if (choice.trim().toLowerCase() === "yes") {
                askNumber();
            } else {
                console.log("Goodbye!");
                rl.close();
            }
        });
    });
}

askNumber();

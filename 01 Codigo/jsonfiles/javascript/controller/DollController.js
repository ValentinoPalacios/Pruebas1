import fs from "fs";
import Doll from "../model/Doll.js";

class DollController {
    constructor() {
        this.dolls = [];
    }

    addDoll(doll) {
        if (this.dolls.some(d => d.id === doll.id)) {
            console.log(`Error: ID ${doll.id} already exists.`);
            return false;
        }
        this.dolls.push(doll);
        return true;
    }

    displayDolls() {
        if (this.dolls.length === 0) {
            console.log("No dolls available.");
        } else {
            console.log("\n--- All Dolls ---");
            this.dolls.forEach(doll => console.log(doll.toString()));
        }
    }

    saveToJSON(filename) {
        fs.writeFileSync(filename, JSON.stringify(this.dolls.map(d => d.toDict()), null, 4));
    }

    loadFromJSON(filename) {
        try {
            const data = JSON.parse(fs.readFileSync(filename));
            this.dolls = data.map(d => Doll.fromDict(d));
        } catch (err) {
            this.dolls = [];
        }
    }
}

export default DollController;

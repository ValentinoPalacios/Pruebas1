class Doll {
    
    constructor(id, name, material, price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.price = price;
    }

    toDict() {
        return {
            id: this.id,
            name: this.name,
            material: this.material,
            price: this.price
        };
    }

    static fromDict(data) {
        return new Doll(data.id, data.name, data.material, data.price);
    }

    toString() {
        return `Doll(ID: ${this.id}, Name: ${this.name}, Material: ${this.material}, Price: ${this.price})`;
    }
}

export default Doll;

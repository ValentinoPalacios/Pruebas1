class Chicken {
  constructor(id, name, color, age, isMolting) {
    this.id = id;
    this.name = name;
    this.color = color;
    this.age = age;
    this.isMolting = isMolting;
  }

  getId() {
    return this.id;
  }

  toString() {
    return `Chicken(\nid-->${this.id}, \nname-->${this.name}, \ncolor-->${this.color}, \nage-->${this.age}, \nisMolting-->${this.isMolting})`;
  }
}

export default Chicken;

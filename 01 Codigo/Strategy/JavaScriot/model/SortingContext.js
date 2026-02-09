const BubbleSort = require("./BubbleSort");
const InsertionSort = require("./InsertionSort");
const QuickSort = require("./QuickSort");

class SortingContext {
  constructor() {
    this.strategy = null;
  }

  sort(data) {
    const n = data.length;
    this.strategy = this.setStrategy(n);
    return this.strategy.sort(data);
  }

  setStrategy(n) {
    if (n > 0 && n < 30) return new BubbleSort();
    if (n >= 30 && n < 100) return new InsertionSort();
    return new QuickSort();
  }

  getStrategyName() {
    return this.strategy.constructor.name;
  }
}

module.exports = SortingContext;

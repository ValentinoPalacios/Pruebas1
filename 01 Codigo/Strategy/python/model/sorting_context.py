from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort

class SortingContext:

    def __init__(self):
        self.ss = None

    def sort(self, data):
        size = len(data)
        self.ss = self.set_sort_strategy(size)
        return self.ss.sort(data)

    def set_sort_strategy(self, n):
        if 0 < n < 30:
            return BubbleSort()
        if 30 <= n < 100:
            return InsertionSort()
        if n >= 100:
            return QuickSort()

    def get_strategy_name(self):
        if isinstance(self.ss, BubbleSort):
            return "BubbleSort"
        if isinstance(self.ss, InsertionSort):
            return "InsertionSort"
        if isinstance(self.ss, QuickSort):
            return "QuickSort"
        return "Unknown"

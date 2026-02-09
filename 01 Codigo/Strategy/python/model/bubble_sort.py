from model.sorting_strategy import SortingStrategy

class BubbleSort(SortingStrategy):

    def sort(self, data):
        print("Selected strategy BubbleSort")
        arr = data.copy()
        arr.sort()
        return arr
